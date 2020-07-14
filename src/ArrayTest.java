public class ArrayTest {
	public static void main(String[] args) {
		int[][] arrNumbers = { 
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0 } 
		};

		int[] numbers = { 2, 6, 8, 26, 43, 45 };
		for (int i = 0; i < numbers.length; i++) {
			int row = numbers[i] / 7;
			int col = numbers[i] % 7 - 1;
			
			if(row > 0 && (numbers[i] % 7 == 0)){
				row -= 1;
				col = 6;
			}
			
			arrNumbers[row][col] = numbers[i]; 
		}
		
		// 검증
		for (int row = 0; row < arrNumbers.length; row++) {
			String data = "";
			for (int col = 0; col < arrNumbers[row].length ; col++) {
				if (col > 0) {
					data += ",";
				}
				data += arrNumbers[row][col];
			}
			
			// 결과 출력
			System.out.println(data);
		}
	}

}
