package auth;
import java.io.*;
import java.util.*;

public class UserAuthRecordsSimple {

    private static final String FILE_PATH = "auth_records.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------- User Authentication Records ---------------");
            System.out.println("1. Update Phone Number");
            System.out.println("2. Update Password");
            System.out.println("3. Delete User");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the old phone number: ");
                    String oldPhone = scanner.nextLine();
                    System.out.print("Enter the new phone number: ");
                    String newPhone = scanner.nextLine();
                    updatePhoneNumber(oldPhone, newPhone);
                    break;

                case 2:
                    System.out.print("Enter the phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter the new password: ");
                    String newPassword = scanner.nextLine();
                    updatePassword(phone, newPassword);
                    break;

                case 3:
                    System.out.print("Enter the phone number to delete: ");
                    String phoneToDelete = scanner.nextLine();
                    deleteUser(phoneToDelete);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Load data from file into a map
    private static Map<String, String> loadData() {
        Map<String, String> authRecords = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) { // Valid record
                    authRecords.put(parts[0], parts[1]); // Key: phone, Value: password
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return authRecords;
    }

    // Save data from a map back to the file
    private static void saveData(Map<String, String> authRecords) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : authRecords.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Update phone number
    private static void updatePhoneNumber(String oldPhone, String newPhone) {
        Map<String, String> authRecords = loadData();

        if (authRecords.containsKey(oldPhone)) {
            String password = authRecords.remove(oldPhone); // Remove old phone
            authRecords.put(newPhone, password); // Add new phone with the same password
            saveData(authRecords);
            System.out.println("Phone number updated successfully.");
        } else {
            System.out.println("Phone number not found.");
        }
    }

    // Update password
    private static void updatePassword(String phone, String newPassword) {
        Map<String, String> authRecords = loadData();

        if (authRecords.containsKey(phone)) {
            authRecords.put(phone, newPassword); // Update password
            saveData(authRecords);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Phone number not found.");
        }
    }

    // Delete user
    private static void deleteUser(String phone) {
        Map<String, String> authRecords = loadData();

        if (authRecords.remove(phone) != null) { // Remove phone
            saveData(authRecords);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Phone number not found.");
        }
    }
}
