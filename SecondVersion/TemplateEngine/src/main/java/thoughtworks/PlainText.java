package thoughtworks;

import java.util.HashMap;

public class PlainText extends Segment {

    @Override
    public boolean equals(Object that) {
        return this.getTemplate().equals(((PlainText)that).getTemplate());
    }

    public PlainText(String template) {
        super(template);
    }

    @Override
    public String evaluate(HashMap<String, String> variables) {
        return getTemplate();
    }
}
