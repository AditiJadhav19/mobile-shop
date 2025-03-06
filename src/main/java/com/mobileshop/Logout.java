import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.TitledBorder;

public class Logout extends JFrame implements ActionListener {
    ImageIcon i1, i 2;
    JLabel l1, l2, l3, l4;
    JPanel p1;

    JButton b1, b2;

    Logout()
    {
        setVisible(true);
        setLayout(null);
        setSize(500,600);
        setLocation(400,0); 

		i1 = new ImageIcon(getClass().getResource("/images/images.jpg"));
        
        Image img=i1.getImage();
        Image temp_img=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
        i1=new ImageIcon(temp_img);
        l1=new JLabel("",i1,JLabel.CENTER);
        l1.setBounds(0,0,500,600);

        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,0,40));
        p1.setBounds(70,70,350,400);

        i2=new ImageIcon("user.png");
        l2=new JLabel("",i2,JLabel.CENTER);
        l2.setBounds(130,0,100,100);

        l3=new JLabel("Oh no!You're leaving...");
        l4=new JLabel("Are you sure?");

        l3.setBounds(50,100,300,100);
        l4.setBounds(100,140,300,100);
        Font f1=new Font("Verdana",Font.BOLD,20);
        l3.setForeground(Color.white);
        l4.setForeground(Color.white);
        l3.setFont(f1);
        l4.setFont(f1);

        b1=new JButton("Yes,Log me out");
        b2=new JButton("Cancel");

        b1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,16));
        b2.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,16));
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        Color c1=Color.decode("#29C5F6");
		b1.setBackground(c1);
        b2.setBackground(c1);
        b1.setBounds(20,250,300,30);
        b2.setBounds(20,300,300,30);

        p1.add(l2);
        p1.add(l3);
        p1.add(b1);
        p1.add(b2);
        p1.add(l4);
        l1.add(p1);

        add(l1);
     

    .

     }

    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("Yes,Log me out")) {
            MobLogin ml = new MobLogin();
            dispose();
        } else if (s.equals("Cancel")) {
            MobWelcome mw = new MobWelcome();
            dispose();
        }
    }
}