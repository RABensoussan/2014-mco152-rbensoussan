package bensoussan.scrabble;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ScrabbleDictionary {

	private Set<String> words;
	
	public ScrabbleDictionary() throws FileNotFoundException{
		words = new HashSet<String>();
		Scanner inputFile = new Scanner(new File("./OWL.txt"));
		while(inputFile.hasNext()){
		words.add(inputFile.next());
		inputFile.nextLine();
		}
		inputFile.close();
	}
	
	public boolean contains(String word){
		if(word==null){return false;}
		String upperWord = word.toUpperCase();
		return this.words.contains(upperWord);
	}
	


	public static void main(String args[]) throws FileNotFoundException{
		ScrabbleDictionary words = new ScrabbleDictionary();
		long startTime = System.currentTimeMillis();
		for(int i=0; i<1000000; i++){
			words.contains("HELLO");
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println(time);
}
}