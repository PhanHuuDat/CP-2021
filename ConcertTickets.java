import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ConcertTickets {

	static InputReader reader = new InputReader();
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) {
		TreeMap<Integer, Integer> tickets = new TreeMap<>();
		ArrayList<Integer> customers = new ArrayList<Integer>();

		int noOfTickets = reader.ni();
		int noOfCustomers = reader.ni();

		int ticketPrice;

		for (int i = 0; i < noOfTickets; i++) {
			ticketPrice = reader.ni();
			if (!tickets.containsKey(ticketPrice)) {
				tickets.put(ticketPrice, 1);
			} else {
				tickets.replace(ticketPrice, tickets.get(ticketPrice), tickets.get(ticketPrice) + 1);
			}
		}


		Integer temp = 0;
		
		for (int i = 0; i < noOfCustomers; i++) {
			
			temp = tickets.floorKey(reader.ni());
			
			if(temp == null) {
				result.append("-1\n");
				continue;
			}
			
			if(tickets.get(temp)==1) {
				tickets.remove(temp);
			}else {
				tickets.replace(temp, tickets.get(temp), tickets.get(temp) -1);
			}
			result.append(temp+"\n");
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
