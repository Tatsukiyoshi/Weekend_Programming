
public class Fibonacci {

	public static void main(String[] args) {
		int[] array = new int[11];
		for(int i = 0; i < 11; i++) {
			if (i == 0) {
				array[i] = 0;
			} else if (i == 1) {
				array[i] = 1;
			} else {
				array[i] = array[i - 1] + array[i - 2];
			}
		}
		
		for(int value : array) {
			System.out.println(value);
		}
	}

}
