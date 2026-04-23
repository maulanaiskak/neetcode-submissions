class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack nyimpen index hari yang belum ketemu hari lebih hangat
        // properti: nilai temperatures di index stack selalu descending (monotonic decreasing stack)
        var stack = new ArrayDeque<Integer>();
        var result = new int[temperatures.length]; // default 0, sesuai requirement

        for (var i = 0; i < temperatures.length; i++) {
            // hari ini lebih hangat dari hari-hari yang nunggu di stack
            // pop semua index yang hari ini adalah jawaban mereka
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var waitingIndex = stack.poll(); // index hari yang sedang nunggu
                result[waitingIndex] = i - waitingIndex; // selisih index = jumlah hari nunggu
            }

            stack.push(i); // push index hari ini, dia nunggu hari yang lebih hangat
        }

        // index yang masih di stack saat loop selesai → ga ada hari lebih hangat → result tetap 0
        return result;
    }
}