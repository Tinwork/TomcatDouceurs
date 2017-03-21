package bean;

/**
 * Created by lookitsmarc on 21/03/2017.
 */
public class UserBean {
    private String username;
    private String mail;

    /**
     * SetUsername
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * SetMail
     * @param mail
     */
    public void setPassword(String mail){
        this.mail = mail;
    }

    /**
     * GetUsername
     * @return
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * GetMail
     * @return
     */
    public String getPassword(){
        return this.mail;
    }
}
