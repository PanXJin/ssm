package panx.controller;

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
     * @param request
     * @return
     */
    @RequestMapping("/GetAll")
    public String test(HttpServletRequest request){
        System.out.println("来过");
        List<AllBook> list = allbookService.GetAll();
        for (AllBook arr:list) {
            System.out.println(arr.getCodenum());
        }
        request.getSession().setAttribute("panxlist",list);
        return "show";
    }
}
