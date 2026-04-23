class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // guard: kalau s1 lebih panjang dari s2, mustahil ada permutasi s1 di s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // array 26 elemen mewakili frekuensi tiap huruf alfabet (a=0, z=25)
        // dipakai buat nyimpen freq s1 dan window s2 secara terpisah
        var freq = new int[26];
        for (var c : s1.toCharArray()) {
            freq[c - 'a']++; // 'a'-'a'=0, 'b'-'a'=1, dst — mapping char ke index array
        }

        // isi window dengan s1.length() karakter pertama s2 (initial window)
        // ukuran window selalu fixed = s1.length()
        var window = new int[26];
        for (var i = 0; i < s1.length(); i++) {
            window[s2.charAt(i) - 'a']++; // sama seperti freq, mapping char ke index
        }

        // hitung berapa dari 26 huruf yang frekuensinya udah sama antara freq dan window
        // huruf yang 0 di keduanya tetap dihitung sebagai match
        // target: matches == 26 berarti semua huruf cocok → window adalah permutasi s1
        var matches = 0;
        for (var i = 0; i < 26; i++) {
            if (freq[i] == window[i]) {
                matches++;
            }
        }

        // early return: handle kasus s1.length() == s2.length()
        // kalau ga dicek di sini, sliding loop ga akan jalan karena i >= s2.length()
        if (matches == 26) {
            return true;
        }

        // slide window satu langkah ke kanan tiap iterasi
        // window size tetap s1.length(), jadi tiap geser: +1 kanan, -1 kiri
        for (var i = s1.length(); i < s2.length(); i++) {
            var rightChar = s2.charAt(i) - 'a'; // karakter baru yang masuk dari kanan
            var leftChar = s2.charAt(i - s1.length()) - 'a'; // karakter lama yang keluar dari kiri

            // pattern update matches: cek sebelum ubah, ubah, cek sesudah ubah
            // kenapa? karena matches harus reflect kondisi window saat ini
            // kalau langsung update window dulu baru cek, kita kehilangan info "sebelumnya match apa engga"

            // handle rightChar: frekuensinya naik 1
            if (freq[rightChar] == window[rightChar]) {
                matches--; // tadinya match, increment bakal bikin ga match
            }
            window[rightChar]++;

            if (freq[rightChar] == window[rightChar]) {
                matches++; // cek apakah setelah increment jadi match
            }

            // handle leftChar: frekuensinya turun 1
            if (freq[leftChar] == window[leftChar]) {
                matches--; // tadinya match, decrement bakal bikin ga match
            }
            window[leftChar]--;

            if (freq[leftChar] == window[leftChar]) {
                matches++; // cek apakah setelah decrement jadi match
            }

            // kalau semua 26 huruf frekuensinya sama persis → window ini permutasi s1
            if (matches == 26) {
                return true;
            }
        }

        // udah scan semua window yang mungkin, ga ada yang cocok
        return false;
    }
}