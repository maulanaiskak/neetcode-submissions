class Solution {
    public int characterReplacement(String s, int k) {
        // freq count tiap huruf di window saat ini (uppercase, jadi 'A'=0, 'Z'=25)
        var freq = new int[26];
        var left = 0; // pointer kiri window
        var maxFreq = 0; // frekuensi huruf terbanyak di window saat ini
        var maxLen = 0; // panjang window valid terpanjang yang ditemukan

        for (var right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++; // tambah karakter baru ke freq

            // update maxFreq — huruf yang paling banyak di window, ini yang "dipertahankan"
            // sisanya (window size - maxFreq) adalah karakter yang harus diganti
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // kalau jumlah karakter yang harus diganti > k, window ga valid
            // (right - left + 1) = ukuran window, dikurangi maxFreq = jumlah yang harus diganti
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // buang karakter kiri dari freq
                left++; // perkecil window dari kiri
            }

            // window sekarang valid, update panjang maksimum
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}