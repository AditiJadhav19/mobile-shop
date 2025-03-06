import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;

public class sell_mobile2 extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
	JButton b1, b2, b3, b4, b5;
	// ImageIcon i1,i2;
	JPanel p1, p3;

	sell_mobile2() {
		setVisible(true);
		setSize(1600, 1600);
		setLayout(null);

		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 90, 1600, 600);
		p1.setBackground(Color.white);

		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBounds(0, 0, 1600, 90);
		Color c2 = Color.decode("#800080");
		p3.setBackground(c2);

		l9 = new JLabel("Add sells Here");
		l9.setBounds(500, 20, 600, 50);
		l9.setForeground(Color.orange);
		Font f7 = new Font("Rockwell", Font.BOLD, 40);
		l9.setFont(f7);
		p3.add(l9);

		/*
		 * i1=new ImageIcon("madd1.jfif");
		 * l7=new JLabel();
		 * l7.setBounds(900,80,200,200);
		 * l7.setIcon(i1);
		 * 
		 * i2=new ImageIcon("madd2.jpg");
		 * l8=new JLabel();
		 * l8.setBounds(900,300,200,200);
		 * l8.setIcon(i2);
		 */

		b1 = new JButton("INSERT");
		b2 = new JButton("UPDATE");
		b3 = new JButton("DELETE");
		b4 = new JButton("CLEAR");
		b5 = new JButton("BILLING");
		b1.setBounds(100, 450, 100, 40);
		b2.setBounds(300, 450, 100, 40);
		b3.setBounds(500, 450, 100, 40);
		b4.setBounds(700, 450, 100, 40);
		b5.setBounds(900, 450, 100, 40);

		Font f10 = new Font("Arial", Font.BOLD, 15);
		b1.setFont(f10);

		Font f11 = new Font("Arial", Font.BOLD, 15);
		b2.setFont(f11);

		Font f12 = new Font("Arial", Font.BOLD, 15);
		b3.setFont(f12);

		Font f13 = new Font("Arial", Font.BOLD, 15);
		b4.setFont(f13);

		Font f15 = new Font("Arial", Font.BOLD, 15);
		b5.setFont(f15);

		Color c1 = Color.decode("#800080");
		b1.setBackground(c1);
		b1.setForeground(Color.orange);

		Color c5 = Color.decode("#800080");
		b2.setBackground(c5);
		b2.setForeground(Color.orange);

		Color c6 = Color.decode("#800080");
		b3.setBackground(c6);
		b3.setForeground(Color.orange);

		Color c4 = Color.decode("#800080");
		b4.setBackground(c4);
		b4.setForeground(Color.orange);

		Color c7 = Color.decode("#800080");
		b5.setBackground(c7);
		b5.setForeground(Color.orange);

		l1 = new JLabel("Customer ID");
		l2 = new JLabel("Customer Name");
		l3 = new JLabel("Customer MNo.");
		l4 = new JLabel("Date");
		l5 = new JLabel("Company Name");
		l6 = new JLabel("Product Price");
		l10 = new JLabel("Quantity");
		l11 = new JLabel("Warranty");
		l12 = new JLabel("Product Name");

		Font f1 = new Font("Georgia", Font.BOLD, 20);
		l1.setFont(f1);
		Font f2 = new Font("Georgia", Font.BOLD, 20);
		l2.setFont(f2);
		Font f3 = new Font("Georgia", Font.BOLD, 20);
		l3.setFont(f3);
		Font f4 = new Font("Georgia", Font.BOLD, 20);
		l4.setFont(f4);
		Font f5 = new Font("Georgia", Font.BOLD, 20);
		l5.setFont(f5);
		Font f6 = new Font("Georgia", Font.BOLD, 20);
		l6.setFont(f6);
		Font f8 = new Font("Georgia", Font.BOLD, 20);
		l10.setFont(f8);
		Font f9 = new Font("Georgia", Font.BOLD, 20);
		l11.setFont(f9);
		Font f14 = new Font("Georgia", Font.BOLD, 20);
		l12.setFont(f14);

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		t7 = new JTextField();
		t8 = new JTextField();
		t9 = new JTextField();

		l1.setBounds(80, 20, 200, 100);
		l2.setBounds(80, 150, 200, 100);
		l3.setBounds(80, 300, 200, 100);
		l4.setBounds(500, 20, 200, 100);
		l5.setBounds(500, 300, 200, 100);
		l6.setBounds(920, 20, 200, 100);
		l10.setBounds(920, 150, 200, 100);
		l11.setBounds(920, 300, 200, 100);
		l12.setBounds(500, 150, 200, 100);

		t1.setBounds(80, 90, 250, 30);
		t2.setBounds(80, 220, 250, 30);
		t3.setBounds(80, 370, 250, 30);
		t4.setBounds(500, 90, 250, 30);
		t5.setBounds(500, 370, 250, 30);
		t6.setBounds(920, 90, 250, 30);
		t7.setBounds(920, 220, 250, 30);
		t8.setBounds(920, 370, 250, 30);
		t9.setBounds(500, 220, 250, 30);

		add(p1);
		add(p3);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);// p1.add(l7);p1.add(l8);
		p1.add(l10);
		p1.add(l11);
		p1.add(l12);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		p1.add(t8);
		p1.add(t9);
		// p2.add(l7);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s.equals("INSERT")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				JOptionPane.showMessageDialog(this, "Driver Registered");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
				JOptionPane.showMessageDialog(this, "Connection Created");

				int a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String b = t4.getText();
				String s3 = t5.getText();
				String s4 = t9.getText();
				int c = Integer.parseInt(t6.getText());
				int d = Integer.parseInt(t7.getText());
				int e = Integer.parseInt(t8.getText());

				PreparedStatement ps = co.prepareStatement("insert into sellmob value(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, a);
				ps.setString(2, s1);
				ps.setString(3, s2);
				ps.setString(4, b);
				ps.setString(5, s4);
				ps.setString(6, s3);
				ps.setInt(7, c);
				ps.setInt(8, d);
				ps.setInt(9, e);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data inserted succesfully");
				// System.out.println("Data inserted succesfully");
				co.close();
			} catch (Exception e) {
			}
		} else if (s.equals("UPDATE")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				JOptionPane.showMessageDialog(this, "Driver Registered");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
				JOptionPane.showMessageDialog(this, "Connection Created");

				int a = Integer.parseInt(t1.getText());
				String s1 = t2.getText();
				String s2 = t3.getText();
				String b = t4.getText();
				String s3 = t5.getText();
				String s4 = t9.getText();
				int c = Integer.parseInt(t6.getText());
				int d = Integer.parseInt(t7.getText());
				int e = Integer.parseInt(t8.getText());

				PreparedStatement ps = co.prepareStatement(
						"update sellmob set cust_nm=?,cust_mob=?,date=?,prod_nm=?,comp_nm=?,prod_price=?,quantity=?,warranty=? where cust_ID="
								+ a);

				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, b);
				ps.setString(4, s4);
				ps.setString(5, s3);
				ps.setInt(6, c);
				ps.setInt(7, d);
				ps.setInt(8, e);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data updated succesfully");
				// System.out.println("Data inserted succesfully");
				co.close();
			} catch (Exception e) {
			}
		} else if (s.equals("DELETE")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				JOptionPane.showMessageDialog(this, "Driver Registered");
				Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
				JOptionPane.showMessageDialog(this, "Connection Created");

				int a = Integer.parseInt(t1.getText());

				// String query="update mobadd SET
				// prod_nm=?,prod_comp=?,prod_price=?,prod_unit=?,prod_type=? where prod_id="+a;
				// PreparedStatement ps=co.prepareStatement(query);
				PreparedStatement ps = co.prepareStatement("delete from sellmob where cust_ID=" + a);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Data deleted succesfully");
				// System.out.println("Data inserted succesfully");
				co.close();
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
			t8.setText("");
			t9.setText("");
		} else if (s.equals("BILLING")) {
			JDialog d = new JDialog();
			JLabel l1 = new JLabel("Unique Mobile Shopee");
			JLabel l2 = new JLabel("Address:Near Dindives Miraj");
			JLabel l3 = new JLabel("Ph.no:8483011076");

			d.setSize(600, 900);
			d.setVisible(true);
			d.setLayout(null);
			l1.setBounds(50, 50, 200, 80);
			l2.setBounds(50, 150, 200, 80);
			l3.setBounds(50, 250, 200, 80);
			d.add(l1);
			d.add(l2);
			d.add(l3);

		}
	}
}
