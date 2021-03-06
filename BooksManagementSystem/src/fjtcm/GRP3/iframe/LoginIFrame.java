package fjtcm.GRP3.iframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fjtcm.GRP3.iframe.MainFrame;
import fjtcm.GRP3.dao.Dao;
import fjtcm.GRP3.model.Operator;
import fjtcm.GRP3.util.CreateIcon;
import fjtcm.GRP3.util.MyDocument;

public class LoginIFrame extends JFrame {

	private class BookResetAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			username.setText("");
			password.setText("");
		}
	}

	class BookLoginAction implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			user = Dao.check(username.getText(), password.getText());
			if (user.getName() != null) {
				try {
					JOptionPane.showMessageDialog(null, "登录成功！");
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					LoginIFrame.this.setVisible(false);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		}
	}

	private JPasswordField password;
	private JTextField username;
	private JButton login;
	private JButton reset;
	private static Operator user;

	/**
	 * Create the frame
	 */
	public LoginIFrame() {
		super();
		final BorderLayout borderLayout = new BorderLayout();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout.setVgap(10);
		getContentPane().setLayout(borderLayout);
		setTitle("图书信息管理系统");
		setBounds(100, 100, 355, 250); // 设置窗体位置和大小
		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EmptyBorder(0, 0, 10, 0));
		getContentPane().add(panel);

		final JPanel panel_2 = new JPanel();
		final GridLayout gridLayout = new GridLayout(0, 2);
		gridLayout.setHgap(5);
		gridLayout.setVgap(20);
		panel_2.setLayout(gridLayout);
		panel.add(panel_2);

		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(0, 0));
		label.setMinimumSize(new Dimension(0, 0));
		panel_2.add(label);
		label.setText("用    户：");

		username = new JTextField(20);
		username.setPreferredSize(new Dimension(0, 0));
		panel_2.add(username);

		final JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(label_1);
		label_1.setText("密    码：");

		password = new JPasswordField(20);
		password.setDocument(new MyDocument(6));
		password.setEchoChar('*');// 设置密码框的回显字符
		password.addKeyListener(new KeyAdapter() {
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == 10) // 回车
					login.doClick();
			}
		});
		panel_2.add(password);

		final JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		login = new JButton();
		login.addActionListener(new BookLoginAction());
		login.setText("登录");
		panel_1.add(login);
		reset = new JButton();
		reset.addActionListener(new BookResetAction());
		reset.setText("重置");
		panel_1.add(reset);

		final JLabel tupianLabel = new JLabel();
		ImageIcon loginIcon = CreateIcon.add("login.jpg");
		tupianLabel.setIcon(loginIcon);
		tupianLabel.setOpaque(true);
		tupianLabel.setPreferredSize(new Dimension(260, 90));
		panel.add(tupianLabel, BorderLayout.NORTH);
		setVisible(true);
		setResizable(false);
	}

	public static Operator getUser() {
		return user;
	}

	public static void setUser(Operator user) {
		LoginIFrame.user = user;
	}
}
