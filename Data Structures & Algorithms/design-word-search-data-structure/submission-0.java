// addWord > O(N)
// search ->   Best: O(N)
            // Worst: O(26^N) (due to wildcard ".")
// Space → O(total Trie size) + O(N) recursion

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if(index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);

        if(c != '.') {
            if(!node.children.containsKey(c)) return false;
            return dfs(word, index + 1, node.children.get(c));
        }

        for(TrieNode child : node.children.values()) {
            if(dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}
class TrieNode {
    boolean endOfWord = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
}