package git;

import java.util.ArrayList;


public class listGet {
	
	public static int get(ArrayList<String> list, String string){
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).equals(string)) {
				return i;
			}
		}
		return -1;
	}
}
