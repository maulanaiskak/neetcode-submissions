class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var freq1 = new int[26];
        for (var c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        var left = 0;
        var freq2 = new int[26];

        for (var right = 0; right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;
            var len = right - left + 1;

            if (len > s1.length()) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
