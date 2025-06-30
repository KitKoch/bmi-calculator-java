import java.util.*;

/*
    BMI                     Interpretation
    BMI < 18.5              Underweight
    18.5 <= BMI < 25.0      Normal
    25.0 <= BMI < 30.0      Overweight
    30.0 <= BMI             Obese
*/

public final class BMICalculator {
    private static final double LB_TO_KG = 0.45359237;
    private static final double IN_TO_M = 0.0254;
    private static final double BMI_UNDER = 18.5;
    private static final double BMI_NORMAL = 25;
    private static final double BMI_OVER = 30;

    private BMICalculator(){}

    private static double userDoublePositive(Scanner input, String msg) {
        while (true) {
            System.out.print(msg);
            if (input.hasNextDouble()) {
                double stat = input.nextDouble();
                if (stat > 0) {
                    return stat;
                }
                System.out.println("Number cannot be negative");
            } else {
                System.out.println("Please enter a number");
                input.next();
            }
        }
    }

    private static double calculateBMI(double LB, double IN) {
        double weightInKG = LB * LB_TO_KG;
        double heightInM = IN * IN_TO_M;
        return weightInKG / (heightInM * heightInM);
    }

    private static String bmiCategory(double BMI) {
        if(BMI < BMI_UNDER) {
            return "Underweight";
        } else if(BMI < BMI_NORMAL) {
            return "Normal";
        } else if(BMI < BMI_OVER) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double weightInLB = userDoublePositive(input, "Please enter a number for weight: ");
            double heightInIn = userDoublePositive(input, "Please enter a number for height: ");
            double BMI = calculateBMI(weightInLB, heightInIn);
            System.out.printf("BMI is %.2f%n%s", BMI, bmiCategory(BMI));
        }
    }
}
