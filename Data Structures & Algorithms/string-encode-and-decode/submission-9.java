class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();

        for (var s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        var res = new ArrayList<String>();
        var i = 0;

        while (i < s.length()) {
            var j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            var len = Integer.parseInt(s.substring(i, j));
            j++;

            res.add(s.substring(j, j + len));

            i = j + len;
        }

        return res;
    }
}
