package panx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import panx.entity.AllBook;
import panx.service.AllbookService;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AlluserController {
    private AllbookService allbookService = (AllbookService) Singleton.GetApplicationContext().getBean("AllbookServiceImpl");
    /**
     * 获取所有数据并且返回到index.jsp页面
     * @param request
     * @return
     */
    @RequestMapping("/GetAllusers")
    public String test(HttpServletRequest request){
        System.out.println("来过");
        List<AllBook> list = allbookService.GetAll();
        for (AllBook arr:list) {
            System.out.println(arr.getCodenum());
        }
        request.getSession().setAttribute("panxuserlist",list);
        return "show";
    }
}
