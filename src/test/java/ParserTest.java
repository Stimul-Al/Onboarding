import by.leverx.task_one.service.Parser;
import by.leverx.task_one.service.impl.ParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    void init() {
        parser = new ParserImpl();
    }

    @Test
    void testParseLine() {
        //given
        String str = "aaawwwwWWWWWmmmmmm1111";
        String expected = "m: 6";

        //when
        String actual = parser.func(str);

        //then
        Assertions.assertEquals(expected, actual);

    }
}


