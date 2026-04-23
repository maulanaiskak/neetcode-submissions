class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        for (var s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            var len = Integer.parseInt(str.substring(i, j));
            var word = str.substring(j + 1, j + 1 + len);

            result.add(word);

            i = j + 1 + len;
        }

        return result;
    }
}
