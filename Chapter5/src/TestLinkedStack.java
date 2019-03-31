
public class TestLinkedStack {

	public static void main (String [] args) {
		LinkedStack a= new LinkedStack(); 
		
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		a.push(5);
		
		System.out.println(a);
		
		a.removesecond();
		System.out.println(a);
		
		a.reverse();
		System.out.println(a); 
		
		
	}
}
