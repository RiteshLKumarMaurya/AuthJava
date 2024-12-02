package auth;
import java.io.*;
import java.util.*;

public class UserAuthRecords {

    private static final String FILE_PATH = "e:/example.txt";

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

    // Function to update the phone number
    public static void updatePhoneNumber(String oldPhone, String newPhone) {
        try {
            List<String> records = readFile();
            boolean found = false;

            for (int i = 0; i < records.size(); i++) {
                String[] parts = records.get(i).split(" ");
                if (parts[0].equals(oldPhone)) {
                    records.set(i, newPhone + " " + parts[1]); // Update phone number
                    found = true;
                    break;
                }
            }

            if (found) {
                writeFile(records);
                System.out.println("Phone number updated successfully.");
            } else {
                System.out.println("Phone number not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Function to update the password
    public static void updatePassword(String phone, String newPassword) {
        try {
            List<String> records = readFile();
            boolean found = false;

            for (int i = 0; i < records.size(); i++) {
                String[] parts = records.get(i).split(" ");
                if (parts[0].equals(phone)) {
                    records.set(i, phone + " " + newPassword); // Update password
                    found = true;
                    break;
                }
            }

            if (found) {
                writeFile(records);
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("Phone number not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Function to delete a user
    public static void deleteUser(String phone) {
        try {
            List<String> records = readFile();
            boolean found = false;

            for (int i = 0; i < records.size(); i++) {
                if (records.get(i).startsWith(phone)) {
                    records.remove(i); // Delete user
                    found = true;
                    break;
                }
            }

            if (found) {
                writeFile(records);
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Phone number not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Helper function to read the file
    private static List<String> readFile() throws IOException {
        List<String> records = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    records.add(line);
                }
            }
        }
        return records;
    }

    // Helper function to write to the file
    private static void writeFile(List<String> records) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        }
    }
}
