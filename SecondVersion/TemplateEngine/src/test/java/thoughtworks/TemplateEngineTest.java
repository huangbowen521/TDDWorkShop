package thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TemplateEngineTest {

    @Test
    public void should_get_plain_text_given_plain_text() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello,world");

        //when
        String actual = templateEngine.transferV1();

        //then
        assertThat(actual,is("hello,world"));
    }

    @Test
    public void should_get_plain_text_given_another_plain_text() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello,huawei");

        //when
        String actual = templateEngine.transferV1();

        //then
        assertThat(actual,is("hello,huawei"));
    }


    // given "hello, ${name}" name=bowen, result: "hello, bowen"

    @Test
    public void should_get_name_text_given_name_text() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello,${name}");
        templateEngine.addTemplateVariable("name","bowen");

        //when
        String actual = templateEngine.transferV1();

        //then
        assertThat(actual,is("hello,bowen"));
    }


    // given "hello, ${firstName}, ${lastName}" firstName=bowen,lastName=huang  result: "hello, bowen, huang"

    @Test
    public void should_get_name_text_given_mulitpe_name() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello,${firstName},${lastName}");
        templateEngine.addTemplateVariable("firstName","bowen");
        templateEngine.addTemplateVariable("lastName","huang");

        //when
        String actual = templateEngine.transferV1();

        //then
        assertThat(actual,is("hello,bowen,huang"));
    }




    // given "hello, ${name}" name have no value, result: throw exception: MissingValueException


    @Test(expected = MissingValueException.class)
    public void should_get_exception_given_none_variable_init() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello,${name}");

        //when
        templateEngine.transferV1();

    }

    // given "hello, ${name}"  name=bowen, lastName=huang result: "hello, bowen"

    @Test
    public void should_get_correct_result_given_extra_variables() {
        //given
        TemplateEngine templateEngine = new TemplateEngine("hello, ${name}");
        templateEngine.addTemplateVariable("name","bowen");
        templateEngine.addTemplateVariable("lastName","huang");
        templateEngine.addTemplateVariable("lastName","bowen");

        //when
        String actual = templateEngine.transferV1();

        //then
        assertThat(actual,is("hello, bowen"));


    }


}
