//this code demonstrate how to read and store image file from java into mysql database


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InsertImageExample {
    private static final String INSERT_IMAGE_SQL = "INSERT INTO images (name, image) VALUES (?, ?)";

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUser = "root";
        String dbPassword = "password";

        String imagePath = "path/to/image.jpg"; // Replace with the actual path to your image file
        String imageName = "Example Image"; // Name of the image

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMAGE_SQL)) {

            // Read the image file into a byte array
            File imageFile = new File(imagePath);
            FileInputStream inputStream = new FileInputStream(imageFile);

            // Set the parameters for the PreparedStatement
            preparedStatement.setString(1, imageName);
            preparedStatement.setBlob(2, inputStream);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");

            // Close the input stream
            inputStream.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}