package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SearchStu extends Frame implements ActionListener,ItemListener
{
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
TextField t2,t3,t4;
Button b1,b2;
Choice ch0,ch1,ch2,ch3,ch4,ch5,ch6;
Frame frm;
public SearchStu()
{

l1=new Label("Student Id:");
l2=new Label("Name:");
l3=new Label("Father's Name:");
l4=new Label("Address  :");
l5=new Label("Course");
l6=new Label("Branch");
l7=new Label("Semester");
l8=new Label("Session Start :");
l9=new Label("Session End :");
l10=new Label("Department :");
ch0=new Choice();
ch1=new Choice();
ch2=new Choice();
ch3=new Choice();
ch4=new Choice();
ch5=new Choice();
ch6=new Choice();

b1=new Button("Save");
b2=new Button("Close");

t2=new TextField();
t3=new TextField();
t4=new TextField();
frm=new Frame("Update STUDENT");
}

public void setUpSearchStu()
{
frm.setBackground(Color.YELLOW);
b2.setBackground(Color.GREEN);
b1.setBackground(Color.GREEN);
frm.setLayout(null);
frm.setSize(600,700);
l1.setBounds(70,100,100,25);

l2.setBounds(70,150,130,25);
l3.setBounds(70,200,130,25);
l4.setBounds(70,250,150,25);
l5.setBounds(70,300,60,25);
l6.setBounds(70,350,60,25);

l7.setBounds(70,400,100,25);
l8.setBounds(70,450,100,25);
l9.setBounds(70,500,100,25);
l10.setBounds(70,550,100,25);

ch0.setBounds(250,100,200,25);
t2.setBounds(250,150,200,25);

t3.setBounds(250,200,200,25);
t4.setBounds(250,250,200,25);
b1.setBounds(120,600,65,30);
b2.setBounds(300,600,65,30);
ch1.setBounds(250,300,80,25);
ch2.setBounds(250,350,80,25);
ch3.setBounds(250,400,80,25);
ch4.setBounds(250,450,80,25);
ch5.setBounds(250,500,80,25);
ch6.setBounds(250,550,80,25);


ch0.addItemListener(this);
ch1.addItem("B.tech");
ch1.addItem("M.tech");
ch1.addItem("BBA");
ch1.addItem("MBA");
ch1.addItem("PolyTecnic");
ch1.addItem("B.Sc agriculture");
ch1.addItem("Farming");


ch2.addItem("CSE");
ch2.addItem("ME");
ch2.addItem("CIVIL");
ch2.addItem("ECE");
ch2.addItem("EEE");
ch2.addItem("Aeronotics");
ch2.addItem("Planting");
ch2.addItem("Farm");
ch2.addItem("Growing");
ch2.addItem("TreeFarming");

ch3.addItem("Even");
ch3.addItem("Odd");

ch4.addItem("2010 AUG");
ch4.addItem("2011 AUG");
ch4.addItem("2014 AUG");
ch4.addItem("2015 AUG");
ch4.addItem("2016 AUG");
ch4.addItem("2017 AUG");
ch4.addItem("2018 AUG");

ch5.addItem("2011 june");
ch5.addItem("2012 june");
ch5.addItem("2013 june");
ch5.addItem("2014 june");
ch5.addItem("2015 june");
ch5.addItem("2016 june");
ch5.addItem("2017 june");
ch5.addItem("2018 june");
ch5.addItem("2019 june");
ch5.addItem("2020 june");



ch6.addItem("CSE department");
ch6.addItem("CIVIL department");
ch6.addItem("ME department");
ch6.addItem("ECE department");
ch6.addItem("EEE department");
ch6.addItem("Aeronotics department");

b2.addActionListener(this);
frm.add(ch1);
frm.add(ch2);
frm.add(ch3);
frm.add(ch4);
frm.add(ch5);
frm.add(ch6);
frm.add(l1);

frm.add(l2);

frm.add(l3);
frm.add(l4);

frm.add(l5);

frm.add(l6);

frm.add(l7);

frm.add(l8);
frm.add(l9);

frm.add(l10);



frm.add(ch0);

frm.add(t2);
frm.add(t3);

frm.add(t4);


frm.add(b1);

frm.add(b2);
conn();

addStudentId();
frm.setVisible(true);



}

public void getData()
{
a1=ch0.getSelectedItem();
a2=t2.getText();
a3=t3.getText();
a4=t4.getText();
a5=ch1.getSelectedItem();
a6=ch2.getSelectedItem();
a7=ch3.getSelectedItem();
a8=ch4.getSelectedItem();
a9=ch5.getSelectedItem();
a10=ch6.getSelectedItem();


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
public void addStudentId()
{
try
{

st=con.createStatement();

rec=st.executeQuery("Select * from newstudent");
while(rec.next())
{

ch0.addItem(rec.getString(1));

}
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void showStuRec()
{
try
{
st=con.createStatement();
String id=ch0.getSelectedItem();
rec=st.executeQuery("Select * from newstudent where studentid='"+id+"'");
if(rec.next())
{

t2.setText(rec.getString(2));
t3.setText(rec.getString(3));
t4.setText(rec.getString(4));

ch1.select(rec.getString(5));
ch2.select(rec.getString(6));
ch3.select(rec.getString(7));
ch4.select(rec.getString(8));
ch5.select(rec.getString(9));
ch6.select(rec.getString(10));

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
}
else if(ae.getSource()==b2)
{
frm.setVisible(false);

}
}
public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==ch0)
{
showStuRec();
}

}
}