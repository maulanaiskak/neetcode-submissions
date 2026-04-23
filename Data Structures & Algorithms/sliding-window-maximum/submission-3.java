class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque nyimpen index (bukan nilai) supaya bisa cek apakah elemen masih dalam window
        // dipertahankan dalam urutan descending by nilai, jadi front selalu index of maximum
        var deque = new ArrayDeque<Integer>();
        var result = new ArrayList<Integer>();

        for (var i = 0; i < nums.length; i++) {
            // buang semua elemen dari back yang nilainya lebih kecil dari elemen baru
            // mereka ga akan pernah jadi maximum selama elemen baru masih di window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast(); // elemen ini obsolete, buang
            }

            deque.add(i); // tambah index baru ke back

            // buang front kalau indexnya udah keluar dari window
            // window valid: [i - k + 1, i]
            if (deque.peekFirst() < i - k + 1) {
                deque.removeFirst(); // index terlalu lama, bukan bagian window lagi
            }

            // hanya tambah result kalau window udah penuh (butuh k elemen)
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]); // front deque = index of maximum di window
            }
        }

        // ArrayList<Integer> ga bisa langsung toArray() ke int[]
        // mapToInt untuk unbox Integer -> int, lalu toArray() untuk convert ke int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}