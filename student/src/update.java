
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class update extends JFrame implements ActionListener {

    JLabel l1, r, n, l, a, p, d, g, n5, id8;
    JTextField Rollno, roll, name, lastname, address, phone, dob, gender;
    JButton Submit, Cancel, update;

    // Connect connect;

    Statement statement;

    update() {

        statement = DataBaseAcceser.getDatabaseStatement();

        setSize(900, 650);
        setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        add(n5);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\2.png");
        Image i3 = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        JLabel l1 = new JLabel("Enter roll number to update the data of student:");
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

        id8 = new JLabel("Update Student Details:");
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

        Submit = new JButton("Update");
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

            try {
                // conn con = new conn();
                String str = "update details set rollno='" + Roll + "',name='" + Name + "',lastname='" + Lastname
                        + "',dob='" + Dob + "',address='" + Address + "',phone='" + Phone + "',gender='" + Gender
                        + "' where rollno='" + roll.getText() + "'";

                String str2 = "update student set rollno='" + Roll + "',name='" + Name + "',lastname='" + Lastname
                        + "',dob='" + Dob + "',address='" + Address + "',phone='" + Phone + "',gender='" + Gender
                        + "' where rollno='" + roll.getText() + "'";
                // connect.statement.executeUpdate(str);
                statement.executeUpdate(str);
                statement.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "successfully updated");
                setVisible(false);
                // MainPageAcceser.mainpage.dispose();
                // MainPageAcceser.mainpage = new mainpage();
                // MainPageAcceser.mainpage.setVisible(true);

                // new mainpage().setVisible(true);

                if (AdminViewAcceser.admin_view != null) {
                    AdminViewAcceser.admin_view.dispose();
                }

                AdminViewAcceser.admin_view = new admin_view();
                AdminViewAcceser.admin_view.setVisible(true);

            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }
        }
        if (ae.getSource() == Cancel) {
            setVisible(false);
            // new Project().setVisible(true);
        }
        if (ae.getSource() == update) {
            try {

                String str = "select * from details where rollno = '" + Rollno.getText() + "'";
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

                } else {

                    JOptionPane.showMessageDialog(this, "Not found");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    public static void main(String[] arg) {
        update up = new update();
        // up.connect = new Connect();
    }
}