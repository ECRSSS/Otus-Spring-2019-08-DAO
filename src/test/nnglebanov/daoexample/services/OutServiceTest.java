package nnglebanov.daoexample.services;

import nnglebanov.daoexample.services.business.ObjectsPrintService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;

@SpringBootTest(properties = {InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=" + false})
public class OutServiceTest {
    @Autowired
    ObjectsPrintService printService;

    @Test
    public void testOut() {
        printService.outAllBooks();
    }
}
