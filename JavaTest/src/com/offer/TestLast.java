package com.offer;

public class TestLast {
	public int movingCount(int threshold, int rows, int cols) {
		boolean b = countNum(0, 0, threshold);
		if (!b) {
			return 0;
		}
		int sum = 0;
		movingCount(sum, threshold, rows, cols, 0, 0);
		return cols;
	}

	private void movingCount(int sum, int threshold, int rows, int cols, int i,
			int j) {
		if (i <= rows && j < cols && countNum(i, j, threshold)) {
			sum++;
			int temp = i + 1;
			movingCount(sum, threshold, rows, cols, temp, j);
			temp = j + 1;
			movingCount(sum, threshold, rows, cols, i, temp);
		}
	}

	private boolean countNum(int rows, int cols, int threshold) {
		int sum = countSum(rows) + countSum(cols);
		return sum > threshold ? false : true;
	}

	private int countSum(int rows) {
		int sum = 0;
		while (rows > 0) {
			int temp = rows % 10;
			rows = (rows - temp) / 10;
			sum += temp;
		}
		return sum;
	}

	public static void main(String[] args) {
		TestLast tl = new TestLast();
		int sum = tl.movingCount(18, 16, 16);
		System.out.println(sum);
	}
}
