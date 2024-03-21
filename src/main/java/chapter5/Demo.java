package chapter5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 事实上，为了保留你真正想看到的异常，可能会抑制多个异常。 这些抑制的异常没有被抛弃， 而是打印在堆栈跟踪中，并标注为被抑制了。
 * 你也可以使用getSuppressed 方法以编程方式访问它们，该方法在 Java 7 中已添加到的Throwable 中。
 * @author karl xie
 */
public class Demo {


    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }catch (Exception e){
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                throwable.printStackTrace();
            }
            return "default";
        }
    }
}