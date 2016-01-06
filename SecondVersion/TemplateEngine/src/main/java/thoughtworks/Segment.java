package thoughtworks;

import java.util.HashMap;

public abstract class Segment {

    protected String template;

    public Segment(String template) {

        this.template = template;
    }

    public abstract String evaluate(HashMap<String,String> variables);

    public String getTemplate() {
        return template;
    }
}
