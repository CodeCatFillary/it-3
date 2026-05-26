package com.example.demo.business;

import com.example.demo.config.AppConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 97
 * 业务模块：用户管理服务
 * 实现用户增删查改、校验、业务逻辑
 */
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        initDefaultUser();
    }

    // 初始化默认用户
    private void initDefaultUser() {
        User defaultUser = new User(1, AppConfig.DEFAULT_USER_NAME, AppConfig.DEFAULT_PASSWORD);
        userList.add(defaultUser);
    }

    // 添加用户
    public boolean addUser(int id, String name, String pwd) {
        if (AppConfig.ENABLE_VALIDATE) {
            if (name == null || name.length() < 2) {
                return false;
            }
            if (pwd == null || pwd.length() < 6) {
                return false;
            }
            if (userList.size() >= AppConfig.MAX_USER_COUNT) {
                return false;
            }
        }
        userList.add(new User(id, name, pwd));
        return true;
    }

    // 根据ID查询用户
    public User findUserById(int id) {
        for (User u : userList) {
            if (u.id == id) return u;
        }
        return null;
    }

    // 删除用户
    public boolean deleteUser(int id) {
        User target = findUserById(id);
        if (target != null) {
            userList.remove(target);
            return true;
        }
        return false;
    }

    // 获取所有用户
    public List<User> getAllUser() {
        return userList;
    }

    // 内部用户实体类
    public static class User {
        public int id;
        public String name;
        public String password;

        public User(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", name='" + name + "'}";
        }
    }
}