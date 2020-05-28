package be.ucll.todolist.model.converter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StringToLocalDateTimeTest {

    private StringToLocalDateTime stringToLocalDateTime = new StringToLocalDateTime();

    Locale locale = new Locale.Builder().setLanguage("nl").setRegion("BE").build();

    LocalDateTime localDateTime1 = LocalDateTime.of(2000,2,23,23,34);

    @Test
    void testFromStringToLocaldatetime() throws ParseException {

        String timeInString = "23-02-2000 23:34";


        LocalDateTime localDateTime = stringToLocalDateTime.parse(timeInString,locale);



        assertEquals(localDateTime,localDateTime1);
    }

    @Test
    void testFromLocaldatetimeToString(){
        String timeInString = "23-02-2000 23:34";


        assertEquals(stringToLocalDateTime.print(localDateTime1,locale),timeInString);

    }
}
