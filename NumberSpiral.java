import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class NumberSpiral {

	static InputReader reader = new InputReader();
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) {
		int noOfTestcases = reader.ni();

		long row;
		long column;
		long total;

		for (int i = 0; i < noOfTestcases; i++) {
			row = reader.nl();
			column = reader.nl();

			if (row > column) {
				total = row * row - (row - 1);
				if (row % 2 == 0) {
					total = total + (row - column);
				} else {
					total = total - (row - column);
				}
				result.append(total + "\n");
			} else if (row < column) {
				total = column * column - (column - 1);
				if (column % 2 == 0) {
					total = total - (column - row);
				} else {
					total = total + (column - row);
				}
				result.append(total + "\n");
			} else {
				total = row * row - (row - 1);
				result.append(total + "\n");
			}
		}

		System.out.println(result);
	}

	static class InputReader {

		static InputStream is = System.in;
		static byte[] inbuf = new byte[1 << 24];
		static int lenbuf = 0, ptrbuf = 0;

		static int readByte() {
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) {
				ptrbuf = 0;
				try {
					lenbuf = is.read(inbuf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}

		static boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		static int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		static double nd() {
			return Double.parseDouble(ns());
		}

		static char nc() {
			return (char) skip();
		}

		static String ns() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		static char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		static int ni() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		static long nl() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
	}

}
