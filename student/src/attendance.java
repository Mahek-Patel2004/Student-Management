
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class attendance extends JFrame implements ActionListener {

    JLabel l1, r, n, l, a, p, d, g, n5, id8, m;
    JTextField Rollno, roll, name, lastname, address, phone, dob, gender, atten;
    JButton Submit, Cancel, search;
    JRadioButton r1, r2;
    Statement statement;
    Connect connect;

    attendance() {
        statement = DataBaseAcceser.getDatabaseStatement();

        setSize(900, 650);
        // setLocation(450, 150);
        // setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\2.png");
        Image i3 = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        // n5 = new JLabel();
        // n5.setBounds(0, 0, 900, 700);
        // n5.setLayout(null);

        JLabel l1 = new JLabel("Enter roll number to mark attendance of the student:");
        l1.setBounds(50, 100, 500, 30);
        l1.setFont(new Font("serif", Font.ITALIC, 20));
        add(l1);

        Rollno = new JTextField();
        Rollno.setBounds(500, 100, 200, 30);
        add(Rollno);

        search = new JButton("Fetch");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(720, 100, 100, 30);
        add(search);
        search.addActionListener(this);

        id8 = new JLabel("Mark Attendance:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        add(id8);

        r = new JLabel("Roll No");
        r.setBounds(50, 150, 100, 30);
        r.setFont(new Font("serif", Font.BOLD, 20));
        add(r);

        roll = new JTextField();
        roll.setBounds(200, 150, 150, 30);
        add(roll);

        n = new JLabel("Name");
        n.setBounds(50, 200, 100, 30);
        n.setFont(new Font("serif", Font.BOLD, 20));
        add(n);

        name = new JTextField();
        name.setBounds(200, 200, 150, 30);
        add(name);

        l = new JLabel("Last name");
        l.setBounds(400, 200, 200, 30);
        l.setFont(new Font("serif", Font.BOLD, 20));
        add(l);

        lastname = new JTextField();
        lastname.setBounds(600, 200, 150, 30);
        add(lastname);

        d = new JLabel("DOB (dd/mm/yyyy)");
        d.setBounds(400, 150, 200, 30);
        d.setFont(new Font("serif", Font.BOLD, 20));
        add(d);

        dob = new JTextField();
        dob.setForeground(new Color(105, 105, 105));
        dob.setBounds(600, 150, 150, 30);
        add(dob);

        a = new JLabel("Address");
        a.setBounds(50, 250, 100, 30);
        a.setFont(new Font("serif", Font.BOLD, 20));
        add(a);

        address = new JTextField();
        address.setBounds(200, 250, 150, 30);
        add(address);

        p = new JLabel("Phone");
        p.setBounds(400, 250, 100, 30);
        p.setFont(new Font("serif", Font.BOLD, 20));
        add(p);

        phone = new JTextField();
        phone.setBounds(600, 250, 150, 30);
        add(phone);

        g = new JLabel("Gender");
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.setBounds(50, 300, 200, 30);
        add(g);

        gender = new JTextField();
        gender.setBounds(200, 300, 150, 30);
        add(gender);

        m = new JLabel("Attendance");
        m.setFont(new Font("serif", Font.BOLD, 20));
        m.setBounds(400, 300, 200, 30);
        add(m);

        r1 = new JRadioButton("Absent");
        r1.setFont(new Font("serif", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);

        r2 = new JRadioButton("Present");
        r2.setFont(new Font("serif", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        r1.setBounds(600, 300, 100, 30);
        add(r1);
        r2.setBounds(720, 300, 100, 30);
        add(r2);

        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(250, 450, 150, 40);

        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(450, 450, 150, 40);

        add(Cancel);
        add(n5);

        Submit.addActionListener(this);
        Cancel.addActionListener(this);
        search.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            /*
             * String Roll = roll.getText();
             * String Name = name.getText();
             * String Lastname = lastname.getText();
             * String Dob = dob.getText();
             * String Address = address.getText();
             * String Phone = phone.getText();
             * String Gender = gender.getText();
             */
            String Attend = null;
            if (r1.isSelected()) {
                Attend = "Absent";
            } else if (r2.isSelected()) {
                Attend = "Present";
            }

            try {
                // conn con = new conn();
                String str = "update details set attend='" + Attend + "' where rollno='" + roll.getText() + "' ";
                String str2 = "update teacher set attend='" + Attend + "' where rollno='" + roll.getText() + "' ";

                statement.execute(str);
                statement.execute(str2);

                JOptionPane.showMessageDialog(null, "successfully attendance inserted");
                setVisible(false);

                // new mainpage().setVisible(true);
                if (AttendanceViewAcceser.AttendanceView != null) {
                    AttendanceViewAcceser.AttendanceView.dispose();
                }
                AttendanceViewAcceser.AttendanceView = new AttendanceView();
                AttendanceViewAcceser.AttendanceView.setVisible(true);

            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == Cancel) {
            setVisible(false);
            // new Project().setVisible(true);
        }
        if (ae.getSource() == search) {
            try {

                String str = "select * from details where rollno = '" + Rollno.getText() + "'";
                ResultSet rs = statement.executeQuery(str);

                if (rs.next()) {
                    setVisible(true);

                    roll.setText(rs.getString(1));
                    name.setText(rs.getString(2));
                    lastname.setText(rs.getString(3));
                    dob.setText(rs.getString(4));
                    address.setText(rs.getString(5));
                    phone.setText(rs.getString(6));
                    gender.setText(rs.getString(7));

                } else {
                    JOptionPane.showMessageDialog(null, "No data found");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    public static void main(String[] arg) {
        attendance up = new attendance();
        up.connect = new Connect();
    }
}