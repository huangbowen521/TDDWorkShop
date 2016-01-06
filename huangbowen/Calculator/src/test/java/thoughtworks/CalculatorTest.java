package thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_get_result_given_one_value() {
        // given
        Calculator calculator = new Calculator("4");

        // when
        int result = calculator.calculate();

        // then
        assertThat(result, is(4));
    }

    @Test
    public void should_get_result_given_one_add_another() {
        // given
        Calculator calculator = new Calculator("4+5");

        // when
        int result = calculator.calculate();

        // then
        assertThat(result, is(9));
    }

    @Test
    public void should_get_result_given_test() {

        test_expression("4+5", 9);
        test_expression("4+3-1", 6);
        test_expression("4*3-2",10);
        test_expression("5-5/5",4);
        test_expression("6-8+5/5+2*2",3);
        test_expression("(1+1)-2",0);
        test_expression("10-8+100*2",202);
        test_expression("(2*(8-1))*2",28);
    }


    private void test_expression(String expression, int expect) {
        // given
        Calculator calculator = new Calculator(expression);

        // when
        int actual = calculator.calculate();

        // then
        assertThat(actual, is(expect));
    }
}
