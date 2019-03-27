import java.util.Random;

public class IntArrays {
	int[] array;
	int index;

	public IntArrays(int n) {
		array = new int[n];
		Random rand = new Random();
		index = 0;
		for (int a = 0; a < n / 2; a++) {
			array[a] = rand.nextInt();
			index++;
		}
	}

	public void add(int x) {
		if (index == array.length) {
			int[] array2 = new int[array.length * 2];
			System.arraycopy(array, 0, array2, 0, index);
			array = array2;
		}
		array[index] = x;
		index++;
		System.out.println("데이터" + x + "의 삽입이 완료되었습니다.");

	}

	public void remove(int y) {
		for (int i = 0; i < index; i++) {
			if (y == array[i]) {
				System.arraycopy(array, i + 1, array, i, array.length - i - 1);
				index--;
				break;
			}
		}
		System.out.println("데이터" + y + "의 삭제가 완료되었습니다.");
	}

	public void print() {
		System.out.println("\n길이 " + array.length + "인 배열을 생성하였습니다.\n");
		System.out.print("배열 데이터 : ");
		for (int i = 0; i < index; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println("");
	}
}