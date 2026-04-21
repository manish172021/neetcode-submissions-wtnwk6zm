class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int j = digits.length - 1; j>=0; j--) {
            if (digits[j] < 9) {
                digits[j]++;
                return digits;
            }
            digits[j] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
