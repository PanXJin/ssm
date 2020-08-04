package panx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import panx.entity.AllUser;
import panx.mapper.AlluserMapper;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AlluserController {
    private AlluserMapper alluserMapper = (AlluserMapper) Singleton.GetApplicationContext().getBean("AlluserServiceImpl");
    /**
     * 获取所有数据并且返回到index.jsp页面
     * @param request
     * @return
     */
    @RequestMapping("/GetAllusers")
    public String test(HttpServletRequest request){
        System.out.println("来过");
        List<AllUser> list = alluserMapper.GetAlluser();
        for (AllUser arr:list) {
            System.out.println(arr.getUsernum());
        }
        request.getSession().setAttribute("panxuserlist",list);
        return "showuser";
    }
}
