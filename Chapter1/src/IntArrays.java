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
		System.out.println("������" + x + "�� ������ �Ϸ�Ǿ����ϴ�.");

	}

	public void remove(int y) {
		for (int i = 0; i < index; i++) {
			if (y == array[i]) {
				System.arraycopy(array, i + 1, array, i, array.length - i - 1);
				index--;
				break;
			}
		}
		System.out.println("������" + y + "�� ������ �Ϸ�Ǿ����ϴ�.");
	}

	public void print() {
		System.out.println("\n���� " + array.length + "�� �迭�� �����Ͽ����ϴ�.\n");
		System.out.print("�迭 ������ : ");
		for (int i = 0; i < index; i++) {
			System.out.print(array[i] + "  ");
		}
		System.out.println("");
	}
}