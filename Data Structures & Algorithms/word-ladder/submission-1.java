class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        var queue = new ArrayDeque<String>();
        queue.offer(beginWord);

        var level = 1;
        var visited = new HashSet<String>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var i = 0; i < size; i++) {
                var word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }

                var chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    var original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        var candidate = new String(chars);

                        if (wordSet.contains(candidate) && !visited.contains(candidate)) {
                            queue.offer(candidate);
                            visited.add(candidate);
                        }
                    }

                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}
