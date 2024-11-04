package com.example.labka7.otherservices;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerClient {

    public static void registerClient(Connection connection, String fullName, String dateOfBirth, String phoneNumber, String password) throws SQLException {


        String sql = "INSERT INTO client (full_name, date_of_birth, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setString(2, dateOfBirth);
            statement.setString(3, phoneNumber);
            statement.executeUpdate();
            System.out.println("Клієнт зареєстрований.");
        }
    }
}
