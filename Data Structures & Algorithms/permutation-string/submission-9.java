class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        var freq1 = new int[26];
        for (var c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        var size = s1.length();
        var left = 0;
        var right = 0;
        var freq2 = new int[26];

        while (right < s2.length()) {
            freq2[s2.charAt(right) - 'a']++;

            while (right - left + 1 > size) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }

            right++;
        }

        return false;
    }
}
