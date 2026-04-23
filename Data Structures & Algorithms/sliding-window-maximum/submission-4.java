class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque nyimpen INDEX (bukan nilai) — supaya bisa cek apakah elemen masih dalam window
        // properti: nilai nums di index deque selalu descending, jadi front = index of maximum
        var deque = new ArrayDeque<Integer>();
        var result = new ArrayList<Integer>();

        for (var i = 0; i < nums.length; i++) {
            // buang dari back: elemen yang nilainya <= nums[i] ga akan pernah jadi maximum
            // karena nums[i] lebih besar DAN lebih baru (lebih lama di window)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.add(i); // tambah index i ke back, nilai nums[i] terkecil di deque saat ini

            // buang dari front: kalau index front udah keluar dari window [i-k+1, i]
            // window di-enforce oleh index, bukan size deque
            if (deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // front deque = index of maximum di window saat ini
            // hanya tambah ke result kalau window udah penuh (perlu k elemen dulu)
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        // ArrayList<Integer> ga bisa toArray() ke int[] langsung karena autoboxing
        // mapToInt unbox Integer→int, toArray() convert ke int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}