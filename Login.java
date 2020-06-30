package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2;
Label l1,l2,l3;
TextField t1,t2;
Button b1,b2,b3,b4;
Frame frm;
public Login()
{

l1=new Label("Enter User Id");
l2=new Label("Enter Password");
l3=new Label("Error");

b1=new Button("Login");
b2=new Button("Exit");

b3=new Button("Change Password");
b4=new Button("Forget Password");
t1=new TextField();
t2=new TextField();
frm=new Frame("Login Form");
}

public void setUpLogin()
{
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,25);

l2.setBounds(70,140,100,25);
l3.setBounds(170,50,150,25);
t1.setBounds(220,100,100,25);
t2.setBounds(220,140,100,25);
b1.setBounds(355,97,50,30);
b2.setBounds(355,140,50,30);
b3.setBounds(70,200,110,30);
b4.setBounds(235,200,100,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
frm.add(l1);

frm.add(l2);

frm.add(l3);

frm.add(t1);

frm.add(t2);

frm.add(b1);
frm.add(b2);
frm.add(b3);
frm.add(b4);
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
con = DriverManager.getConnection("jdbc:odbc:LMS");
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void searchData()
{
try
{
st=con.createStatement();
rec=st.executeQuery("Select * from createacc where userid='"+a1+"' and password='"+a2+"'");
if(rec.next())
{
frm.setVisible(false);
AfterLogin obj=new AfterLogin();
obj.setUpAfterLogin();
}
else
{
l3.setText("Invalid Id or password");
}
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
conn();
getData();
searchData();

}
else if(ae.getSource()==b2)
{
System.exit(0);
}

else if(ae.getSource()==b3)
{
UpdatePwd obb=new UpdatePwd();
obb.setUpUpdatePwd();
}

else if(ae.getSource()==b4)
{
ForgetPsw op=new ForgetPsw();
op.setUpForgetPsw();
}

}



}