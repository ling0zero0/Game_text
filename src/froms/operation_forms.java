package froms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class operation_forms {
    public static void fun() {
        // 创建主菜单窗口
        createMainMenu();
    }

    // 创建主菜单窗口
    private static void createMainMenu() {
        JFrame frame = new JFrame("主菜单");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);




        // 个人信息按钮
        JButton profileButton = new JButton("查看个人信息");
        profileButton.setBounds(50, 30, 150, 40);
        frame.add(profileButton);

        // 背包信息按钮
        JButton backpackButton = new JButton("查看背包信息");
        backpackButton.setBounds(50, 90, 150, 40);
        frame.add(backpackButton);

        // 地图按钮
        JButton mapButton = new JButton("查看地图");
        mapButton.setBounds(50, 150, 150, 40);
        frame.add(mapButton);

        // 图鉴按钮
        JButton encyclopediaButton = new JButton("查看图鉴");
        encyclopediaButton.setBounds(50, 210, 150, 40);
        frame.add(encyclopediaButton);

        // 战斗按钮
        JButton battleButton = new JButton("开始战斗");
        battleButton.setBounds(50, 270, 150, 40);
        frame.add(battleButton);



        // 个人信息按钮事件
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "这里是个人信息页面！");
            }
        });

        // 背包信息按钮事件
        backpackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "这里是背包信息页面！");
            }
        });

        // 地图按钮事件
        mapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "这里是地图页面！");
            }
        });

        // 图鉴按钮事件
        encyclopediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //图鉴页面！
                petinfo_forms petinfo_forms = new petinfo_forms();
                petinfo_forms.fun();
            }
        });

        // 战斗按钮事件
        battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "这里是战斗页面！");
                Battle_forms battle_forms = new Battle_forms();
                battle_forms.fun();
            }
        });


        frame.setVisible(true);
    }

}
