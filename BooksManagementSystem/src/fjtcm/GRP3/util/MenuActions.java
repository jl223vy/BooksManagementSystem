package fjtcm.GRP3.util;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;

import fjtcm.GRP3.iframe.BookAddIFrame;
import fjtcm.GRP3.iframe.BookModiAndDelIFrame;
import fjtcm.GRP3.iframe.BookTypeAddIFrame;
import fjtcm.GRP3.iframe.BookTypeModiAndDelIFrame;
import fjtcm.GRP3.iframe.ModifyPass;
import fjtcm.GRP3.iframe.MainFrame;
import fjtcm.GRP3.iframe.ReaderAddIFrame;
import fjtcm.GRP3.iframe.ReaderModiAndDelIFrame;
import fjtcm.GRP3.iframe.UserAddIFrame;
import fjtcm.GRP3.iframe.UserModiAndDelIFrame;

/**
 * 菜单和按钮的Action对象
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // 子窗体集合
	public static PasswordModiAction MODIFY_PASSWORD; // 修改密码窗体动作
	public static UserModiAction USER_MODIFY; // 修改用户资料窗体动作
	public static UserAddAction USER_ADD; // 用户添加窗体动作
	public static BookTypeModiAction BOOKTYPE_MODIFY; // 图书类型修改窗体动作
	public static BookTypeAddAction BOOKTYPE_ADD; // 图书类型添加窗体动作
	public static ReaderModiAction READER_MODIFY; // 读者信息修改窗体动作
	public static ReaderAddAction READER_ADD; // 读者信息添加窗体动作
	public static BookModiAction BOOK_MODIFY; // 图书信息修改窗体动作
	public static BookAddAction BOOK_ADD; // 图书信息添加窗体动作
	public static ExitAction EXIT; // 系统退出动作

	static {// static区域，初始化内部类，类在被加载时，首先执行static区域的代码，而且只执行一次
		frames = new HashMap<String, JInternalFrame>();
		MODIFY_PASSWORD = new PasswordModiAction();
		USER_MODIFY = new UserModiAction();
		USER_ADD = new UserAddAction();
		BOOKTYPE_MODIFY = new BookTypeModiAction();
		BOOKTYPE_ADD = new BookTypeAddAction();
		READER_MODIFY = new ReaderModiAction();
		READER_ADD = new ReaderAddAction();
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		EXIT = new ExitAction();
	}

	private static class PasswordModiAction extends AbstractAction {
		PasswordModiAction() {
			putValue(Action.NAME, "修改密码");
			putValue(Action.LONG_DESCRIPTION, "修改当前用户密码");
			putValue(Action.SHORT_DESCRIPTION, "修改密码");
			// 在“更改口令”提示中显示的文字
			// putValue(Action.SMALL_ICON,CreatecdIcon.add("bookAddtb.jpg"));
			// 将图标存储到动作对象中
			// setEnabled(false);//使动作禁用
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("修改密码") || frames.get("修改密码").isClosed()) {
				ModifyPass iframe = new ModifyPass();
				frames.put("修改密码", iframe);
				MainFrame.addIFame(frames.get("修改密码"));
			}
		}
	}

	private static class UserModiAction extends AbstractAction {
		UserModiAction() {
			super("管理员信息修改与删除", null);
			putValue(Action.LONG_DESCRIPTION, "修改与删除管理员信息");
			putValue(Action.SHORT_DESCRIPTION, "管理员信息修改与删除");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("管理员信息修改与删除") || frames.get("管理员信息修改与删除").isClosed()) {
				UserModiAndDelIFrame iframe = new UserModiAndDelIFrame();
				frames.put("管理员信息修改与删除", iframe);
				MainFrame.addIFame(frames.get("管理员信息修改与删除"));
			}
		}
	}

	private static class UserAddAction extends AbstractAction {
		UserAddAction() {
			super("管理员信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的管理员");
			putValue(Action.SHORT_DESCRIPTION, "管理员信息添加");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("管理员信息添加") || frames.get("管理员信息添加").isClosed()) {
				UserAddIFrame iframe = new UserAddIFrame();
				frames.put("管理员信息添加", iframe);
				MainFrame.addIFame(frames.get("管理员信息添加"));
			}
		}
	}

	private static class BookTypeModiAction extends AbstractAction {
		BookTypeModiAction() {
			super("图书类别修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改图书类别信息");
			putValue(Action.SHORT_DESCRIPTION, "图书类别修改");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别修改") || frames.get("图书类别修改").isClosed()) {
				BookTypeModiAndDelIFrame iframe = new BookTypeModiAndDelIFrame();
				frames.put("图书类别修改", iframe);
				MainFrame.addIFame(frames.get("图书类别修改"));
			}
		}
	}

	private static class BookTypeAddAction extends AbstractAction {
		BookTypeAddAction() {
			super("图书类别添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的图书类别");
			putValue(Action.SHORT_DESCRIPTION, "图书类别添加");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别添加") || frames.get("图书类别添加").isClosed()) {
				BookTypeAddIFrame iframe = new BookTypeAddIFrame();
				frames.put("图书类别添加", iframe);
				MainFrame.addIFame(frames.get("图书类别添加"));
			}
		}
	}

	private static class ReaderModiAction extends AbstractAction {
		ReaderModiAction() {
			super("读者信息修改与删除", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除读者信息");
			putValue(Action.SHORT_DESCRIPTION, "读者信息修改与删除");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("读者信息修改与删除") || frames.get("读者信息修改与删除").isClosed()) {
				ReaderModiAndDelIFrame iframe = new ReaderModiAndDelIFrame();
				frames.put("读者信息修改与删除", iframe);
				MainFrame.addIFame(frames.get("读者信息修改与删除"));
			}
		}
	}

	private static class ReaderAddAction extends AbstractAction {
		ReaderAddAction() {
			super("读者信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的读者信息");
			putValue(Action.SHORT_DESCRIPTION, "读者信息添加");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("读者信息添加") || frames.get("读者信息添加").isClosed()) {
				ReaderAddIFrame iframe = new ReaderAddIFrame();
				frames.put("读者信息添加", iframe);
				MainFrame.addIFame(frames.get("读者信息添加"));
			}
		}
	}

	// 图书修改与删除
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("图书修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书修改");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书修改") || frames.get("图书修改").isClosed()) {
				BookModiAndDelIFrame iframe = new BookModiAndDelIFrame();
				frames.put("图书修改", iframe);
				MainFrame.addIFame(frames.get("图书修改"));
			}
		}
	}

	private static class BookAddAction extends AbstractAction { // 图书信息添加
		BookAddAction() {
			super("图书信息添加", null);
			putValue(Action.LONG_DESCRIPTION, "添加新的图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书信息添加");
		}

		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书信息添加") || frames.get("图书信息添加").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("图书信息添加", iframe);
				MainFrame.addIFame(frames.get("图书信息添加"));
			}
		}
	}

	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出图书信息管理系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}

		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}
}
