package tk.suyuesheng.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JackSonTextDemo {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.setAge(20);
        person.setName("zhang");
        person.setSex("man");
        person.setDate(new Date());
        System.out.println(person.toString());
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(person);
        System.out.println(s);
        mapper.writeValue(new File("e:"+File.separator+"a.txt"), person);
    }
    @Test
    public void testOne() throws IOException {
        Person person = new Person();
        person.setDate(new Date());
        person.setSex("男");
        person.setAge(16);
        person.setName("老王");
        List<Object> list = new ArrayList<Object>();
        list.add(person);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", "老张");
        map.put("sex", "男");
        String s1 = mapper.writeValueAsString(map);
        System.out.println(s1);
        for (Object o : list) {
            System.out.println(o);
        }
        String jj = "{\"name\":\"老王\",\"age\":16,\"sex\":\"男\",\"date\":\"2020-03-25\"}";
        Person person1 = mapper.readValue(jj, person.getClass());
        System.out.println(person1);
    }
}
