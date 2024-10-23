package org.example;

import java.io.InputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import at.favre.lib.crypto.bcrypt.BCrypt;


public class Main {

    public static Properties readConfiguration(String filename) {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                System.out.println("Неможливо " + filename);
                return null;
            }
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Помилка! " + e.getMessage());
        }
        return properties;
    }

    public static void registerClient(Connection connection, String fullName, String dateOfBirth, String phoneNumber, String password) throws SQLException {

        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        String sql = "INSERT INTO client (full_name, date_of_birth, phone_number, hashed_password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullName);
            statement.setString(2, dateOfBirth);
            statement.setString(3, phoneNumber);
            statement.setString(4, hashedPassword);
            statement.executeUpdate();
            System.out.println("Клієнт зареєстрований.");
        }
    }



    public static boolean authenticateClient(Connection connection, String phoneNumber, String password) throws SQLException {
        String sql = "SELECT hashed_password FROM client WHERE phone_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedHashedPassword = resultSet.getString("hashed_password");

                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), storedHashedPassword);
                return result.verified;
            } else {
                System.out.println("Клієнта не знайдено.");
                return false;
            }
        }
    }

    public static List<Car> carsByDistance(Connection connection) throws SQLException {
        List<Car> cars = new ArrayList<>();

        String sql = "SELECT car.*, SUM(o.distance) AS total_distance " +
                "FROM `orders` o " +
                "JOIN car ON o.car_id = car.id " +
                "GROUP BY car.id " +
                "ORDER BY total_distance ASC";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getString("marka"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("fuel_type"),
                        resultSet.getString("body_type"),
                        resultSet.getString("color"),
                        resultSet.getString("license_plate"),
                        resultSet.getInt("passenger_capacity"),
                        resultSet.getDouble("load_capacity")
                );
                car.setId(resultSet.getInt("id"));
                double totalDistance = resultSet.getDouble("total_distance");

                System.out.println("Автомобіль: " + car.getMarka() + " " + car.getModel() + " - Загальна дистанція: " + totalDistance + " км");

                cars.add(car);
            }
        }
        return cars;
    }

    public static List<Client> clientsByUsageTaxi(Connection connection) throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT client.*, COUNT(o.id) AS order_count " +
                "FROM `orders` o " +
                "JOIN client ON o.client_id = client.id " +
                "GROUP BY client.id " +
                "ORDER BY order_count DESC";

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



    public static void main(String[] args) {
        String configFilename = "config.properties";
        Properties properties = readConfiguration(configFilename);

        if (properties != null) {
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Підключено до БД");
                List<Car> cars = carsByDistance(connection);
                List<Client> clients = clientsByUsageTaxi(connection);


                //registerClient(connection, "John Doe", "1985-04-15", "123456789", "securepassword123");

                //boolean isAuthenticated = authenticateClient(connection, "123456789", "securepassword123");
                //System.out.println("Аутентифікація успішна: " + isAuthenticated);

                TaxiServices services = new TaxiServices(connection);
                System.out.println("dddd");

                //services.createCar("Toyota", "Corolla", 2001, "Gasoline", "Sedan", "White", "CE1234BI", 3, 400.0);
                //services.deleteCar(9);
                //services.readCars(connection);
                //services.updateCar(2, "red");

                //services.createOrder(30,5,1);
                //services.readClients(connection);



            } catch (SQLException e) {
                System.out.println("Помилка в підключенні до БД");
                e.printStackTrace();
            }
        }
    }
}









             /*Statement statement = connection.createStatement();
            ResultSet clientResult = statement.executeQuery("SELECT * FROM client");
            while (clientResult.next()) {
                System.out.println("Client: " + clientResult.getInt("id") + " " + clientResult.getString("full_name") + " "  + clientResult.getDate("date_of_birth") + " " + clientResult.getString("phone_number"));
            }*/