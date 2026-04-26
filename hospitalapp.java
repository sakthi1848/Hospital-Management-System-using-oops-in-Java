import java.util.*;

public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> list = new ArrayList<>();

        while (true) {

            System.out.println("\n===== HOSPITAL MENU =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Update Patient");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); 

            switch (ch) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine(); 

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine(); 

                    list.add(new Patient(id, name, age, disease));
                    System.out.println("Patient Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Records Found!");
                    } else {
                        System.out.println("\n--- Patient List ---");
                        for (Patient p : list) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Patient p : list) {
                        if (p.id == searchId) {
                            System.out.println("Patient Found:");
                            p.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Patient ID to Delete: ");
                    int delId = sc.nextInt();

                    boolean removed = list.removeIf(p -> p.id == delId);

                    if (removed) {
                        System.out.println("Patient Deleted Successfully!");
                    } else {
                        System.out.println("Patient Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Patient ID to Update: ");
                    int updId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Patient p : list) {
                        if (p.id == updId) {

                            System.out.print("Enter New Name: ");
                            p.name = sc.nextLine(); 

                            System.out.print("Enter New Age: ");
                            p.age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter New Disease: ");
                            p.disease = sc.nextLine(); 

                            System.out.println("Patient Updated Successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Patient Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}

class Patient {

    int id, age;
    String name, disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println(id + " | " + name + " | Age: " + age + " | Disease: " + disease);
    }
}