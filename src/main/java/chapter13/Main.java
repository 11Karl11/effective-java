package chapter13;

/**
 * @author karl xie
 */
public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("3");
        stack.push("d");
        stack.push("c");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}