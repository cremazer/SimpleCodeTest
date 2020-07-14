import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSortTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		dataSort(list);
		
		System.out.println();
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public static Object dataSort(Object data){
		Object obj = new Object();
		
		if(data instanceof List){
			Collections.sort((List<Integer>)data);
			obj = data;
		}else if(data instanceof int[]){
			for (int i = 0; i < ((int[])data).length - 1; i++) {
				for (int j = i+1; j < ((int[])data).length; j++) {
					if(((int[])data)[i] > ((int[])data)[j]){
						int temp = ((int[])data)[i];
						((int[])data)[i] = ((int[])data)[j];
						((int[])data)[j] = temp;
					}
				}
			}
			obj = data;
		}
		
		return obj;
	}
}
