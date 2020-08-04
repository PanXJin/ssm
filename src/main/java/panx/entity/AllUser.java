package panx.entity;

public class AllUser {
    private Integer usernum;
    private Integer password;
    private String username;
    private String nowbook;
    private String allbooknum;
    private String gods;

    public String getNowbook() {
        return nowbook;
    }

    public void setNowbook(String nowbook) {
        this.nowbook = nowbook;
    }

    public Integer getUsernum() {
        return usernum;
    }

    public void setUsernum(Integer usernum) {
        this.usernum = usernum;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAllbooknum() {
        return allbooknum;
    }

    public void setAllbooknum(String allbooknum) {
        this.allbooknum = allbooknum;
    }

    public String getGods() {
        return gods;
    }

    public void setGods(String gods) {
        this.gods = gods;
    }
}
