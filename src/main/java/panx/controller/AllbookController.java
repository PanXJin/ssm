package panx.controller;

import io.github.yidasanqian.json.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import panx.service.AllbookService;
import panx.entity.AllBook;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AllbookController {
    private AllbookService allbookService = (AllbookService) Singleton.GetApplicationContext().getBean("AllbookServiceImpl");

    /**
     * 获取所有数据并且返回到index.jsp页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/GetAllbooks")
    public String test(HttpServletRequest request) {
        List<AllBook> list = allbookService.GetAllbook();
        for (AllBook arr : list) {
            System.out.println(arr.getBookcode());
        }
        request.getSession().setAttribute("panxbooklist", list);
        return "showbook";
    }

    @RequestMapping("/findbook")
    public String findbook(HttpServletRequest request) {
        String codenum = request.getParameter("codenum");
        String json = JsonUtil.toJsonString(allbookService.Findbook(codenum));
        return json;
    }
}
