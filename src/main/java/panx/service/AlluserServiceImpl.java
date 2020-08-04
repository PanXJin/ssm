package panx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panx.entity.AllBook;
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
        return alluserMapper.GetAlluser();
    }

    @Override
    public boolean isLoginOK(String username, String password) {
        //这里使用了最简单粗暴的方法，获取全部用户信息后再逐个进行对比
        List<AllUser> list = GetAlluser();
        for (AllUser arr:list) {
            if(username.equals(arr.getUsernum())&&password.equals(arr.getPassword()))
                return true;
        }
        return false;
    }
}
