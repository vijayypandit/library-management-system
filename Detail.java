package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Detail extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2,a3,a4,a5,a6,a7;
Label l1,l2,l3,l4,l5,l6,l7;
TextField t1,t2,t3,t4,t5,t6;
Choice ch;
Button b1,b2;
Frame frm;
public Detail()
{

l1=new Label("Enter  User   Name :");
l2=new Label("User Id :");
l3=new Label("PassWord :");
l4=new Label("Enter  Email :");
l5=new Label("Mobile No :");
l6=new Label("Address");
l7=new Label("Occupation :");

b1=new Button("Save");
b2=new Button("Close");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
ch=new Choice();

frm=new Frame("Detail");
}

public void SetUpDetail()
{
frm.setLayout(null);
frm.setSize(1000,1000);
frm.setBackground(Color.ORANGE);

b1.setBackground(Color.GREEN);
b2.setBackground(Color.GREEN);
l1.setBounds(80,100,120,25);

l2.setBounds(80,150,100,25);
l3.setBounds(80,200,120,25);
l4.setBounds(80,250,120,25);
l5.setBounds(80,300,120,25);
l6.setBounds(80,350,120,25);
l7.setBounds(80,400,120,25);
t1.setBounds(300,100,200,35);
t2.setBounds(300,150,200,35);
t3.setBounds(300,200,200,35);
t4.setBounds(300,250,200,35);
t5.setBounds(300,300,200,35);
t6.setBounds(300,350,200,35);
ch.setBounds(300,400,200,70);



b1.setBounds(120,600,70,30);
b2.setBounds(280,600,70,30);
ch.addItem("Student");
ch.addItem("Teacher");
ch.addItem("HOD");
ch.addItem("Director");
ch.addItem("Security");
ch.addItem("Programmer");
b1.addActionListener(this);
b2.addActionListener(this);
frm.add(l1);

frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(l7);

frm.add(t1);

frm.add(t2);
frm.add(t3);
frm.add(t4);
frm.add(t5);
frm.add(t6);
frm.add(ch);
frm.add(b1);

frm.add(b2);

frm.setVisible(true);



}

public void getData()
{
a1=t1.getText();
a2=t2.getText();
a3=t3.getText();
a4=t4.getText();
a5=t5.getText();
a6=t6.getText();
a7=ch.getSelectedItem();

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
pst = con.prepareStatement("insert into details values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"')");
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