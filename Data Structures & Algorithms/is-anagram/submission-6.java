class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var sChars = s.toCharArray();
        var tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return new String(sChars).equals(new String(tChars));
    }
}
