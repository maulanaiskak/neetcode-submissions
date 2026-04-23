class Solution {
    public String minWindow(String s, String t) {
        var freq = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        var need = freq.size();
        var have = 0;
        var minLen = Integer.MAX_VALUE;
        var minLeft = 0;
        var left = 0;

        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right);

            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);

                if (freq.get(c) == 0) {
                    have++;
                }
            }

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                var leftC = s.charAt(left);
                if (freq.containsKey(leftC)) {
                    freq.put(leftC, freq.get(leftC) + 1);

                    if (freq.get(leftC) > 0) {
                        have--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
