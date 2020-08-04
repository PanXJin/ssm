package panx.service;

import panx.entity.AllUser;

import java.util.List;

public interface AlluserService {
    List<AllUser> GetAlluser();
    boolean isLoginOK(String username, String password);
}
