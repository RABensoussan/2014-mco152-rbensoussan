package bensoussan.scrabble;

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;


public class ScrabbleDictionaryTest {

	@Test	//annotation
	public void testContainsTrue() throws FileNotFoundException {	//methods here must contain the word test and must have an annotation
		ScrabbleDictionary dictionary = new ScrabbleDictionary();
		
		Assert.assertTrue(
				dictionary.contains("HELLO"));
	}
	
	@Test
	public void testContainsFalse() throws FileNotFoundException{
		ScrabbleDictionary dictionary = new ScrabbleDictionary();
		Assert.assertFalse(dictionary.contains("Eaf;oadjf"));
	}
	
	@Test
	public void testContainsNull() throws FileNotFoundException{
		ScrabbleDictionary dictionary = new ScrabbleDictionary();
		
		Assert.assertFalse(dictionary.contains(null));
	}

}
