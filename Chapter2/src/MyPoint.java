public class MyPoint implements Point {
	double x, y;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double a) {
		x = a;
	}

	public void setY(double b) {
		y = b;
	}

	public void moveTo(double p, double q) {
		x = x + p;
		y = y + q;
		System.out.println("[move]  x축으로" + p + ", y축으로" + q + "만큼 이동 완료 하였습니다.");
		System.out.println("현재좌표: (" + x + ", " + y + ")");
	}

	public void scaleTo(double r) {
		if (r <= 0) {
			System.out.println("[Error] 입력하신 " + r + "는 양수가 아니므로 조건에 어긋납니다.");
			System.out.println("현재좌표 : (" + x + ", " + y + ")");
		} else {
			x = x * r;
			y = y * r;
			System.out.println("[scale] 좌표에 " + r + "배를 하였습니다.");
			System.out.println("현재좌표 : (" + x + ", " + y + ")");
		}
	}
}
