class Solution {
    public String minWindow(String s, String t) {
        var freqT = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        var minLen = 1000;
        var result = "";

        for (var left = 0; left < s.length(); left++) {
            var freqWindow = new HashMap<Character, Integer>();

            for (var right = left; right < s.length(); right++) {
                var c = s.charAt(right);
                freqWindow.put(c, freqWindow.getOrDefault(c, 0) + 1);
                
                if (isValid(freqWindow, freqT)) {
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

    private boolean isValid(Map<Character, Integer> freqWindow, Map<Character, Integer> freqT) {
        for (var entry : freqT.entrySet()) {
            if (freqWindow.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
