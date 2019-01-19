package PracticeJavaHighConcurrency.chapter6;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class MethodRefDemo {
    public static void main(String[] args) {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            User u = new User();
            u.setName("name" + i);
            users.add(u);
        }

        users.stream().map(User::getName).forEach(System.out::println);


        List<Double> doubles = Arrays.asList(Double.valueOf("8.0"));
        // 编译不通过
//        doubles.stream().map(Double::toString).forEach(System.out::println);

    }


    static class User {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
