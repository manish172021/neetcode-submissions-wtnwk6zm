class Solution {

    public List<String> generateParenthesis(int n) {
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

        // // 
        // ()
        // (()) ()() // 2
        

        // ((())) (()()) 
        // ()(())  (())() 
        // ()()()

        // ((()))  (()())  (())()  ()(())  ()()()

        // (((()))) ()((())) ((()))()

        // (())(())

        // ()()()() (()())() (()(())) ()()(())  (())()()
        //  ()(())() ()(()()) (()()()) ((()()))  ((())())
    }
}
