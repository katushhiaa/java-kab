package com.example.labka7.controllers;

import com.example.labka7.models.Client;
import com.example.labka7.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/add-client")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("/add-client")
    public String addClient(@ModelAttribute Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @PostMapping("/update-client-phone")
    public String updateClientPhone(@RequestParam int id, @RequestParam String phoneNumber) {
        clientService.updatePhoneNumber(id, phoneNumber);
        return "redirect:/clients";
    }

    @PostMapping("/delete-client")
    public String deleteClient(@RequestParam int id) {
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }

}
