package oracle.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 */

public class PalindromeUtilTest{
	
	@Test
	public void isPalindromeTest() {
		assertTrue(PalindromeUtil.isPalindrome("abba"));
		assertTrue(PalindromeUtil.isPalindrome("aba"));
		assertFalse(PalindromeUtil.isPalindrome("abca"));
		assertFalse(PalindromeUtil.isPalindrome("ac"));
	}
}
