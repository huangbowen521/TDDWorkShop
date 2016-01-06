package thoughtworks;

import java.util.HashMap;

public class VariablePart extends Segment {

    public VariablePart(String template) {
        super(template);
    }

    @Override
    public boolean equals(Object other) {
        return this.getTemplate().equals(((VariablePart)other).getTemplate());
    }

    @Override
    public String evaluate(HashMap<String, String> variables) {

        if (variables.containsKey(template)) {
            return variables.get(template);
        }

        throw new MissingValueException();
    }
}
