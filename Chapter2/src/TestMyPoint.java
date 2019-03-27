public class TestMyPoint {
	public static void main(String args[]) {
		MyPoint a = new MyPoint();

		a.setX(-1);
		a.setY(3);

		System.out.println("현재좌표 : (" + a.getX() + ", " + a.getY() + ")");
		a.moveTo(2, -5);
		a.scaleTo(-2);
		a.scaleTo(2);

	}

}
