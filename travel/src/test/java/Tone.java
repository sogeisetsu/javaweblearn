import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tone {
    @Test
    public void one(){
        String str = "hello world ! ll.";
        String pattern = ".*";
        System.out.println(str.matches(pattern));//true
        Pattern pattern1 = Pattern.compile(pattern);
        System.out.println(pattern1.pattern());//.*
        Matcher matcher = pattern1.matcher(str);
        System.out.println("============");
        System.out.println(matcher.pattern());//.*
        System.out.println(matcher);//java.util.regex.Matcher[pattern=.* region=0,17 lastmatch=]
        System.out.println(matcher.find());//true
        System.out.println(matcher.group());//hello world ! ll.
        System.out.println("=========");
        String w = "Windows 2000";
        System.out.println(w.matches("\\w*\\s(?=2000|95)"));//false
        Pattern p = Pattern.compile("\\w*?\\s(?=2000|95)");
        Matcher matcher1 = p.matcher(w);
        while (matcher1.find()){
            System.out.println(matcher1.group());//Windows
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        String ww = "Windows 3.5";
        Matcher mww = p.matcher(ww);
        System.out.println(mww.matches());//false
        System.out.println(mww.find());//false
    }
    @Test
    public void authora(){
        List<Object> list = new ArrayList<Object>();
        List<Object> cc = new ArrayList<>();
        cc.add(12);
        cc.add("kk");
        System.out.println(cc);
        System.out.println(">------------");
        list.add(12);
        list.add("hello");
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
