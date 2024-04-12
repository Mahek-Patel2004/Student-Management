import java.util.Scanner;

class TerracedFieldTour {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int NetCost = 0;
        System.out.println("ENter number of Steps");
        int n = sr.nextInt();
        sr.close();
        for (int i = 1; i <= n; i++) {
            if (i % 8 == 0 || i == n) {
                int num = i;
                while (num > 0) {
                    int digit = num % 10;
                    if (digit == 6 || digit == 8) {
                        NetCost++;

                    }
                    num = num / 10;

                }
            }
        }
        System.out.println("Total Cost" + NetCost);
    }
}
