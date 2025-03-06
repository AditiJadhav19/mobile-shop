import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.sql.*;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.*;
import java.time.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class attendance extends JFrame implements ActionListener
{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JPanel p1,p2,p3;
	ImageIcon i1;
	JRadioButton rb1,rb2,rb3,rb4;
	ButtonGroup bg1,bg2;
	ResultSet rs;
	boolean flag=true;
	Connection co;
	PreparedStatement ps;
	Statement st;
	String atd;
	int a;
	String s6;
	String gender;
	JTable jt;
	String data4[][]=new String[100][100];
	String data5[][]=new String[100][100];

    attendance()
    {
		initComponent();
	}
	public void initComponent()
	{

		try
        {
            Class.forName("com.mysql.jdbc.Driver");
			co=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db","root","root");
			st=co.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
        }
        catch(SQLException ex)
        {
            System.out.println("Exception: "+ex);
        }
		catch(ClassNotFoundException ex)
        {
            System.out.println("Exception: "+ex);
        }

        setVisible(true); 
		setSize(1400,750);
		setLayout(null);


       	p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();

		getContentPane().setBackground(Color.pink);

        l1=new JLabel("Employee ID");
		l2=new JLabel("Employee Name");
		l3=new JLabel("Employee MNo.");
		l4=new JLabel("Employee Address");
		l5=new JLabel("Employee Salary");
		l6=new JLabel("Attendance");
		l7=new JLabel("Age");
		l8=new JLabel("Gender");
		l9=new JLabel("Date");
		
		rb1=new JRadioButton("Present");
		rb2=new JRadioButton("Absent");
		rb3=new JRadioButton("Male");
		rb4=new JRadioButton("Female");

        l1.setForeground(Color.blue);
		l2.setForeground(Color.blue);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.blue);
		l6.setForeground(Color.blue);
		l7.setForeground(Color.blue);
		l8.setForeground(Color.blue);
		l9.setForeground(Color.blue);

        Font f1=new Font("Georgia",Font.BOLD,15);
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		l9.setFont(f1);


		LocalDate date=LocalDate.now();
		
        t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t8=new JTextField();
		t9=new JTextField();

		t8.setText(""+date);

        b1=new JButton("INSERT");
		b2=new JButton("UPDATE");
		b3=new JButton("DELETE");
		b4=new JButton("CLEAR");
		b6=new JButton("Check Records");
		b7=new JButton("SEARCH");
		b8=new JButton("ATTENDANCE");
		b9=new JButton("Search");
		bg1=new ButtonGroup();
		bg2=new ButtonGroup();
		

        b5=new JButton();
		i1=new ImageIcon("cross.jpg");
		b5.setIcon(i1);
		b5.setBounds(1300,10,30,30);
		add(b5);

        Font f2=new Font("Arial",Font.BOLD,15);
		b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b6.setFont(f2);
		b7.setFont(f2);
		b8.setFont(f2);
		b9.setFont(f2);
		rb1.setFont(f2);
		rb2.setFont(f2);
		rb3.setFont(f2);
		rb4.setFont(f2);
		
		

        b1.setForeground(Color.black);
        b2.setForeground(Color.black);
        b3.setForeground(Color.black);
        b4.setForeground(Color.black);
        b6.setForeground(Color.black);
		b7.setForeground(Color.black);
		b8.setForeground(Color.black);
		b9.setForeground(Color.black);

		rb1.setForeground(Color.black);
		rb2.setForeground(Color.black);
		rb3.setForeground(Color.black);
		rb4.setForeground(Color.black);

		b1.setBackground(Color.pink);
		b2.setBackground(Color.pink);
		b3.setBackground(Color.pink);
		b4.setBackground(Color.pink);
		b6.setBackground(Color.pink);
		b7.setBackground(Color.pink);
		b8.setBackground(Color.pink);
		b9.setBackground(Color.pink);
		rb1.setBackground(Color.white);
		rb2.setBackground(Color.white);
		rb3.setBackground(Color.white);
		rb4.setBackground(Color.white);

        l1.setBounds(30,70,150,20);
		l2.setBounds(30,130,150,20);
		l3.setBounds(30,190,150,20);
		l4.setBounds(30,250,150,20);
		l5.setBounds(30,310,150,20);
		l6.setBounds(400,130,150,20);
		l7.setBounds(400,70,150,20);
		l8.setBounds(400,210,150,20);

        t1.setBounds(180,70,150,20);
		t2.setBounds(180,130,150,20);
		t3.setBounds(180,190,150,20);
		t4.setBounds(180,250,150,20);
		t5.setBounds(180,310,150,20);
		t6.setBounds(460,70,150,20);
		rb1.setBounds(510,130,100,20);
		rb2.setBounds(510,160,100,20);
		rb3.setBounds(510,210,100,20);
		rb4.setBounds(510,240,100,20);
		l9.setBounds(400,290,150,20);
		t8.setBounds(510,290,150,20);
		t9.setBounds(800,400,150,20);

        b1.setBounds(230,370,100,40);
		b2.setBounds(380,370,100,40);
		b3.setBounds(230,430,100,40);
		b4.setBounds(380,430,100,40);
		b6.setBounds(220,250,150,40);
		b7.setBounds(520,370,100,40);
		b8.setBounds(520,430,100,40);
		b9.setBounds(1000,390,100,40);

		/*try{

			if(flag)
			{
				rs=st.executeQuery("Select * from attendance");
				flag=false;
			}
			rs.last();
			t1.setText(rs.getInt("Emp_ID")+1+"");
		}
		catch(SQLException ex){
			System.out.println("Exception "+ex);
		}*/


        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Attendance Here", TitledBorder.LEFT, TitledBorder.TOP));
		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.LEFT, TitledBorder.TOP));

        p1.setBounds(10,50,700,500);	
		p2.setBounds(730,56,600,300);
		p3.setBounds(730,450,600,200);

        p1.setBackground(Color.white);
		p2.setBackground(Color.gray);
		p3.setBackground(Color.gray);

        add(p1);
		add(p2);
		//add(p3);
		p1.setLayout(null);
		p2.setLayout(null);
		p1.add(l1);p1.add(t1);p1.add(l2);p1.add(t2);p1.add(l3);p1.add(t3);
		p1.add(l4);p1.add(t4);p1.add(l5);p1.add(t5);p1.add(l7);p1.add(t6);
		p1.add(l6);
		p1.add(l8);
		bg1.add(rb1);bg1.add(rb2);
		bg2.add(rb3);bg2.add(rb4);
		p1.add(rb1);p1.add(rb2);
		p1.add(rb3);p1.add(rb4);
		p1.add(l9);p1.add(t8);

        p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
        p2.add(b6);
		p1.add(b7);
		p1.add(b8);


		//add(t9);
		//add(b9);
		

     	b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		t1.addKeyListener(new KeyAdapter()
		{
			 public void keyPressed(KeyEvent e) 
			 {
    			
       			if(e.getKeyChar()==KeyEvent.VK_ENTER) 
			   	{
        			t2.requestFocus();
					
				}
			 }
		});
		t2.addKeyListener(new KeyAdapter()
		{
			 public void keyPressed(KeyEvent e) 
			 {
    			
       			if(e.getKeyChar()==KeyEvent.VK_ENTER) 
			   	{
        			t3.requestFocus();
					
				}
			 }
		});
		t3.addKeyListener(new KeyAdapter()
		{
			 public void keyPressed(KeyEvent e) 
			 {
    			
       			if(e.getKeyChar()==KeyEvent.VK_ENTER) 
			   	{
        			t4.requestFocus();
					
				}
			 }
		});
		t4.addKeyListener(new KeyAdapter()
		{
			 public void keyPressed(KeyEvent e) 
			 {
    			
       			if(e.getKeyChar()==KeyEvent.VK_ENTER) 
			   	{
        			t5.requestFocus();
					
				}
			 }
		});
		t5.addKeyListener(new KeyAdapter()
		{
			 public void keyPressed(KeyEvent e) 
			 {
    			
       			if(e.getKeyChar()==KeyEvent.VK_ENTER) 
			   	{
        			t6.requestFocus();
					
				}
			 }
		});
		t1.addKeyListener(new KeyAdapter()
		{
			 public void keyTyped(KeyEvent e) 
			 {
    			char c = e.getKeyChar();
       			if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) 
			   	{
        			e.consume();
				}
			 }
		});
		t2.addKeyListener(new KeyAdapter()
		{
			 public void keyTyped(KeyEvent e) 
			 {
    			char c = e.getKeyChar();
       			if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE )) 
			   	{
        			e.consume();
				}
			 }
		});
		t3.addKeyListener(new KeyAdapter()
        {
			 public void keyPressed(KeyEvent e) 
			 {
                 String phoneNo=t3.getText();
                 int length=phoneNo.length();
    			char c = e.getKeyChar();
       			if(e.getKeyChar()>'0' && e.getKeyChar()<='9' || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) 
			   	{
        			if(length<10)
                    {
                        t3.setEditable(true);
                    }
                    else
                    {
                         t3.setEditable(false);
                    }
                }
			}
			 
		});
		t4.addKeyListener(new KeyAdapter()
		{
			 public void keyTyped(KeyEvent e) 
			 {
    			char c = e.getKeyChar();
       			if(!(Character.isAlphabetic(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_SPACE )) 
			   	{
        			e.consume();
				}
			 }
		});
		t5.addKeyListener(new KeyAdapter()
		{
			 public void keyTyped(KeyEvent e) 
			 {
    			char c = e.getKeyChar();
       			if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) 
			   	{
        			e.consume();
				}
			 }
		});
		t6.addKeyListener(new KeyAdapter()
		{
			 public void keyTyped(KeyEvent e) 
			 {
    			char c = e.getKeyChar();
       			if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE )) 
			   	{
        			e.consume();
				}
			 }
		});


    }
	public void actionPerformed(ActionEvent ae)
	{
		
		if(rb1.isSelected())
		{
			atd="Present";

		}
		else if(rb2.isSelected()){

			atd="Absent";
		}
		if(rb3.isSelected())
		{
			gender="Male";
		}
		else if(rb4.isSelected())
		{
			gender="Female";
		}
		String s=ae.getActionCommand();
		
		if(s.equals("INSERT"))
		{
		if(t2.getText().trim().isEmpty()|| t3.getText().trim().isEmpty()||t4.getText().trim().isEmpty()||t8.getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please enter data!");
		}
		else{
		
			
			try
			{
				a=Integer.parseInt(t1.getText());
				String s1=t2.getText();
				String s2=t3.getText();
				String s3=t4.getText();
				int b=Integer.parseInt(t5.getText());
				int c=Integer.parseInt(t6.getText());
				String s4=atd;
				String s5=gender;
				String s6=t8.getText();

				ps=co.prepareStatement("insert into attendance value(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1,a);
				ps.setString(2,s1);
				ps.setString(3,s2);
				ps.setString(4,s3);
				ps.setInt(5,b);
				ps.setInt(6,c);
				ps.setString(7,s4);
				ps.setString(8,s5);
				ps.setString(9,s6);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,"Data inserted succesfully");
				//System.out.println("Data inserted succesfully");
				//co.close();
			}
			catch(Exception e){}
		}
		}
		else if(s.equals("UPDATE"))
		{
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile-shop-management-db","root","root");

				int a=Integer.parseInt(t1.getText());
				String s1=t2.getText();
				String s2=t3.getText();
				String s3=t4.getText();
				int b=Integer.parseInt(t5.getText());
				int c=Integer.parseInt(t6.getText());
				String s4=atd;
				String s5=gender;
				String s6=t8.getText();

				ps=co.prepareStatement("update attendance set Emp_name=?,Emp_mob=?,Emp_addr=?,Emp_sal=?,Age=?,Attendance=?,Gender=?,Date=? where Emp_ID="+a);

				
				ps.setString(1,s1);
				ps.setString(2,s2);
				ps.setString(3,s3);
				ps.setInt(4,b);
				ps.setInt(5,c);
				ps.setString(6,s4);
				ps.setString(7,s5);
				ps.setString(8,s6);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,"Data updated succesfully");
			}
			catch(Exception e){}
		}
		else if(s.equals("DELETE"))
		{
			try
			{
			int a=Integer.parseInt(t1.getText());
			ps=co.prepareStatement("delete from attendance where Emp_ID="+a);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this,"Data deleted succesfully");
			}
			catch(Exception e){}
		}
		else if(s.equals("SEARCH"))
		{
             
            try
			{
          
             PreparedStatement ps=co.prepareStatement("select Emp_name,Emp_mob,Emp_addr,Emp_sal,Age,Attendance,Gender,Date from attendance where Emp_ID=?");
			
			
			      
               a=Integer.parseInt(t1.getText());  
                ps.setInt(1,a);

				/*s1=t2.getText();
				 ps.setString(2,s1);*/
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
			{
				JOptionPane.showMessageDialog(this,"record not found");
				t1.requestFocus();
			}
			else
			{ 
			t2.setText(rs.getString("Emp_name"));
			t3.setText(rs.getString("Emp_mob"));
			t4.setText(rs.getString("Emp_addr"));
			t5.setText(rs.getString("Emp_sal"));
			t6.setText(rs.getString("Age"));
			t8.setText(rs.getString("Date"));

			if(null!=rs.getString("Attendance"))switch(rs.getString("Attendance"))
			{
					case "Present":
							rb1.setSelected(true);
							break;
					case "Absent":
							rb2.setSelected(true);
							break;
					default:
							rb1.setSelected(false);
							rb2.setSelected(false);
			}
			else
			{
				rb1.setSelected(false);
				rb2.setSelected(false);
			}
			
			if(null!=rs.getString("Gender"))switch(rs.getString("Gender"))
			{
					case "Male":
							rb3.setSelected(true);
							break;
					case "Female":
							rb4.setSelected(true);
							break;
					default:
							rb3.setSelected(false);
							rb4.setSelected(false);
			}
			else
			{
				rb3.setSelected(false);
				rb4.setSelected(false);
			}
			
			}
			}
			
			catch( SQLException ex)
			{
				System.out.println("Exception: "+ex);
			}
			catch( NullPointerException ex)
			{
				System.out.println("Exception: "+ex);
			}
        }
		else if(s.equals("ATTENDANCE"))
		{
             
            try
			{
          
             PreparedStatement ps=co.prepareStatement("select Emp_name,Emp_mob,Emp_addr,Emp_sal,Age,Gender from addemp2 where Emp_ID=?");
			
			
			      
               a=Integer.parseInt(t1.getText());  
                ps.setInt(1,a);

				/*s1=t2.getText();
				 ps.setString(2,s1);*/
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
			{
				JOptionPane.showMessageDialog(this,"record not found");
				t1.requestFocus();
			}
			else
			{ 
			t2.setText(rs.getString("Emp_name"));
			t3.setText(rs.getString("Emp_mob"));
			t4.setText(rs.getString("Emp_addr"));
			t5.setText(rs.getString("Emp_sal"));
			t6.setText(rs.getString("Age"));


			
			if(null!=rs.getString("Gender"))switch(rs.getString("Gender"))
			{
					case "Male":
							rb3.setSelected(true);
							break;
					case "Female":
							rb4.setSelected(true);
							break;
					default:
							rb3.setSelected(false);
							rb4.setSelected(false);
			}
			else
			{
				rb3.setSelected(false);
				rb4.setSelected(false);
			}
			/*if(null!=rs.getString("Attendance"))switch(rs.getString("Attendance"))
			{
					case "Present":
							rb1.setSelected(true);
							break;
					case "Absent":
							rb2.setSelected(true);
							break;
					default:
							rb1.setSelected(false);
							rb2.setSelected(false);
			}
			else
			{
				rb1.setSelected(false);
				rb2.setSelected(false);
			}*/
			}
			}
			
			catch( SQLException ex)
			{
				System.out.println("Exception: "+ex);
			}
			catch( NullPointerException ex)
			{
				System.out.println("Exception: "+ex);
			}
        }
		/*else if(s.equals("Search"))
		{
           try
			{
							String [] column5={"Emp_ID"," Emp_name","Emp_mob","Emp_addr","Emp_sal","Age","Attendance","Gender","Date"};
							 ps=co.prepareStatement("select * from attendance where Date=?");
							 s6=t8.getText();
				 			 ps.setString(1,s6);
							 rs=ps.executeQuery();

							
							 //jt.setModel(DbUtils.resultSetToTableModel)
							int i=0;
							if(rs.next()==false)
							{
								JOptionPane.showMessageDialog(this,"record not found");
								t8.requestFocus();
							}
						else
						{ 
							while(rs.next())
							{
									for(int j=0;j<=8;j++)
									{
										if(s6.equals(rs.getString("Date")))
										{
												data5[i][j]=""+rs.getString("Date");
												System.out.println(s6);
										}
										
									}
									i++;
									
							}
							jt=new JTable(data5,column5);
							JScrollPane jp=new JScrollPane(jt);
							jt.setShowVerticalLines(true);
							jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							jt.setShowHorizontalLines(true);
							jp.setBounds(0,0,600,150);
							p3.add(jp);
							//JOptionPane.showMessageDialog(this,"data inserted");
						}
			}
			//catch(Exception e){}
			
			catch( SQLException ex)
			{
				System.out.println("Exception: "+ex);
			}
			catch( NullPointerException ex)
			{
				System.out.println("Exception: "+ex);
			}
        }*/
		else if(s.equals("Check Records"))
		{
			try
			{
				String [] column4={"Emp_ID"," Emp_name","Emp_mob","Emp_addr","Emp_sal","Age","Attendance","Gender","Date"};
							PreparedStatement ps=co.prepareStatement("select * from attendance");
							ResultSet rs=ps.executeQuery();
							int i=0;
							while(rs.next())
							{
									for(int j=0;j<=8;j++)
									{
										data4[i][j]=""+rs.getString(j+1);
									}
									i++;
									
							}
							jt=new JTable(data4,column4);
							JScrollPane jp=new JScrollPane(jt);
							jt.setShowVerticalLines(true);
							jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							jt.setShowHorizontalLines(true);
							jp.setBounds(0,0,600,180);
							p2.add(jp);
			}
			catch(Exception e){}
		}
		else if(s.equals("CLEAR"))
		{
		 	t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			rb4.setSelected(false);

		}
		else if(ae.getSource()==b5)
		{
			MobWelcome mb=new MobWelcome();
			dispose();
		}
	}

}