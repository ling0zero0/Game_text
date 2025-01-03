package com.run.game;

import java.util.Map;

public class Spirit {// 精灵类
    private int 精灵id;
    private String 名字;
    private String 性别;
    private String 简介;
    private Map<String, Integer> 属性;
    private String 图片位置;

    // Getter 和 Setter 方法
    public int get精灵id() {
        return 精灵id;
    }

    public void set精灵id(int 精灵id) {
        this.精灵id = 精灵id;
    }

    public String get名字() {
        return 名字;
    }

    public void set名字(String 名字) {
        this.名字 = 名字;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    public String get简介() {
        return 简介;
    }

    public void set简介(String 简介) {
        this.简介 = 简介;
    }

    public Map<String, Integer> get属性() {
        return 属性;
    }

    public void set属性(Map<String, Integer> 属性) {
        this.属性 = 属性;
    }

    public String get图片位置() {
        return 图片位置;
    }

    public void set图片位置(String 图片位置) {
        this.图片位置 = 图片位置;
    }

    @Override
    public String toString() {
        return "Spirit{" +
                "精灵id=" + 精灵id +
                ", 名字='" + 名字 + '\'' +
                ", 性别='" + 性别 + '\'' +
                ", 简介='" + 简介 + '\'' +
                ", 属性=" + 属性 +
                ", 图片位置='" + 图片位置 + '\'' +
                '}';
    }
}