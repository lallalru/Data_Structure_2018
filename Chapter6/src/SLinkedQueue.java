
public class SLinkedQueue implements Queue{
	
	private class Node {
		Object object;
		Node next;
		Node(Object object) { this.object=object; }
		Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}
	}
	private Node head;
	private Node rear;
	private int size;
	
	public void add(Object object) {
		if (head == null) {
			rear =new Node(object);
			head= rear;
			size++;
		} else {
			Node t = new Node(object);
			rear.next = t;
			rear = rear.next;
			size++;
		}
	}
	
	public Object first() {
		if (empty()) {
			System.out.print("배열이 비어서 숫자를 뺄 수 없습니다.");
			return -987654321;
		}
		return head.object;
	}
	
	public Object remove() {
		if (empty()) {
			System.out.print("배열이 비어서 숫자를 뺄 수 없습니다.");
			return -987654321;
		}
		size--;
		Node t= head;
		head = head.next;
		return t.object;
	
	}

	public int size() {
		return this.size;
	}
	
	public boolean empty() {
		return this.head == null;
	}
	
	public void print() {
		System.out.println(this.toString()+"\n");
	}
	
	public String toString() {
		String str = " * Singly Linked Queue = head";
		
		Node ptr = this.head;
		
		while(ptr != null) {
			str = str + " -> " + ptr.object;
			ptr = ptr.next;
		}
		return str;
	}
}
