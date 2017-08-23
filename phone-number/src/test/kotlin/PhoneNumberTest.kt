import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PhoneNumberTest {


    @Test
    fun cleansNumber() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("(223) 456-7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun cleansNumberWithDots() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("223.456.7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun validWhen11DigitsAndFirstIs1() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("12234567890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidWhen10DigitsAndFirstIs1() {
        PhoneNumber("1234567890")
        fail("IllegalArgumentException should have been thrown")
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidWhenOnly11Digits() {
        PhoneNumber("21234567890")
        fail("IllegalArgumentException should have been thrown")
    }

    @Test(expected = IllegalArgumentException::class)
    fun invalidWhen9Digits() {
        PhoneNumber("223456789")
        fail("IllegalArgumentException should have been thrown")
    }

    @Test
    fun areaCode() {
        val expectedAreaCode = "223"
        val actualAreaCode = PhoneNumber("2234567890").areaCode

        assertEquals(expectedAreaCode, actualAreaCode)
    }

    @Test
    fun toStringPrint() {
        val expectedtoStringNumber = "(223) 456-7890"
        val actualtoStringNumber = PhoneNumber("2234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

    @Test
    fun toStringPrintWithFullUSPhoneNumber() {
        val expectedtoStringNumber = "(223) 456-7890"
        val actualtoStringNumber = PhoneNumber("12234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

}
