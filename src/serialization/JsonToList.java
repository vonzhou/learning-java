package serialization;

import com.alibaba.fastjson.JSON;
import serialization.jackson.JacksonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author vonzhou
 * @date 2018/12/6
 */
public class JsonToList {

    public static void main(String[] args) {

        String s = "[{\"name\":\"vonz\", \"age\":99}]";
        List<Foo> list = useJackson(s);
        System.out.println(list);

        list = useFastjson(s);
        System.out.println(list);


        s = "[{\"name\":\"vonz\", \"age\":99}, {\"name\":\"vonz\", \"age\":99}]";
         list = useJacksonMultiType(s);
        System.out.println(list);

        list = useFastjson(s);
        System.out.println(list);
    }


    public static List<Foo> useJackson(String s) {
        Foo[] ar = JacksonUtils.fromJson(s, Foo[].class);
        return Arrays.asList(ar);
    }

    public static List<Foo> useJacksonMultiType(String s) {
        Foo[] ar = JacksonUtils.fromJson(s, Foo[].class);
        return Arrays.asList(ar);
    }


    public static List<Foo> useFastjson(String s) {
        return JSON.parseArray(s, Foo.class);
    }

    static class Foo {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Bar extends Foo {
        private String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }


        @Override
        public String toString() {
            return "Bar{" +
                    "name='" + super.name + '\'' +
                    ", age=" + super.age +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

}
