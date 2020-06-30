package lms;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.*;
public class ReturnBook extends Frame implements ActionListener,ItemListener
{
String sr;
String a0,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25;
TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30;
Button b1,b2;
Choice ch2;
Frame frm;
String status="ISSUE";
String sti="RETURNED";
Connection con;
PreparedStatement pst;
Statement st;
ResultSet rec;

Date dt=new Date();
String str=""+dt;
String da=""+str.charAt(8)+str.charAt(9);

String yr=""+str.charAt(24)+str.charAt(25)+str.charAt(26)+str.charAt(27);
public ReturnBook()

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
l19=new Label("ISSUE date :");
l20=new Label("Return date :");
l21=new Label("current date :");
l22=new Label("No.of days");
l23=new Label("Fine Amount");
l24=new Label("Paid Amount :");
l25=new Label("Balance Amount ");

ch2=new Choice();
t28=new TextField();
t29=new TextField();
t30=new TextField();
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
t17=new TextField();
t18=new TextField();
t19=new TextField();
t20=new TextField();
t21=new TextField();
t22=new TextField();
t23=new TextField();
t24=new TextField();
t25=new TextField();
t26=new TextField();
t27=new TextField();
frm=new Frame("Return Books");
}

public void setUpReturnBook()
{

b2.setBackground(Color.BLUE);
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
t17.setBounds(250,100,200,25);



l11.setBounds(600,100,100,30);
l12.setBounds(600,150,130,30);
l13.setBounds(600,200,130,30);
l14.setBounds(600,250,150,30);
l15.setBounds(600,300,60,30);
l16.setBounds(600,350,130,30);
l17.setBounds(600,400,100,30);
l18.setBounds(600,450,100,30);

l19.setBounds(600,500,100,40);
l20.setBounds(600,540,100,30);
l21.setBounds(600,570,100,30);
l22.setBounds(600,610,100,30);
l23.setBounds(600,640,100,30);
l24.setBounds(600,670,100,30);
l25.setBounds(600,700,100,30);

t10.setBounds(800,460,200,25);
t11.setBounds(800,150,200,25);
t12.setBounds(800,200,200,25);
t13.setBounds(800,250,200,25);
t14.setBounds(800,300,200,25);
t15.setBounds(800,350,200,25);
t16.setBounds(800,400,200,25);

ch2.setBounds(800,100,200,40);

t18.setBounds(800,510,45,25);
t19.setBounds(848,510,45,25);
t20.setBounds(895,510,60,25);
t21.setBounds(800,540,45,25);
t22.setBounds(848,540,45,25);
t23.setBounds(895,540,60,25);

t24.setBounds(800,610,200,25);
t25.setBounds(800,640,200,25);
t26.setBounds(800,670,200,25);
t27.setBounds(800,700,200,25);

t28.setBounds(800,570,45,25);
t29.setBounds(848,570,45,25);
t30.setBounds(895,570,60,25);
b1.setBounds(120,600,70,30);
b2.setBounds(300,600,65,30);

t28.setText(""+da);

sr=""+str.charAt(4)+str.charAt(5)+str.charAt(6);
if(sr.equals("Mar"))
{
t29.setText(""+3);

}
else if(sr.equals("Apr"))
{
t29.setText(""+4);

}
else if(sr.equals("Jan"))
{
t29.setText(""+1);

}
else if(sr.equals("Feb"))
{
t29.setText(""+2);

}
t30.setText(""+yr);

b1.addActionListener(this);
b2.addActionListener(this);
ch2.addItemListener(this);
frm.add(t17);
frm.add(ch2);
frm.add(t28);
frm.add(t29);
frm.add(t30);
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
frm.add(l21);
frm.add(l22);
frm.add(l23);
frm.add(l24);
frm.add(l25);
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
frm.add(t18);
frm.add(t19);
frm.add(t20);
frm.add(t21);

frm.add(t22);
frm.add(t23);
frm.add(t24);
frm.add(t25);
frm.add(t26);
frm.add(t27);

frm.add(b1);

frm.add(b2);
conn();
addbookno();
frm.setVisible(true);

}


public void getData()
{
a1=t17.getText();
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

a19=t18.getText();
a20=t19.getText();
a21=t20.getText();

a22=t21.getText();
a23=t22.getText();
a24=t23.getText();

a25=t28.getText();
a26=t29.getText();
a27=t30.getText();

a28=t24.getText();
a29=t25.getText();
a30=t26.getText();
a31=t27.getText();
a0="RETURNED";


}
public void addbookno()
{
try
{
st=con.createStatement();

rec=st.executeQuery("Select * from issuebook where status='"+status+"'");
while(rec.next())
{
ch2.addItem(rec.getString(11));
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
rec=st.executeQuery("Select * from issuebook where booknumber='"+number+"'");
if(rec.next())
{
t17.setText(rec.getString(1));
t1.setText(rec.getString(2));
t2.setText(rec.getString(3));
t3.setText(rec.getString(4));
t4.setText(rec.getString(5));
t5.setText(rec.getString(6));
t6.setText(rec.getString(7));
t7.setText(rec.getString(8));
t8.setText(rec.getString(9));
t9.setText(rec.getString(10));
t10.setText(rec.getString(18));
t11.setText(rec.getString(12));
t12.setText(rec.getString(13));
t13.setText(rec.getString(14));
t14.setText(rec.getString(15));
t15.setText(rec.getString(16));
t16.setText(rec.getString(17));

t18.setText(rec.getString(19));
t19.setText(rec.getString(20));
t20.setText(rec.getString(21));
t21.setText(rec.getString(22));
t22.setText(rec.getString(23));
t23.setText(rec.getString(24));



}
}
catch(Exception ex)
{
System.out.println(ex);
}
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
pst = con.prepareStatement("insert into returnbook values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','"+a13+"','"+a14+"','"+a15+"','"+a16+"','"+a17+"','"+a18+"','"+a19+"','"+a20+"','"+a21+"','"+a22+"','"+a23+"','"+a24+"','"+a25+"','"+a26+"','"+a27+"','"+a28+"','"+a29+"','"+a30+"','"+a31+"','"+a0+"')");
pst.executeUpdate();
}
catch(Exception se)
{
System.out.println(se);
}
}


public void updateData()
{
try
{
String bookid=ch2.getSelectedItem();
pst = con.prepareStatement("update issuebook set status='"+sti+"' where booknumber='"+bookid+"'");
pst.executeUpdate();
}
 
catch(Exception se)
{
System.out.println(se);
}
}


public void days()
{
int a=Integer.parseInt(t21.getText());
int b=Integer.parseInt(t22.getText());
int c=Integer.parseInt(t23.getText());

int d=Integer.parseInt(t28.getText());
int e=Integer.parseInt(t29.getText());
int f=Integer.parseInt(t30.getText());

int cf=(f-c)*365;
int be=(e-b)*30;
int ad=d-a;
int fine=2;

int day=ad+be+cf;


if(day<=0)
{
fine=0;
}
else if(day>0)
{
fine=fine*day;
}

t24.setText(""+day);
t25.setText(""+fine);


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
if(ie.getSource()==ch2)
{
showBookRec();
days();
}

}


}