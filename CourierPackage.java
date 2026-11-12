
package CourierPackageManagementSystem;

import java.util.*;
import java.io.*;

public class CourierPackage implements Serializable {

    int packageId;
    String senderName, receiverName, source, destination, deliveryStatus;
    double packageWeight, deliveryCharge;

    static Scanner sc = new Scanner(System.in);
    static String file = "packages.data";

    // Constructor
    CourierPackage(int id, String sender, String receiver,
            String src, String dest, double weight,
            double charge, String status) {

        packageId = id;
        senderName = sender;
        receiverName = receiver;
        source = src;
        destination = dest;
        packageWeight = weight;
        deliveryCharge = charge;
        deliveryStatus = status;
    }

    // Display
    void display() {
        System.out.println("\nPackage ID: " + packageId);
        System.out.println("Sender: " + senderName);
        System.out.println("Receiver: " + receiverName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Weight: " + packageWeight);
        System.out.println("Charge: " + deliveryCharge);
        System.out.println("Status: " + deliveryStatus);
    }

    // Read File
    static ArrayList<CourierPackage> readPackages() throws Exception {

        ArrayList<CourierPackage> list = new ArrayList<>();

        try {
            ObjectInputStream in =new ObjectInputStream(new FileInputStream(file));

            while (true)
                list.add((CourierPackage) in.readObject());

        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
        }

        return list;
    }

    // Write File
    static void writePackages(ArrayList<CourierPackage> list) throws Exception {

        ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(file));

        for (CourierPackage p : list)
            out.writeObject(p);

        out.close();
    }

    // 1. Add Package
    public static void addPackage() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        System.out.print("Enter Package ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (CourierPackage p : list) {
            if (p.packageId == id) {
                System.out.println("Package ID Already Exist.");
                return;
            }
        }

        System.out.print("Sender Name: ");
        String sender = sc.nextLine();

        System.out.print("Receiver Name: ");
        String receiver = sc.nextLine();

        System.out.print("Source: ");
        String src = sc.nextLine();

        System.out.print("Destination: ");
        String dest = sc.nextLine();

        System.out.print("Weight: ");
        double weight = Double.parseDouble(sc.nextLine());

        System.out.print("Delivery Charge: ");
        double charge = Double.parseDouble(sc.nextLine());

        System.out.print("Delivery Status: ");
        String status = sc.nextLine();

        list.add(new CourierPackage(id, sender, receiver,
                src, dest, weight, charge, status));

        writePackages(list);
        System.out.println("Package Added Successfully.");
    }

    // 2. Display All
    public static void displayAllPackages() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        if (list.isEmpty()) {
            System.out.println("No package records found.");
            return;
        }

        for (CourierPackage p : list)
            p.display();
    }

    // 3. Search
    public static void searchPackage() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        System.out.print("Enter Package ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (CourierPackage p : list) {
            if (p.packageId == id) {
                p.display();
                return;
            }
        }

        System.out.println("Package not found.");
    }

    // 4. Update
    public static void updatePackage() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        System.out.print("Enter Package ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (CourierPackage p : list) {

            if (p.packageId == id) {

                System.out.print("New Destination: ");
                p.destination = sc.nextLine();

                System.out.print("New Delivery Charge: ");
                p.deliveryCharge = Double.parseDouble(sc.nextLine());

                System.out.print("New Delivery Status: ");
                p.deliveryStatus = sc.nextLine();

                writePackages(list);
                System.out.println("Package Updated Successfully.");
                return;
            }
        }

        System.out.println("Package not found.");
    }

    // 5. Delete
    public static void deletePackage() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        System.out.print("Enter Package ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Iterator<CourierPackage> it = list.iterator();

        while (it.hasNext()) {
            CourierPackage p = it.next();

            if (p.packageId == id) {
                it.remove();
                writePackages(list);
                System.out.println("Package Deleted Successfully.");
                return;
            }
        }

        System.out.println("Package not found.");
    }

    // 6. Delivery Report
    public static void generateDeliveryReport() throws Exception {

        ArrayList<CourierPackage> list = readPackages();

        int count = 0, highestId = 0;
        double revenue = 0, highestCharge = 0;

        for (CourierPackage p : list) {

            if (p.deliveryStatus.equalsIgnoreCase("Delivered")) {
                count++;
                revenue += p.deliveryCharge;
            }

            if (p.deliveryCharge > highestCharge) {
                highestCharge = p.deliveryCharge;
                highestId = p.packageId;
            }
        }

        System.out.println("\n***** Delivery Report *****");
        System.out.println("Delivered Packages: " + count);
        System.out.println("Total Revenue: " + revenue);
        System.out.println("Highest Charge Package ID: " + highestId);
        System.out.println("Highest Delivery Charge: " + highestCharge);
    }
}
