class Solution {
    public int largestRectangleArea(int[] heights) {
        // stack nyimpen index, dipertahankan monotonic increasing by heights
        // artinya heights[stack[0]] <= heights[stack[1]] <= ...
        // saat ketemu bar lebih pendek → bar di stack "selesai", hitung area-nya
        var stack = new ArrayDeque<Integer>();
        var maxArea = 0;

        for (var i = 0; i < heights.length; i++) {
            // selama bar sekarang lebih pendek dari top stack → top stack ga bisa extend ke kanan
            // ini adalah momen untuk hitung area maksimal bar tersebut
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                var j = stack.pop(); // index bar yang dihitung areanya
                // batas kiri = stack.peek() setelah pop (bar pertama yang lebih pendek di kiri j)
                // batas kanan = i (bar pertama yang lebih pendek di kanan j)
                // width = i - peek - 1 karena peek dan i adalah batas eksklusif (mereka lebih pendek)
                // kalau stack kosong setelah pop → ga ada yang lebih pendek di kiri → batas kiri = 0
                // width = i - 0 = i (bar j bisa extend sampai index 0)
                var width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heights[j] * width);
            }

            stack.push(i); // bar sekarang belum ketemu batas kanan, simpan dulu
        }

        // bar yang masih di stack = ga pernah ketemu bar lebih pendek di kanannya
        // batas kanannya = heights.length (satu index setelah akhir array)
        // sama persis dengan logika di dalam loop, cuma i diganti heights.length
        while (!stack.isEmpty()) {
            var j = stack.pop(); // index bar yang dihitung areanya
            var width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, heights[j] * width);
        }

        return maxArea;
    }
}