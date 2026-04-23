class Solution {
    public int lengthOfLongestSubstring(String s) {
        // set untuk track karakter yang ada di window saat ini, O(1) lookup
        var set = new HashSet<Character>();
        var left = 0; // pointer kiri window
        var current = 0; // panjang substring terpanjang yang ditemukan

        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right); // karakter baru yang masuk dari kanan

            // kalau c udah ada di window, geser left sampai c ga ada lagi
            // ini mastiin window selalu berisi karakter unik
            while (set.contains(c)) {
                set.remove(s.charAt(left)); // buang karakter paling kiri
                left++; // perkecil window dari kiri
            }

            set.add(c); // tambah karakter baru ke window

            // update panjang maksimum kalau window sekarang lebih panjang
            current = Math.max(current, right - left + 1);
        }

        return current;
    }
}