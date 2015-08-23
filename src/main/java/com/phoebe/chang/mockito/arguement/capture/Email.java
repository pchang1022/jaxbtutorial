package com.phoebe.chang.mockito.arguement.capture;

/**
 * Created by phoebe on 8/23/15.
 *
 * https://gist.github.com/searls/864224
 * An example of behavior verification + argument capture with Mockito (on TestNG)
 *
 */
public class Email {

    private String domain;
    private String user;
    private String body;

    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
