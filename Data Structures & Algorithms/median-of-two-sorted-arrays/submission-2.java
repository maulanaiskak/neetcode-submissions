class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        // pastikan binary search di array yang lebih kecil
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }

        int m = a.length;
        int n = b.length;

        // total elemen yang harus ada di sisi kiri partition
        int leftSize = (m + n + 1) / 2;

        int lo = 0;
        int hi = m;

        while (lo <= hi) {

            // coba ambil "cut" di array a
            int cutA = lo + (hi - lo) / 2;

            // sisanya otomatis dari array b
            int cutB = leftSize - cutA;

            // ambil nilai sekitar garis potong

            int leftA  = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int rightA = (cutA == m) ? Integer.MAX_VALUE : a[cutA];

            int leftB  = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int rightB = (cutB == n) ? Integer.MAX_VALUE : b[cutB];

            // cek apakah partition sudah valid
            if (leftA <= rightB && leftB <= rightA) {

                // kalau sudah benar, langsung hitung median

                if ((m + n) % 2 == 1) {
                    // ganjil → ambil dari kiri
                    return Math.max(leftA, leftB);
                } else {
                    // genap → rata-rata tengah
                    int leftMax  = Math.max(leftA, leftB);
                    int rightMin = Math.min(rightA, rightB);
                    return (leftMax + rightMin) / 2.0;
                }
            }

            // kalau belum valid, geser binary search

            if (leftA > rightB) {
                // terlalu banyak ambil dari A → geser kiri
                hi = cutA - 1;
            } else {
                // terlalu sedikit ambil dari A → geser kanan
                lo = cutA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}