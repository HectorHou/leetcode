public class NthDigit {
	/*
	 * Solution :
	 * 1 - 9    	9
	 * 10 - 99		90 * 2
	 * 100 - 999	900 * 3
	 * ...
	 * Based on these rules find the current number, then find the position of this number.
	 */
	public int findNthDigit(int n) {
		if (n < 10)
			return n;
		long value = 9, start = 1;
		int times = 1;
		while (true) {
			if (n <= (value * times))
				break;
			n -= (value * times);
			start *= 10;
			value *= 10;
			times++;
		}
		int re = n % times;
		if (re == 0)
			return (n / times - 1) % 10;

		long x = start + n / times;
		return Integer.valueOf(String.valueOf(x).substring(re - 1, re));

	}

	public static void main(String[] args) {
		System.out.println(new NthDigit().findNthDigit(3));
	}
}
