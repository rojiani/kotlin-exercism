import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {


    @Test
    fun singleDigitStringsCannotBeValid() {
        assertFalse(Luhn.isValid("1"))
    }

    @Test
    fun singleZeroIsInvalid() {
        assertFalse(Luhn.isValid("0"))
    }

    @Test
    fun simpleValidSINThatRemainsValidIfReversed() {
        assertTrue(Luhn.isValid("059"))
        assertTrue(Luhn.isValid("950"))
    }

    @Test
    fun simpleValidSINThatBecomesInvalidIfReversed() {
        assertTrue(Luhn.isValid("59"))
        assertFalse(Luhn.isValid("95"))
    }

    @Test
    fun validCanadianSIN() {
        assertTrue(Luhn.isValid("055 444 285"))
    }

    @Test
    fun invalidCanadianSIN() {
        assertFalse(Luhn.isValid("055 444 286"))
    }

    @Test
    fun invalidCreditCard() {
        assertFalse(Luhn.isValid("8273 1232 7352 0569"))
    }

    @Test
    fun validCreditCard() {
        assertTrue(Luhn.isValid("4539 1488 0343 6467"))
    }

    @Test
    fun validStringsWithNonDigitIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055a 444 285"))
    }

    @Test
    fun validStringsWithPunctuationIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055-444-285"))
    }

    @Test
    fun validStringsWithSymbolsIncludedBecomeInvalid() {
        assertFalse(Luhn.isValid("055£ 444$ 285"))
    }

    @Test
    fun singleZeroWithSpaceIsInvalid() {
        assertFalse(Luhn.isValid(" 0"))
    }

    @Test
    fun moreThanSingleZeroIsValid() {
        assertTrue(Luhn.isValid("0000 0"))
    }

    @Test
    fun inputDigit9IsCorrectlyConvertedToOutputDigit9() {
        assertTrue(Luhn.isValid("091"))
    }

}
