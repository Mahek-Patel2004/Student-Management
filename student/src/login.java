import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

class conn {
    public Connection c;
    Statement s;

    conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root",
                    "@Mayra#1918.Sis");
            s = c.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

public class login extends JFrame implements ActionListener {
    JTextField usern, pass;
    JButton b, b1;
    Panel p1, p2;
    conn c1;

    login() {
        // heading sub panel1
        Panel p1 = new Panel();
        add(p1);
        p1.setBounds(20, 20, 500, 200);
        p1.setBackground(Color.darkGray);
        p1.setLayout(null);

        // information form sub panel2
        Panel p2 = new Panel();
        add(p2);
        p2.setBounds(20, 220, 500, 400);
        p2.setBackground(Color.gray);
        p2.setLayout(null);

        // heading
        Font f = new Font("algerian", Font.BOLD, 50);
        Label l1 = new Label("Login");
        l1.setFont(f);
        l1.setBounds(150, 80, 200, 60);
        p1.add(l1);

        // information
        Font f1 = new Font("algerian", Font.BOLD, 30);
        JLabel l2 = new JLabel("USER NAME");
        l2.setFont(f1);
        p2.add(l2);
        l2.setBounds(30, 50, 270, 30);

        usern = new JTextField();
        p2.add(usern);
        usern.setBounds(280, 50, 190, 30);

        JLabel l3 = new JLabel("Password");
        l3.setFont(f1);
        p2.add(l3);
        l3.setBounds(30, 100, 270, 30);

        pass = new JPasswordField(); // Use JPasswordField for password input
        p2.add(pass);
        pass.setBounds(280, 100, 190, 30);

        b = new JButton("Login");
        b.setFont(f1);
        p2.add(b);
        b.setBounds(30, 210, 180, 30);
        b1 = new JButton("Cancel");
        b1.setFont(f1);
        p2.add(b1);
        b1.setBounds(250, 210, 180, 30);

        b.addActionListener(this);
        b1.addActionListener(this);

        setSize(800, 800);
        setLayout(null);
        setVisible(true);

        // Initialize the conn class
        c1 = new conn();
    }

    public void actionPerformed(ActionEvent A) {
        if (A.getSource() == b1) {
            setVisible(false);
        }
        if (A.getSource() == b) {
            try {
                String username = usern.getText();
                String password = pass.getText();

                // Use PreparedStatement to prevent SQL injection
                String q = "SELECT * FROM login WHERE username ='mahek' AND password ='mahek1321'";
                PreparedStatement pstmt = c1.c.prepareStatement(q);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Valid login");

                    // new mainpage().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public static void main(String args[]) {
        new login();
    }
}
