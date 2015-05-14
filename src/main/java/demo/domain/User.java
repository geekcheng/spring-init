package demo.domain;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by geek on 2015/5/14.
 */
public class User {

    public interface WithoutPasswordView{};
    public interface WithPasswordView extends WithoutPasswordView{}
    private String username;
    private String password;

    public User(){
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
