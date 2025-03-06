import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class mobinfo extends JFrame implements ActionListener {
	String data1[][] = new String[100][100];
	String data2[][] = new String[100][100];
	String data3[][] = new String[100][100];
	String data4[][] = new String[100][100];
	String data5[][] = new String[100][100];

	JButton b1, b2, b3, b4, b5, b6, b7;
	JPanel p1, p2;
	JScrollPane jsp;
	JTable jt;
	ResultSet rs;

	mobinfo() {
		setVisible(true);
		setSize(1500, 800);
		setLayout(null);

		p1 = new JPanel();
		p1.setLayout(null);
		Color c3 = Color.decode("#004225");
		p1.setBackground(c3);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(300, 0, 1200, 800);
		Color c2 = Color.decode("#66fcae");
		p2.setBackground(c2);
		add(p1);
		add(p2);

		b1 = new JButton("MOBILE INFO");
		Color c4 = Color.decode("#66fcae");
		b1.setBackground(c4);
		b1.setForeground(Color.black);
		java.awt.Font f1 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b1.setFont(f1);

		b2 = new JButton("SELL INFO");
		Color c5 = Color.decode("#66fcae");
		b2.setBackground(c5);
		b2.setForeground(Color.black);
		java.awt.Font f2 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b2.setFont(f2);

		ImageIcon i1 = new ImageIcon("back.png");
		b4 = new JButton();
		b4.setIcon(i1);

		b3 = new JButton("EMP INFO");
		Color c6 = Color.decode("#66fcae");
		b3.setBackground(c6);
		b3.setForeground(Color.black);
		java.awt.Font f3 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b3.setFont(f3);

		b5 = new JButton("PRINT");
		Color c7 = Color.decode("#004225");
		b5.setBackground(c7);
		b5.setForeground(Color.white);
		java.awt.Font f4 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b5.setFont(f4);

		b6 = new JButton("ATTENDANCE");
		Color c8 = Color.decode("#66fcae");
		b6.setBackground(c8);
		b6.setForeground(Color.black);
		java.awt.Font f5 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b6.setFont(f5);

		b7 = new JButton("REPAIR MOBILE");
		Color c9 = Color.decode("#66fcae");
		b7.setBackground(c8);
		b7.setForeground(Color.black);
		java.awt.Font f6 = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
		b7.setFont(f6);

		p1.setBounds(0, 0, 300, 800);

		b1.setBounds(50, 50, 200, 50);
		b2.setBounds(50, 150, 200, 50);
		b3.setBounds(50, 250, 200, 50);
		b4.setBounds(10, 10, 25, 25);
		b6.setBounds(50, 350, 200, 50);
		b7.setBounds(50, 450, 200, 50);
		b5.setBounds(400, 500, 200, 50);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		// p2.add(b5);
		p1.add(b6);
		p1.add(b7);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		// b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/sana", "root", "root");
			if (s.equals("MOBILE INFO")) {
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
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 1050, 400);
				p2.add(jp);
			} else if (s.equals("SELL INFO")) {
				String[] column2 = { "Prod_ID", "cust_nm", "cust_mob", "date", "Prod_nm", "comp_nm", "prod_price",
						"quantity", "warranty", "Total Amount" };
				PreparedStatement ps = co.prepareStatement("select * from sale");
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 9; j++) {
						data2[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data2, column2);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 1050, 400);
				p2.add(jp);
			} else if (s.equals("EMP INFO")) {
				String[] column = { "Emp_ID", " Emp_name", "Emp_mob", "Emp_addr", "Emp_sal", "Age", "Gender", "Date" };
				PreparedStatement ps = co.prepareStatement("select * from addemp2");
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 7; j++) {
						data2[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data2, column);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 1050, 400);
				p2.add(jp);
			} else if (s.equals("ATTENDANCE")) {
				String[] column4 = { "Emp_ID", " Emp_name", "Emp_mob", "Emp_addr", "Emp_sal", "Age", "Attendance",
						"Gender", "Date" };
				PreparedStatement ps = co.prepareStatement("select * from attendance");
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 8; j++) {
						data4[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data4, column4);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 1050, 400);
				p2.add(jp);
			} else if (s.equals("REPAIR MOBILE")) {
				String[] column5 = { "repairno", "custname", "phoneno", "dmodel", "sn", "prob", "price", "amount",
						"due", "status" };
				PreparedStatement ps = co.prepareStatement("select * from repair1");
				ResultSet rs = ps.executeQuery();
				int i = 0;
				while (rs.next()) {
					for (int j = 0; j <= 9; j++) {
						data5[i][j] = "" + rs.getString(j + 1);
					}
					i++;

				}
				jt = new JTable(data5, column5);
				JScrollPane jp = new JScrollPane(jt);
				jt.setShowVerticalLines(true);
				jp.setBounds(0, 0, 1050, 400);
				p2.add(jp);
			}

			co.close();

		} catch (Exception e) {
		}
		if (s.equals("PRINT")) {
			// String file="C:\java\Mobile shop management system\mobile_info.pdf";
			// PdfDdocument pd=new PdfDdocument(new PdfWriter(file));
			Document dc = new Document();
			PdfWriter.getInstance(dc, new FileOutputStream("pdfs/mobile_info.pdf"));
			dc.open();
			PdfPTable tb = new PdfPTable(8);
			PdfPCell tc;

			/*
			 * while(rs.next()){
			 * //int Prod_ID=Integer.parseInt(t1.getText());
			 * //tc=new PdfPCell(new Phrase(Prod_ID));
			 * //tb.addCell(tc);
			 * String Prod_nm=rs.getString("Product_Name");
			 * tc=new PdfPCell(new Phrase(Prod_nm));
			 * tb.addCell(tc);
			 * 
			 * }
			 * dc.add(tb);
			 * dc.close();
			 */

		}
		if (ae.getSource() == b4) {
			MobWelcome mw = new MobWelcome();
			dispose();
		}
	}

}