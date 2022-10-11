package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //service层用户关闭的接口
    public List<User> findAll(); //查询所有用户信息

    public User login(User user); //登录方法

    public void addUser(User user);

    public void  deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public  User findUserById(String id);

    public  void updateUser(User user); //修改用户

    void delSelectedUser(String[] uids); //删除选中的用户

    //分页查询，分页条件查询
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);//分页查询
}
