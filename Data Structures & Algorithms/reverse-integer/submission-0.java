class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 || 
               (rev == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // Integer.MAX_VALUE = 2147483647 → last digit = 7
                // If rev == 214748364, adding digit > 7 will overflow
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || 
               (rev == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                // Integer.MIN_VALUE = -2147483648 → last digit = -8
                // If rev == -214748364, adding digit < -8 will overflow
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
