import java.awt.*;
//import java.sql.*;
//import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Statement;

//import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.demo.DateChooserPanel;

class addstudent extends JFrame implements ActionListener {

    JLabel l1, r, n, l, a, p, d, g, n5;
    JTextField roll, name, lastname, address, phone, dateChooser;
    JButton Submit, Cancel;
    // JDateChooser dateChooser;
    JRadioButton r1, r2;
    Statement statement;
    Connect connect;

    public addstudent() {
        statement = DataBaseAcceser.getDatabaseStatement();

        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\2.png");
        Image i3 = img.getImage().getScaledInstance(1220, 700, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        l1 = new JLabel("New Student Details");
        l1.setBounds(320, 30, 500, 50);
        l1.setFont(new Font("serif", Font.ITALIC, 40));
        l1.setForeground(Color.black);
        n5.add(l1);
        add(n5);

        r = new JLabel("Roll No.");
        r.setBounds(50, 150, 100, 30);
        r.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(r);

        roll = new JTextField();
        roll.setBounds(200, 150, 150, 30);
        n5.add(roll);

        n = new JLabel("Name");
        n.setBounds(50, 200, 100, 30);
        n.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(n);

        name = new JTextField();
        name.setBounds(200, 200, 150, 30);
        n5.add(name);

        l = new JLabel("Last name");
        l.setBounds(430, 200, 200, 30);
        l.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(l);

        lastname = new JTextField();
        lastname.setBounds(630, 200, 150, 30);
        n5.add(lastname);

        d = new JLabel("DOB (dd/mm/yyyy)");
        d.setBounds(430, 150, 200, 30);
        d.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(d);

        // dateChooser = new JDateChooser();
        // dateChooser.setForeground(new Color(105, 105, 105));
        // dateChooser.setBounds(600, 150, 150, 30);
        // n5.add(dateChooser);

        dateChooser = new JTextField();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(630, 150, 150, 30);
        n5.add(dateChooser);

        a = new JLabel("Address");
        a.setBounds(50, 250, 100, 30);
        a.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(a);

        address = new JTextField();
        address.setBounds(200, 250, 150, 30);
        n5.add(address);

        p = new JLabel("Phone");
        p.setBounds(430, 250, 100, 30);
        p.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(p);

        phone = new JTextField();
        phone.setBounds(630, 250, 150, 30);
        n5.add(phone);

        g = new JLabel("Gender");
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.setBounds(50, 300, 200, 30);
        n5.add(g);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("serif", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("serif", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        r1.setBounds(200, 300, 60, 30);
        n5.add(r1);
        r2.setBounds(300, 300, 90, 30);
        n5.add(r2);

        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(250, 450, 150, 40);
        n5.add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(450, 450, 150, 40);
        n5.add(Cancel);

        Submit.addActionListener(this);
        Cancel.addActionListener(this);

        setSize(900, 700);
        setLocation(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Cancel) {
            setVisible(false);

            // new mainpage().setVisible(true);

            if (AdminViewAcceser.admin_view != null) {
                AdminViewAcceser.admin_view.dispose();
            }
            AdminViewAcceser.admin_view = new admin_view();
            AdminViewAcceser.admin_view.setVisible(true);
            return;

        }
        String Roll = roll.getText();
        String Name = name.getText();
        String Lastname = lastname.getText();
        String dob = dateChooser.getText();
        // dateChooser.getDateEditor().getUiComponent()).getText();
        String Address = address.getText();
        String Phone = phone.getText();
        String gender = null;
        if (r1.isSelected()) {
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }

        if (ae.getSource() == Submit) {
            try {

                // Connect cc = new Connect();
                // String q = "insert into
                // details(rollno,name,lastname,dob,address,phone,gender)
                // values(?,?,?,?,?,?,?)";
                String q = "INSERT INTO details (rollno, name, lastname, dob, address, phone, gender) values('" + Roll
                        + "','" + Name + "','" + Lastname + "','" + dob + "','"
                        + Address + "','" + Phone + "','" + gender + "')";

                String q2 = "INSERT INTO student (rollno, name, lastname, dob, address, phone, gender) values('" + Roll
                        + "','" + Name + "','" + Lastname + "','" + dob + "','"
                        + Address + "','" + Phone + "','" + gender + "')";

                String q3 = "INSERT INTO teacher (rollno) values('" + Roll + "')";

                System.out.println(q);
                statement.execute(q);
                statement.execute(q2);
                statement.execute(q3);

                // connect.statement
                // .execute("insert into details values(11, 'aaa' , 'aa' , '21312' , 'assa' ,
                // '21312312' , 'm')");
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
                // new mainpage().setVisible(true);
                if (AdminViewAcceser.admin_view != null) {
                    AdminViewAcceser.admin_view.dispose();
                }
                AdminViewAcceser.admin_view = new admin_view();
                AdminViewAcceser.admin_view.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public static void main(String[] arg) {
        addstudent ads = new addstudent();
        ads.connect = new Connect();

    }
}