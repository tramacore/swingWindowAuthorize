
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Framee extends JFrame {
		public static byte count;
		protected String login;
		protected String password;
		JTextField loginField;
		JPasswordField passwordField;

		public Framee() {
				super("Авторизация");
				setDefaultCloseOperation(EXIT_ON_CLOSE);

				setLocation(825, 450);

				Box box1 = Box.createHorizontalBox();
				JLabel loginfield = new JLabel("Логин:");
				loginField = new JTextField(15);
				box1.add(loginfield);
				box1.add(Box.createHorizontalStrut(6));//промежуток между лейблом и вводом
				box1.add(loginField);
//первый бокс
				Box box2 = Box.createHorizontalBox();
				JLabel passwordfield = new JLabel("Пароль:");
				passwordField = new JPasswordField(15);
				box2.add(passwordfield);
				box2.add(Box.createHorizontalStrut(6));
				box2.add(passwordField);

				Box box3 = Box.createHorizontalBox();
				JButton ok = new JButton("Ок");
				JButton cancel = new JButton("Отмена");
				box3.add(Box.createHorizontalGlue());
				box3.add(ok);
				box3.add(Box.createHorizontalStrut(12));
				box3.add(cancel);

				loginfield.setPreferredSize(passwordfield.getPreferredSize());
				ok.addActionListener(e -> {
						StringBuilder Info = new StringBuilder();
						Info.delete(0, 16);
						login = loginField.getText() + " ";
						password = new String(passwordField.getPassword());
						Info.append(login).append(password);
						count = 1;
						System.out.print("\r");

						// Очистка строки в консоли (заполнение пробелами)
						System.out.print(new String(new char[Info.length()]).replace('\0', ' '));

						// Печать новой информации
						System.out.print("\r" + Info);
				});

				cancel.addActionListener(e -> dispose());
				Box mainBox = Box.createVerticalBox();
				mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
				mainBox.add(box1);
				mainBox.add(Box.createVerticalStrut(12));
				mainBox.add(box2);
				mainBox.add(Box.createVerticalStrut(17));
				mainBox.add(box3);
				setContentPane(mainBox);
				pack();
				setVisible(true);
				setResizable(false);
		}
}


