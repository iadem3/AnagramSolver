import java.util.*;
public class AnagramSolver {
	HashMap<String,LetterInventory> dictionary = new HashMap<>();
	String[] ana;
	
	public AnagramSolver(List<String> list) {
		for(String i : list) {
			LetterInventory j = new LetterInventory(i);
			dictionary.put(i,j);
		}
	}
	
	public void print(String s, int max) {
		if(max < 0) {
			throw new IllegalArgumentException();
		}
		
			
		Set<String> keys = dictionary.keySet();
		Iterator<String> i = keys.iterator();
		LetterInventory s1 = new LetterInventory(s);
		TreeSet<String> remove = new TreeSet<>();
		
		while(i.hasNext()) {
			String holder = i.next();
			LetterInventory temp = s1.subtract(dictionary.get(holder));
			if(temp == null) {
				remove.add(holder);
			}
		}
		
		for(String k : remove) {
			keys.remove(k);
		}
		
		recursion(s1, max, keys, 0, new ArrayList<String>());
		System.out.println(dictionary.keySet().toString());
		System.out.println(keys.toString());
	}
	
	private void recursion(LetterInventory s1, int max, Set<String> keys, int counter, ArrayList<String> holder) {
		if(max == counter && s1.size() == 0) {
			System.out.println(holder);
		}
		else {
			for(String k : keys) {
				LetterInventory sub = s1.subtract(dictionary.get(k));
				if(sub != null) {
					holder.add(k);
					counter++;
					recursion(sub, max, keys, counter, holder);
			
					counter--;
					holder.remove(k);
				}
				
				
				
				
			}
		}
		
		
		
	}
	
	
}
