import java.awt.*;
import java.time.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.regex.*;

public class add_mobile extends JFrame implements ActionListener, TextListener// ,KeyListener
{
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4, t5, t7, t8;
	TextField t6;
	// ImageIcon i1,i2;
	JPanel p1, p2;
	JButton b1, b2, b3, b4, b5, b6, b7;
	JTable jt;
	Choice c;
	String data1[][] = new String[100][100];
	ResultSet rs;
	boolean flag = true;
	Connection co;
	PreparedStatement ps;
	Statement st;
	int a;

	add_mobile() {
		initComponent();
	}

	public void initComponent() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// JOptionPane.showMessageDialog(this,"Driver registered");
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/sana", "root", "root");
			// JOptionPane.showMessageDialog(this,"Connection created");
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

		l1 = new JLabel("Product ID");
		l2 = new JLabel("Product Name");
		l3 = new JLabel("Company Name");
		l4 = new JLabel("Date");
		l5 = new JLabel("Product Price");
		l6 = new JLabel("Product Quantity");
		l7 = new JLabel("Product Type");
		l8 = new JLabel("Total Amount");

		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		l6.setForeground(Color.blue);
		l7.setForeground(Color.blue);
		l8.setForeground(Color.blue);

		LocalDate date = LocalDate.now();

		ImageIcon i = new ImageIcon(getClass().getResource("/images/i1.jpg"));
		l9 = new JLabel(i);

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
		Font f6 = new Font("Georgia", Font.BOLD, 15);
		l6.setFont(f6);
		Font f7 = new Font("Georgia", Font.BOLD, 15);
		l7.setFont(f7);
		Font f8 = new Font("Georgia", Font.BOLD, 15);
		l8.setFont(f8);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new TextField();
		t7 = new JTextField("Mobile");
		// t7.add(d);
		// t7.setText();
		t4.setText("" + date);
		t8 = new JTextField();

		String DateFormat = "HH:mm dd/MM/yyyy";

		/*
		 * String now()
		 * {
		 * Calendar cal=Calendar.getInstance();
		 * SimpleDateFormat f=new SimpleDateFormat(DateFormat);
		 * return f.f(cal.getTime());
		 * 
		 * }
		 */

		b6 = new JButton();
		ImageIcon i2 = new ImageIcon(getClass().getResource("/images/cross.jpg"));
		b6.setIcon(i2);
		b6.setBounds(1300, 10, 30, 30);
		add(b6);

		b1 = new JButton("INSERT");
		b1.setForeground(Color.black);
		Font f11 = new Font("Arial", Font.BOLD, 15);
		b1.setFont(f11);
		b2 = new JButton("UPDATE");
		b2.setForeground(Color.black);
		Font f9 = new Font("Arial", Font.BOLD, 15);
		b2.setFont(f9);
		b3 = new JButton("DELETE");
		b3.setForeground(Color.black);
		Font f10 = new Font("Arial", Font.BOLD, 15);
		b3.setFont(f10);
		b4 = new JButton("CLEAR");
		b4.setForeground(Color.black);
		Font f12 = new Font("Arial", Font.BOLD, 15);
		b4.setFont(f12);
		b5 = new JButton("Check Records");
		b5.setForeground(Color.black);
		Font f13 = new Font("Arial", Font.BOLD, 15);
		b5.setFont(f13);
		b7 = new JButton("SEARCH");
		b7.setForeground(Color.black);
		Font f14 = new Font("Arial", Font.BOLD, 15);
		b7.setFont(f14);

		/*
		 * c=new Choice();
		 * c.add("Oppo");
		 * c.add("Realme");
		 * c.add("Samsung");
		 * c.add("Vivo");
		 * c.add("OnePlus");
		 */

		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		b5.setBackground(Color.pink);
		b7.setBackground(Color.pink);
		l1.setBounds(30, 70, 150, 20);
		l2.setBounds(30, 130, 150, 20);
		l3.setBounds(30, 190, 150, 20);
		l4.setBounds(30, 250, 150, 20);
		l5.setBounds(360, 70, 150, 20);
		l6.setBounds(360, 130, 150, 20);
		l7.setBounds(360, 190, 150, 20);
		l8.setBounds(360, 250, 150, 20);
		l9.setBounds(0, 800, 200, 100);

		t1.setBounds(180, 70, 150, 20);
		t2.setBounds(180, 130, 150, 20);
		t3.setBounds(180, 190, 150, 20);
		t4.setBounds(180, 250, 150, 20);
		t5.setBounds(510, 70, 150, 20);
		t6.setBounds(510, 130, 150, 20);
		t7.setBounds(510, 190, 150, 20);
		t8.setBounds(510, 250, 150, 20);

		b1.setBounds(230, 310, 100, 40);
		b2.setBounds(380, 310, 100, 40);
		b3.setBounds(230, 370, 100, 40);
		b4.setBounds(380, 370, 100, 40);
		b5.setBounds(220, 370, 150, 40);
		b7.setBounds(520, 310, 100, 40);

		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Mobile Here",
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
		p1.add(t7);
		p1.add(l8);
		p1.add(t8);
		add(l9);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p2.add(b5);
		p1.add(b7);

		try {

			if (flag) {
				rs = st.executeQuery("Select * from add1");
				flag = false;
			}
			rs.last();
			t1.setText(rs.getInt("Prod_ID") + 1 + "");
		} catch (SQLException ex) {
			System.out.println("Exception " + ex);
		}

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		t6.addTextListener(this);
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
		t7.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t8.requestFocus();

				}
			}
		});
		t3.addKeyListener(new KeyAdapter() {
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
		String s = ae.getActionCommand();

		if (s.equals("INSERT")) {
			if (t2.getText().trim().isEmpty() || t3.getText().trim().isEmpty() || t4.getText().trim().isEmpty()
					|| t7.getText().trim().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Please enter data!");
			}
			/*
			 * if(t2.getText().matches("^\\d+$")||t2.getText().matches("^\\d+$"))
			 * {
			 * JOptionPane.showMessageDialog(
			 * this,"You entering number so please enter character");
			 * }
			 */
			// else{
			try {
				int a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String s3 = t4.getText();
				int b = Integer.parseInt(t5.getText());
				int c = Integer.parseInt(t6.getText());
				String s4 = t7.getText();
				int d = Integer.parseInt(t8.getText());

				PreparedStatement ps = co.prepareStatement("insert into add1 value(?,?,?,?,?,?,?,?)");

				ps.setInt(1, a);
				ps.setString(2, s1);
				ps.setString(3, s2);
				ps.setString(4, s3);
				ps.setInt(5, b);
				ps.setInt(6, c);
				ps.setString(7, s4);
				ps.setInt(8, d);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data inserted succesfully");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			} catch (NumberFormatException ex) {
				System.out.println("Exception: " + ex);
			}
			// }
		} else if (s.equals("UPDATE")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// JOptionPane.showMessageDialog(this,"Driver Registered");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/sana", "root", "root");
				// JOptionPane.showMessageDialog(this,"Connection Created");
				int a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String s3 = t4.getText();
				int b = Integer.parseInt(t5.getText());
				int c = Integer.parseInt(t6.getText());
				String s4 = t7.getText();
				int d = Integer.parseInt(t8.getText());

				ps = co.prepareStatement(
						"update add1 set Prod_nm=?,Comp_nm=?,Date=?,Prod_Price=?,Quantity=?,Prod_Type=?,Total_Amount=? where Prod_ID="
								+ a);

				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, s3);
				ps.setInt(4, b);
				ps.setInt(5, c);
				ps.setString(6, s4);
				ps.setInt(7, d);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data updated succesfully");
			} catch (Exception ex) {
			}
		}

		else if (s.equals("DELETE")) {
			try {
				int a = Integer.parseInt(t1.getText());
				ps = co.prepareStatement("delete from add1 where Prod_ID=" + a);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data deleted succesfully");
			} catch (Exception ex) {
			}
		} else if (s.equals("SEARCH")) {

			try {

				ps = co.prepareStatement(
						"select Prod_nm,Comp_nm,Date,Prod_Price,Quantity,Prod_Type,Total_Amount from add1 where Prod_ID=?");

				a = Integer.parseInt(t1.getText());
				ps.setInt(1, a);

				ResultSet rs = ps.executeQuery();
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(this, "record not found");
					t1.requestFocus();
				} else {
					t2.setText(rs.getString("Prod_nm"));
					t3.setText(rs.getString("Comp_nm"));
					t4.setText(rs.getString("Date"));
					t5.setText(rs.getString("Prod_Price"));
					t6.setText(rs.getString("Quantity"));
					t7.setText(rs.getString("Prod_Type"));
					t8.setText(rs.getString("Total_Amount"));

				}

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			} catch (NullPointerException ex) {
				System.out.println("Exception: " + ex);
			}
		} else if (s.equals("CLEAR")) {
			try {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
			} catch (NumberFormatException ex) {
				System.out.println("Exception: " + ex);
			}
		} else if (s.equals("Check Records")) {
			try {
				String[] column = { "Prod_ID", "Prod_nm", "Comp_nm", "Date", "Prod_price", "Prod_quantity", "Prod_type",
						"Total Amount" };
				PreparedStatement ps = co.prepareStatement("select * from add1");
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 7; j++) {
						data1[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data1, column);
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 600, 300);
				p2.add(jp);
			} catch (Exception e) {
			}
		} else if (ae.getSource() == b6) {
			MobWelcome m1 = new MobWelcome();
			dispose();
		}
	}

	public void textValueChanged(TextEvent te) {
		int a = Integer.parseInt(t5.getText());
		int b = Integer.parseInt(t6.getText());
		int c;
		c = a * b;
		t8.setText("" + c);

	}
	/*
	 * public void keyReleased(KeyEvent ke)
	 * {
	 * String s1=t2.getText();
	 * int b=Integer.parseInt(t5.getText());
	 * 
	 * if(t2.getText().matches("^\\d+$")||t3.getText().matches("^\\d+$"))
	 * {
	 * JOptionPane.showMessageDialog(
	 * this,"You entering number so please enter character");
	 * 
	 * }
	 * if(!isNumber(ch) && !isValidSignal(ch)&& !validatePoint(ch) && ch!='\b')
	 * 
	 * }
	 * public void keyPressed(KeyEvent ke)
	 * {
	 * 
	 * }
	 * 
	 * public void keyTyped(java.awt.event.KeyEvent ke)
	 * {
	 * char ch=ke.getKeyChar();
	 * if(t2.getText().matches("^\\d+$")||t3.getText().matches("^\\d+$"))
	 * if(!(Character.isAlphabetic(ch) || (ch==KeyEvent.VK_BACK_SPACE) ||
	 * ch==KeyEvent.VK_DELETE))
	 * {
	 * JOptionPane.showMessageDialog(
	 * this,"You entering number so please enter character");
	 * ke.consume();
	 * 
	 * }
	 * else if(!(Character.isDigit(ch) || (ch==KeyEvent.VK_BACK_SPACE) ||
	 * ch==KeyEvent.VK_DELETE))
	 * {
	 * ke.consume();
	 * 
	 * }
	 * 
	 * }
	 */

}
