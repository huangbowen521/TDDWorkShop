package thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EmailTemplateEngineTest {


    //given "你好", result "你好"

    @Test
    public void should_get_plain_text_given_template_is_plain_text() {
        // given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("你好");

        // when
        String result = templateEngine.transform();

        // then
        assertThat(result,equalTo("你好"));

    }

    @Test
    public void should_get_plain_text_given_template_is_another_plain_text() {
        // given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("hello,world");

        // when
        String result = templateEngine.transform();

        // then
        assertThat(result,equalTo("hello,world"));

    }


    // given "你好,${name}", name=华为 result "你好,华为"

    @Test
    public void should_get_replaced_template_given_template_contains_one_variable() {
        //given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("你好,${name}");
        templateEngine.addVariable("name","华为");

        //when
        String result = templateEngine.transform();


        //then
        assertThat(result,equalTo("你好,华为"));
    }


    // given "${greeting},${name}" greeting=你好,name=IT,result "你好,IT"

    @Test
    public void should_get_replaced_template_given_template_contains_multiple_variables() {
        //given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("${greeting},${name}");
        templateEngine.addVariable("greeting","你好");
        templateEngine.addVariable("name","IT");

        //when
        String result = templateEngine.transform();


        //then
        assertThat(result,equalTo("你好,IT"));
    }


    @Test
    public void should_get_replaced_template_given_template_contains_multiple_variablesV2() {
        //given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("${name},${greeting}");
        templateEngine.addVariable("greeting","name");
        templateEngine.addVariable("name","greeting");

        //when
        String result = templateEngine.transform();

        //then
        assertThat(result,equalTo("greeting,name"));
    }


    //given "你好,${name}" name = null, throw MissingValueError

    @Test(expected = MissingValueError.class)
    public void should_get_MissingValueError_given_not_init_variable() {
        // given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("你好,${name}");

        // when
        templateEngine.transform();

    }



    // given "你好,${name}" doestnotexist=你好,name=IT result "你好,IT"


    @Test
    public void should_get_replaced_template_given_template_contains_extra_variable() {
        //given
        EmailTemplateEngine templateEngine = new EmailTemplateEngine("你好,${name}");
        templateEngine.addVariable("name","华为");
        templateEngine.addVariable("notExist","bowen");

        //when
        String result = templateEngine.transform();


        //then
        assertThat(result,equalTo("你好,华为"));
    }

}
