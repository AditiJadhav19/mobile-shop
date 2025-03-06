import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.TitledBorder;

public class MobLogin extends JFrame implements ActionListener, ItemListener {
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton b1;
	JTextField t1;
	JPasswordField t2;
	ImageIcon i1, i2;
	JCheckBox cb;

	MobLogin() {
		initComponent();
	}

	public void initComponent() {

		getContentPane().setBackground(Color.white);
		JPanel p1 = new JPanel();
		p1.setBounds(50, 80, 300, 550);
		Color c1 = Color.decode("#DF5B89");
		p1.setBackground(c1);
		add(p1);
		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.LEFT,
				TitledBorder.TOP));
		p2.setBounds(400, 80, 330, 550);
		p2.setBackground(Color.white);
		add(p2);
		l1 = new JLabel("Sign in to continue");
		Font f2 = new Font("Elephant", Font.BOLD, 25);
		l1.setFont(f2);
		l2 = new JLabel("Username :");
		Font f3 = new Font("Elephant", Font.BOLD, 20);
		l2.setFont(f3);
		l3 = new JLabel("Password :");
		Font f4 = new Font("Elephant", Font.BOLD, 20);
		l3.setFont(f4);
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel("Mobile Shop");
		l7 = new JLabel("Management System");

		i1 = new ImageIcon("abstract (1).png");

		l4.setBounds(40, 20, 100, 100);
		l5.setBounds(80, 200, 200, 150);
		l1.setBounds(50, 90, 300, 80);
		l2.setBounds(60, 180, 150, 40);
		l3.setBounds(60, 280, 150, 40);
		l6.setBounds(30, 30, 200, 100);
		l7.setBounds(30, 90, 250, 100);
		Font f1 = new Font("Harlow Solid Italic", Font.BOLD, 27);
		l6.setFont(f1);
		Font f8 = new Font("Harlow Solid Italic", Font.BOLD, 27);
		l7.setFont(f8);

		b1 = new JButton("Login");
		Font f5 = new Font("Elephant", Font.BOLD, 25);
		b1.setFont(f5);
		Color c2 = Color.decode("#DF5B89");
		b1.setBackground(c2);
		b1.setBounds(60, 400, 200, 40);
		t1 = new JTextField();
		t2 = new JPasswordField();
		t1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		t1.setBounds(60, 250, 200, 20);
		t2.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		t2.setBounds(60, 350, 200, 20);
		i2 = new ImageIcon("abstract (3).png");

		cb = new JCheckBox(new ImageIcon(getClass().getResource("/images/eye.png")));
		cb.setSelectedIcon(new ImageIcon(getClass().getResource("/images/eye1.png")));
		cb.setBounds(230, 330, 30, 25);

		p1.setLayout(null);
		p2.setLayout(null);
		l4.setIcon(i1);
		l5.setIcon(i2);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);

		// b1.setOpaque(false);
		// b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		p2.add(b1);
		p2.add(t1);
		p2.add(t2);
		// p2.add(cb);
		setSize(800, 800);
		setLayout(null);
		setVisible(true);
		setLocation(300, 0);
		b1.addActionListener(this);
		t1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					t2.requestFocus();

				}
			}
		});
		cb.addItemListener(this);

	}

	public void actionPerformed(ActionEvent ae) {

		String s = ae.getActionCommand();

		String s2 = t1.getText();
		String s3 = t2.getText();
		// if(s.equals("Login") && s2.equals("A") && s3.equals("u"))
		if (s.equals("Login") && s2.equals("admin") && s3.equals("admin")) {
			JOptionPane.showMessageDialog(this, "Login Successfully");
			MobWelcome mw = new MobWelcome();
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "Login Unsuccessfully");
		}

	}

	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == cb) {
			if (cb.isSelected()) {
				t2.setEchoChar((char) 0);
			} else {
				t2.setEchoChar('.');
			}
		}
	}

	public static void main(String args[]) {
		MobLogin ml = new MobLogin();

	}
}