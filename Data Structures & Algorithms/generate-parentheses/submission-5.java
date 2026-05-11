class Solution {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    // O(Cn * n)
    private void backtrack(List<String> ans, String outputSoFar, int open, int close, int n) {
        // If string length becomes 2*n,
        // we used all brackets
        if (outputSoFar.length() == 2 * n) {
            ans.add(outputSoFar);
            return;
        }
        // We can add '(' only if
        // open brackets used are less than n
        if (open < n) { // 1. optiization 1
            backtrack(ans, outputSoFar + "(", open + 1, close, n);
        }
        // We can add ')' only if
        // close brackets are less than open brackets
        // otherwise bracket sequence becomes invalid
        if (close < open) { // // 2. optiization 2
            backtrack(ans, outputSoFar + ")", open, close + 1, n);
        }
    }



    // Total = C(n-1) * O(n) insertions * O(n) string creation
    // Cn ≈ 4^n / (n^(3/2))
    public List<String> generateParenthesisRec(int n) {
        Set<String> ans = new HashSet<>();
        if(n == 1) {
            ans.add("()");
            return new ArrayList<>(ans);
        }

        List<String> smallAns = generateParenthesis(n - 1);

        for (String s : smallAns) {

            for (int i = 0; i <= s.length(); i++) {

                String newStr = s.substring(0, i) + "()" + s.substring(i);

                ans.add(newStr);
            }
        }
        return new ArrayList<>(ans);


        // (()) ()() // 2
        // ()(()) (()())
        // ((())) (()()) (())()
        // ()()() (())() ()()() ()(()) ()()()
        

        // ((())) (()()) 
        // ()(())  (())() 
        // ()()()

        
    }
}
