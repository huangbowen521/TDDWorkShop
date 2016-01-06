package thoughtworks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {
    public static final String VARIABLE_PATTERN = "\\$\\{([^}]+)\\}";
    private String template;
    private HashMap<String,String> variables= new HashMap<String, String>();

    public TemplateEngine(String template) {
        this.template = template;
    }

    public String transferV1() {

        String result = template;
        result = replaceVariable(result);

        return result;
    }

    public String transferV2() {

        StringBuilder result = new StringBuilder();
        List<Segment> segments = new TemplateParser().parse(template);

        for(Segment segment: segments) {
            result.append(segment.evaluate(variables));
        }

        return result.toString();
    }

    private String replaceVariable(String result) {
        Pattern pattern = Pattern.compile(VARIABLE_PATTERN);

        Matcher matcher = pattern.matcher(template);

        while(matcher.find()) {
            String variable = matcher.group(1);

            if (!variables.containsKey(variable)) {
                throw new MissingValueException();
            }

            for(Map.Entry entry : variables.entrySet()) {
                if (variable.equals(entry.getKey())) {
                    result = result.replaceAll("\\$\\{" + entry.getKey() + "\\}", String.valueOf(entry.getValue()));
                }
            }
        }
        return result;
    }

    public void addTemplateVariable(String key, String value) {
        variables.put(key,value);
    }
}
