import java.util.Scanner;

public class FinancialForecast {

    // Recursive function
    public static double futureValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return futureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Present Value: ");
        double presentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (as decimal, e.g., 0.05 for 5%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double result = futureValue(presentValue, rate, years);

        System.out.printf("Future Value as predicted : %.2f\n", result);


        sc.close();
    }
}
