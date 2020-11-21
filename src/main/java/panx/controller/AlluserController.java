package panx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import panx.entity.AllBorrow;
import panx.entity.AllUser;
import panx.mapper.AlluserMapper;
import panx.service.AllborrowService;
import panx.service.AlluserService;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlluserController {
    private AlluserService alluserService = (AlluserService) Singleton.GetApplicationContext().getBean("AlluserServiceImpl");
    private AllborrowService allborrowService = (AllborrowService) Singleton.GetApplicationContext().getBean("AllborrowServiceImpl");

    /**
     * 获取所有数据并且返回到index.jsp页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/GetAllusers")
    public String test(HttpServletRequest request) {
        System.out.println("来过");
        List<AllUser> list = alluserService.GetAlluser();
        for (AllUser arr : list) {
            System.out.println(arr.getUsername());
        }
        request.getSession().setAttribute("panxuserlist", list);
        return "showuser";
    }

    @ResponseBody
    @RequestMapping("/Login")
    public String login(HttpServletRequest request) {
        //获取请求中的参数，用户名和密码
        String name = request.getParameter("name");
        String key = request.getParameter("key");
        AllUser allUser = alluserService.getUserData(name, key);
        List<AllBorrow> allBorrowList = new ArrayList<>();
        if (allUser != null) {
            String borrowId = allUser.getBorrowid();
            //逗号分隔开，循环后查list《AllBorrow》
            String[] strings = borrowId.split(",");
            for (String str : strings) {
                AllBorrow allBorrow = allborrowService.GetAllBorrow(str);
                allBorrowList.add(allBorrow);
                //还没查书
            }
        }
        //缺少json数据的转换
        String json = "1";
        //返回验证结果
        return json;
    }
}
