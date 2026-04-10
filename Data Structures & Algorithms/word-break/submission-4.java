class Solution {
    Trie trie = new Trie();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        for (String word : wordDict) {
            trie.insert(word);
        }
        Boolean[] memo = new Boolean[s.length()];
        return dfsTrie(0, s, set, memo);
    }

    // Rec O(2^n) Memo O(n^2)
    private boolean dfsTrie(int start, String s, Set<String> set, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        TrieNode node = trie.root;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null) {
                break;
            }
            node = node.children[c - 'a'];
            if (node.isWord && dfsTrie(i + 1, s, set, memo)) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }



    private boolean wordBreakRec(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return dfs(0, s, set, memo);
    }

    // Rec O(2^n) Memo O(n^2)
    private boolean dfs(int start, String s, Set<String> set, Boolean[] memo) {
        if (start == s.length()) return true;

        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end))) {
                if (dfs(end, s, set, memo)) {
                    return memo[start] = true;
                }
            }
        }

        return memo[start] = false;
    }
}


class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }

        node.isWord = true;
    }
}
