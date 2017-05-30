import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Tests {
    private fun assertFileContent(nameOut: String, nameIn: String) {
        val fileExpected = File(nameOut)
        val fileOut = File(nameIn)
        val contentExpected = fileExpected.readLines()
        val contentOut = fileOut.readLines()
        assertEquals(contentOut, contentExpected)
    }


    @Test
    fun main() {
        var input = arrayOf("-c", "-o", "C://output/out1.txt", "C://input/in1.txt", "2-4")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out1.txt", "C://expected/exp1.txt")

        input = arrayOf("-w", "-o", "C://output/out2.txt", "C://input/in2.txt", "2-")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out2.txt", "C://expected/exp2.txt")

        input = arrayOf("-c", "-o", "C://output/out3.txt", "C://input/in3.txt", "18-")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out3.txt", "C://expected/exp3.txt")

        input = arrayOf("-w", "-o", "C://output/out4.txt", "C://input/in4.txt", "4-")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out4.txt", "C://expected/exp4.txt")

        input = arrayOf("-w", "-o", "C://output/out4.txt", "C://input/in4.txt", "4-")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out4.txt", "C://expected/exp4.txt")

        input = arrayOf("-w", "-o", "C://output/out5.txt", "C://input/in5.txt", "4-5")
        CutTheTextLauncher.main(input)
        assertFileContent("C://output/out5.txt", "C://expected/exp5.txt")
    }
}