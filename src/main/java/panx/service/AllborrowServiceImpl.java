package panx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panx.entity.AllBorrow;
import panx.mapper.AllborrowMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("AllborrowServiceImpl")
public class AllborrowServiceImpl implements AllborrowService{
    @Autowired
    @Resource
    AllborrowMapper allborrowMapper;

    public AllborrowMapper getAllborrowMapper() {
        return allborrowMapper;
    }

    public void setAllborrowMapper(AllborrowMapper allborrowMapper) {
        this.allborrowMapper = allborrowMapper;
    }

    @Override
    public AllBorrow GetAllBorrow(String borrowId) {
        return allborrowMapper.getBorrow(borrowId);
    }
}
