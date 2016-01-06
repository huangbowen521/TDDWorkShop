package thoughtworks;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class VariablePartTest {


    @Test
    public void should_equals_given_template_is_equals() {
        //given
        String template = "name";
        VariablePart thisVariablePart = new VariablePart(template);
        VariablePart thatVariablePart = new VariablePart(template);

        //then
        assertThat(thisVariablePart,equalTo(thatVariablePart));

    }


    @Test(expected = MissingValueException.class)
    public void should_get_exception_given_missing_variable() {
        //given
        VariablePart variablePart = new VariablePart("name");
        HashMap<String,String> variables = new HashMap<String, String>();

        //then
        variablePart.evaluate(variables);
    }


    @Test
    public void should_get_replaced_value_given_variable(){
        //given
        VariablePart variablePart = new VariablePart("name");
        HashMap<String, String> variables = new HashMap<String, String>();
        variables.put("name","bowen");

        //when
        String result = variablePart.evaluate(variables);

        //then
        assertThat(result,equalTo("bowen"));


    }


}