package chapter24;

/**
 * @author karl xie
 */
public class Message implements Transportable {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

