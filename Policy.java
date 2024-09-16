import java.util.Scanner;

public class Policy {

    int policyNumber;
    String providerName;
    String policyholderFirstName;
    String policyholderLastName;
    int policyholderAge;
    String policyholderSmokingStatus;
    double policyholderHeight; // Inches
    double policyholderWeight; // Pounds

    // No-arg constructor
    public Policy() {
        this.policyNumber = 00000;
        this.providerName = "Unknown";
        this.policyholderFirstName = "Unknown";
        this.policyholderLastName = "Unknown";
        this.policyholderAge = 0;
        this.policyholderSmokingStatus = "Non-Smoker";  // Default to non-smoking
        this.policyholderHeight = 0.0;
        this.policyholderWeight = 0.0;
    }

    // Parameterized constructor
    public Policy(int policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String policyholderSmokingStatus,
                  double policyholderHeight, double policyholderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.policyholderSmokingStatus = policyholderSmokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
    }

    // Method to calculate BMI
    public double calculateBMI(double policyholderWeight, double policyholderHeight) {
        double bmiWeight = policyholderWeight * 703;
        double bmiHeight = Math.pow(policyholderHeight, 2);
        return bmiWeight / bmiHeight;
    }

    // Method to calculate price
    public double pricePolicy() {
        double baseFee = 600;
        double finalPrice = baseFee;
        double bmi = calculateBMI(policyholderWeight, policyholderHeight);

        if (policyholderAge > 50) {
            finalPrice += 75;
        }

        if (policyholderSmokingStatus.equalsIgnoreCase("smoker")) {
            finalPrice += 100;
        }

        if (bmi > 35) {
            double additional = bmi - 35;
            finalPrice += additional * 20;
        }

        return finalPrice;
    }

    // Method to display policy details with simple formatting using String.format()
    public void displayPolicyDetails() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Provider Name: " + providerName);
        System.out.println("Policyholder’s First Name: " + policyholderFirstName);
        System.out.println("Policyholder’s Last Name: " + policyholderLastName);
        System.out.println("Policyholder’s Age: " + policyholderAge);
        System.out.println("Policyholder’s Smoking Status: " + policyholderSmokingStatus);
        System.out.println("Policyholder’s Height: " + policyholderHeight + " inches");
        System.out.println("Policyholder’s Weight: " + policyholderWeight + " pounds");

        // Use String.format() to round and format BMI and Policy Price to 2 decimal places
        System.out.println("Policyholder’s BMI: " + String.format("%.2f", calculateBMI(policyholderWeight, policyholderHeight)));
        System.out.println("Policy Price: $" + String.format("%.2f", pricePolicy()));
    }

    public static void main(String[] args) {
        Scanner scannerUser = new Scanner(System.in);  // Correct Scanner instantiation

        System.out.print("Enter policy number: ");
        int policyNumber = scannerUser.nextInt();

        System.out.print("Enter provider name: ");
        scannerUser.nextLine(); // consume leftover newline
        String providerName = scannerUser.nextLine();

        System.out.print("Enter policyholder's first name: ");
        String firstName = scannerUser.nextLine();

        System.out.print("Enter policyholder's last name: ");
        String lastName = scannerUser.nextLine();

        System.out.print("Enter policyholder's age: ");
        int age = scannerUser.nextInt();

        System.out.print("Enter policyholder's smoking status (smoker/non-smoker): ");
        scannerUser.nextLine();  // consume newline
        String isSmoker = scannerUser.nextLine();

        System.out.print("Enter policyholder's height (in inches): ");
        double height = scannerUser.nextDouble();

        System.out.print("Enter policyholder's weight (in pounds): ");
        double weight = scannerUser.nextDouble();

        // Create a new Policy object using the parameterized constructor
        Policy policyUser = new Policy(policyNumber, providerName, firstName, lastName, age, isSmoker, height, weight);

        // Display policy details and calculate price
        policyUser.displayPolicyDetails();
    }
}