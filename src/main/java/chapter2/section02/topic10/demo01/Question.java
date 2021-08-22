package chapter2.section02.topic10.demo01;

/**
 * Created by 76973 on 2021/8/16 20:50
 */
public class Question {
    private String username;
    private String content;

    public Question(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
