package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoTest {




    public void login() {
        User loginUser = new User();
        loginUser.setUsername("superbaby"); //设置姓名，密码，
        loginUser.setPassword("123");


        UserDao dao = new UserDao(); //来使用账户和密码来查询表中数据，封装为对象
        User user = dao.login(loginUser); //登录用户
        System.out.println(user);
    }
}
