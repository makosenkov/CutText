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
        var input = arrayOf("-c", "-o", "tests/files/output/out1.txt", "tests/files/input/in1.txt", "2-4")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out1.txt", "tests/files/expected/exp1.txt")

        input = arrayOf("-w", "-o", "tests/files/output/out2.txt", "tests/files/input/in2.txt", "2-")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out2.txt", "tests/files/expected/exp2.txt")

        input = arrayOf("-c", "-o", "tests/files/output/out3.txt", "tests/files/input/in3.txt", "18-")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out3.txt", "tests/files/expected/exp3.txt")

        input = arrayOf("-w", "-o", "tests/files/output/out4.txt", "tests/files/input/in4.txt", "4-")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out4.txt", "tests/files/expected/exp4.txt")

        input = arrayOf("-w", "-o", "tests/files/output/out5.txt", "tests/files/input/in5.txt", "4-5")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out5.txt", "tests/files/expected/exp5.txt")

        input = arrayOf("-c", "-o", "tests/files/output/out6.txt", "tests/files/input/in6.txt", " -2")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out6.txt", "tests/files/expected/exp6.txt")

        input = arrayOf("-w", "-o", "tests/files/output/out7.txt", "tests/files/input/in7.txt", " -2")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out7.txt", "tests/files/expected/exp7.txt")

        input = arrayOf("-c", "-o", "tests/files/output/out8.txt", "tests/files/input/in8.txt", " -500")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out8.txt", "tests/files/expected/exp8.txt")

        input = arrayOf("-c", "-o", "tests/files/output/out9.txt", "tests/files/input/in9.txt", "650-980")
        CutTheTextLauncher.main(input)
        assertFileContent("tests/files/output/out9.txt", "tests/files/expected/exp9.txt")
    }
}