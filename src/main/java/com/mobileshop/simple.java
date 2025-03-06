import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class simple extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1;
    public simple()
    {
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        l1=new JLabel("Enter Name");
        l2=new JLabel("Enter phone");
        t1=new JTextField();
        t2=new JTextField();
        b1=new JButton("Add");
        l1.setBounds(30,30,100,50);
        t1.setBounds(30,60,50,50);
        l2.setBounds(30,90,100,50);
        t2.setBounds(30,120,100,50);
        b1.setBounds(30,150,100,50);



        add(l1);add(t1);
        add(l2);add(t2);
        add(b1);
        b1.addActionListener(this);
       

    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        String s1=t1.getText();
        String s2=t2.getText();
        if(s.equals("Add") || s1.equals("") || s2.equals(""))
        {
            JOptionPane.showMessageDialog(this,"added");
        }
    }
    public static void main(String args[])
    {
        simple s=new simple();
    }
}