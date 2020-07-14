package kakao;

import java.util.HashMap;
import java.util.Map;

public class FailureRate {
	public static void main(String[] args) {
		/*
		 * 실패율 정의
		 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
		 */
		
		int[] test1statges = {
			2, 1, 2, 6, 2, 4, 3, 3	
		};
		int[] test2statges = {
			4,4,4,4,4	
		};
		int[] test1 = solution(5, test1statges);
		
		System.out.println("test1 result"); 
		for (int i = 0; i < test1.length; i++) {
			System.out.println(test1[i]);
		}
		
		System.out.println();
		System.out.println("test2 result");
		int[] test2 = solution(4, test2statges);
		
		for (int i = 0; i < test2.length; i++) {
			System.out.println(test2[i]);
		}
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = i + 1;
		}
        
        int remainCnt = stages.length;	// 남은 수
                
        double[] arrFailRate = new double[N];
        
        Map<Integer, Map<String, Object>> analyData = new HashMap<Integer, Map<String, Object>>();
        
        // set stage & challengerCnt
        for (int i = 0; i < stages.length; i++) {
			int stageNumber = stages[i];
			if (analyData.containsKey(stageNumber)) {
				Map<String, Object> data = analyData.get(stageNumber);
				int challengerCnt = (int) data.get("challengerCnt");
				data.put("challengerCnt", ++challengerCnt);
			} else {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("challengerCnt", 1);
				analyData.put(stageNumber, data);
			}
		}
        
        // calculate fail rate
        for (int stageNumber = 1; stageNumber <= N; stageNumber++) {
        	double failRate = 0.0;
        	if (analyData.containsKey(stageNumber)) {
	        	Map<String, Object> data = analyData.get(stageNumber);
	        	double challengerCnt = (int) data.get("challengerCnt") * 1.0;
	        	failRate = challengerCnt / (double) remainCnt;
	        	remainCnt -= (int)challengerCnt; 
        	}
        	
        	arrFailRate[stageNumber-1] = failRate;
		}
        
        // sorting
        /*
        for (int i = 0; i < arrFailRate.length - 1; i++) {
        	for (int j = i; j < arrFailRate.length; j++) {
        		if (arrFailRate[i] < arrFailRate[j]) {
        			double tmp = arrFailRate[i];
        			arrFailRate[i] = arrFailRate[j];
        			arrFailRate[j] = tmp;
        			
        			int stageNumber = answer[i];
        			answer[i] = answer[j];
        			answer[j] = stageNumber;
        		}
        	}
        	
		}
		*/
        for (int i = arrFailRate.length - 1 ; i >= 1; i--) {
        	for (int j = i - 1; j >= 0; j--) {
        		if (arrFailRate[i] > arrFailRate[j]) {
        			double tmp = arrFailRate[i];
        			arrFailRate[i] = arrFailRate[j];
        			arrFailRate[j] = tmp;
        			
        			int stageNumber = answer[i];
        			answer[i] = answer[j];
        			answer[j] = stageNumber;
        		}
        	}
		}
        
        return answer;
    }
}
