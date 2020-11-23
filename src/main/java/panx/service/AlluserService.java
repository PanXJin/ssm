package panx.service;

import panx.entity.AllUser;

import java.util.List;

public interface AlluserService {
    List<AllUser> GetAlluser();
    AllUser getUserData(String userName,String passWord);
    void setToken(String Token,String userId);
    boolean register(String userId,String userName,String psw,String name ,String token);
}
