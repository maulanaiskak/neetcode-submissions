class Solution {

    public String encode(List<String> strs) {
        var builder = new StringBuilder();

        for (var str : strs) {
            builder.append(str.length()).append("#").append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        var i = 0;
        var result = new ArrayList<String>();

        while (i < str.length()) {
            var delimiterIdx = i;

            while (str.charAt(delimiterIdx) != '#') {
                delimiterIdx++;
            }

            var length = Integer.parseInt(str.substring(i, delimiterIdx));
            delimiterIdx++;

            result.add(str.substring(delimiterIdx, delimiterIdx + length));
            i = delimiterIdx + length;
        }

        return result;
    }
}
