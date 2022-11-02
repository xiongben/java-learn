package com.xb.demo1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("=====ATM系统初始化=======");
            System.out.println("1,账户登录");
            System.out.println("2,账户开户");


            System.out.println("请选择你的操作");
            int command = sc.nextInt();

            switch (command){
                case 1:
                    // user login
                    break;
                case 2:
                    //user register
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("你输入的命令不存在！");

            }
        }
    }

    /**
     * user register account
     * @param accounts
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("==========系统开户操作===========");
        Account account = new Account();
        System.out.println("enter user name:");
        String userName = sc.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("enter user password");
            String pwd = sc.next();
            System.out.println("enter user password again");
            String okPwd = sc.next();
            if (okPwd.equals(pwd)) {
                account.setPassWord(pwd);
                break;
            } else {
                System.out.println("password is not correct!");
            }
        }

        System.out.println("enter account limit:");
        double moneyLimit = sc.nextDouble();
        account.setQuotaMoney(moneyLimit);

        // create account number
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);

        accounts.add(account);
        System.out.println("create card success!" + userName + ",card number is :" + cardId);
    }

    /**
     * create account number
     * @return
     */
    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "";
            for(int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId, accounts);
            if(acc == null) {
                return cardId;
            }
        }
    }

    public static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if(acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;
    }

}
