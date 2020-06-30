package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPsw extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2;
Label l1,l2,l3,l4,l5,l6;
TextField t1,t2;
Button b1,b2,b3;

Frame frm;

public ForgetPsw()
{

l1=new Label("Enter User Id");
l2=new Label("your Security que is");
l3=new Label("Give Answer");
l4=new Label("Your Password is ");
l5=new Label("");
l6=new Label("");


b1=new Button("OK");
b2=new Button("Retrive");
b3=new Button("close");
t1=new TextField();
t2=new TextField();
frm=new Frame("Forget Password");
}

public void setUpForgetPsw()
{
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,25);

l2.setBounds(70,150,130,25);
l3.setBounds(70,200,130,25);
l4.setBounds(70,250,150,25);
l5.setBounds(220,150,100,25);
l6.setBounds(225,250,100,25);

t1.setBounds(220,100,150,25);
t2.setBounds(220,200,150,25);

b1.setBounds(400,100,50,30);
b2.setBounds(400,200,50,30);
b3.setBounds(300,300,60,25);


b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

frm.add(l1);

frm.add(l2);

frm.add(l3);
frm.add(l4);

frm.add(l5);
frm.add(l6);

frm.add(t1);

frm.add(t2);
frm.add(b1);
frm.add(b2);
frm.add(b3);
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
rec=st.executeQuery("Select sq from createacc where userid='"+a1+"'");
if(rec.next())
{
l5.setText(rec.getString(1));
}
else
{
l5.setText("Invalid user Id");
}

}
catch(Exception ex)
{
System.out.println(ex);
}
}
public void searchData1()
{
try
{
st=con.createStatement();
rec=st.executeQuery("Select password from createacc where userid='"+a1+"' and ans='"+a2+"'");
if(rec.next())
{
l6.setText(rec.getString(1));
}
else
{
l6.setText("Invalid Answer");
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
conn();
getData();
searchData1();

}
else if(ae.getSource()==b3)
{
frm.setVisible(false);

}
}

}