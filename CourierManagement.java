package CourierPackageManagementSystem;
import java.util.*;
public class CourierManagement {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== COURIER PACKAGE MANAGEMENT =====");
            System.out.println("1. Add Package");
            System.out.println("2. Display All Packages");
            System.out.println("3. Search Package");
            System.out.println("4. Update Package");
            System.out.println("5. Delete Package");
            System.out.println("6. Generate Delivery Report");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    CourierPackage.addPackage();
                    break;

                case 2:
                    CourierPackage.displayAllPackages();
                    break;

                case 3:
                    CourierPackage.searchPackage();
                    break;

                case 4:
                    CourierPackage.updatePackage();
                    break;

                case 5:
                    CourierPackage.deletePackage();
                    break;

                case 6:
                    CourierPackage.generateDeliveryReport();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }
}