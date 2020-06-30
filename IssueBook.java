package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class IssueBook extends Frame implements ActionListener,ItemListener
{
Connection con;
PreparedStatement pst;
Statement st;
String a;
String status="AVAIL";
String sti="ISSUE";
ResultSet rec;
int i;
String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
Button b1,b2;
Choice ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8;
Frame frm;
public IssueBook()
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

l11=new Label("Book Number :");
l12=new Label("Title :");
l13=new Label("Author's Name:");
l14=new Label("Publication :");
l15=new Label("Edition  :");
l16=new Label("Number Of Pages :");
l17=new Label("Price Of Book :");
l18=new Label("Department  :");

l19=new Label("Current Date :");
l20=new Label("Return Date :");
ch1=new Choice();
ch2=new Choice();
ch3=new Choice();
ch4=new Choice();
ch5=new Choice();
ch6=new Choice();

ch7=new Choice();
ch8=new Choice();



b1=new Button("Save");
b2=new Button("Close");
t1=new TextField();
t2=new TextField();
t3=new TextField();
t4=new TextField();
t5=new TextField();
t6=new TextField();
t7=new TextField();
t8=new TextField();
t9=new TextField();
t10=new TextField();
t11=new TextField();
t12=new TextField();
t13=new TextField();
t14=new TextField();
t15=new TextField();
t16=new TextField();
frm=new Frame("Issue Books");
}

public void setUpIssueBook()
{
frm.setBackground(Color.ORANGE);
b2.setBackground(Color.RED);
b1.setBackground(Color.RED);
frm.setLayout(null);
frm.setSize(3000,800);
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
t1.setBounds(250,150,200,25);
t2.setBounds(250,200,150,35);
t3.setBounds(250,250,150,35);
t4.setBounds(250,300,150,35);
t5.setBounds(250,350,150,35);
t6.setBounds(250,400,150,35);
t7.setBounds(250,450,150,35);
t8.setBounds(250,500,150,35);
t9.setBounds(250,550,150,35);
ch1.setBounds(250,100,200,25);



l11.setBounds(600,100,100,40);
l12.setBounds(600,150,130,40);
l13.setBounds(600,200,130,40);
l14.setBounds(600,250,150,40);
l15.setBounds(600,300,60,40);
l16.setBounds(600,350,130,40);
l17.setBounds(600,400,100,40);
l18.setBounds(600,450,100,50);
l19.setBounds(600,500,100,40);
l20.setBounds(600,550,100,50);



t10.setBounds(800,150,200,25);
t11.setBounds(800,200,200,40);
t12.setBounds(800,250,240,40);
t13.setBounds(800,300,250,35);
t14.setBounds(800,350,200,35);
t15.setBounds(800,400,200,40);
t16.setBounds(800,450,200,40);

ch2.setBounds(800,100,200,40);

ch3.setBounds(800,510,40,25);
ch4.setBounds(840,510,40,25);
ch5.setBounds(880,510,60,25);
ch6.setBounds(800,560,40,25);
ch7.setBounds(840,560,40,25);
ch8.setBounds(880,560,60,25);

b1.setBounds(120,630,85,30);
b2.setBounds(300,630,85,30);

for(i=0;i<=31;i++)
{
ch3.addItem(""+i);
ch6.addItem(""+i);
}

for(i=0;i<=12;i++)
{
ch4.addItem(""+i);
ch7.addItem(""+i);
}

for(i=2017;i<=2029;i++)
{
ch5.addItem(""+i);
ch8.addItem(""+i);
}


ch1.addItemListener(this);

ch2.addItemListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
frm.add(ch1);
frm.add(ch2);
frm.add(ch3);
frm.add(ch4);
frm.add(ch5);
frm.add(ch6);
frm.add(ch7);
frm.add(ch8);
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

frm.add(l11);
frm.add(l12);

frm.add(l13);

frm.add(l14);

frm.add(l15);

frm.add(l16);
frm.add(l17);

frm.add(l18);
frm.add(l19);

frm.add(l20);



frm.add(t1);

frm.add(t2);
frm.add(t3);

frm.add(t4);
frm.add(t5);

frm.add(t6);
frm.add(t7);

frm.add(t8);

frm.add(t9);
frm.add(t10);
frm.add(t11);
frm.add(t12);
frm.add(t13);
frm.add(t14);
frm.add(t15);
frm.add(t16);



frm.add(b1);

frm.add(b2);

conn();
addStudentId();
addbookno();


frm.setVisible(true);

}

public void getData()
{
a1=ch1.getSelectedItem();
a2=t1.getText();
a3=t2.getText();
a4=t3.getText();
a5=t4.getText();
a6=t5.getText();
a7=t6.getText();
a8=t7.getText();
a9=t8.getText();
a10=t9.getText();
a11=ch2.getSelectedItem();
a12=t10.getText();
a13=t11.getText();
a14=t12.getText();
a15=t13.getText();
a16=t14.getText();
a17=t15.getText();
a18=t16.getText();
a19=ch3.getSelectedItem();
a20=ch4.getSelectedItem();
a21=ch5.getSelectedItem();
a22=ch6.getSelectedItem();
a23=ch7.getSelectedItem();
a24=ch8.getSelectedItem();
a="ISSUE";
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

ch1.addItem(rec.getString(1));

}
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void addbookno()
{
try
{
st=con.createStatement();

rec=st.executeQuery("Select * from newbook where status='"+status+"'");
while(rec.next())
{
ch2.addItem(rec.getString(1));
}
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void showRec()
{
try
{
st=con.createStatement();
String id=ch1.getSelectedItem();
rec=st.executeQuery("Select * from newstudent where studentid='"+id+"'");
if(rec.next())
{
t1.setText(rec.getString(2));
t2.setText(rec.getString(3));
t3.setText(rec.getString(4));
t4.setText(rec.getString(5));
t5.setText(rec.getString(6));
t6.setText(rec.getString(7));
t7.setText(rec.getString(8));
t8.setText(rec.getString(9));
t9.setText(rec.getString(10));
}
}
catch(Exception ex)
{
System.out.println(ex);
}
}

public void showBookRec()
{
try
{
st=con.createStatement();
String number=ch2.getSelectedItem();
rec=st.executeQuery("Select * from newbook where booknumber='"+number+"'");
if(rec.next())
{
t10.setText(rec.getString(2));
t11.setText(rec.getString(3));
t12.setText(rec.getString(4));
t13.setText(rec.getString(5));
t14.setText(rec.getString(6));
t15.setText(rec.getString(7));
t16.setText(rec.getString(8));

}
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
pst = con.prepareStatement("insert into issuebook values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"','"+a14+"','"+a15+"','"+a16+"','"+a17+"','"+a18+"','"+a19+"','"+a20+"','"+a21+"','"+a22+"','"+a23+"','"+a24+"','"+a+"')");
pst.executeUpdate();
}
 
catch(SQLException se)
{
System.out.println(se);
}
}
public void updateData()
{
try
{
String bookid=ch2.getSelectedItem();
pst = con.prepareStatement("update newbook set status='"+sti+"' where booknumber='"+bookid+"'");
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
updateData();
}
else if(ae.getSource()==b2)
{
frm.setVisible(false);
}


}

public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==ch1)
{
showRec();

}
if(ie.getSource()==ch2)
{
showBookRec();

}
}

}