package guiapptest.contactapp;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactDataSource {
    private static String url;
    private static String username;
    private static String password;
    public ContactDataSource() throws FileNotFoundException {
        File config = new File("src/main/resources/config.txt");
        Scanner sc = new Scanner(config);
        int i = 0;
        String[] db = new String[3];
        while(sc.hasNextLine()){
            db[i] = sc.nextLine();
            i++;
        }

        url = db[0].substring(db[0].indexOf('=')+1).trim();
        username= db[1].substring(db[1].indexOf('=')+1).trim();
        password= db[2].substring(db[2].indexOf('=')+1).trim();
    }
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

    public static void edit(Contact contact, String name, String phone, String email){
        String query = "UPDATE contacts SET name=?, phone_number=?, email=? WHERE phone_number=?";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4,contact.getPhoneNumber());

            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
