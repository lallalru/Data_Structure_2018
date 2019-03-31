
public class TestBigInt {

	public static void main(String[] args) {
		BigInt x = new BigInt(54321);
		BigInt y = new BigInt(9);
		BigInt z = new BigInt(8888);
		
		System.out.println(" [ x : "+ x +" ,  y : "+ y +" ]");
		System.out.println(" - x.multiplyone(y) = "+ x.multiplyone(y));
		
		System.out.println(" [ x : "+ x +" ,  z : "+ z +" ]");
		System.out.println(" - x.multiply(z) = "+ x.multiply(z));
		System.out.println(" - z.multiply(x) = "+ z.multiply(x));
				
		BigInt a = new BigInt(8888);
		BigInt b = new BigInt(54321);
		
		System.out.println(" [ x : "+ a +" ,  z : "+ b +" ]");
		System.out.println(" - x.multiply(z) = "+ x.multiply(z));
		System.out.println(" - z.multiply(x) = "+ z.multiply(x));
	}
	
	

}
