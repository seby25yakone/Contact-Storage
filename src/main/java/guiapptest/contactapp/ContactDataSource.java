package guiapptest.contactapp;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDataSource {
    private static final String url = "jdbc:mysql://localhost:3306/contacts";
    private static final String username = "admin";
    private static final String password = "admin";

    public static void save(Contact contact){
        String query = "INSERT INTO contacts VALUES(?,?,?)";
        try (
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getPhoneNumber());
            statement.setString(3, contact.getEmail());

            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Contact> findAll() {
        String query = "SELECT * FROM contacts";
        List<Contact> contacts = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact(resultSet.getString("name"), resultSet.getString("phone_number"), resultSet.getString("email"));
                contacts.add(contact);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
        public static void deleteContact(Contact contact){
        String query= "DELETE FROM contacts WHERE phone_number=?";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, contact.getPhoneNumber());

            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
