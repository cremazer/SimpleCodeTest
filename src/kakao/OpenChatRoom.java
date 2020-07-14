package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방 (Open Chatting Room)
 * 
 * source
 * https://tech.kakao.com/2018/09/21/kakao-blind-recruitment-for2019-round-1/
 * 
 * @author cremazer (cremazer@gmail.com)
 * @since 2019.10.12
 */
public class OpenChatRoom {
	public static void main(String[] args) {
		// event record data
		String[] record = {
			"Enter uid1234 Muzi",
			"Enter uid4567 Prodo",
			"Leave uid1234",
			"Enter uid1234 Prodo",
			"Change uid4567 Ryan"
		};
		
		// process event
		String[] chatMessage = processEvent(record);
		
		// show result
		showMessage(chatMessage);
	}

	private static String[] processEvent(String[] record) {
		String[] answer = {};
		
		/** 
		 * event message map
		 *
		 * key : event
		 * value : message
		 */
		Map<String, String> eventMessageMap = new HashMap<String, String>();
		eventMessageMap.put("Enter","님이 들어왔습니다.");
		eventMessageMap.put("Leave","님이 나갔습니다.");
		
		/** 
		 * nickname map
		 * 
		 * key : userid
		 * value : nickname
		 */
		Map<String, String> nicknameMap = new HashMap<String, String>();
		
		/**
		 * message setting list
		 */
		List<String> list = new ArrayList<String>();
		
//        int answerCnt = 0; 
        
		// set last nickname
		for (int i = 0; i < record.length; i++) {
			// record = "event userid (ninkname)"
			if (record[i].startsWith("Enter")
                    || record[i].startsWith("Leave")
                    || record[i].startsWith("Change")
                   ) {
				/*
				 * fail code
				String[] recordData = record[i].trim().split(" ");
				if (!"Leave".equals(recordData[0])) {
					nicknameMap.put(recordData[1], recordData[2]);
				}
				
				if (!"Change".equals(recordData[0])) {
					answerCnt++;
				}
				*/
				
				String[] recordData = record[i].trim().split("\\s+");
                String eventCode = recordData[0];
                String userid = recordData[1];
                if (recordData.length > 2) {
                    String nickname = recordData[2];
                    nicknameMap.put(userid, nickname);
                }
                
                if (!"Change".equals(eventCode)) {
                    list.add(eventCode + " " + userid);
                }
			}
		}
		
//		answer = new String[answerCnt];	// fail code
		answer = new String[list.size()];
		
		// set message List
		/*
		 * fail code
		for (int i = 0; i < record.length; i++) {
			if (record[i].startsWith("Enter")
                    || record[i].startsWith("Leave")
                    || record[i].startsWith("Change")
                   ) {
				String[] recordData = record[i].trim().split(" ");
				if (!"Change".equals(recordData[0])) {
					answer[i] = nicknameMap.get(recordData[1]) +  eventMessageMap.get(recordData[0]);
				}
			}
		}
		*/
		
		// set message
        for (int i = 0 ; i < answer.length ; i++) {
            String[] msgData = list.get(i).split("\\s+");
            answer[i] = nicknameMap.get(msgData[1]) + eventMessageMap.get(msgData[0]);
        }
		
		return answer;
	}
	
	private static void showMessage(String[] chatMessage) {
		for (int i = 0; i < chatMessage.length; i++) {
			System.out.println(chatMessage[i]);
		}
	}
}





// test
//import java.util.HashMap;
//import java.util.Map;
//
//// why test fail?
//class Solution {
//    public String[] solution(String[] record) {
//        String[] answer = {};
//        int answerCnt = 0;
//        
//        Map<String, String> eventMessageMap = new HashMap<String, String>();
//        eventMessageMap.put("Enter","님이 들어왔습니다.");
//        eventMessageMap.put("Leave","님이 나갔습니다.");
//        
//        Map<String, String> nicknameMap = new HashMap<String, String>();
//        
//        // set last nickname
//        if (record != null) {                    
//            for (int i = 0 ; i < record.length ; i++) {
//                if (record[i].startsWith("Enter")
//                    || record[i].startsWith("Leave")
//                    || record[i].startsWith("Change")
//                   ) {
//                    String[] recordData = record[i].trim().split(" ");                
//                    if (!"Leave".equals(recordData[0])) {
//                        nicknameMap.put(recordData[1], recordData[2]);
//                    }
//                    if (!"Change".equals(recordData[0])) {
//                        answerCnt++;
//                    }
//                }
//            }
//
//            answer = new String[answerCnt];
//
//            // set message
//            for (int i = 0 ; i < record.length ; i++) {
//                if (record[i].startsWith("Enter")
//                    || record[i].startsWith("Leave")
//                    || record[i].startsWith("Change")
//                   ) {
//                    String[] recordData = record[i].trim().split(" ");
//                    if (!"Change".equals(recordData[0])) {
//                        answer[i] = nicknameMap.get(recordData[1]) + eventMessageMap.get(recordData[0]);
//                    }
//                }
//            }            
//        } // end if record null check
//        
//        return answer;
//    }
//}


//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Solution {
//    public String[] solution(String[] record) {
//        HashMap<String, String> codeMap = new HashMap<String, String>();
//        codeMap.put("enter","들어왔습니다.");
//        codeMap.put("leave","나갔습니다.");
//
//        HashMap<String, String> uidMap = new HashMap<String, String>();
//        List<String> list = new ArrayList<String>();
//        for(String str:record){
//            String[] split = str.split("\\s+");
//            String code = split[0];
//            String uid = split[1];
//            if(split.length > 2) {
//                String name = split[2];
//                uidMap.put(uid, name);
//            }
//            if(!"Change".equalsIgnoreCase(code)){
//                list.add(code +" "+uid);
//            }
//
//        }
//        String[] answer = new String[list.size()];
//        for(int i=0;i<answer.length;i++){
//            String[] split = list.get(i).split("\\s+");
//            String name = uidMap.get(split[1]);
//            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
//        }
//
//        return answer;
//    }
//}