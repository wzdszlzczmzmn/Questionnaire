package questionnaire.web;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import questionnaire.database.*;
import questionnaire.utils.QuestionnaireTools;
import questionnaire.utils.SessionFactorySource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zong chang on 2023/12/11 11:00
 */

@Controller // 控制定义
@RequestMapping("/") // 相应web路径
public class HomePageController {
    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = GET) // 相应的请求方法
    public String homePage(Model model) throws HibernateException {
        Session session;
        session = SessionFactorySource.getSessionFactory().openSession();
        session.beginTransaction();
        Manager manager = new Manager();
        manager.setUserName("admin");
        manager.setPassword("admin");
        session.save(manager);
        session.getTransaction().commit();
        session.close();
        return "home";
    }
}