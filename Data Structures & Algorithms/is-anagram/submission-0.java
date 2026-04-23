class Solution {
    public boolean isAnagram(String s, String t) {
        var sMap = countFrequency(s);
        var tMap = countFrequency(t);

        if (sMap.size() != tMap.size()) {
            return false;
        }

        return sMap.equals(tMap);
    }

    private Map<Character, Integer> countFrequency(String string) {
        var stringMap = new HashMap<Character, Integer> ();

        for (var character: string.toCharArray()) {
            var frequency = stringMap.getOrDefault(character, 0) + 1;
            stringMap.put(character, frequency);
        }

        return stringMap;
    }
}
