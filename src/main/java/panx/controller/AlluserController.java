package panx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.yidasanqian.json.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import panx.entity.AllBorrow;
import panx.entity.AllUser;
import panx.entity.ResultMessaage;
import panx.service.AllborrowService;
import panx.service.AlluserService;
import panx.utils.ReturnMessageUtil;
import panx.utils.Singleton;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class AlluserController {
    private AlluserService alluserService = (AlluserService) Singleton.GetApplicationContext().getBean("AlluserServiceImpl");
    private AllborrowService allborrowService = (AllborrowService) Singleton.GetApplicationContext().getBean("AllborrowServiceImpl");
    private int errCode;
    private String errMsg;

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

    /**
     * 登陆
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/Login")
    public String login(HttpServletRequest request) {
        //获取请求中的参数，用户名和密码
        String name = request.getParameter("name");
        String key = request.getParameter("key");
        AllUser allUser = alluserService.getUserData(name, key);
        List<AllBorrow> allBorrowList = new ArrayList<>();
        if (allUser != null) {
            errCode = 0;
            //创建Token
            String Token = UUID.randomUUID().toString().replace("-", "");
            alluserService.setToken(Token,allUser.getUserid());
            allUser.setToken(Token);
            String borrowId = allUser.getBorrowid();
            //逗号分隔开，循环后查list《AllBorrow》
            String[] strings = borrowId.split(",");
            for (String str : strings) {
                AllBorrow allBorrow = allborrowService.GetAllBorrow(str);
                allBorrowList.add(allBorrow);
            }
        } else {
            errCode = 1;
            errMsg = "找不到账号或密码错误";
        }
        ResultMessaage resultMessaage = ReturnMessageUtil.getReturnLogin(errCode, errMsg, allUser, allBorrowList);
        return JsonUtil.toJsonString(resultMessaage);
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(HttpServletRequest request) {
        ResultMessaage resultMessaage = null;
        AllUser allUser = null;
        //获取请求中的参数，用户名和密码
        String userId = request.getParameter("classNum");
        String userName = request.getParameter("userName");
        String psw = request.getParameter("password");
        String name = request.getParameter("name");
        //创建Token
        String Token = UUID.randomUUID().toString().replace("-", "");
        boolean isRegister = alluserService.register(userId, userName, psw, name, Token);
        if (isRegister) {
            errCode = 0;
            allUser = alluserService.getUserData(userName, psw);
        } else {
            errCode = 1;
            errMsg = "找不到账号或密码错误";
        }
        resultMessaage = ReturnMessageUtil.getReturnLogin(errCode, errMsg, allUser, null);
        return JsonUtil.toJsonString(resultMessaage);
    }

}
