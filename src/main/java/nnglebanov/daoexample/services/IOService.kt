package nnglebanov.daoexample.services

import org.apache.commons.lang3.math.NumberUtils
import org.jline.reader.LineReader
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class IOService(@param:Lazy private val lineReader: LineReader) {

    fun readLine(): String {
        return lineReader.readLine()
    }

    fun readLineWithMessage(message: String): String {
        println(message)
        return readLine()
    }

    fun readIntWithMessage(message: String): Int? {
        while (true) {
            val value = readLineWithMessage(message)
            if (NumberUtils.isParsable(value)) {
                return Integer.parseInt(value)
            } else {
                println("This is not number, please input number")
                continue
            }
        }
    }
}