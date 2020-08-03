package panx.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Singleton {
    /**
     * 进行访问控制
     */
    private Singleton(){

    }
    private volatile static ApplicationContext applicationcontext;
    /**
     * 得到ApplicationContext对象的方法
     * @return
     */
    public static ApplicationContext GetApplicationContext(){
        if (applicationcontext==null) {
            synchronized (Singleton.class) {
                if (applicationcontext==null) {
                    applicationcontext = new ClassPathXmlApplicationContext("applicationContext.xml");
                }
            }
        }
        return applicationcontext;
    }
}
