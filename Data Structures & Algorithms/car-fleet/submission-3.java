class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        var n = position.length;
        var cars = new int[n][2];

        for (var i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        var stack = new ArrayDeque<Double>();

        for (var car : cars) {
            var time = (target - car[0]) / (double) car[1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
