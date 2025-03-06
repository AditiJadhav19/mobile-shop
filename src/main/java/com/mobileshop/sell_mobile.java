
//package org.codejava.itextpdf;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.applet.*;
import java.sql.*;

import javax.swing.border.TitledBorder;

import java.awt.print.*;
import java.awt.image.BufferedImage;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.time.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/*import com.itextpdf.layout.element.image;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;*/

public class sell_mobile extends JFrame implements ActionListener, TextListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
	JLabel ll, ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9, ll10, ll11, ll12, ll13, ll14, ll15, ll16, ll17, ll18, ll19,
			ll20, ll21, ll22, ll23, ll24, ll25, ll26, ll27;
	JLabel jl1;
	JTextField t1, t2, t3, t4, t5, t6, t8, t9, t10;
	java.awt.TextField t7;
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	String data1[][] = new String[100][100];
	ImageIcon i1;
	JTable jt;
	JPanel p1, p2;
	Choice c;
	ResultSet rs;
	boolean flag = true;
	Connection co;
	PreparedStatement ps;
	Statement st;
	int a;
	public static final long serialVersionUID = 1L;

	sell_mobile() {
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
		setSize(1600, 1600);
		setVisible(true);
		setLayout(null);

		getContentPane().setBackground(Color.pink);

		b1 = new JButton("INSERT");
		b2 = new JButton("UPDATE");
		b3 = new JButton("DELETE");
		b4 = new JButton("CLEAR");
		b5 = new JButton("BILL");
		b6 = new JButton("Check Records");
		b8 = new JButton("SEARCH");

		i1 = new ImageIcon(getClass().getResource("/images/cross.jpg"));
		b7 = new JButton();
		b7.setIcon(i1);
		b7.setBounds(1300, 10, 30, 30);
		add(b7);

		b1.setBounds(230, 370, 100, 40);
		b2.setBounds(380, 370, 100, 40);
		b3.setBounds(230, 430, 100, 40);
		b4.setBounds(380, 430, 100, 40);
		b5.setBounds(230, 490, 100, 40);
		b6.setBounds(220, 370, 150, 40);
		b8.setBounds(380, 490, 100, 40);

		java.awt.Font f10 = new java.awt.Font("Arial", java.awt.Font.BOLD, 15);
		b1.setFont(f10);
		b2.setFont(f10);
		b3.setFont(f10);
		b4.setFont(f10);
		b5.setFont(f10);
		b6.setFont(f10);
		b8.setFont(f10);

		l1 = new JLabel("Product ID");
		l2 = new JLabel("Customer Name");
		l3 = new JLabel("Customer MNo.");
		l4 = new JLabel("Date");
		l5 = new JLabel("Company Name");
		l6 = new JLabel("Product Price");
		l10 = new JLabel("Quantity");
		l11 = new JLabel("Warranty");
		l12 = new JLabel("Product Name");
		l13 = new JLabel("Total Amount");

		/*
		 * c=new Choice();
		 * c.add("Oppo");
		 * c.add("Realme");
		 * c.add("Samsung");
		 * c.add("Vivo");
		 * c.add("OnePlus");
		 */

		java.awt.Font f1 = new java.awt.Font("Georgia", java.awt.Font.BOLD, 15);
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l10.setFont(f1);
		l11.setFont(f1);
		l12.setFont(f1);
		l13.setFont(f1);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new java.awt.TextField();
		t8 = new JTextField();
		t9 = new JTextField();
		t10 = new JTextField();

		LocalDate date = LocalDate.now();
		t4.setText("" + date);

		l1.setBounds(30, 70, 150, 20);
		l2.setBounds(30, 130, 150, 20);
		l3.setBounds(30, 190, 150, 20);
		l4.setBounds(30, 250, 150, 30);
		l5.setBounds(30, 310, 150, 30);

		l6.setBounds(360, 70, 150, 20);
		l10.setBounds(360, 130, 150, 20);
		l11.setBounds(360, 190, 150, 20);
		l12.setBounds(360, 250, 150, 30);
		l13.setBounds(360, 310, 150, 30);

		t1.setBounds(180, 70, 150, 20);
		t2.setBounds(180, 130, 150, 20);
		t3.setBounds(180, 190, 150, 20);
		t4.setBounds(180, 250, 150, 20);
		t5.setBounds(180, 310, 150, 20);

		t6.setBounds(510, 70, 150, 20);
		t7.setBounds(510, 130, 150, 20);
		t8.setBounds(510, 190, 150, 20);
		t9.setBounds(510, 250, 150, 20);
		t10.setBounds(510, 310, 150, 20);

		l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		l6.setForeground(Color.blue);
		l10.setForeground(Color.blue);
		l11.setForeground(Color.blue);
		l12.setForeground(Color.blue);
		l13.setForeground(Color.blue);

		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		b5.setBackground(Color.pink);
		b6.setBackground(Color.pink);
		b8.setBackground(Color.pink);

		b1.setForeground(Color.black);
		b2.setForeground(Color.black);
		b3.setForeground(Color.black);
		b4.setForeground(Color.black);
		b5.setForeground(Color.black);
		b6.setForeground(Color.black);
		b8.setForeground(Color.black);

		p1 = new JPanel();
		p2 = new JPanel();
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sell Mobile Here",
				TitledBorder.LEFT, TitledBorder.TOP));
		p1.setBounds(10, 50, 700, 600);
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.LEFT,
				TitledBorder.TOP));
		p2.setBounds(730, 56, 600, 495);
		p1.setBackground(Color.white);
		p2.setBackground(Color.gray);
		p1.setLayout(null);
		p2.setLayout(null);
		add(p1);
		add(p2);

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
		p1.add(l10);
		p1.add(t7);
		p1.add(l11);
		p1.add(t8);
		p1.add(l12);
		p1.add(t9);
		p1.add(l13);
		p1.add(t10);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p2.add(b6);
		p1.add(b8);
		// p1.add(t5);

		try {

			if (flag) {
				rs = st.executeQuery("Select * from sale");
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
		b8.addActionListener(this);
		t7.addTextListener(this);
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
		t8.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t9.requestFocus();

				}
			}
		});
		t9.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t10.requestFocus();

				}
			}
		});
		t2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
						|| c == KeyEvent.VK_SPACE)) {
					e.consume();

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
		t5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
						|| c == KeyEvent.VK_SPACE)) {
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
		t7.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		t8.addKeyListener(new KeyAdapter() {
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
					|| t5.getText().trim().isEmpty() || t9.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please enter data!");
			} else {
				try {

					a = Integer.parseInt(t1.getText());
					String s1 = t2.getText();
					String s2 = t3.getText();
					String b = t4.getText();
					String s3 = t5.getText();
					String s4 = t9.getText();
					int c = Integer.parseInt(t6.getText());
					int d = Integer.parseInt(t7.getText());
					int e = Integer.parseInt(t8.getText());
					int f = Integer.parseInt(t10.getText());

					ps = co.prepareStatement("insert into sale value(?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, a);
					ps.setString(2, s1);
					ps.setString(3, s2);
					ps.setString(4, b);
					ps.setString(5, s4);
					ps.setString(6, s3);
					ps.setInt(7, c);
					ps.setInt(8, d);
					ps.setInt(9, e);
					ps.setInt(10, f);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(this, "Data inserted succesfully");
					JOptionPane.showMessageDialog(this, "Do you want print bill then click on 'BILL' button");

				} catch (SQLException ex) {
					System.out.println("Exception: " + ex);
				}
			}
		} else if (s.equals("UPDATE")) {
			try {

				int a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String b = t4.getText();
				String s3 = t5.getText();
				String s4 = t9.getText();
				int c = Integer.parseInt(t6.getText());
				int d = Integer.parseInt(t7.getText());
				int e = Integer.parseInt(t8.getText());
				int f = Integer.parseInt(t10.getText());

				ps = co.prepareStatement(
						"update sale set cust_nm=?,cust_mob=?,date=?,prod_nm=?,comp_nm=?,prod_price=?,quantity=?,warranty=?,Total_Amount=? where Prod_ID="
								+ a);

				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, b);
				ps.setString(4, s4);
				ps.setString(5, s3);
				ps.setInt(6, c);
				ps.setInt(7, d);
				ps.setInt(8, e);
				ps.setInt(9, f);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data updated succesfully");
				// System.out.println("Data inserted succesfully");

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			}
		} else if (s.equals("DELETE")) {
			try {

				int a = Integer.parseInt(t1.getText());

				// String query="update mobadd SET
				// prod_nm=?,prod_comp=?,prod_price=?,prod_unit=?,prod_type=?,Total Amount=?
				// where prod_id="+a;
				// PreparedStatement ps=co.prepareStatement(query);
				ps = co.prepareStatement("delete from sale where Prod_ID=" + a);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data deleted succesfully");
				// System.out.println("Data inserted succesfully");

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			}
		}

		else if (s.equals("CLEAR")) {

			t2.setText("");
			t3.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t9.setText("");
			t10.setText("");
		} else if (s.equals("BILL")) {
			Frame f = new Frame();
			JDialog d = new JDialog(f, "Dialog Example", true);
			d.setLayout(null);
			d.getContentPane().setBackground(Color.white);
			d.setLocation(400, 0);

			ll = new JLabel(new ImageIcon("unique1.jpg"));
			ll1 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll2 = new JLabel("Unique Mobile Shopee");
			ll3 = new JLabel("Phone No.1234567892");
			ll4 = new JLabel("Address.Dindives,udgaon ves,Miraj");
			ll5 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll6 = new JLabel("Date                   :" + t4.getText());
			ll7 = new JLabel("Customer Name   :" + t2.getText());
			ll8 = new JLabel("Customer Mobile :" + t3.getText());
			ll9 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll10 = new JLabel("Prod ID");
			ll15 = new JLabel("" + t1.getText());
			ll11 = new JLabel("Prod Name");
			ll16 = new JLabel("" + t9.getText());
			ll12 = new JLabel("Comp Name");
			ll17 = new JLabel("" + t5.getText());
			ll13 = new JLabel("Prod Price");
			ll18 = new JLabel("" + t6.getText());
			ll14 = new JLabel("Warranty");
			ll19 = new JLabel("" + t8.getText());
			ll20 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll21 = new JLabel("Quantity");
			ll22 = new JLabel("" + t7.getText());
			ll25 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll23 = new JLabel("Total Amount");
			ll24 = new JLabel("" + t10.getText());
			ll26 = new JLabel(
					"----------------------------------------------------------------------------------------------------------------------------------");
			ll27 = new JLabel("THANK YOU COME AGAIN");

			JButton b = new JButton("PRINT");
			b.setBounds(230, 630, 100, 50);

			ll.setBounds(180, 0, 200, 100);
			ll1.setBounds(0, 70, 1000, 50);
			ll2.setBounds(100, 100, 600, 50);
			ll3.setBounds(100, 130, 600, 50);
			ll4.setBounds(100, 160, 600, 50);
			ll5.setBounds(0, 190, 1000, 50);
			ll6.setBounds(50, 220, 300, 50);
			ll7.setBounds(50, 250, 300, 50);
			ll8.setBounds(50, 280, 300, 50);
			ll9.setBounds(0, 310, 1000, 50);
			ll10.setBounds(30, 340, 200, 50);
			ll15.setBounds(40, 370, 200, 50);
			ll11.setBounds(130, 340, 200, 50);
			ll16.setBounds(130, 370, 200, 50);
			ll12.setBounds(250, 340, 200, 50);
			ll17.setBounds(250, 370, 200, 50);
			ll13.setBounds(480, 340, 200, 50);
			ll18.setBounds(500, 370, 200, 50);
			ll14.setBounds(370, 340, 200, 50);
			ll19.setBounds(370, 370, 200, 50);
			ll20.setBounds(0, 400, 1000, 50);
			ll21.setBounds(30, 430, 200, 50);
			ll22.setBounds(500, 430, 200, 50);
			ll23.setBounds(30, 490, 200, 50);
			ll24.setBounds(500, 490, 200, 50);
			ll25.setBounds(0, 460, 1000, 50);
			ll26.setBounds(0, 520, 1000, 50);
			ll27.setBounds(150, 570, 600, 50);

			java.awt.Font f1 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll1.setFont(f1);
			java.awt.Font f2 = new java.awt.Font("", java.awt.Font.BOLD, 20);
			ll2.setFont(f2);
			java.awt.Font f3 = new java.awt.Font("", java.awt.Font.BOLD, 20);
			ll3.setFont(f3);
			java.awt.Font f4 = new java.awt.Font("", java.awt.Font.BOLD, 20);
			ll4.setFont(f4);
			java.awt.Font f5 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll5.setFont(f5);
			java.awt.Font f6 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll6.setFont(f6);
			java.awt.Font f7 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll7.setFont(f7);
			java.awt.Font f8 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll8.setFont(f8);
			java.awt.Font f9 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll9.setFont(f9);
			java.awt.Font f10 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll10.setFont(f10);
			java.awt.Font f11 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll11.setFont(f11);
			java.awt.Font f12 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll12.setFont(f12);
			java.awt.Font f13 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll13.setFont(f13);
			java.awt.Font f14 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll14.setFont(f14);
			java.awt.Font f15 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll15.setFont(f15);
			java.awt.Font f16 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll16.setFont(f16);
			java.awt.Font f17 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll17.setFont(f17);
			java.awt.Font f18 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll18.setFont(f18);
			java.awt.Font f19 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll19.setFont(f19);
			java.awt.Font f20 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll20.setFont(f20);
			java.awt.Font f21 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll21.setFont(f21);
			java.awt.Font f22 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll22.setFont(f22);
			java.awt.Font f23 = new java.awt.Font("", java.awt.Font.BOLD, 15);
			ll23.setFont(f23);
			java.awt.Font f24 = new java.awt.Font("", java.awt.Font.PLAIN, 15);
			ll24.setFont(f24);
			java.awt.Font f25 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll25.setFont(f25);
			java.awt.Font f26 = new java.awt.Font("", java.awt.Font.BOLD, 30);
			ll26.setFont(f26);
			java.awt.Font f27 = new java.awt.Font("", java.awt.Font.BOLD, 20);
			ll27.setFont(f27);
			java.awt.Font f28 = new java.awt.Font("Elephant", java.awt.Font.BOLD, 15);
			b.setFont(f28);
			b.setBackground(Color.black);
			b.setForeground(Color.white);

			d.add(ll);
			d.add(ll1);
			d.add(ll2);
			d.add(ll3);
			d.add(ll4);
			d.add(ll5);
			d.add(ll6);
			d.add(ll7);
			d.add(ll8);
			d.add(ll9);
			d.add(ll10);
			d.add(ll11);
			d.add(ll12);
			d.add(ll13);
			d.add(ll14);
			d.add(ll15);
			d.add(ll16);
			d.add(ll17);
			d.add(ll18);
			d.add(ll19);
			d.add(ll20);
			d.add(ll21);
			d.add(ll22);
			d.add(ll23);
			d.add(ll24);
			d.add(ll25);
			d.add(ll26);
			d.add(ll27);
			d.add(b);
			b.addActionListener(this);
			d.setSize(600, 800);
			d.setVisible(true);

		} else if (s.equals("PRINT")) {
			try {
				Document d = new Document();
				PdfWriter pd = PdfWriter.getInstance(d, new FileOutputStream("aaa.pdf"));
				d.open();

				String filename = "c:/java/Mobile shop management system/unique1.jpg";
				Image image = Image.getInstance(filename);
				/*
				 * image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
				 * float x = (PageSize.A4.getWidth() - image.getScaledWidth()) / 4;
				 * float y = (PageSize.A4.getHeight() - image.getScaledHeight()) / 4;
				 * image.setAbsolutePosition(x, y);
				 */
				image.setAbsolutePosition(250, 750);
				d.add(image);

				d.add(new Paragraph("\n\n\n" + ll1.getText()));
				d.add(new Paragraph("                                             " + ll2.getText()
						+ "                                                "));
				d.add(new Paragraph("                                             " + ll3.getText()
						+ "                                                "));
				d.add(new Paragraph("                                             " + ll4.getText()
						+ "                                                "));
				d.add(new Paragraph("" + ll5.getText()));
				d.add(new Paragraph(" " + ll6.getText()));
				d.add(new Paragraph(" " + ll7.getText()));
				d.add(new Paragraph(" " + ll8.getText()));
				d.add(new Paragraph("" + ll9.getText()));
				d.add(new Paragraph("       " + ll10.getText() + "               " + ll11.getText() + "               "
						+ ll12.getText() + "               " + ll14.getText() + "               " + ll13.getText()
						+ "\n\n"));
				d.add(new Paragraph("       " + ll15.getText() + "                      " + ll16.getText()
						+ "                       " + ll17.getText() + "                     " + ll19.getText()
						+ "                                " + ll18.getText()));
				d.add(new Paragraph("" + ll20.getText()));
				d.add(new Paragraph(" " + ll21.getText()
						+ "                                                                                                                                "
						+ ll22.getText()));
				d.add(new Paragraph("" + ll25.getText()));
				d.add(new Paragraph(" " + ll23.getText()
						+ "                                                                                                                     "
						+ ll24.getText()));
				d.add(new Paragraph("" + ll26.getText()));
				d.add(new Paragraph("                                                       " + ll27.getText()
						+ "                                                                                                               "));

				d.close();
				pd.close();
				JOptionPane.showMessageDialog(this, "PDF saved");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");

			} catch (Exception e) {
				System.out.println(e);

			}

		} else if (s.equals("Check Records")) {
			try {

				String[] column1 = { "Prod_ID", "cust_nm", "cust_mob", "date", "prod_nm", "comp_nm", "prod_price",
						"quantity", "warranty", "Total Amount" };
				ps = co.prepareStatement("select * from sale");
				rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 9; j++) {
						data1[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				// int hsb=JScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
				// int hsb=JScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
				jt = new JTable(data1, column1);
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 600, 300);
				p2.add(jp);
			} catch (Exception e) {
			}
		} else if (ae.getSource() == b7) {
			MobWelcome m1 = new MobWelcome();
			dispose();
		} else if (s.equals("SEARCH")) {

			try {

				ps = co.prepareStatement(
						"select cust_nm,cust_mob,date,prod_nm,comp_nm,prod_price,quantity,warranty,Total_Amount from sale where Prod_ID=?");
				// ps.setInt(1,a);

				a = Integer.parseInt(t1.getText());
				ps.setInt(1, a);
				rs = ps.executeQuery();
				if (rs.next() == false) {
					JOptionPane.showMessageDialog(this, "record not found");

					t1.requestFocus();
				} else {
					t2.setText(rs.getString("cust_nm"));
					t3.setText(rs.getString("cust_mob"));
					t4.setText(rs.getString("date"));
					t5.setText(rs.getString("comp_nm"));
					t6.setText(rs.getString("prod_price"));
					t7.setText(rs.getString("quantity"));
					t8.setText(rs.getString("warranty"));
					t9.setText(rs.getString("prod_nm"));
					t10.setText(rs.getString("Total_Amount"));
				}

			} catch (SQLException ex) {
				System.out.println("Exception: " + ex);
			} catch (NullPointerException ex) {
				System.out.println("Exception: " + ex);
			}

		}

	}

	public void textValueChanged(TextEvent te) {
		int a = Integer.parseInt(t6.getText());
		int b = Integer.parseInt(t7.getText());
		int c;
		c = a * b;
		t10.setText("" + c);

	}

}
