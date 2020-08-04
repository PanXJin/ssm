package panx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import panx.entity.AllUser;
import panx.mapper.AlluserMapper;
import panx.service.AlluserService;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class AlluserController {
    private AlluserService alluserService = (AlluserService) Singleton.GetApplicationContext().getBean("AlluserServiceImpl");
    /**
     * 获取所有数据并且返回到index.jsp页面
     * @param request
     * @return
     */
    @RequestMapping("/GetAllusers")
    public String test(HttpServletRequest request){
        System.out.println("来过");
        List<AllUser> list = alluserService.GetAlluser();
        for (AllUser arr:list) {
            System.out.println(arr.getUsernum());
        }
        request.getSession().setAttribute("panxuserlist",list);
        return "showuser";
    }
    @ResponseBody
    @RequestMapping("/Login")
    public String check(HttpServletRequest request){
        //获取请求中的参数，用户名和密码
        String name = request.getParameter("name");
        String key = request.getParameter("key");
        //返回验证结果
        return alluserService.isLoginOK(name,key) ? "YES" : "NO";
    }
}
