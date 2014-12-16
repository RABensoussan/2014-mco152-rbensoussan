package bensoussan.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testToPlainText() {
		MorseCode decoder = new MorseCode();
		String encoded = decoder.toPlainText(".... .. / - .... . .-. . / .... --- .-- / .- .-. . / -.-- --- ..- ..--..");
		Assert.assertEquals("Hi there how are you?".toUpperCase(), encoded);
	}
	
	@Test
	public void testToMorseCode(){
		MorseCode decoder = new MorseCode();
		String encoded = decoder.toMorseCode("Hi there how are you?");
		Assert.assertEquals(".... .. / - .... . .-. . / .... --- .-- / .- .-. . / -.-- --- ..- ..--..", encoded);
	}

}

