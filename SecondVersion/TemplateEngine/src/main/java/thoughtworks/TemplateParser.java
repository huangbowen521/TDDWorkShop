package thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParser {

        public List<Segment> parse(String template) {
            List<Segment> segments = new ArrayList<Segment>();
            int index = collectSegments(template, segments);
            addTail(template, segments, index);
            addPlainTextIfTemplateIsEmpty(segments);
            return segments;
        }

    private void addPlainTextIfTemplateIsEmpty(List<Segment> segments) {
        if (segments.isEmpty()) {
            segments.add(new PlainText(""));
        }
    }

    private void addTail(String template, List<Segment> segments, int index) {
        if (index < template.length()) {
            segments.add(new PlainText(template.substring(index,template.length())));
        }
    }

    private int collectSegments(String template, List<Segment> segments) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(template);
        int index = 0;
        while (matcher.find()) {
            addPredicatePlainText(template, segments, matcher, index);
            addVariable(template, segments, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addVariable(String template, List<Segment> segments, Matcher matcher) {
        segments.add((new VariablePart(template.substring(matcher.start()+2,matcher.end()-1))));
    }

    private void addPredicatePlainText(String template, List<Segment> segments, Matcher matcher, int index) {
        if (matcher.start()!= 0 && matcher.start() > index) {
            segments.add(new PlainText(template.substring(index,matcher.start())));
        }
    }
}
