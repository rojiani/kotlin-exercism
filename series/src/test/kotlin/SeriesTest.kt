import org.junit.Test
import kotlin.test.assertEquals

class SeriesTest {


    @Test
    fun slicesOfOne() {
        assertEquals(listOf(), Series.slices(1, ""))
        assertEquals(
                listOf(listOf(0), listOf(1), listOf(2), listOf(3), listOf(4)),
                Series.slices(1, "01234")
        )
    }

    @Test
    fun slicesOfTwo() {
        assertEquals(listOf(), Series.slices(2, ""))
        assertEquals(listOf(listOf(0, 1)), Series.slices(2, "01"))
        assertEquals(
                listOf(listOf(0, 1), listOf(1, 2), listOf(2, 3), listOf(3, 4)),
                Series.slices(2, "01234")
        )
    }

    @Test
    fun slicesOfThree() {
        assertEquals(listOf(), Series.slices(3, ""))
        assertEquals(listOf(listOf(0, 1, 2)), Series.slices(3, "012"))
        assertEquals(
                listOf(listOf(0, 1, 2), listOf(1, 2, 3), listOf(2, 3, 4)),
                Series.slices(3, "01234")
        )
    }
}
