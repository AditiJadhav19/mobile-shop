import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MobWelcome extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	JLabel l1, l2, l3;
	ImageIcon i2, i3, i4, i5, i6, i7, i8, i9, i10, i11;
	JPanel p1, p2;

	MobWelcome() {

		setVisible(true);
		setSize(1400, 750);
		setLayout(null);
		// getContentPane().setBackground(Color.pink);

		p1 = new JPanel();
		Color c1 = Color.decode("#008080");
		p1.setBackground(c1);
		// p1.setLayout(null);
		p1.setBounds(0, 0, 1400, 100);

		l2 = new JLabel("Welcome To Unique Mobile Shopee");
		l2.setForeground(Color.white);
		l2.setBounds(230, 0, 1000, 100);
		Font f1 = new Font("Harlow Solid Italic", Font.BOLD, 55);
		l2.setFont(f1);

		p2 = new JPanel();
		p2.setSize(700, 350);
		p2.setLayout(null);
		p2.setBounds(250, 150, 900, 500);
		Color c2 = Color.decode("#008080");
		p2.setBackground(c2);

		/*
		 * i2=new ImageIcon("mob1.jpg");
		 * Image img=i2.getImage();
		 * Image temp=img.getScaledInstance(1400,750,Image.SCALE_SMOOTH);
		 * i2=new ImageIcon(temp);
		 */
		l1 = new JLabel("", i2, JLabel.CENTER);
		l1.setBounds(0, 0, 1400, 750);

		i11 = new ImageIcon(getClass().getResource("/images/cross.jpg"));
		b9 = new JButton();
		b9.setIcon(i11);
		b9.setBounds(1300, 10, 30, 30);
		add(b9);

		l1.add(p1);
		p1.add(l2);
		l1.add(p2);
		add(l1);

		// i1=new ImageIcon(new
		// ImageIcon("mob1.jpg").getImage().getScaledInstance(1400,750,Image.SCALE_SMOOTH));
		// p1.setBounds(200,200,700,350);
		// i1=new ImageIcon("m14.jpg");
		// l1=new JLabel();
		// Font f1=new Font("Harlow Solid Italic",Font.BOLD,55);
		// l1.setIcon(i1);
		// l1.setBounds(0,0,1400,750);
		// Color c1=Color.decode("#990066");
		// getContentPane().setBackground(c1);
		// l1.setForeground(Color.PINK);
		// l1.setIcon(i1);

		// l2=new JLabel("Welcome To Unique Mobile Shopee");
		// l2.setBounds(180,0,1000,100);
		// Font f1=new Font("Harlow Solid Italic",Font.BOLD,55);
		// l2.setFont(f1);

		// add(p1);
		// add(l1);
		// p1.add(l2);

		i3 = new ImageIcon(getClass().getResource("/images/icon1.jpg"));
		b1 = new JButton(i3);
		b1.setText("Brands");
		i4 = new ImageIcon(getClass().getResource("/images/icon2.jpg"));
		b2 = new JButton(i4);
		b2.setText("Add Mobile");
		i5 = new ImageIcon(getClass().getResource("/images/icon3.jpg"));
		b3 = new JButton(i5);
		b3.setText("Add Sells");
		i6 = new ImageIcon(getClass().getResource("/images/icon4.jpg"));
		b4 = new JButton(i6);
		b4.setText("Add Employee");
		i8 = new ImageIcon(getClass().getResource("/images/icon7.jpg"));
		b5 = new JButton(i8);
		b5.setText("Attendance");
		i9 = new ImageIcon(getClass().getResource("/images/icon6.jpg"));
		b6 = new JButton(i9);
		b6.setText("Repair Mobile");
		i7 = new ImageIcon(getClass().getResource("/images/icon5.jpg"));
		b7 = new JButton(i7);
		b7.setText("Show Table");
		i10 = new ImageIcon(getClass().getResource("/images/icon8.jpg"));
		b8 = new JButton(i10);
		b8.setText("Logout");

		/*
		 * b1.setBorderPainted(false);
		 * b2.setBorderPainted(false);
		 * b3.setBorderPainted(false);
		 * b4.setBorderPainted(false);
		 * b5.setBorderPainted(false);
		 * b6.setBorderPainted(false);
		 * b7.setBorderPainted(false);
		 * b8.setBorderPainted(false);
		 */

		b1.setBounds(220, 80, 230, 80);
		b2.setBounds(220, 180, 230, 80);
		b3.setBounds(220, 280, 230, 80);
		b4.setBounds(500, 80, 230, 80);
		b5.setBounds(500, 180, 230, 80);
		b6.setBounds(500, 280, 230, 80);
		b7.setBounds(220, 380, 230, 80);
		b8.setBounds(500, 380, 230, 80);

		b1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b4.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b5.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b6.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b7.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		b8.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));

		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		b6.setBackground(Color.white);
		b7.setBackground(Color.white);
		b8.setBackground(Color.white);

		b1.setForeground(Color.black);
		b2.setForeground(Color.black);
		b3.setForeground(Color.black);
		b4.setForeground(Color.black);
		b5.setForeground(Color.black);
		b6.setForeground(Color.black);
		b7.setForeground(Color.black);
		b8.setForeground(Color.black);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);

	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("Brands")) {
			brands_demo bd = new brands_demo();
			dispose();
		} else if (s.equals("Add Mobile")) {
			// duplicate d=new duplicate();
			add_mobile ad = new add_mobile();
			dispose();
		} else if (s.equals("Add Sells")) {
			sell_mobile sm = new sell_mobile();
			dispose();
		} else if (s.equals("Show Table")) {
			mobinfo mi = new mobinfo();
			dispose();
		} else if (s.equals("Add Employee")) {
			add_emp_org mi = new add_emp_org();
			dispose();
		} else if (s.equals("Attendance")) {
			attendance at = new attendance();
			dispose();

		} else if (ae.getSource() == b9) {
			MobLogin ml = new MobLogin();
			dispose();
		} else if (s.equals("Logout")) {
			Logout lt = new Logout();
			dispose();

		} else if (s.equals("Repair Mobile")) {
			repair_mobile rm = new repair_mobile();
			dispose();

		}

	}

}
