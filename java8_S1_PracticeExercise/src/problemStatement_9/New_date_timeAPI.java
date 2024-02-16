package problemStatement_9;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class New_date_timeAPI {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a z");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentManager appointmentManager = new AppointmentManager();

        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (option) {
                case 1:
                    scheduleAppointment(scanner, appointmentManager);
                    break;
                case 2:
                    printAppointmentDetails(scanner, appointmentManager);
                    break;
                case 3:
                    rescheduleAppointment(scanner, appointmentManager);
                    break;
                case 4:
                    getReminder(scanner, appointmentManager);
                    break;
                case 5:
                    cancelAppointment(scanner, appointmentManager);
                    break;
                case 6:
                    System.out.println("Exiting Health Box. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (option != 6);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n1. Schedule an Appointment.");
        System.out.println("2. Print Appointment Details.");
        System.out.println("3. Reschedule an Appointment.");
        System.out.println("4. Get Reminder.");
        System.out.println("5. Cancel the Appointments.");
        System.out.println("6. Exit.");
        System.out.print("Enter an Option: ");
    }

    private static void scheduleAppointment(Scanner scanner, AppointmentManager appointmentManager) {
        System.out.println("\nEnter Date (dd/mm/yyyy): ");
        String dateStr = scanner.nextLine();
        System.out.println("Enter Time (hh:mm): ");
        String timeStr = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.println("Available Zones are\nA: America/Anchorage\nB: Europe/Paris\nC: Asia/Tokyo\nD: America/Phoenix");
        System.out.print("Select the Zone: ");
        String zoneInput = scanner.nextLine();

        ZoneId selectedZone;
        switch (zoneInput.toUpperCase()) {
            case "A":
                selectedZone = ZoneId.of("America/Anchorage");
                break;
            case "B":
                selectedZone = ZoneId.of("Europe/Paris");
                break;
            case "C":
                selectedZone = ZoneId.of("Asia/Tokyo");
                break;
            case "D":
                selectedZone = ZoneId.of("America/Phoenix");
                break;
            default:
                System.out.println("Invalid Zone. Defaulting to America/Anchorage.");
                selectedZone = ZoneId.of("America/Anchorage");
        }

        ZonedDateTime appointmentDateTime = ZonedDateTime.of(date, time, selectedZone);
        appointmentManager.scheduleAppointment(appointmentDateTime);
        System.out.println("Successfully Booked");
    }

    private static void printAppointmentDetails(Scanner scanner, AppointmentManager appointmentManager) {
        System.out.print("\nEnter an Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (option == 2) {
            ZonedDateTime appointmentDateTime = appointmentManager.getAppointmentDateTime();
            if (appointmentDateTime != null) {
                System.out.println(formatter.format(appointmentDateTime));
            } else {
                System.out.println("Appointment not booked. No details to display.");
            }
        } else {
            System.out.println("Invalid option for printing appointment details.");
        }
    }

    private static void rescheduleAppointment(Scanner scanner, AppointmentManager appointmentManager) {
        System.out.print("\nEnter an Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (option == 3) {
            ZonedDateTime currentAppointmentDateTime = appointmentManager.getAppointmentDateTime();
            if (currentAppointmentDateTime != null) {
                System.out.println("Current Appointment Date is " + formatter.format(currentAppointmentDateTime));
                System.out.println("Kindly Enter Number of Days to be postponed: ");
                int daysToPostpone = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                System.out.println("Enter the new time in HH:mm: ");
                String newTimeStr = scanner.nextLine();
                LocalTime newTime = LocalTime.parse(newTimeStr, DateTimeFormatter.ofPattern("HH:mm"));

                ZonedDateTime newAppointmentDateTime = currentAppointmentDateTime.plusDays(daysToPostpone).with(LocalTime.from(newTime));

                appointmentManager.rescheduleAppointment(newAppointmentDateTime);
                System.out.println("Your Appointment has been rescheduled to: " + formatter.format(newAppointmentDateTime));
            } else {
                System.out.println("Appointment not booked. Cannot reschedule.");
            }
        } else {
            System.out.println("Invalid option for rescheduling appointment.");
        }
    }

    private static void getReminder(Scanner scanner, AppointmentManager appointmentManager) {
        System.out.print("\nEnter an Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (option == 4) {
            ZonedDateTime appointmentDateTime = appointmentManager.getAppointmentDateTime();
            if (appointmentDateTime != null) {
                ZonedDateTime oneDayPrior = appointmentDateTime.minusDays(1);
                System.out.println(formatter.format(oneDayPrior));
            } else {
                System.out.println("No appointment scheduled. No reminder available.");
            }
        } else {
            System.out.println("Invalid option for getting a reminder.");
        }
    }

    private static void cancelAppointment(Scanner scanner, AppointmentManager appointmentManager) {
        System.out.print("\nEnter an Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (option == 5) {
            if (appointmentManager.cancelAppointment()) {
                System.out.println("Appointment has been cancelled!!");
            } else {
                System.out.println("No appointment scheduled. Nothing to cancel.");
            }
        } else {
            System.out.println("Invalid option for cancelling appointments.");
        }
    }
}

class AppointmentManager {
    private ZonedDateTime appointmentDateTime;

    public void scheduleAppointment(ZonedDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public ZonedDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void rescheduleAppointment(ZonedDateTime newAppointmentDateTime) {
        this.appointmentDateTime = newAppointmentDateTime;
    }

    public boolean cancelAppointment() {
        if (appointmentDateTime != null) {
            appointmentDateTime = null;
            return true;
        }
        return false;
    }
}

