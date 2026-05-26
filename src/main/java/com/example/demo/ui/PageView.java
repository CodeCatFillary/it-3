package com.example.demo.ui;

import com.example.demo.business.UserService;
import com.example.demo.config.AppConfig;
import java.util.List;
import java.util.Scanner;

/**
 * @author 84
 * UI界面模块：控制台页面交互（组员2负责）
 * 实现菜单、输入输出、界面展示
 */
public class PageView {
    private Scanner scanner;

    public PageView() {
        scanner = new Scanner(System.in);
    }

    // 打印主菜单
    public void showMainMenu() {
        System.out.println("\n===== " + AppConfig.PROJECT_NAME + " =====");
        System.out.println("当前版本：" + AppConfig.VERSION);
        System.out.println("当前日期：" + AppConfig.getCurrentTime());
        System.out.println("1. 用户列表");
        System.out.println("2. 添加用户");
        System.out.println("3. 删除用户");
        System.out.println("4. 查看系统配置");
        System.out.println("0. 退出");
        System.out.print("请输入选择：");
    }

    // 展示用户列表页面
    public void showUserList(UserService service) {
        List<UserService.User> list = service.getAllUser();
        System.out.println("\n----- 用户列表 -----");
        if (list.isEmpty()) {
            System.out.println("暂无用户数据");
            return;
        }
        for (UserService.User u : list) {
            System.out.println(u);
        }
    }

    // 添加用户输入页面
    public void showAddUserPage(UserService service) {
        System.out.print("请输入用户ID：");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("请输入用户名：");
        String name = scanner.nextLine();
        System.out.print("请输入密码：");
        String pwd = scanner.nextLine();

        boolean result = service.addUser(id, name, pwd);
        if (result) {
            System.out.println("✅ 添加成功");
        } else {
            System.out.println("❌ 添加失败（参数不合法或数量超限）");
        }
    }

    // 删除用户页面
    public void showDeletePage(UserService service) {
        System.out.print("请输入要删除的用户ID：");
        int id = Integer.parseInt(scanner.nextLine());
        boolean ok = service.deleteUser(id);
        System.out.println(ok ? "✅ 删除成功" : "❌ 用户不存在");
    }

    // 展示系统配置页面
    public void showConfigPage() {
        AppConfig.printConfig();
    }

    public void close() {
        scanner.close();
    }
}
