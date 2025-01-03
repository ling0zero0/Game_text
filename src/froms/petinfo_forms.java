package froms;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.run.game.Main;
import com.run.game.Spirit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.List;

public class petinfo_forms {

//图签窗体
private static List<Spirit> spirits;
    private static int currentIndex = 0; // 当前显示的精灵索引
    private static JLabel imageLabel;// 图片显示区域
    private static JTextArea textArea;// 文字信息显示区域
    private static JTextField searchField;// 搜索框


    public static void fun( ) {//main方法

        ObjectMapper objectMapper = new ObjectMapper();

        // 从 classpath 读取文件
        try (InputStream inputStream = petinfo_forms.class.getClassLoader().getResourceAsStream("data/petinfo.json")) {
            if (inputStream == null) {
                System.out.println("文件未找到！");
                return;
            }

            // 解析 JSON 文件为 List<Spirit>
            spirits = objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, Spirit.class));

            // 创建并显示窗口
            SwingUtilities.invokeLater(petinfo_forms::createAndShowGUI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAndShowGUI() {
        // 创建主窗口
        JFrame frame = new JFrame("精灵信息");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 图片显示区域
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        // 文字信息显示区域
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("宋体", Font.PLAIN, 14));
        JScrollPane textScrollPane = new JScrollPane(textArea);
        mainPanel.add(textScrollPane, BorderLayout.SOUTH);

        // 控制面板（搜索和导航）
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // 搜索框
        searchField = new JTextField(10);
        controlPanel.add(new JLabel("搜索序号:"));
        controlPanel.add(searchField);

        // 搜索按钮
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = Integer.parseInt(searchField.getText()) - 1; // 转换为索引
                    if (index >= 0 && index < spirits.size()) {
                        currentIndex = index;
                        updateDisplay();
                    } else {
                        JOptionPane.showMessageDialog(frame, "序号无效！", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "请输入有效的序号！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        controlPanel.add(searchButton);

        // 上一页按钮
        JButton prevButton = new JButton("上一页");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateDisplay();
                }
            }
        });
        controlPanel.add(prevButton);

        // 下一页按钮
        JButton nextButton = new JButton("下一页");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < spirits.size() - 1) {
                    currentIndex++;
                    updateDisplay();
                }
            }
        });
        controlPanel.add(nextButton);

        // 将控制面板添加到主面板
        mainPanel.add(controlPanel, BorderLayout.NORTH);

        // 初始化显示
        updateDisplay();

        // 将主面板添加到窗口
        frame.add(mainPanel);

        // 显示窗口
        frame.setVisible(true);
    }

    // 更新显示内容
    public static void updateDisplay() {
        Spirit spirit = spirits.get(currentIndex);

        // 加载图片并等比例缩放
        ImageIcon icon = new ImageIcon(petinfo_forms.class.getClassLoader().getResource(spirit.get图片位置()));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 设置图片大小为 300x300
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // 更新文字信息
        textArea.setText(
                "精灵ID: " + spirit.get精灵id() + "\n" +
                        "名字: " + spirit.get名字() + "\n" +
                        "性别: " + spirit.get性别() + "\n" +
                        "简介: " + spirit.get简介() + "\n" +
                        "属性: " + spirit.get属性()

        );
    }




}
