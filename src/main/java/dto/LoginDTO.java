package dto;

public class LoginDTO {
    public LoginDTO(String UserName, String PassWord){
        this.UserName = UserName;
        this.PassWord = PassWord;

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    String UserName = null;
    String PassWord = null;
}
