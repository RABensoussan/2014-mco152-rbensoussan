package bensoussan.morsecode;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

	private Map<String, String> decoder;
	private Map<String, String> decoder2;
	private String[][] code;

	public MorseCode(){
		
		code = new String[2][];

		code[0] = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
				"Q", "R","S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", ".", ",", "?", "=", " "}; 
		code[1] = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.",  "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--..","-----", ".----","..---","...--","....-",".....","-....","--...","---..",
				"----.",".-.-.-", "--..--","..--..","-...-","/"};
		
		decoder = new HashMap<String, String>();
		decoder2 = new HashMap<String, String>();
		for(int i=0; i<code[0].length; i++){
			decoder.put(code[0][i], code[1][i]);
			decoder2.put(code[1][i], code[0][i]);
		}
		

	}

	public String toMorseCode(String str){
		StringBuilder info = new StringBuilder();
		char[] characters = str.toUpperCase().toCharArray();
		for(int i=0; i<characters.length; i++){
			String key = String.valueOf(characters[i]);
			info.append(decoder.get(key));
			if(i!=characters.length-1){
				info.append(" ");
				}
		}
		return info.toString();
	}

	public String toPlainText(String morse){
		StringBuilder info = new StringBuilder();
		String[] morsecode = morse.split(" ");
		for(int i=0; i<morsecode.length; i++){
			String key = morsecode[i]; 
			info.append(decoder2.get(key));
		}
		return info.toString();
	}
	
}