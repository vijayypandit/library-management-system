package lms;
import java.awt.*;
import java.awt.event.*;

public class AfterLogin extends Frame implements ActionListener
{
MenuBar mb;
Menu mnuAdd,mnuOpr,mnuUp,mnuSrc;
MenuItem miAddStu,miAddBook,miAcc,miExit;
MenuItem miIssBook,miRetBook;
MenuItem miStu,miBook,miIssue,miReturn;
MenuItem mibd,misd;
Frame frm;

public AfterLogin()
{

mb=new MenuBar();

mnuAdd=new Menu("Add");
miAddStu=new MenuItem(" Add New Student");
miAddBook=new MenuItem("Add New Book");
miAcc=new MenuItem("New Account");
miExit=new MenuItem("Exit");

mnuOpr=new Menu("Operation");
miIssBook=new MenuItem("Issue Book");
miRetBook=new MenuItem("Return Book");

mnuUp=new Menu("Update");
miStu=new MenuItem("Student Details");
miBook=new MenuItem("Book Details");
miIssue=new MenuItem("Issue Book Details");
miReturn=new MenuItem("Return Book Details");

mnuSrc=new Menu("Search");
mibd=new MenuItem("Book Details");
misd=new MenuItem("Student Details");


frm=new Frame("Login");
}

public void setUpAfterLogin()
{

frm.setSize(600,700);
mnuAdd.add(miAddStu);
mnuAdd.add(miAddBook);
mnuAdd.add(miAcc);
mnuAdd.add(miExit);

mnuOpr.add(miIssBook);
mnuOpr.add(miRetBook);

mnuUp.add(miStu);
mnuUp.add(miBook);
mnuUp.add(miIssue);
mnuUp.add(miReturn);

mnuSrc.add(mibd);
mnuSrc.add(misd);

mb.add(mnuAdd);
mb.add(mnuOpr);
mb.add(mnuUp);
mb.add(mnuSrc);

frm.setMenuBar(mb);
frm.setVisible(true);

miAddStu.addActionListener(this);
miAddBook.addActionListener(this);
miAcc.addActionListener(this);
miExit.addActionListener(this);

miIssBook.addActionListener(this);
miRetBook.addActionListener(this);

miStu.addActionListener(this);
miBook.addActionListener(this);
miIssue.addActionListener(this);
miReturn.addActionListener(this);

mibd.addActionListener(this);
misd.addActionListener(this);




}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==miAddStu)
{
AddNewStudent ob=new AddNewStudent();
ob.setUpAddNewStudent();
}
else if(ae.getSource()==miAddBook)
{
AddNewBook bo=new AddNewBook();
bo.setUpAddNewBook();
}
else if(ae.getSource()==miAcc)
{
CreateAccount ac=new CreateAccount();
ac.setUpCreateAccount();
}
else if(ae.getSource()==miExit)
{
frm.setVisible(false);
}
else if(ae.getSource()==miIssBook)
{
IssueBook is=new IssueBook();
is.setUpIssueBook();
}
else if(ae.getSource()==miRetBook)
{
ReturnBook re=new ReturnBook();
re.setUpReturnBook();
}

else if(ae.getSource()==miStu)
{
UpdateStudentDetail re=new UpdateStudentDetail();
re.setUpUpdateStudentDetail();
}


else if(ae.getSource()==miBook)
{
UpdateBookDetail re=new UpdateBookDetail();
re.setUpUpdateBookDetail();
}
else if(ae.getSource()==miIssue)
{
UpdateIssueBook re=new UpdateIssueBook();
re.setUpUpdateIssueBook();
}

else if(ae.getSource()==miReturn)
{
UpdateReturnBook re=new UpdateReturnBook();
re.setUpUpdateReturnBook();
}
else if(ae.getSource()==mibd)
{
SearchBook sr=new SearchBook();
sr.setUpSearchBook();
}

else if(ae.getSource()==misd)
{
SearchStu st=new SearchStu();
st.setUpSearchStu();
}

}








}