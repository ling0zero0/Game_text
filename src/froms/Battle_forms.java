package froms;
import javax.swing.*;
import java.awt.*;

public class Battle_forms extends JPanel {

    private Image background;  // 背景图像
    private Image player;      // 玩家角色图像
    private Image enemy;       // 敌人图像
    private int playerHealth;  // 玩家生命值
    private int enemyHealth;   // 敌人生命值

    public Battle_forms() {
        // 加载资源
        background = new ImageIcon("resources/background.png").getImage(); // 替换背景图片路径
        player = new ImageIcon("resources/player.jpg").getImage();         // 替换玩家角色图片路径
        enemy = new ImageIcon("resources/enemy.jpg").getImage();           // 替换敌人图片路径
        playerHealth = 100; // 玩家初始生命值
        enemyHealth = 100;  // 敌人初始生命值
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制背景并适配屏幕
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        // 设置角色图像的大小
        int playerWidth = 100; // 玩家角色图像宽度
        int playerHeight = 100; // 玩家角色图像高度
        int enemyWidth = 100; // 敌人角色图像宽度
        int enemyHeight = 100; // 敌人角色图像高度

        // 固定玩家角色位置（左下角）
        int playerX = 50;
        int playerY = getHeight() - playerHeight - 50; // 玩家角色底部距屏幕底部50像素

        // 固定敌人角色位置（右下角）
        int enemyX = getWidth() - enemyWidth - 50;   // 敌人角色底部距屏幕底部50像素
        int enemyY = getHeight() - enemyHeight - 50; // 敌人角色位置

        // 绘制玩家角色
        g.drawImage(player, playerX, playerY, playerWidth, playerHeight, this);

        // 绘制敌人角色
        g.drawImage(enemy, enemyX, enemyY, enemyWidth, enemyHeight, this);

        // 绘制生命值条
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, playerHealth, 20); // 玩家生命值
        g.setColor(Color.RED);
        g.fillRect(getWidth() - enemyHealth - 50, 50, enemyHealth, 20); // 敌人生命值

        g.setColor(Color.WHITE);
        g.drawString("玩家生命值", 50, 30);
        g.drawString("敌人生命值", getWidth() - 150, 30);
    }

    public static void fun() {
        // 创建主窗口
        JFrame frame = new JFrame("战斗界面示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 添加自定义面板
        Battle_forms battlePanel = new Battle_forms();
        frame.add(battlePanel);

        // 显示窗口
        frame.setVisible(true);
    }
}
