# 82提交，负责以下代码


```java
/**
 * Config.java
 */

package com.example.demo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author 82
 */
public class AppConfig {
    // ===================== 环境配置 =====================
    public static final String ENV = "dev";
    public static final String BASE_URL = "http://localhost:8080/api/v1";
    public static final int TIMEOUT = 5000;
    public static final int MAX_RETRY = 3;

    // ===================== 项目基础信息 =====================
    public static final String PROJECT_NAME = "软件工程小组实验项目";
    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "小组团队";

    // ===================== 业务常量 =====================
    public static final int MAX_USER_COUNT = 1000;
    public static final String DEFAULT_USER_NAME = "test_user";
    public static final String DEFAULT_PASSWORD = "123456";

    // ===================== 功能开关 =====================
    public static final boolean ENABLE_LOG = true;
    public static final boolean ENABLE_VALIDATE = true;
    public static final boolean ENABLE_CACHE = false;

    // ===================== 系统工具方法 =====================
    public static String getCurrentTime() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(fmt);
    }

    public static void printConfig() {
        System.out.println("========== 系统配置信息 ==========");
        System.out.println("项目名称：" + PROJECT_NAME);
        System.out.println("版本号：" + VERSION);
        System.out.println("运行环境：" + ENV);
        System.out.println("接口地址：" + BASE_URL);
        System.out.println("超时时间：" + TIMEOUT + "ms");
        System.out.println("最大重试：" + MAX_RETRY + "次");
        System.out.println("日志开关：" + (ENABLE_LOG ? "开启" : "关闭"));
        System.out.println("校验开关：" + (ENABLE_VALIDATE ? "开启" : "关闭"));
        System.out.println("==================================");
    }

    public static boolean isDevEnv() {
        return "dev".equals(ENV);
    }

    public static boolean isProdEnv() {
        return "prod".equals(ENV);
    }
}
```