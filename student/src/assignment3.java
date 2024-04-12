import java.io.*;
import java.util.*;

public class Submit {
    void result(int a, int b) {
        int i;
        int mul = 1;
        for (i = a; i <= b; i++) {
            mul = mul * i;
        }
        // System.out.println(mul);
        add(mul);

    }

    void add(int mul) {
        int sum = 0;

        while (mul > 0) {

            sum = sum + (mul%10);
           
            mul = mul / 10;

        }
        if (sum >= 10) {
            add(sum);

        } else {
            System.out.print(sum);
        }

    }

    public static void main(String args[]) {
        Submit s = new Submit();
        int m1 = 10;
        int m2 = 12;
        s.result(m1, m2);
    }

}