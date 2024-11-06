package com.example.labka7.repositories;

import com.example.labka7.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Client client) {
        String sql = "INSERT INTO client (full_name, date_of_birth, phone_number) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, client.getFullName(), client.getDateOfBirth(), client.getPhoneNumber());
    }

    public List<Client> findAll() {
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setFullName(rs.getString("full_name"));
            client.setDateOfBirth(rs.getString("date_of_birth"));
            client.setPhoneNumber(rs.getString("phone_number"));
            return client;
        });
    }

    public Client findById(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setFullName(rs.getString("full_name"));
            client.setDateOfBirth(rs.getString("date_of_birth"));
            client.setPhoneNumber(rs.getString("phone_number"));
            return client;
        });
    }

    public void updatePhoneNumber(int clientId, String phoneNumber) {
        String sql = "UPDATE client SET phone_number = ? WHERE id = ?";
        jdbcTemplate.update(sql, phoneNumber, clientId);
    }


    public void deleteById(int id) {
        String sql = "DELETE FROM client WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
