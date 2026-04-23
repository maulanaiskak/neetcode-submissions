class Solution {
    public int[] countBits(int n) {
        var result = new int[n + 1];
        for (var i = 0; i < n + 1; i++) {
            result[i] = hammingWeight(i);
        }
        return result;
    }

    public int hammingWeight(int n) {
    var count = 0;
    while (n != 0) {
        count += n & 1;
        n >>>= 1;
    }
    return count;
}
}
