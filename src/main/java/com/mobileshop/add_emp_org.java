import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import javax.swing.border.TitledBorder;

import java.io.*;
import java.time.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class add_emp_org extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2, b3, b4, b5, b6, b7;
	JPanel p1, p2;
	ImageIcon i1;
	JTable jt;
	ResultSet rs;
	boolean flag = true;
	Connection co;
	PreparedStatement ps;
	Statement st;
	int a;
	String data1[][] = new String[100][100];
	JButton browse;
	JButton userimg;
	JFileChooser jf;
	String gender;
	JRadioButton rb3, rb4;
	ButtonGroup bg2;

	add_emp_org() {
		initComponent();
	}

	public void initComponent() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
			st = co.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (SQLException ex) {
			System.out.println("Exception: " + ex);
		} catch (ClassNotFoundException ex) {
			System.out.println("Exception: " + ex);
		}
		setVisible(true);
		setSize(1600, 1600);
		setLayout(null);
		getContentPane().setBackground(Color.pink);

		p1 = new JPanel();
		p2 = new JPanel();

		l1 = new JLabel("Employee ID");
		l2 = new JLabel("Employee Name");
		l3 = new JLabel("Employee MNo.");
		l4 = new JLabel("Employee Address");
		l5 = new JLabel("Employee Salary");
		l6 = new JLabel("Age");
		l7 = new JLabel("Gender");
		l8 = new JLabel("Date");

		rb3 = new JRadioButton("Male");
		rb4 = new JRadioButton("Female");

		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		l6.setForeground(Color.blue);
		l7.setForeground(Color.blue);
		l8.setForeground(Color.blue);

		rb3.setForeground(Color.black);
		rb4.setForeground(Color.black);

		Font f1 = new Font("Georgia", Font.BOLD, 15);
		l1.setFont(f1);
		Font f2 = new Font("Georgia", Font.BOLD, 15);
		l2.setFont(f2);
		Font f3 = new Font("Georgia", Font.BOLD, 15);
		l3.setFont(f3);
		Font f4 = new Font("Georgia", Font.BOLD, 15);
		l4.setFont(f4);
		Font f5 = new Font("Georgia", Font.BOLD, 15);
		l5.setFont(f5);
		l6.setFont(f5);
		l7.setFont(f5);
		l8.setFont(f5);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();

		LocalDate date = LocalDate.now();

		t7.setText("" + date);

		b1 = new JButton("INSERT");
		b2 = new JButton("UPDATE");
		b3 = new JButton("DELETE");
		b4 = new JButton("CLEAR");
		b6 = new JButton("Check Records");
		b7 = new JButton("SEARCH");
		browse = new JButton("Browse");
		userimg = new JButton();
		bg2 = new ButtonGroup();
		browse.addActionListener(this);
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("."));

		b5 = new JButton();
		i1 = new ImageIcon(getClass().getResource("/images/cross.jpg"));
		b5.setIcon(i1);
		b5.setBounds(1300, 10, 30, 30);
		add(b5);

		Font f6 = new Font("Arial", Font.BOLD, 15);
		b1.setFont(f6);
		b1.setForeground(Color.black);

		Font f7 = new Font("Arial", Font.BOLD, 15);
		b2.setFont(f7);
		b2.setForeground(Color.black);

		Font f8 = new Font("Arial", Font.BOLD, 15);
		b3.setFont(f8);
		b3.setForeground(Color.black);

		Font f9 = new Font("Arial", Font.BOLD, 15);
		b4.setFont(f9);
		b4.setForeground(Color.black);

		Font f10 = new Font("Arial", Font.BOLD, 15);
		b6.setFont(f10);
		b6.setForeground(Color.black);

		Font f11 = new Font("Arial", Font.BOLD, 15);
		b7.setFont(f11);
		b7.setForeground(Color.black);

		Font f12 = new Font("Arial", Font.BOLD, 15);
		browse.setFont(f12);
		browse.setForeground(Color.black);

		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		b6.setBackground(Color.pink);
		b7.setBackground(Color.pink);
		browse.setBackground(Color.pink);
		userimg.setBackground(Color.white);

		l1.setBounds(30, 70, 150, 20);
		l2.setBounds(30, 120, 150, 20);
		l3.setBounds(30, 180, 150, 20);
		l4.setBounds(30, 240, 150, 20);
		l5.setBounds(30, 300, 150, 20);
		l6.setBounds(30, 360, 150, 20);
		l7.setBounds(30, 400, 150, 20);
		l8.setBounds(30, 460, 150, 20);

		t1.setBounds(180, 70, 150, 20);
		t2.setBounds(180, 120, 150, 20);
		t3.setBounds(180, 180, 150, 20);
		t4.setBounds(180, 240, 150, 20);
		t5.setBounds(180, 300, 150, 20);
		t6.setBounds(180, 360, 150, 20);
		rb3.setBounds(180, 400, 100, 20);
		rb4.setBounds(180, 420, 100, 20);
		t7.setBounds(180, 460, 150, 20);

		b1.setBounds(350, 370, 100, 40);
		b2.setBounds(470, 370, 100, 40);
		b3.setBounds(350, 430, 100, 40);
		b4.setBounds(470, 430, 100, 40);
		b6.setBounds(220, 370, 150, 40);
		b7.setBounds(580, 370, 100, 40);
		browse.setBounds(465, 290, 100, 40);
		userimg.setBounds(420, 70, 200, 200);

		try {

			if (flag) {
				rs = st.executeQuery("Select * from addemp2");
				flag = false;
			}
			rs.last();
			t1.setText(rs.getInt("Emp_ID") + 1 + "");
		} catch (SQLException ex) {
			System.out.println("Exception " + ex);
		}

		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Employee Here",
				TitledBorder.LEFT, TitledBorder.TOP));
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.LEFT,
				TitledBorder.TOP));

		p1.setBounds(10, 50, 700, 500);
		p2.setBounds(730, 56, 600, 495);

		p1.setBackground(Color.white);
		p2.setBackground(Color.gray);

		add(p1);
		add(p2);
		p1.setLayout(null);
		p2.setLayout(null);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(l5);
		p1.add(t5);
		p1.add(l6);
		p1.add(t6);
		p1.add(l7);
		p1.add(l8);
		p1.add(t7);
		bg2.add(rb3);
		bg2.add(rb4);
		p1.add(rb3);
		p1.add(rb4);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(b6);
		p1.add(b7);
		p1.add(userimg);
		p1.add(browse);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		browse.addActionListener(this);
		t2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
						|| c == KeyEvent.VK_SPACE)) {
					e.consume();
				}
			}
		});
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t2.requestFocus();

				}
			}
		});
		t2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t3.requestFocus();

				}
			}
		});
		t3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t4.requestFocus();

				}
			}
		});
		t4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t5.requestFocus();

				}
			}
		});
		t5.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t6.requestFocus();

				}
			}
		});
		t6.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t7.requestFocus();

				}
			}
		});
		t3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String phoneNo = t3.getText();
				int length = phoneNo.length();
				char c = e.getKeyChar();
				if (e.getKeyChar() > '0' && e.getKeyChar() <= '9' || (c == KeyEvent.VK_BACK_SPACE)
						|| c == KeyEvent.VK_DELETE) {
					if (length < 10) {
						t3.setEditable(true);
					} else {
						t3.setEditable(false);
					}
				}
			}

		});
		t4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
						|| c == KeyEvent.VK_SPACE)) {
					e.consume();
				}
			}
		});
		t5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		t6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
	}

	public void actionPerformed(ActionEvent ae) {

		if (rb3.isSelected()) {
			gender = "Male";
		} else if (rb4.isSelected()) {
			gender = "Female";
		}
		String s = ae.getActionCommand();

		if (s.equals("INSERT")) {
			if (t2.getText().trim().isEmpty() || t3.getText().trim().isEmpty() || t4.getText().trim().isEmpty()
					|| t7.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter data!");
			} else {
				try {
					/*
					 * Class.forName("com.mysql.jdbc.Driver");
					 * JOptionPane.showMessageDialog(this,"Driver Registered");
					 * Connection
					 * co=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db","root",
					 * "root");
					 * JOptionPane.showMessageDialog(this,"Connection Created");
					 */

					int a = Integer.parseInt(t1.getText());
					String s1 = t2.getText();
					String s2 = t3.getText();
					String s3 = t4.getText();
					int b = Integer.parseInt(t5.getText());
					int c = Integer.parseInt(t6.getText());
					String s4 = gender;
					String s5 = t7.getText();

					ps = co.prepareStatement("insert into addemp2 value(?,?,?,?,?,?,?,?)");
					ps.setInt(1, a);
					ps.setString(2, s1);
					ps.setString(3, s2);
					ps.setString(4, s3);
					ps.setInt(5, b);
					ps.setInt(6, c);
					ps.setString(7, s4);
					ps.setString(8, s5);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(this, "Data inserted succesfully");
					// System.out.println("Data inserted succesfully");
					// co.close();
				} catch (Exception e) {
				}
			}
		} else if (s.equals("UPDATE")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// JOptionPane.showMessageDialog(this,"Driver Registered");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
				// JOptionPane.showMessageDialog(this,"Connection Created");

				a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String s3 = t4.getText();
				int b = Integer.parseInt(t5.getText());
				int c = Integer.parseInt(t6.getText());
				String s4 = gender;
				String s5 = t7.getText();

				ps = co.prepareStatement(
						"update addemp2 set Emp_name=?,Emp_mob=?,Emp_addr=?,Emp_sal=?,Age=?,Gender=?,Date=? where Emp_ID="
								+ a);

				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, s3);
				ps.setInt(4, b);
				ps.setInt(5, c);
				ps.setString(6, s4);
				ps.setString(7, s5);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data updated succesfully");
				// System.out.println("Data inserted succesfully");
				// co.close();
			} catch (Exception e) {
			}
		} else if (s.equals("DELETE")) {
			try {
				/*
				 * Class.forName("com.mysql.jdbc.Driver");
				 * JOptionPane.showMessageDialog(this,"Driver Registered");
				 * Connection
				 * co=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db","root",
				 * "root");
				 * JOptionPane.showMessageDialog(this,"Connection Created");
				 */

				int a = Integer.parseInt(t1.getText());

				// String query="update mobadd SET
				// prod_nm=?,prod_comp=?,prod_price=?,prod_unit=?,prod_type=? where prod_id="+a;
				// PreparedStatement ps=co.prepareStatement(query);
				ps = co.prepareStatement("delete from addemp2 where Emp_ID=" + a);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data deleted succesfully");
				// System.out.println("Data inserted succesfully");
				// co.close();
			} catch (Exception e) {
			}
		}

		else if (s.equals("CLEAR")) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");

		} else if (s.equals("SEARCH")) {

			try {

				PreparedStatement ps = co.prepareStatement(
						"select Emp_name,Emp_mob,Emp_addr,Emp_sal,Age,Gender,Date from addemp2 where Emp_ID=?");

				a = Integer.parseInt(t1.getText());
				ps.setInt(1, a);

				ResultSet rs = ps.executeQuery();
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(this, "record not found");
					t1.requestFocus();
				} else {
					t2.setText(rs.getString("Emp_name"));
					t3.setText(rs.getString("Emp_mob"));
					t4.setText(rs.getString("Emp_addr"));
					t5.setText(rs.getString("Emp_sal"));
					t6.setText(rs.getString("Age"));
					t7.setText(rs.getString("Date"));
					if (null != rs.getString("Gender"))
						switch (rs.getString("Gender")) {
							case "Male":
								rb3.setSelected(true);
								break;
							case "Female":
								rb4.setSelected(true);
								break;
							default:
								rb3.setSelected(false);
								rb4.setSelected(false);
						}
					else {
						rb3.setSelected(false);
						rb4.setSelected(false);
					}

				}

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			} catch (NullPointerException ex) {
				System.out.println("Exception: " + ex);
			}
		} else if (ae.getSource() == b5) {
			MobWelcome mb = new MobWelcome();
			dispose();
		} else if (s.equals("Browse")) {
			int result = jf.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				String nm = jf.getSelectedFile().getPath();
				userimg.setIcon(new ImageIcon(nm));
			}

		} else if (s.equals("Check Records")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
				String[] column = { "Emp_ID", "Emp_nm", "Emp_mob", "Emp_addr", "Emp_sal", "Age", "Gender", "Date" };
				ps = co.prepareStatement("select * from addemp2");
				rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 7; j++) {
						data1[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data1, column);
				JScrollPane jp = new JScrollPane(jt);
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 600, 300);
				p2.add(jp);
				// co.close();
			} catch (Exception e) {
			}
		}

	}
}
