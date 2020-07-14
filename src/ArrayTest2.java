public class ArrayTest2 {
	public static void main(String[] args) {
		int win = 904;
		int index = 0;
		for (int i = win - 1 - 1; i > win - 1 - 30 - 1; i--) {
			System.out.println(++index + " : " + i);
		}
	}
}
