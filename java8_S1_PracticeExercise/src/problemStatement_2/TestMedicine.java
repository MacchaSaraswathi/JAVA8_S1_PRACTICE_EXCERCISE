package problemStatement_2;

import java.util.Random;

interface MedicineInfo {
    void displayLabel();
}

class Tablet implements MedicineInfo {
    private String companyName;

    Tablet(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void displayLabel() {
        System.out.println("Tablet: Store in a cool dry place");
        System.out.println("Manufactured by: " + companyName);
    }
}

class Syrup implements MedicineInfo {
    private String companyName;

    Syrup(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void displayLabel() {
        System.out.println("Syrup: Shake well before use");
        System.out.println("Manufactured by: " + companyName);
    }
}

class Ointment implements MedicineInfo {
    private String companyName;

    Ointment(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void displayLabel() {
        System.out.println("Ointment: For external use only");
        System.out.println("Manufactured by: " + companyName);
    }
}

public class TestMedicine {
    public static void main(String[] args) {
        Random rand = new Random();

        MedicineInfo[] medicines = new MedicineInfo[10];

        for (int i = 0; i < 10; i++) {
            int randomNum = rand.nextInt(3) + 1;
            String companyName = "Company" + i;

            switch (randomNum) {
                case 1:
                    medicines[i] = new Tablet(companyName);
                    break;
                case 2:
                    medicines[i] = new Syrup(companyName);
                    break;
                case 3:
                    medicines[i] = new Ointment(companyName);
                    break;
            }
        }

        // Check polymorphic behavior
        for (MedicineInfo medicine : medicines) {
            medicine.displayLabel();
            System.out.println("------------------");
        }
    }
}


