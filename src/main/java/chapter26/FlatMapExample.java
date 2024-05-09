package chapter26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author karl xie
 */
public class FlatMapExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Alice", Arrays.asList("Math", "English")),
                new Student("Bob", Arrays.asList("History", "Biology")), new Student("Carol", Arrays.asList("Biology", "Math")));

        List<String> allCourses = students.stream().flatMap(student -> student.getCourses().stream()).distinct().collect(Collectors.toList());


        System.out.println(allCourses);
    }

    static class Student {
        private String name;
        private List<String> courses;

        public Student(String name, List<String> courses) {
            this.name = name;
            this.courses = courses;
        }

        public List<String> getCourses() {
            return courses;
        }
    }
}