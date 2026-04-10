class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String s1  = new String(c);
            map.computeIfAbsent(s1, v -> new ArrayList<>()).add(s);
        }
        return map.entrySet().stream()
        .map(e -> e.getValue())
        .collect(Collectors.toList());
    }
}
