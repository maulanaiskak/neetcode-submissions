class Solution {
    public String minWindow(String s, String t) {
        var freqT = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        var need = freqT.size();
        var minLen = Integer.MAX_VALUE;
        var result = "";

        for (var left = 0; left < s.length(); left++) {
            var freqWindow = new HashMap<Character, Integer>();
            var have = 0;

            for (var right = left; right < s.length(); right++) {
                var c = s.charAt(right);
                freqWindow.put(c, freqWindow.getOrDefault(c, 0) + 1);

                if (freqT.containsKey(c) && freqWindow.get(c).equals(freqT.get(c))) {
                    have++;
                }

                if (have == need) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        result = s.substring(left, right + 1);
                    }
                    break;
                }
            }
        }

        return result;
    }
}