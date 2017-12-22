// 从最高位开始，假设当前位是1
// 利用 a^b = 1  ->  a^1 = b的原理，先将每个数的最高位存入set，然后对set的每一个数和 1 作 XOR，如果结果还出现在set中，则证明最大值的最高为位1
// 再将所有数的次高位存入set，假设次高位的位1，分别对set中的数作XOR，如都不存在，则次高位为1，否则为0
// 以此类推，做32次，得出最大结果

// example: Given [14, 11, 7, 2], which in binary are [1110, 1011, 0111, 0010].
// Since the MSB is 3, I'll start from i = 3 to make it simplify.

// i = 3, set = {1000, 0000}, max = 1000
// i = 2, set = {1100, 1000, 0100, 0000}, max = 1100
// i = 1, set = {1110, 1010, 0110, 0010}, max = 1100
// i = 0, set = {1110, 1011, 0111, 0010}, max = 1100

public int findMaximumXOR(int[] nums) {
    int max = 0, mask = 0;

    for (int i = 31; i >= 0; i--){
        // 从最高为开始，向低位检查
        mask = mask | (1 << i);
        HashSet<Integer> set = new HashSet<>();

        for (int j = 0; j < nums.length; j++){
            set.add(nums[j] & mask);
        }

        // 针对每一位，先假设最大值就是1
        int assumptionMaxValue = max | (1 << i);

        for (Integer prefix : set){
            if (set.contains(prefix ^ assumptionMaxValue)){
                max = assumptionMaxValue;
                break;
            }
        }
    }

    return max;
}
