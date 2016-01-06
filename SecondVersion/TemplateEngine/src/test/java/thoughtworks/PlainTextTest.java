package thoughtworks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlainTextTest {


    @Test
    public void should_equals_if_the_template_is_equals() {
        //given
        String template = "hello, world";
        PlainText thisPlainText = new PlainText(template);
        PlainText thatPlainText = new PlainText(template);

        //then
        assertEquals(thisPlainText,thatPlainText);
    }

}