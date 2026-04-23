class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search di nilai k (kecepatan makan), bukan di index array
        // range k: minimum 1, maksimum max(piles) — worst case habisin pile terbesar dalam 1 jam
        var left = 1;
        var right = Arrays.stream(piles).max().getAsInt();
        var result = right; // worst case answer = max(piles)

        while (left <= right) {
            var mid = left + (right - left) / 2; // kandidat k yang dicoba

            if (canFinish(piles, mid, h)) {
                result = mid;      // mid cukup, simpan sebagai kandidat, coba lebih kecil
                right = mid - 1;   // geser kanan ke kiri, cari k yang lebih kecil
            } else {
                left = mid + 1;    // mid ga cukup, harus lebih besar
            }
        }

        return result;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        var totalHours = 0;

        for (var pile : piles) {
            // ceiling division: kalau pile ga habis dibagi k, tetap butuh 1 jam extra
            // (pile + k - 1) / k = Math.ceil(pile / k) tapi tanpa floating point
            totalHours += (pile + k - 1) / k;
        }

        // kalau total jam <= h, kecepatan k cukup untuk habisin semua pile
        return totalHours <= h;
    }
}