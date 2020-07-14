
public class TriangleTest {
	public static void main(String[] args) {
		int[][] arrNumbers = {
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0} 
			};
		int number = 1;
		
		for (int row = 0; row < arrNumbers.length; row++) {
			for (int col = 0; col < arrNumbers[row].length; col++) {
				arrNumbers[row][col] = number++;
			}
		}
		
		// 좌상 삼각형
//		for (int row = 0; row < arrNumbers.length; row++) {
//			String colNumbers = "";
//			for (int col = 0; col < arrNumbers[row].length - row; col++) {
//				if (!"".equals(colNumbers)) {
//					colNumbers += ",";
//				}
//				colNumbers += arrNumbers[row][col];
//			}
//			System.out.println(colNumbers);
//		}
		
		// 좌하 삼각형
//		for (int row = 0; row < arrNumbers.length; row++) {
//			int endColIndex = arrNumbers[row].length - row;
//			String colNumbers = "";
//			for (int col = 0; col < arrNumbers[row].length - endColIndex + 1; col++) {
//				if (!"".equals(colNumbers)) {
//					colNumbers += ",";
//				}
//				colNumbers += arrNumbers[row][col];
//			}
//			System.out.println(colNumbers);
//		}
		
		// 우상 삼각형
//		for (int row = 0; row < arrNumbers.length; row++) {
//			int startColIndex = arrNumbers[row].length - (arrNumbers[row].length - row);
//			String colNumbers = "";
//			for (int col = 0 + startColIndex; col < arrNumbers[row].length; col++) {
//				if (!"".equals(colNumbers)) {
//					colNumbers += ",";
//				}
//				colNumbers += arrNumbers[row][col];
//			}
//			System.out.println(colNumbers);
//		}
		
		// 우하 삼각형
		for (int row = 0; row < arrNumbers.length; row++) {
			int startColIndex = arrNumbers[row].length - row - 1;
			String colNumbers = "";
			for (int col = 0 + startColIndex; col < arrNumbers[row].length; col++) {
				if (!"".equals(colNumbers)) {
					colNumbers += ",";
				}
				colNumbers += arrNumbers[row][col];
			}
			System.out.println(colNumbers);
		}
	}
}
