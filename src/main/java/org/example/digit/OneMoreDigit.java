package org.example.digit;

public class OneMoreDigit {

    /**
     * Transforms the given number by adding 1 to each digit.
     *
     * @param number the number to be transformed
     * @return the transformed number
     */
    public static int transform(int number) {
        if (number == 0) {
            return 1;
        }
        boolean isNegative = number < 0;
        if (isNegative) {
            number = -number;
        }
        int result = 0;
        int n = 10;
        while (number > 0) {
            result = result + (number % 10 + 1) * n;
            n *= (number % 10 == 9) ? 100 : 10;
            number /= 10;
        }
        return (isNegative ? -result : result) / 10;
    }
}
