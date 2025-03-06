import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.TitledBorder;
import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import javax.swing.table.DefaultTableModel;

public class repair_mobile extends JFrame implements ActionListener, TextListener {

    JPanel p1, p2, p3;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, ll;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    java.awt.TextField tf;
    JTextArea ta1;
    JButton b1, b2, b3;
    ImageIcon i1;
    JComboBox cb;
    JTable jt;
    Connection co;
    PreparedStatement ps;
    ResultSet rs;
    boolean flag = true;
    String data1[][] = new String[100][100];
    Statement st;
    String sts[] = { "Active", "Completed" };

    repair_mobile() {
        initComponent();
        tableData();
    }

    public void initComponent() {
        setVisible(true);
        setSize(1600, 1600);
        setLayout(null);

        getContentPane().setBackground(Color.pink);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 40, 500, 500);
        Color c1 = Color.decode("#F0F0F0");
        p1.setBackground(c1);
        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Repairing Mobile",
                TitledBorder.LEFT, TitledBorder.TOP));

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(600, 40, 500, 300);
        Color c2 = Color.decode("#F0F0F0");
        p2.setBackground(c2);
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Bill Information",
                TitledBorder.LEFT, TitledBorder.TOP));

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(600, 400, 700, 250);
        Color c3 = Color.decode("#F0F0F0");
        p3.setBackground(c3);

        cb = new JComboBox(sts);
        cb.setBounds(240, 250, 150, 20);

        l1 = new JLabel("Repair No");
        l2 = new JLabel("Customer Name");
        l3 = new JLabel("Customer Phone No");
        l4 = new JLabel("Device Model");
        l5 = new JLabel("Device S/N");
        l6 = new JLabel("Problem");
        l7 = new JLabel("Repair Price");
        l8 = new JLabel("Advance");
        l9 = new JLabel("Due");
        l10 = new JLabel("Status");

        b1 = new JButton("Print");
        b2 = new JButton("Clear");
        i1 = new ImageIcon(getClass().getResource("/images/cross.jpg"));
        b3 = new JButton();
        b3.setIcon(i1);
        b3.setBounds(1300, 10, 30, 30);
        add(b3);

        java.awt.Font f1 = new java.awt.Font("Georgia", java.awt.Font.BOLD, 15);
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);

        l1.setForeground(Color.blue);
        l2.setForeground(Color.blue);
        l3.setForeground(Color.blue);
        l4.setForeground(Color.blue);
        l5.setForeground(Color.blue);
        l6.setForeground(Color.blue);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        tf = new java.awt.TextField();
        ta1 = new JTextArea();

        l1.setBounds(30, 70, 150, 20);
        l2.setBounds(30, 130, 150, 20);
        l3.setBounds(30, 190, 200, 20);
        l4.setBounds(30, 250, 150, 20);
        l5.setBounds(30, 310, 150, 20);
        l6.setBounds(30, 370, 150, 20);

        l7.setBounds(30, 70, 150, 20);
        l8.setBounds(30, 130, 150, 20);
        l9.setBounds(30, 190, 200, 20);
        l10.setBounds(30, 250, 150, 20);

        t1.setBounds(240, 70, 150, 20);
        t2.setBounds(240, 130, 150, 20);
        t3.setBounds(240, 190, 150, 20);
        t4.setBounds(240, 250, 150, 20);
        t5.setBounds(240, 310, 150, 20);
        ta1.setBounds(240, 370, 200, 100);

        t6.setBounds(240, 70, 150, 20);
        tf.setBounds(240, 130, 150, 20);
        t7.setBounds(240, 190, 150, 20);

        b1.setBounds(100, 600, 100, 50);
        b2.setBounds(300, 600, 100, 50);

        add(p1);
        add(p2);
        add(p3);
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
        p1.add(ta1);
        p2.add(l7);
        p2.add(t6);
        p2.add(l8);
        p2.add(tf);
        p2.add(l9);
        p2.add(t7);
        p2.add(l10);
        p2.add(cb);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        tf.addTextListener(this);
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
                    ta1.requestFocus();
                }
            }
        });
        t6.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    tf.requestFocus();
                }
            }
        });
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    t7.requestFocus();
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
                if (e.getKeyChar() > '0' && e.getKeyChar() <= '9') {
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
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        ta1.addKeyListener(new KeyAdapter() {
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
        tf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        AutoId();
    }

    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();

        if (s.equals("Print")) {
            if (t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty() || t3.getText().trim().isEmpty()
                    || t4.getText().trim().isEmpty() || ta1.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter data!");
            } else {
                Frame f = new Frame();
                JDialog d = new JDialog(f, "", true);
                d.setLayout(null);
                d.getContentPane().setBackground(Color.white);
                d.setLocation(400, 0);

                ll = new JLabel(new ImageIcon(getClass().getResource("/images/unique1.jpg")));
                l11 = new JLabel(
                        "----------------------------------------------------------------------------------------------------------------------------------");
                l12 = new JLabel("Unique Mobile Shopee");
                l13 = new JLabel("Phone No.1234567892");
                l14 = new JLabel("Address.Dindives,udgaon ves,Miraj");
                l15 = new JLabel(
                        "----------------------------------------------------------------------------------------------------------------------------------");
                l16 = new JLabel("Repair No         :" + t1.getText());
                l17 = new JLabel("Model             :" + t4.getText());
                l18 = new JLabel("Device S/N        :" + t5.getText());
                l19 = new JLabel("Repair amount     :" + t6.getText());
                l20 = new JLabel("Pay               :" + tf.getText());
                l21 = new JLabel("Due               :" + t7.getText());
                l22 = new JLabel(
                        "----------------------------------------------------------------------------------------------------------------------------------");
                l23 = new JLabel("THANK YOU COME AGAIN");

                JButton b = new JButton("Generate PDF");
                b.setBounds(190, 590, 200, 50);

                ll.setBounds(180, 0, 200, 100);
                l11.setBounds(0, 70, 1000, 50);
                l12.setBounds(100, 100, 600, 50);
                l13.setBounds(100, 130, 600, 50);
                l14.setBounds(100, 160, 600, 50);
                l15.setBounds(0, 190, 1000, 50);
                l16.setBounds(50, 220, 300, 50);
                l17.setBounds(50, 250, 300, 50);
                l18.setBounds(50, 280, 300, 50);
                l19.setBounds(50, 310, 300, 50);
                l20.setBounds(50, 340, 300, 50);
                l21.setBounds(50, 370, 300, 50);
                l22.setBounds(0, 400, 1000, 50);
                l23.setBounds(200, 430, 300, 50);

                java.awt.Font f1 = new java.awt.Font("", java.awt.Font.BOLD, 15);
                l16.setFont(f1);
                l17.setFont(f1);
                l18.setFont(f1);
                l19.setFont(f1);
                l20.setFont(f1);
                l21.setFont(f1);
                l23.setFont(f1);

                java.awt.Font f2 = new java.awt.Font("", java.awt.Font.BOLD, 20);
                l12.setFont(f2);
                l13.setFont(f2);
                l14.setFont(f2);

                java.awt.Font f3 = new java.awt.Font("", java.awt.Font.BOLD, 30);
                l11.setFont(f3);
                l15.setFont(f3);
                l22.setFont(f3);

                b.setBackground(Color.black);
                b.setForeground(Color.white);

                d.add(ll);
                d.add(l11);
                d.add(l12);
                d.add(l13);
                d.add(l14);
                d.add(l15);
                d.add(l16);
                d.add(l17);
                d.add(l18);
                d.add(l19);
                d.add(l20);
                d.add(l21);
                d.add(l22);
                d.add(l23);
                d.add(b);
                b.addActionListener(this);

                d.setSize(600, 800);
                d.setVisible(true);
            }
        } else if (s.equals("Generate PDF")) {
            try {
                Document d = new Document();
                PdfWriter pd = PdfWriter.getInstance(d, new FileOutputStream("bbb.pdf"));
                d.open();

                String filename = "c:/java/Mobile shop management system/unique1.jpg";
                Image image = Image.getInstance(filename);
                image.setAbsolutePosition(250, 750);
                d.add(image);

                d.add(new Paragraph("\n\n\n" + l11.getText()));
                d.add(new Paragraph("                                             " + l12.getText()
                        + "                                                "));
                d.add(new Paragraph("                                             " + l13.getText()
                        + "                                                "));
                d.add(new Paragraph("                                             " + l14.getText()
                        + "                                                "));
                d.add(new Paragraph("" + l15.getText()));
                d.add(new Paragraph(" " + l16.getText()));
                d.add(new Paragraph(" " + l17.getText()));
                d.add(new Paragraph(" " + l18.getText()));
                d.add(new Paragraph(" " + l19.getText()));
                d.add(new Paragraph(" " + l20.getText()));
                d.add(new Paragraph(" " + l21.getText()));
                d.add(new Paragraph("" + l22.getText()));
                d.add(new Paragraph("                                                       " + l23.getText()
                        + "                                                                                                               "));

                d.close();
                pd.close();
                JOptionPane.showMessageDialog(this, "PDF saved");
            } catch (Exception e) {
                System.out.println(e);
            }

            Save();
        } else if (ae.getSource() == b3) {
            MobWelcome m1 = new MobWelcome();
            dispose();
        } else if (s.equals("Clear")) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            ta1.setText("");
            tf.setText("");
        }
    }

    public void textValueChanged(TextEvent te) {
        int a = Integer.parseInt(t6.getText());
        int b = Integer.parseInt(tf.getText());
        int c;
        c = a - b;
        t7.setText("" + c);
    }

    public void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void AutoId() {
        try {
            connection();
            Statement s = co.createStatement();
            ResultSet rs = s.executeQuery("select MAX(repairno)from repair1");
            rs.next();
            rs.getString("MAX(repairno)");
            if (rs.getString("MAX(repairno)") == null) {
                t1.setText("RE001");
            } else {
                long id = Long
                        .parseLong(rs.getString("MAX(repairno)").substring(2, rs.getString("MAX(repairno)").length()));
                id++;
                t1.setText("RE" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
        }
    }

    public void Save() {

        String repairno = t1.getText();
        String custname = t2.getText();
        String phone = t3.getText();
        String Model = t4.getText();
        int sn = Integer.parseInt(t5.getText());
        String problem = ta1.getText();

        int fee = Integer.parseInt(t6.getText());
        int pay = Integer.parseInt(tf.getText());
        int Due = Integer.parseInt(t7.getText());
        String status = cb.getSelectedItem().toString();

        connection();

        try {
            ps = co.prepareStatement(
                    "insert into repair1(repairno,custname,phoneno,dmodel,sn,prob,price,amount,due,status)value(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, repairno);
            ps.setString(2, custname);
            ps.setString(3, phone);
            ps.setString(4, Model);
            ps.setInt(5, sn);
            ps.setString(6, problem);
            ps.setInt(7, fee);
            ps.setInt(8, pay);
            ps.setInt(9, Due);
            ps.setString(10, status);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added...");

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            ta1.setText("");
            t6.setText("");
            tf.setText("");
            t7.setText("");
            cb.setSelectedIndex(-1);

            t2.requestFocus();
            AutoId();

        } catch (SQLException ex) {
        }

    }

    public void tableData() {
        connection();

        try {

            String[] column1 = { "repairno", "custname", "phoneno", "dmodel", "sn", "prob", "price", "amount", "due",
                    "status" };
            ps = co.prepareStatement("select * from repair1");
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
            jp.setBounds(0, 0, 700, 250);
            p3.add(jp);
        } catch (Exception e) {
        }

    }

}
