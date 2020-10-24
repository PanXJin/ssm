package panx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panx.entity.AllBook;
import panx.mapper.AllbookMapper;
import javax.annotation.Resource;

import java.util.List;
@Service("AllbookServiceImpl")
public class AllbookServiceImpl implements AllbookService{
    @Autowired
    @Resource
    private AllbookMapper allbookMapper;

    public AllbookMapper getAllbookMapper() {
        return allbookMapper;
    }

    public void setAllbookMapper(AllbookMapper allbookMapper) {
        this.allbookMapper = allbookMapper;
    }

    @Override
    public List<AllBook> GetAllbook() {
        return allbookMapper.GetAllbook();
    }

    @Override
    public List<AllBook> Findbook(String codenum) {
        return null;
    }
}
