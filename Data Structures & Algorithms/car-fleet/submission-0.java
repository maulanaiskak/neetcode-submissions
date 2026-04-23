class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        var stack = new ArrayDeque<Double>();
        var indices = new Integer[position.length];
        for (var i = 0; i < position.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]); // sort by position descending

        for (var i = 0; i < position.length; i++) {
            var idx = indices[i];
            var time = (target - position[idx]) / (double) speed[idx];
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            stack.push(time);
        }

        return stack.size();
    }
}
