
public class Test77 {
	public static void main(String[] args) {
		int[][] arrNumbers = {
				{0,0,0,4,0,0,0},	
				{0,0,0,11,0,0,0},	
				{0,0,0,18,0,0,0},	
				{0,0,0,0,0,0,0},	
				{29,30,0,0,0,0,0},	
				{0,0,0,0,0,41,0},	
				{0,0,0,0,0,0,0}	
		};
		
		// 체크할 대상 row 수
		int checkLineCnt = 6;
		// 체크할 row count
		int[] checkLineArray = {0,0,0,0,0,0};
		// 체크할 row 인덱스
		int checkRowIndex = 0;
		
		// 반복회수
		int repeatCnt = 7 - (checkLineCnt - 1);
		// 체크한도 라인수
		int limitCheckLine = arrNumbers.length - checkLineCnt;

		// 가로패턴 체크
		int checkCnt = 0;
		for (int i = 0; i < repeatCnt; i++) {
			// 체크수 초기화
			checkCnt = 0;
			checkRowIndex = 0;
			for (int j = 0; j < checkLineArray.length; j++) {
				checkLineArray[j] = 0;
			}
			
			for (int row = 0 + i; row < arrNumbers.length - (limitCheckLine - i); row++) {
				for (int col = 0; col < arrNumbers[row].length; col++) {
					System.out.println(row + "," + col + "=" + arrNumbers[row][col] + " / row = " + checkRowIndex);
					if (arrNumbers[row][col] > 0) {
						// 체크할 row count를 1로 설정
						checkLineArray[checkRowIndex] = 1;
					}
				}
				// 1~7열 체크 후 체크할 row수 인덱스 증가
				checkRowIndex++;
			}

			// 결과체크
			for (int j = 0; j < checkLineArray.length; j++) {
				System.out.println(j + "=" + checkLineArray[j] );
				checkCnt += checkLineArray[j];
			}
			System.out.println("checkCnt=" + checkCnt);
			
			if (checkCnt == 6) {
				break;
			}
			System.out.println(checkCnt);
		}

		// 결과체크
		if (checkCnt == 6) {
			// 가로 연속 라인 패턴 포함
			System.out.println(true);
		}
	}
}
