package panx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panx.entity.AllUser;
import panx.mapper.AlluserMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("AlluserServiceImpl")
public class AlluserServiceImpl implements AlluserService{
    @Autowired
    @Resource
    private AlluserMapper alluserMapper;

    public AlluserMapper getAlluserMapper() {
        return alluserMapper;
    }

    public void setAlluserMapper(AlluserMapper alluserMapper) {
        this.alluserMapper = alluserMapper;
    }

    @Override
    public List<AllUser> GetAlluser() {
        return alluserMapper.getAlluser();
    }

    @Override
    public AllUser getUserData(String userName, String passWord) {
        return alluserMapper.getUserData(userName, passWord);
    }

}
