class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        var need = new HashMap<Character, Integer>();

        for (var c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        var have = new HashMap<Character, Integer>();
        var left = 0;
        var result = "";

        for (var right = 0; right < s.length(); right++) {
            have.put(s.charAt(right), have.getOrDefault(s.charAt(right), 0) + 1);

            while (isValid(need, have)) {
                var currentResult = s.substring(left, right + 1);

                if (result == "" || currentResult.length() < result.length()) {
                    result = currentResult;
                }

                have.put(s.charAt(left), have.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return result;
    }

    private boolean isValid(Map<Character, Integer> need, Map<Character, Integer> have) {
        var haveCount = 0;
        var needCount = need.size();

        for (var key : need.keySet()) {
            if (have.get(key) != null && have.get(key) >= need.get(key)) {
                haveCount++;
            }
        }

        return haveCount >= needCount;
    }
}
