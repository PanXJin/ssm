package panx.service;

import panx.entity.AllBook;

import java.util.List;

public interface AllbookService {
    List<AllBook> GetAllbook();
    List<AllBook> Findbook(String codenum);
}
