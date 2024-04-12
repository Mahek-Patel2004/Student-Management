
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class student_view extends JFrame implements ActionListener {

    JLabel l1, r, n, l, a, p, d, g, n5, id8, att, mp, cn, java, nnfl, dbms;
    JTextField Rollno, roll, name, lastname, address, phone, dob, gender, Att, MP, CN, Java, NNfl, DBMS;
    JButton Submit, Cancel, update;

    // Connect connect;
    Statement statement;

    student_view() {

        statement = DataBaseAcceser.getDatabaseStatement();

        setSize(900, 650);
        setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\2.png");
        Image i3 = img.getImage().getScaledInstance(1200, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        JLabel l1 = new JLabel("Enter roll number to get the data of student:");
        l1.setBounds(50, 100, 500, 30);
        l1.setFont(new Font("serif", Font.ITALIC, 20));
        n5.add(l1);

        Rollno = new JTextField();
        Rollno.setBounds(500, 100, 200, 30);
        n5.add(Rollno);

        update = new JButton("Fetch");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(720, 100, 100, 30);
        n5.add(update);
        update.addActionListener(this);

        id8 = new JLabel("Student Details:");
        id8.setBounds(50, 10, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        n5.add(id8);

        r = new JLabel("Roll No");
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
        l.setBounds(400, 200, 200, 30);
        l.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(l);

        lastname = new JTextField();
        lastname.setBounds(600, 200, 150, 30);
        n5.add(lastname);

        d = new JLabel("DOB (dd/mm/yyyy)");
        d.setBounds(400, 150, 200, 30);
        d.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(d);

        dob = new JTextField();
        dob.setForeground(new Color(105, 105, 105));
        dob.setBounds(600, 150, 150, 30);
        n5.add(dob);

        a = new JLabel("Address");
        a.setBounds(50, 250, 100, 30);
        a.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(a);

        address = new JTextField();
        address.setBounds(200, 250, 150, 30);
        n5.add(address);

        p = new JLabel("Phone");
        p.setBounds(400, 250, 100, 30);
        p.setFont(new Font("serif", Font.BOLD, 20));
        n5.add(p);

        phone = new JTextField();
        phone.setBounds(600, 250, 150, 30);
        n5.add(phone);

        g = new JLabel("Gender");
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.setBounds(50, 300, 200, 30);
        n5.add(g);

        gender = new JTextField();
        gender.setBounds(200, 300, 150, 30);
        n5.add(gender);

        att = new JLabel("Attendance");
        att.setFont(new Font("serif", Font.BOLD, 20));
        att.setBounds(400, 300, 200, 30);
        n5.add(att);

        Att = new JTextField();
        Att.setBounds(600, 300, 150, 30);
        n5.add(Att);

        mp = new JLabel("Microprocessor");
        mp.setFont(new Font("serif", Font.BOLD, 20));
        mp.setBounds(50, 350, 200, 30);
        n5.add(mp);

        MP = new JTextField();
        MP.setBounds(200, 350, 150, 30);
        n5.add(MP);

        cn = new JLabel("Computer Network");
        cn.setFont(new Font("serif", Font.BOLD, 20));
        cn.setBounds(400, 350, 200, 30);
        n5.add(cn);

        CN = new JTextField();
        CN.setBounds(600, 350, 150, 30);
        n5.add(CN);

        java = new JLabel("Java");
        java.setFont(new Font("serif", Font.BOLD, 20));
        java.setBounds(50, 400, 200, 30);
        n5.add(java);

        Java = new JTextField();
        Java.setBounds(200, 400, 150, 30);
        n5.add(Java);

        nnfl = new JLabel("NNFL");
        nnfl.setFont(new Font("serif", Font.BOLD, 20));
        nnfl.setBounds(400, 400, 200, 30);
        n5.add(nnfl);

        NNfl = new JTextField();
        NNfl.setBounds(600, 400, 150, 30);
        n5.add(NNfl);

        dbms = new JLabel("DBMS");
        dbms.setFont(new Font("serif", Font.BOLD, 20));
        dbms.setBounds(50, 450, 200, 30);
        n5.add(dbms);

        DBMS = new JTextField();
        DBMS.setBounds(200, 450, 150, 30);
        n5.add(DBMS);

        Submit = new JButton("Cancel");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(450, 550, 150, 40);

        n5.add(Submit);

        Cancel = new JButton("Done");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(250, 550, 150, 40);

        n5.add(Cancel);
        add(n5);
        Submit.addActionListener(this);
        Cancel.addActionListener(this);
        update.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String Roll = roll.getText();
            String Name = name.getText();
            String Lastname = lastname.getText();
            String Dob = dob.getText();
            String Address = address.getText();
            String Phone = phone.getText();
            String Gender = gender.getText();

            /*
             * try =
             * 
             * String str = "update details set rollno='" + Roll + "',name='" + Name +
             * "',lastname='" + Lastname
             * + "',dob='" + Dob + "',address='" + Address + "',phone='" + Phone +
             * "',gender='" + Gender
             * + "' where rollno='" + roll.getText() + "'";
             * 
             * connect.statement.executeUpdate(str);
             * JOptionPane.showMessageDialog(null, "successfully updated");
             * 
             * setVisible(false);
             * new mainpage().setVisible(true);
             * 
             * }
             * catch (Exception e) {
             * System.out.println("The error is:" + e);
             * }
             */
        }

        if (ae.getSource() == Cancel) {
            setVisible(false);
            // new Project().setVisible(true);
        }
        if (ae.getSource() == update) {
            try {

                String str = "select s.rollno, s.name, s.lastname, s.dob, s.address, s.phone, s.gender, t.attend, t.java_mark, t.cn_mark, t.microp, t.dbms, t.nnfl from student s inner join teacher t on s.rollno = t.rollno  where s.rollno = '"
                        + Rollno.getText() + "'";
                // ResultSet rs = connect.statement.executeQuery(str);
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
                    Att.setText(rs.getString(8));
                    MP.setText(rs.getString(9));
                    CN.setText(rs.getString(10));
                    Java.setText(rs.getString(11));
                    NNfl.setText(rs.getString(12));
                    DBMS.setText(rs.getString(13));

                } else {
                    JOptionPane.showMessageDialog(null, "No data found");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }

    }

    public static void main(String[] arg) {
        student_view up = new student_view();
        // up.connect = new Connect();
    }
}