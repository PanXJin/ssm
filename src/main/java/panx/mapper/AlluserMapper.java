package panx.mapper;

import panx.entity.AllUser;

import java.util.List;

public interface AlluserMapper {
    List<AllUser> getAlluser();
    AllUser getUserData(String userName, String passWord);
}
