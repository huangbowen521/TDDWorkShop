package thoughtworks;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TemplateParserTest {


    @Test
    public void should_get_plain_text_given_plain_text() {
        TemplateParser templateParser = new TemplateParser();
        List<Segment> result = templateParser.parse("你好");

        assertThat(result.size(),is(1));
        assertEquals(result.get(0),new PlainText("你好"));
    }


    @Test
    public void should_get_plain_text_given_plain_text_and_variables() {
        TemplateParser templateParser = new TemplateParser();
        List<Segment> result = templateParser.parse("你好,${firstName}");

        assertThat(result.size(),is(2));
        assertEquals(result.get(0), new PlainText("你好,"));
        assertEquals(result.get(1),new VariablePart("firstName"));
    }

    @Test
    public void should_get_variables_given_variables() {
        TemplateParser templateParser = new TemplateParser();
        List<Segment> result = templateParser.parse("${firstName}");

        assertThat(result.size(),is(1));
        assertEquals(result.get(0), new VariablePart("firstName"));
    }

    @Test
    public void should_get_empty_given_empty() {
        TemplateParser templateParser = new TemplateParser();
        List<Segment> result = templateParser.parse("");

        assertThat(result.size(),is(1));
        assertEquals(result.get(0), new PlainText(""));
    }

    @Test
    public void should_get_multiple_result_given_multiple_variable() {
        TemplateParser templateParser = new TemplateParser();
        List<Segment> result = templateParser.parse("${firstName},${lastName}");

        assertThat(result.size(),is(3));
        assertEquals(result.get(0), new VariablePart("firstName"));
        assertEquals(result.get(1), new PlainText(","));
        assertEquals(result.get(2), new VariablePart("lastName"));
    }








}
