package nnglebanov.daoexample.services

import nnglebanov.daoexample.services.business.ObjectsPrintService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.jline.InteractiveShellApplicationRunner
import org.springframework.test.context.jdbc.Sql

@SpringBootTest(properties = [InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=" + false])
class OutServiceTest {
    @Autowired
    internal var printService: ObjectsPrintService? = null

    @Test
    fun testOut() {
        printService!!.outAllBooks()
    }
}
