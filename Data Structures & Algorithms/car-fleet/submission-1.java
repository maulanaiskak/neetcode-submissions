class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        var indices = new Integer[position.length];
        for (var i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        var stack = new ArrayDeque<Double>();
        for (var i : indices) {
            var arrival = (double) (target - position[i]) / speed[i];

            if (stack.isEmpty()) {
                stack.push(arrival);
            } else {
                if (arrival > stack.peek()) {
                    stack.push(arrival);
                }
            }
        }

        return stack.size();
    }
}
