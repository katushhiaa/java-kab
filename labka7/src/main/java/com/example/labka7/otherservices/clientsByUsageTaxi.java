package com.example.labka7.otherservices;

import com.example.labka7.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clientsByUsageTaxi {

    public static List<Client> clientsByUsageTaxi(Connection connection) throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT client.*, COUNT(o.id) AS order_count " +
                "FROM `orders` o " +
                "JOIN client ON o.client_id = client.id " +
                "GROUP BY client.id " +
                "ORDER BY order_count ASC";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client(
                        resultSet.getString("full_name"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("phone_number")
                );
                client.setId(resultSet.getInt("id"));
                int orderCount = resultSet.getInt("order_count");
                System.out.println("Клієнт: " + client.getFullName() + " - Кількість замовлень: " + orderCount);

                clients.add(client);
            }
        }

        return clients;
    }
}
