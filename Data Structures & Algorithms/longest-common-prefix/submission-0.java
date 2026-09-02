class Solution {
    public String longestCommonPrefix(String[] strs) {
        var minLength = Integer.MAX_VALUE;
        for (var str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        var prefix = new StringBuilder();
        for (var i = 0; i < minLength; i++) {
            var character = strs[0].charAt(i);
            var matched = true;

            for (var j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != character) {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }

            prefix.append(character);
        }

        return prefix.toString();
    }
}