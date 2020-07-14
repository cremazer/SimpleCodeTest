import java.util.HashMap;
import java.util.Map;

/**
 * https://stove99.tistory.com/96
 * 
 * @author cremazer
 *
 */
public class MapIterator {
	public static void main(String[] args) {
		Map<Integer, Integer> checkResultMap = new HashMap<Integer, Integer>();
		checkResultMap.put(1, 5);
		checkResultMap.put(2, 3);
		
		// 방법3
        for( int key : checkResultMap.keySet() ){
            System.out.println( String.format("키 : %s, 값 : %s", key, checkResultMap.get(key)) );
        }
	}
}
