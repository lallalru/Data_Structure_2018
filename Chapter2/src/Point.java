public interface Point {

	public double getX(); // 선조건:x 후조건:값은 변경되지않는다.

	public double getY(); // 선조건:x 후조건:값은 변경되지않는다.

	public void setX(double a); // 선조건:a는 double형이다. 후조건: 주어진 값을 가진다

	public void setY(double b); // 선조건:b는 double형이다. 후조건: 주어진 값을 가진다

	public void moveTo(double p, double q); // 선조건:p와 q는 double형이다. 후조건: 입력받은 값만큼 좌표를 변경한다.

	public void scaleTo(double r); // 선조건:r은 double형이다. 후조건: 입력받은 값만큼 좌표를 변경한다.

}
