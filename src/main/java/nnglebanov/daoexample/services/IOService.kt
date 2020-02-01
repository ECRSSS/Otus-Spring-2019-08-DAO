package nnglebanov.daoexample.services;

import org.apache.commons.lang3.math.NumberUtils;
import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class IOService {

    public IOService(@Lazy LineReader lineReader) {
        this.lineReader = lineReader;
    }

    private final LineReader lineReader;

    public String readLine() {
        return lineReader.readLine();
    }

    public String readLineWithMessage(String message) {
        System.out.println(message);
        return readLine();
    }

    public Integer readIntWithMessage(String message) {
        while (true) {
            String value = readLineWithMessage(message);
            if (NumberUtils.isParsable(value)) {
                return Integer.parseInt(value);
            } else {
                System.out.println("This is not number, please input number");
                continue;
            }
        }
    }
}