class Solution {

    public String encode(List<String> strs) {
        var builder = new StringBuilder();

        for (var str : strs) {
            builder.append(str.length()).append("#").append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        var index = 0;
        var result = new ArrayList<String>();

        while (index < str.length()) {
            var delimiterIndex = str.indexOf("#", index);
            var length = Integer.parseInt(str.substring(index, delimiterIndex));

            delimiterIndex++;
            result.add(str.substring(delimiterIndex, delimiterIndex + length));

            index = delimiterIndex + length;
        }

        return result;
    }
}
