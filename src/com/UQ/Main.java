package com.UQ;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputMN = new Scanner(System.in);
        String [] functionInputs  = new String[4];
        short [] parsedMN = new short[2];

        System.out.println("Enter Ackermann function inputs");

        while (true) {

            if (parseInputs(inputMN, functionInputs, parsedMN)) {
                long ackVal = ackermann(parsedMN[0], parsedMN[1]);
                System.out.println("Ackermann Value: " + ackVal);
            }

        }

    }

    public static long ackermann(short m, short n) {

        if (m == 0) {
            return (long)n+1;
        } else if (m > 0 && n == 0) {

            return ackermann((short)(m - 1), (short)1);

        } else if (m > 0 && n > 0) {
            return ackermann((short)(m- 1), (short)ackermann(m, (short)(n - 1)));
        }
        return 0;
    }

    public static boolean parseInputs(Scanner inputMN, String[] functionInputs, short[] parsedMN) {

        if (inputMN.hasNextLine()) {

            String inputs = inputMN.nextLine();

            functionInputs = inputs.split(",");

            try {
                parsedMN[0] = Short.parseShort(functionInputs[0]);
                parsedMN[1] = Short.parseShort(functionInputs[1]);

                if (parsedMN[0] >= 0 && parsedMN[1] >= 0) {

                    if ((parsedMN[0] > 3 || parsedMN[1] > 4)) {
                        System.out.println("M > 3 or N > 4 will cause recursion stackOverflow, try with values lower.");
                        return false;
                    }

                    return true;
                } else {
                    System.out.println("Usage: m,n : Positive integers only");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Usage: m,n : Positive integers only");
            }

        }
        return false;
    }


}
