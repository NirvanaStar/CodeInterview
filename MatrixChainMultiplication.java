class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solution {
	public int matrixmul(Pair[] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}
		
		int len = pairs.length;
		int[][] dp = new int[len][len];
		
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		// 对角线不用计算
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 0;
		}
		
		for (int space = 1; space < pairs.length; space++) {
			for (int i = 0; i < pairs.length - space; i++) {
				int j = i + space;
				
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + pairs[i].row * pairs[k].col * pairs[j].col, dp[i][j]);
				}
			}
		}
		
		
		return dp[0][len - 1];
	}
	
	public static void main(String[] args) {
        // Prints 'Hello, World' to the terminal window.
        Solution s = new Solution();
        Pair pair1 = new Pair(30, 35);
        Pair pair2 = new Pair(35, 15);
        Pair pair3 = new Pair(15, 5);
        Pair pair4 = new Pair(5, 10);
        Pair pair5 = new Pair(10, 20);
        Pair pair6 = new Pair(20, 25);
        Pair[] pairs = new Pair[] {pair1, pair2, pair3, pair4, pair5, pair6};
        int ret = s.matrixmul(pairs);
        System.out.println(ret);
    }
}
