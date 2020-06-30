package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Email extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2;
Label l1,l2;
TextField t1,t2;

Button b1,b2;
Frame frm;
public Email()
{

l1=new Label("Enter  User   Name :");
l2=new Label("password :");


b1=new Button("Save");
b2=new Button("Close");
t1=new TextField();
t2=new TextField();


frm=new Frame("Email");
}

public void SetUpEmail()
{
frm.setLayout(null);
frm.setSize(1000,1000);
frm.setBackground(Color.ORANGE);


l1.setBounds(80,100,120,25);

l2.setBounds(80,150,100,25);

t1.setBounds(300,100,200,35);
t2.setBounds(300,150,200,35);

b1.setBounds(120,600,70,30);
b2.setBounds(280,600,70,30);

b1.addActionListener(this);
b2.addActionListener(this);
frm.add(l1);

frm.add(l2);


frm.add(t1);

frm.add(t2);
frm.add(b1);

frm.add(b2);

frm.setVisible(true);



}

public void getData()
{
a1=t1.getText();
a2=t2.getText();

}
public void conn()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con = DriverManager.getConnection("jdbc:odbc:DSNDEMO");
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
pst = con.prepareStatement("insert into Detail values('"+a1+"','"+a2+"')");
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