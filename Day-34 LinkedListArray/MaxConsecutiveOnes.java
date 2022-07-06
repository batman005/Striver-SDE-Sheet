class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    int ones = 0, maxOnes = 0;
    for (int num : nums)
        if (num != 1)   ones = 0;
        else            maxOnes = Math.max(maxOnes, ++ones);
    return maxOnes;
}
}