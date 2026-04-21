class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length + 1;
        int[] ans = new int[n];

        int carry = 1;
        for(int j = digits.length - 1; j>=0; j--) {
            int num = digits[j] + carry;
            ans[j + 1] = num % 10;
            carry = num / 10;
        }
        if(carry == 0) return Arrays.copyOfRange(ans, 1, ans.length);;
        ans[0] = carry;
        return ans;
    }
}
