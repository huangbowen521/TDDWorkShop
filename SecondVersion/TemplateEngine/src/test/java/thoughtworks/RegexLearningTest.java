package thoughtworks;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RegexLearningTest {


    @Test
    public void should_get_correct_value_when_match_variable() {
        //given
        String template = "hello, ${name}";
        Pattern pattern = Pattern.compile("\\$\\{[^}]+\\}");

        //when
        Matcher matcher = pattern.matcher(template);

        //then
        assertThat(matcher.find(),is(true));
        assertThat(matcher.start(),is(7));
        assertThat(matcher.end(),is(template.length()));
    }
}
