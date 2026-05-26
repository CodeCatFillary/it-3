package com.example.demo;

import java.util.Scanner;

import com.example.demo.business.UserService;
import com.example.demo.ui.PageView;
import com.example.demo.utils.Tools;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PageView page = new PageView();

        while (true) {
            page.showMainMenu();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    page.showUserList(userService);
                    break;
                case "2":
                    page.showAddUserPage(userService);
                    break;
                case "3":
                    page.showDeletePage(userService);
                    break;
                case "4":
                    page.showConfigPage();
                    break;
                case "0":
                    page.close();
                    Tools.log("系统退出");
                    return;
                default:
                    System.out.println("输入无效，请重试");
            }
        }
    }
}