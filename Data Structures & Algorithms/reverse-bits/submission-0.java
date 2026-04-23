class Solution {
    public int reverseBits(int n) {
        var result = 0;
        for (var i = 0; i < 32; i++) { // 32 bit
            var bit = n & 1;
            result <<= 1;
            result |= bit;
            n >>>= 1;
        }
        
        return result;
    }
}
