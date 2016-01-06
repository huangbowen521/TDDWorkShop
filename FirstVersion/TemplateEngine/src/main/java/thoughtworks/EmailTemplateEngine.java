package thoughtworks;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTemplateEngine {
    private String template;

    private HashMap<String, String> variables = new HashMap<String, String>();

    public EmailTemplateEngine(String template) {

        this.template = template;
    }

    public String transform() {

        String result = template;

        if (variables.size() > 0) {

            for (Map.Entry<String, String> entry : variables.entrySet()) {

                String replacedKey = "\\$\\{" + entry.getKey() + "\\}";
                result = result.replaceAll(replacedKey, entry.getValue());
            }

        }

        Pattern pattern = Pattern.compile("\\$\\{[^}]+\\}");
        Matcher matcher = pattern.matcher(result);
        if(matcher.find()) {
            throw new MissingValueError();
        }

        return result;
    }

    public void addVariable(String key, String value) {

        variables.put(key, value);
    }
}
