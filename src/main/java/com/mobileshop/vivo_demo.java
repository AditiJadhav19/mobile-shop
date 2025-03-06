import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class vivo_demo extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7;
	ImageIcon i1, i2, i3, i4, i5, i6, i7;
	JTextArea ta1, ta2, ta3, ta4, ta5, ta6;

	JButton b1;

	vivo_demo() {
		setVisible(true);
		setSize(1600, 1600);
		setLayout(null);
		getContentPane().setBackground(Color.pink);

		i1 = new ImageIcon(getClass().getResource("/images/vivo1.jpg"));

		i2 = new ImageIcon(getClass().getResource("/images/vivo2.jfif"));
		i3 = new ImageIcon(getClass().getResource("/images/vivo3.jpg"));
		i4 = new ImageIcon(getClass().getResource("/images/vivo4.jpg"));
		i5 = new ImageIcon(getClass().getResource("/images/vivo5.jpg"));
		i6 = new ImageIcon(getClass().getResource("/images/vivo6.jpg"));
		i7 = new ImageIcon(getClass().getResource("/images/cross.jpg"));

		// Label
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel("Vivo Brands");
		l1.setBounds(100, 80, 700, 250);
		l2.setBounds(500, 80, 700, 250);
		l3.setBounds(950, 80, 700, 250);
		l4.setBounds(100, 400, 700, 250);
		l5.setBounds(500, 400, 700, 250);
		l6.setBounds(950, 400, 700, 250);
		l7.setBounds(590, 0, 300, 70);

		Font f7 = new Font("Rockwell", Font.BOLD, 30);
		l7.setFont(f7);

		b1 = new JButton(i7);
		b1.setBounds(1300, 10, 30, 30);
		b1.setBackground(Color.pink);

		String val1 = "Vivo X60 Pro\n" + "Rs.49,,990.00 \n" + "Storage:256GB\n" + "RAM:12GB\n";
		ta1 = new JTextArea(val1, 4, 50);
		Font f1 = new Font("Calibri", Font.BOLD, 20);
		ta1.setFont(f1);
		ta1.setBackground(Color.pink);
		ta1.setBounds(330, 100, 150, 100);

		String val2 = "vivo X 50 Pro\n" + "Rs.18,999.00 \n" + "Storage:256GB\n" + "RAM:8GB\n";
		ta2 = new JTextArea(val2, 4, 50);
		Font f2 = new Font("Calibri", Font.BOLD, 20);
		ta2.setFont(f2);
		ta2.setBackground(Color.pink);
		ta2.setBounds(750, 100, 150, 100);

		String val3 = "Vivo V19\n" + "Rs.24,990.00 \n" + "Storage:128GB\n" + "RAM:8GB\n";
		ta3 = new JTextArea(val3, 4, 50);
		Font f3 = new Font("Calibri", Font.BOLD, 20);
		ta3.setFont(f3);
		ta3.setBackground(Color.pink);
		ta3.setBounds(1200, 100, 150, 100);

		String val4 = "Vivo V17 Pro\n" + "Rs.28,499.00 \n" + "Storage:128GB\n" + "RAM:8GB\n";
		ta4 = new JTextArea(val4, 4, 50);
		Font f4 = new Font("Calibri", Font.BOLD, 20);
		ta4.setFont(f4);
		ta4.setBackground(Color.pink);
		ta4.setBounds(330, 450, 150, 100);

		String val5 = "Vivo V21\n" + "Rs.29,990.00 \n" + "Storage:128GB\n" + "RAM:8GB\n";
		ta5 = new JTextArea(val5, 4, 50);
		Font f5 = new Font("Calibri", Font.BOLD, 20);
		ta5.setFont(f5);
		ta5.setBackground(Color.pink);
		ta5.setBounds(750, 450, 150, 100);

		String val6 = "Vivo Y33s\n" + "Rs.18,590.00 \n" + "Storage:128GB\n" + "RAM:8GB\n";
		ta6 = new JTextArea(val6, 4, 50);
		Font f6 = new Font("Calibri", Font.BOLD, 20);
		ta6.setFont(f6);
		ta6.setBackground(Color.pink);
		ta6.setBounds(1200, 450, 150, 100);

		l1.setIcon(i1);
		l2.setIcon(i2);
		l3.setIcon(i3);
		l4.setIcon(i4);
		l5.setIcon(i5);
		l6.setIcon(i6);
		add(b1);

		// Images

		// add(p1);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(ta1);
		add(ta2);
		add(ta3);
		add(ta4);
		add(ta5);
		add(ta6);
		// add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);

		b1.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			brands_demo b2 = new brands_demo();
			dispose();
		}
	}

}
