package froms;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login_forms {

    private static final String JSON_FILE = "src/data/accounts.json"; // JSON 文件路径
    private static Map<String, String> accounts = new HashMap<>(); // 存储账号和密码

    public static void fun() {
        // 加载已有的账号数据
        loadAccounts();

        // 创建登录窗口
        createLoginWindow();
    }

    // 加载 JSON 文件中的账号数据
    private static void loadAccounts() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(JSON_FILE);

        if (file.exists()) {
            try {
                accounts = objectMapper.readValue(file, Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 保存账号数据到 JSON 文件
    private static void saveAccounts() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(JSON_FILE), accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建登录窗口
    private static void createLoginWindow() {
        JFrame frame = new JFrame("登录页面");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 账号输入框
        JLabel userLabel = new JLabel("账号:");
        userLabel.setBounds(10, 20, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        frame.add(userText);

        // 密码输入框
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10, 50, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        frame.add(passwordText);

        // 登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(10, 80, 80, 25);
        frame.add(loginButton);

        // 创建账号按钮
        JButton createAccountButton = new JButton("创建账号");
        createAccountButton.setBounds(100, 80, 100, 25);
        frame.add(createAccountButton);

        // 登录按钮事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
                    //JOptionPane.showMessageDialog(frame, "登录成功！");
                    operation_forms op = new operation_forms();
                    op.fun();

                } else {
                    JOptionPane.showMessageDialog(frame, "账号或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 创建账号按钮事件
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "账号和密码不能为空！", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (accounts.containsKey(username)) {
                    JOptionPane.showMessageDialog(frame, "账号已存在！", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    accounts.put(username, password);
                    saveAccounts();
                    JOptionPane.showMessageDialog(frame, "账号创建成功！");
                }
            }
        });

        frame.setVisible(true);
    }


}
