package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddNewBook extends Frame implements ActionListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2,a3,a4,a5,a6,a7,a8,a9;
Label l1,l2,l3,l4,l5,l6,l7,l8;
TextField t1,t2,t3,t4,t5,t6,t7;
Button b1,b2;
Choice ch1;
Frame frm;



public AddNewBook()
{

l1=new Label("Book Number :");
l2=new Label("Title :");
l3=new Label("Author's Name:");
l4=new Label("Publication :");
l5=new Label("Edition  :");
l6=new Label("Number Of Pages :");
l7=new Label("Price Of Book :");
l8=new Label("Department  :");

ch1=new Choice();


b1=new Button("Save");
b2=new Button("Close");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
t7=new TextField();
frm=new Frame("ADD NEW BOOK");
}

public void setUpAddNewBook()
{
frm.setBackground(Color.ORANGE);
b2.setBackground(Color.YELLOW);
b1.setBackground(Color.YELLOW);
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,40);

l2.setBounds(70,150,130,40);
l3.setBounds(70,200,130,40);
l4.setBounds(70,250,150,40);
l5.setBounds(70,300,60,40);
l6.setBounds(70,350,130,40);

l7.setBounds(70,400,100,40);
l8.setBounds(70,450,100,50);

t1.setBounds(250,100,200,40);
t2.setBounds(250,150,200,40);

t3.setBounds(250,200,240,40);
t4.setBounds(250,250,250,35);
t5.setBounds(250,300,200,35);
t6.setBounds(250,350,200,40);
t7.setBounds(260,400,200,40);



b1.setBounds(120,600,80,30);
b2.setBounds(300,600,80,30);
ch1.setBounds(250,460,140,45);

b1.addActionListener(this);
b2.addActionListener(this);
ch1.addItem("B.TECH");
ch1.addItem("BBA");
ch1.addItem("M.TECH");
ch1.addItem("MBA");
ch1.addItem("POLYTECHNIC");
ch1.addItem("B.Sc Agriculture");

frm.add(ch1);
frm.add(l1);
frm.add(l2);
frm.add(l3);
frm.add(l4);
frm.add(l5);
frm.add(l6);
frm.add(l7);
frm.add(l8);

frm.add(t1);
frm.add(t2);
frm.add(t3);
frm.add(t4);
frm.add(t5);
frm.add(t6);
frm.add(t7);

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
a7=t7.getText();
a8=ch1.getSelectedItem();
a9="AVAIL";
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
pst = con.prepareStatement("insert into newbook values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"')");
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