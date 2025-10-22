import java.util.Scanner;

public class StudentDetails {
    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        long[] ids = new long[100];    
        String[] names = new String[100];
        double[] marks = new double[100];

        int studentCount = 0;

        for ( i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            while (true) {
                System.out.print("Enter ID (max 15 digits): ");
                ids[i] = scanner.nextLong();
                scanner.nextLine();

                if (String.valueOf(ids[i]).length() <= 15) {
                    break;
                } else {
                    System.out.println("ID too large! Please enter up to 15 digits.");
                }
            }

            System.out.print("Enter Name: ");
            names[i] = scanner.nextLine();

            System.out.print("Enter Marks: ");
            marks[i] = scanner.nextDouble();
            scanner.nextLine();
        }
         System.out.println("===== Student Details =====");
 
        for ( i = 0; i < n; i++) {
           System.out.println("Student ID: " + ids[i]);
           System.out.println("Name: " + names[i]);
           System.out.println("Marks: " + marks[i]);

        }


        studentCount = n;

        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: 
                    if (studentCount >= 100) {
                        System.out.println("Cannot add more students!");
                        break;
                    }

                    System.out.println("\nEnter details for new student:");

                    long id;
                    while (true) {
                        System.out.print("Enter ID (max 15 digits): ");
                        id = scanner.nextLong();
                        scanner.nextLine();
                        if (String.valueOf(id).length() <= 15) {
                            break;
                        } else {
                            System.out.println("ID too large! Please enter up to 15 digits.");
                        }
                    }

                    System.out.print("Enter Name: ");
                    names[studentCount] = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    marks[studentCount] = scanner.nextDouble();
                    scanner.nextLine();

                    ids[studentCount] = id;
                    studentCount++;

                    System.out.println("Student added successfully!");
                    break;

                case 2: 
                    if (studentCount == 0) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("\n===== Student Details =====");
                        System.out.printf("%-20s %-20s %-10s\n", "Student ID", "Name", "Marks");
                        for (int j = 0; j < studentCount; j++) {
                            System.out.printf("%-20d %-20s %-10.2f\n", ids[j], names[j], marks[j]);
                        }
                    }
                    break;

                case 3: 
                    if (studentCount == 0) {
                        System.out.println("No students available to update.");
                        break;
                    }
                    System.out.print("Enter student ID to update: ");
                    long updateId = scanner.nextLong();
                    scanner.nextLine();
                    boolean found = false;
                    for (int j = 0; j < studentCount; j++) {
                        if (ids[j] == updateId) {
                            System.out.print("Enter new Name: ");
                            names[j] = scanner.nextLine();
                            System.out.print("Enter new Marks: ");
                            marks[j] = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Student updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID " + updateId + " not found.");
                    }
                    break;

                case 4: 
                    if (studentCount == 0) {
                        System.out.println("No students available to delete.");
                        break;
                    }
                    System.out.print("Enter student ID to delete: ");
                    long deleteId = scanner.nextLong();
                    scanner.nextLine();
                    boolean deleted = false;
                    for (int j = 0; j < studentCount; j++) {
                        if (ids[j] == deleteId) {
                            for (int k = j; k < studentCount - 1; k++) {
                                ids[k] = ids[k + 1];
                                names[k] = names[k + 1];
                                marks[k] = marks[k + 1];
                            }
                            studentCount--;
                            deleted = true;
                            System.out.println("Student deleted successfully!");
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
