
public class StringSplitTest {
	public static void main(String[] args) {
		String excludeNum = "26, 23, 39, 36, 40, 31";
		String[] datas = excludeNum.split(", ");
		int[] excludeNumbers = new int[datas.length];
		for (int i = 0; i < datas.length; i++) {
			excludeNumbers[i] = Integer.parseInt(datas[i]);
		}
		
		for (int i = 0; i < excludeNumbers.length; i++) {
			System.out.println(excludeNumbers[i]);
		}
	}
}
