package thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PerformanceTest {

    @Test
    public void should_get_better_performance() {


        long start = System.currentTimeMillis();
        for (int i = 0; i <= 1000000; i++) {
            testPerformanceV1();
        }

        long end = System.currentTimeMillis();

        long firstRun = end -start;

        for (int i = 0; i <= 1000000; i++) {
            testPerformanceV2();
        }

        long secondEnd = System.currentTimeMillis();

        long secondRun = secondEnd - end;

        System.out.println(firstRun);
        System.out.println(secondRun);

        assertTrue("the performance of second version should be better",firstRun > secondRun);

    }

    private void testPerformanceV1() {

        //given
        TemplateEngine templateEngine = new TemplateEngine("你好，${firstName}，${lastName}");

        //when
        templateEngine.addTemplateVariable("firstName", "华为");
        templateEngine.addTemplateVariable("lastName", "上海");
        String result = templateEngine.transferV1();

        //then
        assertThat(result, is("你好，华为，上海"));
    }


    private void testPerformanceV2() {

        //given
        TemplateEngine templateEngine = new TemplateEngine("你好，${firstName}，${lastName}");

        //when
        templateEngine.addTemplateVariable("firstName", "华为");
        templateEngine.addTemplateVariable("lastName", "上海");
        String result = templateEngine.transferV2();

        //then
        assertThat(result, is("你好，华为，上海"));
    }





}
