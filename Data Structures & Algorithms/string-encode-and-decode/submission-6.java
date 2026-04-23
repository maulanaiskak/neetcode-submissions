class Solution {

    public String encode(List<String> strs) {
        var encoded = new StringBuilder();

        for (var str : strs) {
            encoded.append(str.length()).append(":").append(str);
        }

        return encoded.toString();
    }


    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        var i = 0;
        
        while (i < str.length()) {
            var colonIndex = str.indexOf(':', i);
            var length = Integer.parseInt(str.substring(i, colonIndex));
            var start = colonIndex + 1;
            
            result.add(str.substring(start, start + length));
            i = start + length;
        }
        
        return result;
    }
}
