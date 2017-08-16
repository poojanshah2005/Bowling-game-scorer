package input;

import java.util.ArrayList;

public class StringPassing {
	String input;
	
	public StringPassing(String input){
		this.input = input;
		String[] list = input.split("|");
		ArrayList<Integer> bowls = new ArrayList<>();
		
		for(int i = 0; i < list.length; i++){
			if(!list[i].equals("|")){
			bowls.add(getNumber(list[i]));
			} else {
			}
		}
		
		System.out.println("list");
		for(int a: bowls){
			System.out.println(a);
		}
	}
	
	public int getNumber(String list){
		switch (list) {
		case "x":
			return 10;
			
		case "-":
			return 0;
			
		case "|":
			return 0;

		default:
			return Integer.valueOf(list);
		}
	}

}
