package com.xb.demo3;

public class Star implements Skill{
    private String name;

    public Star(String name){
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println(name + "开始跳舞！");
    }

    @Override
    public void sing() {
        System.out.println(name + "开始唱歌！");
    }
}
