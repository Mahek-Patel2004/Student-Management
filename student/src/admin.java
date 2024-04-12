import java.sql.Connection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class admin extends JFrame implements ActionListener {
    JTextField usern, pass;
    JButton b, b1;
    Panel p1, p2;
    JLabel n5;

    admin() {
        /*
         * Panel p1 = new Panel();
         * add(p1);
         * p1.setBounds(20, 20, 500, 200);
         * p1.setBackground(Color.darkGray);
         * p1.setLayout(null);
         * 
         * Panel p2 = new Panel();
         * add(p2);
         * p2.setBounds(20, 220, 500, 400);
         * p2.setBackground(Color.gray);
         * p2.setLayout(null);
         */
        // setSize(900, 650);
        // setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\9.png");
        Image i3 = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        Font f = new Font("algerian", Font.BOLD, 50);
        Label l1 = new Label("Admin");
        l1.setFont(f);
        l1.setBounds(150, 50, 160, 60);
        add(l1);

        Font f1 = new Font("algerian", Font.BOLD, 30);
        JLabel l2 = new JLabel("USER NAME");
        l2.setFont(f1);
        add(l2);
        l2.setBounds(30, 150, 270, 30);

        usern = new JTextField();
        add(usern);
        usern.setBounds(280, 150, 190, 30);

        JLabel l3 = new JLabel("Password");
        l3.setFont(f1);
        add(l3);
        l3.setBounds(30, 220, 270, 30);

        pass = new JPasswordField(); // Use JPasswordField for password input
        add(pass);
        pass.setBounds(280, 220, 190, 30);

        b = new JButton("Login");
        b.setFont(f1);
        add(b);
        b.setBounds(30, 290, 180, 30);
        b1 = new JButton("Cancel");
        b1.setFont(f1);
        add(b1);
        b1.setBounds(280, 290, 180, 30);
        add(n5);
        b.addActionListener(this);
        b1.addActionListener(this);

        setSize(500, 500);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent A) {
        if (A.getSource() == b1) {
            setVisible(false);
        }
        if (A.getSource() == b) {
            String enteredUsername = usern.getText();
            String enteredPassword = pass.getText();

            // Hardcoded username and password
            String correctUsername = "admin123";
            String correctPassword = "admin123";

            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
                JOptionPane.showMessageDialog(this, "Login Successful");

                // MainPageAcceser.mainpage = new mainpage();
                // MainPageAcceser.mainpage.setVisible(false);

                AdminViewAcceser.admin_view = new admin_view();
                AdminViewAcceser.admin_view.setVisible(true);

                // Add code to open the admin panel or perform other actions after successful
                // login
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
    }

    public static void main(String args[]) {
        new admin();
    }

}
