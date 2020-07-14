import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0, 5);
		list.add(4);
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
