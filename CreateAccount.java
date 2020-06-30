package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class CreateAccount extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2,a3,a4,a5;
JLabel l1,l2,l3,l4,l5;
JTextField t1,t2,t3,t4;
JButton b1,b2;
Choice ch;
Frame frm;

public CreateAccount()
{

l1=new JLabel("Enter User Id");
l2=new JLabel("Enter Password");
l3=new JLabel("Re-Enter Password");
l4=new JLabel("Select Security Question ");
l5=new JLabel("Answer");
ch=new Choice();


b1=new JButton("Save");
b2=new JButton("Close");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
frm=new Frame("Login");
}

public void setUpCreateAccount()
{
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,25);

l2.setBounds(70,150,130,25);
l3.setBounds(70,200,130,25);
l4.setBounds(70,250,150,25);
l5.setBounds(100,300,100,25);

t1.setBounds(250,100,200,25);
t2.setBounds(250,150,200,25);

t3.setBounds(250,200,200,25);
t4.setBounds(250,300,200,25);
b1.setBounds(80,350,130,30);
b2.setBounds(300,350,130,30);
ch.setBounds(240,250,150,25);
ch.addItem("What is your Name");
ch.addItem("Previous password");
ch.addItem("What is your E-mail");



b1.addActionListener(this);
b2.addActionListener(this);
frm.add(ch);
frm.add(l1);

frm.add(l2);

frm.add(l3);
frm.add(l4);

frm.add(l5);


frm.add(t1);

frm.add(t2);
frm.add(t3);

frm.add(t4);


frm.add(b1);

frm.add(b2);

frm.setVisible(true);

}
public void getData()
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=ch.getSelectedItem();
a5=t4.getText();

}

public void conn()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con = DriverManager.getConnection("jdbc:odbc:LMS");
}
catch(Exception ex)
{
System.out.println(ex);
}
}


public void putData()
{
try
{
pst = con.prepareStatement("insert into createacc values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"')");
pst.executeUpdate();
}
 
catch(SQLException se)
{
System.out.println(se);
}
}



public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
conn();
getData();
putData();

}
else if(ae.getSource()==b2)
{
frm.setVisible(false);
}



}

}