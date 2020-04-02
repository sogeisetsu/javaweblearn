import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tone {
    @Test
    public void one(){
        String str = "hello world ! ll.";
        String pattern = ".*";
        System.out.println(str.matches(pattern));
        Pattern pattern1 = Pattern.compile(pattern);
        System.out.println(pattern1.pattern());
        Matcher matcher = pattern1.matcher(str);
        System.out.println("============");
        System.out.println(matcher.pattern());
        System.out.println(matcher);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println("=========");
        String w = "Windows 2000";
        System.out.println(w.matches("\\w*\\s(?=2000|95)"));
        Pattern p = Pattern.compile("\\w*?\\s(?=2000|95)");
        Matcher matcher1 = p.matcher(w);
        while (matcher1.find()){
            System.out.println(matcher1.group());
        }

    }
}
