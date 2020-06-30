package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdatePwd extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2,a3,a4;
Label l1,l2,l3,l4;
TextField t1,t2,t3,t4;
Button b1,b2;

Frame frm;

public UpdatePwd()
{

l1=new Label("User Id");
l2=new Label("Current Password");
l3=new Label("New Password");
l4=new Label("Re-Enter password");



b1=new Button("Change");
b2=new Button("Close");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
frm=new Frame("Login");
}

public void setUpUpdatePwd()
{
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,25);

l2.setBounds(70,150,130,25);
l3.setBounds(70,200,130,25);
l4.setBounds(70,250,150,25);


t1.setBounds(250,100,200,25);
t2.setBounds(250,150,200,25);

t3.setBounds(250,200,200,25);
t4.setBounds(250,250,200,25);
b1.setBounds(120,350,50,30);
b2.setBounds(300,350,50,30);



b1.addActionListener(this);
b2.addActionListener(this);

frm.add(l1);

frm.add(l2);

frm.add(l3);
frm.add(l4);



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
a4=t4.getText();


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

public void updateData()
{
try
{

pst = con.prepareStatement("update createacc set password='"+a3+"',cpassword='"+a4+"' where userid='"+a1+"' and password='"+a2+"' and '"+a3+"'='"+a4+"'");
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
updateData();

}
else if(ae.getSource()==b2)
{
frm.setVisible(false);
}



}

}