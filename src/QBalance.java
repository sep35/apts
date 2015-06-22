import java.util.Stack;
import java.util.HashMap;

public class QBalance { 
	public int bindex(String symbols) { 
		HashMap<Character, Character> yes = new HashMap<Character, Character>();
		Stack<Character> checker = new Stack<Character>();
		yes.put(')', '(');
		yes.put(']', '[');
		yes.put('}', '{');

		for(int i = 0; i < symbols.length(); i++){
			if(symbols.charAt(i) == '(' || symbols.charAt(i) == '{' || symbols.charAt(i) == '['){
				checker.push(symbols.charAt(i));
			}
			if(symbols.charAt(i) == ')' || symbols.charAt(i) == '}' || symbols.charAt(i) == ']'){
				if(checker.empty()){
					return i;
				}
				if(checker.peek() != yes.get(symbols.charAt(i))){
					return i;
				}
				if(checker.peek() == yes.get(symbols.charAt(i))){
					checker.pop();
				}				
			}
		}
		if(!checker.empty()){
			return symbols.length();
		}
		return -1;
	}
}