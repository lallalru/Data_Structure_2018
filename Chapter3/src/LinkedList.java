public class LinkedList {

	Node startNode;
	Node p;

	
	public void insertlast(int x) {
		if (startNode == null) {
			startNode = new Node(x);
			p = startNode;
		} else {
			p.setNext(new Node(x));
			p = p.Next();
		}
	}

	public void insertfirst(int x) {
		if (startNode == null) {
			startNode = new Node(x);
		} else {
			Node temp = new Node(x);
			temp.setNext(startNode);
			startNode = temp;
		}
	}

	public boolean contain(int x) {
		boolean result = false;
		for (Node temp = startNode; temp != null; temp = temp.Next()) {
			if (temp.Value() == x) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void print() {
		System.out.print("List : ");
		for (Node temp = startNode; temp != null; temp = temp.Next()) {
			System.out.print(temp.Value() + " ");
		}
	}
}
