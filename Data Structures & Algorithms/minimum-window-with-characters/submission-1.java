class Solution {
    public String minWindow(String s, String t) {
        // freq count tiap huruf di t, ini jadi "target" yang harus dipenuhi window
        var freq = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1); // increment freq huruf t
        }

        var need = freq.size(); // jumlah unique char di t yang harus terpenuhi
        var have = 0; // jumlah unique char yang frekuensinya udah terpenuhi di window
        var minLen = Integer.MAX_VALUE; // panjang minimum window yang valid, init MAX karena nyari minimum
        var minLeft = 0; // index kiri dari minimum window yang ditemukan
        var left = 0; // pointer kiri sliding window

        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right); // karakter baru yang masuk dari kanan

            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1); // kurangi "hutang" frekuensi karakter ini

                if (freq.get(c) == 0) {
                    have++; // frekuensi tepat terpenuhi (0 = pas, negatif = kelebihan)
                }
            }

            // kalau semua unique char udah terpenuhi, coba perkecil window dari kiri
            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1; // update panjang minimum
                    minLeft = left; // catat posisi kiri window terkecil
                }

                var leftC = s.charAt(left); // karakter yang akan dibuang dari kiri
                if (freq.containsKey(leftC)) {
                    freq.put(leftC, freq.get(leftC) + 1); // kembalikan "hutang" frekuensi

                    if (freq.get(leftC) > 0) {
                        have--; // frekuensi jadi kurang dari target, window ga valid lagi
                    }
                }

                left++; // geser pointer kiri
            }
        }

        // kalau minLen ga pernah update berarti ga ada window valid
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}