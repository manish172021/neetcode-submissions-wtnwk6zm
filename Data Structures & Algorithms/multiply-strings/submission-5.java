class Solution {
    public String multiply(String num1, String num2) {

    //          6 6
    //          6 6
    //        3 9 6
    //     3 2 1
    //     1 2 3
    //     9 6 3
    //   6 4 2 0
    // 3 2 1 0 0
    // 3 9 4 8 3
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        int power = 0;
        for(int i = m-1; i >= 0; i--) {
            int carry = 0;
            for(int j = n-1; j >= 0; j--) {

                int index = (n - 1 - j) + power;

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = mul + res[index] + carry;

                res[index] = sum % 10;
                carry = sum / 10;
            }
            if(carry > 0) {
                res[n + power] = carry;
            }
            power++;
        }

        StringBuilder result = new StringBuilder();

        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) i--;

        while (i >= 0) {
            result.append(res[i--]);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}