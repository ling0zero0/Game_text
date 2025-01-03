package com.run.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    {
        // 设置默认字体
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            Font font = new Font("Microsoft YaHei", Font.PLAIN, 16); // 使用支持中文的字体
            UIManager.put("Button.font", font);
            UIManager.put("Label.font", font);
            UIManager.put("TextField.font", font);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 创建主窗口
        JFrame frame = new JFrame("游戏菜单"); // 设置窗口标题
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 窗口关闭时退出程序
        frame.setSize(300, 200); // 设置窗口大小为300x200像素

        // 创建面板，将按钮放在面板上
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 使用垂直BoxLayout
        panel.setBackground(new Color(220, 220, 220)); // 设置面板背景颜色

        // 创建按钮
        JButton startButton = createButton("开始游戏");
        JButton loadButton = createButton("读取存档");
        JButton exitButton = createButton("退出游戏");

        // 设置按钮点击事件
        startButton.addActionListener(new Menu.ButtonClickListener("开始游戏被点击"));
        loadButton.addActionListener(new Menu.ButtonClickListener("读取存档被点击"));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("退出游戏被点击"); // 点击后打印消息到控制台
                System.exit(0); // 退出程序
            }
        });

        // 将按钮添加到面板，增加间距
        panel.add(Box.createVerticalStrut(20));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(loadButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(exitButton);
        panel.add(Box.createVerticalStrut(20));

        frame.add(panel); // 将面板添加到窗口上
        frame.setVisible(true); // 设置窗口可见
    }

    // 创建按钮，设置样式
    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(100, 150, 255)); // 设置按钮颜色
        button.setForeground(Color.WHITE); // 设置字体颜色
        button.setFont(new Font("Microsoft YaHei", Font.BOLD, 16)); // 设置字体
        button.setFocusPainted(false); // 去掉按钮按下时的边框
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // 设置按钮居中
        return button;
    }

    // 按钮点击事件处理器
    private static class ButtonClickListener implements ActionListener {
        private String message;

        public ButtonClickListener(String message) {
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(message); // 点击后打印消息到控制台
        }


    }
}
