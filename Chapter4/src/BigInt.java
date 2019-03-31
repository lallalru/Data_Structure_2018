public class BigInt {

	public Node start;

	private static class Node {
		int digit;
		Node next;
		Node(int digit) { this.digit = digit; }
	}

	public BigInt(int n) {
		if (n < 0)  throw new IllegalArgumentException(n + "<0");
		start = new Node(n % 10);
		Node p = start;
		n /= 10;
		while (n > 0) {
			p = p.next = new Node(n % 10);
			n /= 10;
		}
	}

	public String toString() {
		StringBuffer buf = new StringBuffer(Integer.toString(start.digit));
		Node p = start.next;
		while (p != null) {
			buf.insert(0, Integer.toString(p.digit));
			p = p.next;
		}
		return buf.toString();
	}

	public BigInt plus(BigInt y) {
		Node p = start;
		Node q = y.start;
		int n = p.digit + q.digit;
		BigInt z = new BigInt(n % 10);
		Node r = z.start;
		p = p.next;
		q = q.next;
		  while (p != null && q != null) {
			n = n / 10 + p.digit + q.digit;
			r.next = new Node(n % 10);
			p = p.next;
			q = q.next;
			r = r.next;
		}
		while (p != null) {
			n = n / 10 + p.digit;
			r.next = new Node(n % 10);
			p = p.next;
			r = r.next;
		}
		while (q != null) {
			n = n / 10 + q.digit;
			r.next = new Node(n % 10);
			q = q.next;
			r = r.next;
		}
		if (n > 9)
			r.next = new Node(n / 10);
		return z;
	}

	public BigInt multiplyone(BigInt y) {
		Node p = start;
		Node q = y.start;
		int n = p.digit * q.digit;
		BigInt z = new BigInt(n % 10);
		Node r = z.start;
		p = p.next;
		while (p != null) {
			n = n / 10 + p.digit * q.digit;
			r.next = new Node(n % 10);
			p = p.next;
			r = r.next;
			if(n > 9) r.next = new Node(n / 10);
		}
		return z;
	}

	public BigInt multiply(BigInt y) {
		Node p = start;
		Node q= y.start;
		BigInt z = new BigInt(0);
		BigInt temp;
		int count = 0;
		
		while(q != null) {
			temp = this.multiplyone(new BigInt(q.digit));
			for(int i = 0; i<count; i++) {
				Node node = new Node(0);
				node.next = temp.start;
				temp.start = node;
			}
			z = z.plus(temp);
			count++;
			q = q.next;
		}
		return z;
	}
		
}