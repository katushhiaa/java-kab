//---CRUD операції із усіма таблицями.

package com.example.labka7.otherservices;


import java.sql.*;

public class TaxiServices {

    private Connection connection;

    public TaxiServices(Connection connection) {
        this.connection = connection;
    }

    public void createCar(String marka, String model, int year, String fuelType, String bodyType, String color, String licensePlate, int passengerCapacity, double loadCapacity) throws SQLException {
        String sql = "INSERT INTO car (marka, model, year, fuel_type, body_type, color, license_plate, passenger_capacity, load_capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, marka);
            statement.setString(2, model);
            statement.setInt(3, year);
            statement.setString(4, fuelType);
            statement.setString(5, bodyType);
            statement.setString(6, color);
            statement.setString(7, licensePlate);
            statement.setInt(8, passengerCapacity);
            statement.setDouble(9, loadCapacity);
            statement.executeUpdate();
            System.out.println("Автомобіль створено.");
        }
    }

    public static void readCars(Connection connection) throws SQLException {
        String sql = "SELECT * FROM car";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Назви колонок для таблиці Car:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " (" + metaData.getColumnTypeName(i) + "), ");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();
            }
        }
    }



    public void updateCar(int id, String color) throws SQLException {
        String sql = "UPDATE car SET color = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, color);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Автомобіль оновлено.");
        }
    }

    public void deleteCar(int id) throws SQLException {
        String sql = "DELETE FROM car WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Автомобіль видалено.");
        }
    }

    public void createDriver(String fullName, Date dateOfBirth, int experience, String phoneNumber, int carId) throws SQLException {
        String sql = "INSERT INTO driver (full_name, date_of_birth, driving_experience, phone_number, car_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setDate(2, dateOfBirth);
            statement.setInt(3, experience);
            statement.setString(4, phoneNumber);
            statement.setInt(5, carId);
            statement.executeUpdate();
            System.out.println("Водія створено.");
        }
    }

    public static void readDrivers(Connection connection) throws SQLException {
        String sql = "SELECT * FROM driver";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Назви колонок для таблиці Driver:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " (" + metaData.getColumnTypeName(i) + "), ");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();
            }
        }
    }



    public void updateDriver(int id, String phoneNumber) throws SQLException {
        String sql = "UPDATE driver SET phone_number = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phoneNumber);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Водія оновлено.");
        }
    }

    public void deleteDriver(int id) throws SQLException {
        String sql = "DELETE FROM driver WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Водія видалено.");
        }
    }

    public void createClient(String fullName, Date dateOfBirth, String phoneNumber, String password) throws SQLException {


        String sql = "INSERT INTO client (full_name, date_of_birth, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setDate(2, dateOfBirth);
            statement.setString(3, phoneNumber);
            statement.executeUpdate();
            System.out.println("Клієнта створено.");
        }
    }

    public static void readClients(Connection connection) throws SQLException {
        String sql = "SELECT * FROM client";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Назви колонок для таблиці Client:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " (" + metaData.getColumnTypeName(i) + "), ");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();
            }
        }
    }



    public void updateClient(int id, String phoneNumber) throws SQLException {
        String sql = "UPDATE client SET phone_number = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phoneNumber);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Клієнта оновлено.");
        }
    }

    public void deleteClient(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Клієнта видалено.");
        }
    }

    public void createOrder(double distance, int carID, int clientId) throws SQLException {
        String sql = "INSERT INTO orders (distance, car_id, client_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, distance);
            statement.setInt(2, carID);
            statement.setInt(3, clientId);
            statement.executeUpdate();
            System.out.println("Замовлення створено.");
        }
    }

    public static void readOrders(Connection connection) throws SQLException {
        String sql = "SELECT * FROM orders";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Назви колонок для таблиці Orders:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + " (" + metaData.getColumnTypeName(i) + "), ");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + ", ");
                }
                System.out.println();
            }
        }
    }

    public void updateOrder(int id, double distance) throws SQLException {
        String sql = "UPDATE orders SET distance = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, distance);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Замовлення оновлено.");
        }
    }

    public void deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Замовлення видалено.");
        }
    }
}
