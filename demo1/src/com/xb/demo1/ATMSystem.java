package com.xb.demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        System.out.println("=====ATM系统初始化=======");
        System.out.println("1,账户登录");
        System.out.println("2,账户开户");

        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你的操作");
    }
}
