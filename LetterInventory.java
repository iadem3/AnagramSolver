import java.util.*;
public class LetterInventory {
	private static char[] org;
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int[] counter = new int[26];
	private int size = 0;
	
	public LetterInventory(String content) {
		//System.out.println(Arrays.toString(alphabet));
		char[] org1 = new char[content.length()];
		for(int i = 0; i < content.length(); i++) {
			char check = content.charAt(i);
			if(Character.isLetter(check) == true) {
				org1[i] = Character.toLowerCase(check);;
			}
		}
		org = org1;
		Arrays.sort(org);
		for(int i = 0; i < 26; i++) {
			char t = alphabet[i];
			for(Character j : org) {
				if(j == t) {
					counter[i]++;
				}
			}
		}
		//System.out.println(Arrays.toString(counter));
	}
	
	public int get(char letter) {
		int holder = 0;
		if(Character.isLetter(letter) == false) {
			throw new IllegalArgumentException();
		}
		
		Character.toLowerCase(letter);
		for(int i = 0; i < org.length; i++) {
			holder = i;
			if(org[i] == letter) {
				break;
			}
			else if((holder == (org.length -1)) && (org[i] != letter)) {
				return 0;
			}
		}
		
		
		for(int j = 0; j < 26; j++) {
			if(alphabet[j] == org[holder]) {
				holder = j;
				}
		}
	
		return counter[holder];
		
	}
	
	public void set(Character old, int value) {
		int holder = 0;
		if((Character.isLetter(old) == false) || (value < 0)) {
			throw new IllegalArgumentException();
		}
		else {
			Character.toLowerCase(old);
			for(int i = 0; i < org.length; i++) {
				if(org[i] == old) {
					holder = i;
				}
			}
			for(int j = 0; j < 26; j++) {
				if(alphabet[j] == org[holder]) {
					holder = j;
				}
			}
			counter[holder] = value;
		}
			
	}
	
	
	public int size() {
		return org.length;
	}
	
	public static boolean isEmpty(LetterInventory A) {
		if(org.length == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String hl = "[";
		for(Character l : org) {
			hl += l;
		}
		return hl + ']';
	}
	
	
	
	
	
	public LetterInventory subtract(LetterInventory old) {
		String temp = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] - old.counter[i];
			if(y < 0) {
				return null;
			}
			else {
				if(y > 0) {
					for(int k = 0; k < y; k++) {
						temp += alphabet[i];
					}
				}
			}
		}
		LetterInventory new1 = new LetterInventory(temp);
		return new1;
	}
	
	
	
	
	
	
	
	
	public LetterInventory add(LetterInventory old) {
		String temp = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] + old.counter[i];
			if(y > 0) {
				for(int k = 0; k < y; k++) {
					temp += alphabet[i];
				}
			}
			
		}
		LetterInventory new1 = new LetterInventory(temp);
		return new1;
	}
	
}
