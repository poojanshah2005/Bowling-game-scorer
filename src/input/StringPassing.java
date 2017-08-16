package input;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.poojanshah.BowlingGame.BowlingGame;
import com.poojanshah.BowlingGame.MatchFactory;

public class StringPassing {
	String input;
	
	ArrayList<Integer> bowls;
	
	BowlingGame game;
	
	public int score;
	
	public ArrayList<Integer> getBowls() {
		return bowls;
	}



	public StringPassing(String input){
		this.input = input;
		game = MatchFactory.createMatch();
		String[] list = input.split(Pattern.quote("|"));
		bowls = new ArrayList<>();
		
		for(String word : list){
			if(!word.equals("\\|")){
//			System.out.print(word);
			}
		}
		
		for(int i = 0; i < list.length-1; i++){
			
//			System.out.println(list[i]);
			
			if(list[i].length() >= 1){
				if((list[i].charAt(0) == 'x' || list[i].charAt(0) == 'X')){
					game.roll(10);
					game.roll(0);
					System.out.println("score: " + game.score() + " " + i);
				}else{
					if(list[i].length() >= 2){
						if((list[i].charAt(1) == '/')){
							int a = Character.getNumericValue(list[i].charAt(0));
							int b = 10 - a;
							System.out.println("a: " + a);
							System.out.println("b: " + (b));
							game.roll(0);
							game.roll(10);
						}else{
							int a = Character.getNumericValue(list[i].charAt(0));
							int b = Character.getNumericValue(list[i].charAt(1));
							if ( b < 0) b = 0;
							System.out.println("a: " + a);
							System.out.println("b: " + b);
							game.roll(a);
							game.roll(0);
								
							
						}
					}
					
				}
			}
		}
		
		score  = game.score();
		
		System.out.println("score: " + game.score());
		
		
				
	}
			
		
	
	public int getNumber(Character list){
		switch (list) {
		case 'x':
			return 10;
			
		case '-':
			return 0;
		case '/':
			return 0;
			
		case '|':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;

		default:
			return Integer.valueOf(list);
		}
	}

}
