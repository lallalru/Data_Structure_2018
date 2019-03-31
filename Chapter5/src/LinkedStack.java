
public class LinkedStack {

	private Node top;
	int num=0;

	public void push(int v) {
		if (top == null) {
			top = new Node(v);
		} else {
			Node newNode = new Node(v);
			newNode.next = top;
			top = newNode;
		}
		num++;
	}

	public  int pop() {
		Node temp = top;
		top = top.next;
		num--;
		return temp.data;
	}

	public int removesecond() {
		Node temp = top.next;
		top.next = top.next.next;
		num--;
		return temp.data;
	}
	
	 public void reverse() {
		
		Node pHead = top;
		Node p = top;

		Node pTail = top;
		while(pTail.next != null) {
			pTail = pTail.next;
			
		}
		pHead = pHead.next;
		pTail.next = p;
		p.next = null;
		
		for(int i = 0; i < num - 2; i++) {
			p = pHead;
			pHead = pHead.next;
			p.next = pTail.next;
			pTail.next = p;
			
		}
		top = pHead;
	}

	public String toString() {
		Node point = top;
		String re = "Current Elements of Stack : top";
		while (point != null) {
			re= re+ " -> "+ point.data;
			point= point.next;
		}
		return re;
	}
}
