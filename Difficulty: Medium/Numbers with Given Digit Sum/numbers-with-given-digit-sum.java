class Solution {
	int counter = 0;
	Map<String, Integer>dp;
	public int countWays(int n, int sum) {
		// code here
		dp = new HashMap<>();
		int res = recursion(0, n, sum, 0, 0);
		return res == 0 ? -1 : res;
		//return counter == 0 ? -1 : counter;
	}
	int recursion(int val, int n, int sum, int digits, int digsum) {
		if (digits > n || digsum > sum)
			return 0;
		
		if (digsum == sum && digits == n) {
			counter++;
			return 1;
		}
		String str = digits + "#" + digsum;
		if (dp.containsKey(str))
			return dp.get(str);
		int ways = 0;
		for (int i = 0; i <= 9; i++) {
			if (val == 0 && i == 0)
				continue;
			ways +=recursion(val * 10 + i, n, sum, digits + 1, digsum + i);
		}
		dp.put(str , ways);
		return ways;
	}
};