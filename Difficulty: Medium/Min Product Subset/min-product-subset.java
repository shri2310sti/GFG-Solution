class Solution {
	public int minProd(int[] arr) {
		int neg = 0;
		int posProduct = 1;
		int min = Integer.MAX_VALUE;
		int maxNeg = Integer.MIN_VALUE;
		int completeproduct = 1;

		int i = 0;

		while (i < arr.length) {

			if (arr[i] > 0) {
				posProduct *= arr[i];

			} else if (arr[i] < 0) {
				neg++;
				maxNeg = Math.max(maxNeg, arr[i]);

			}
			if (arr[i] != 0) {
				completeproduct *= arr[i];
			}
			min = Math.min(min, arr[i]);
			i++;
		}

		if (neg % 2 != 0) {
			return completeproduct;
		}

		if (neg == 0) {
			return min;
		}

		return completeproduct / maxNeg;
	}
}