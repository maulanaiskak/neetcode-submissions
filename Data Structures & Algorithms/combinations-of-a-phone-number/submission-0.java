class Solution {
    private String[] numbers = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(0, digits, new StringBuilder());
        return result;

    }

    private void backtrack(int index, String digits, StringBuilder builder) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }

        var chars = numbers[digits.charAt(index) - '0'];

        for (var c : chars.toCharArray()) {
            builder.append(String.valueOf(c));
            backtrack(index + 1, digits, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
