import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class option extends JFrame implements ActionListener {
    JButton admin, teacher, student;
    JLabel n5;
    // Statement statement;

    option() {
        // statement = DataBaseAcceser.getDatabaseStatement();

        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\9.png");
        Image i3 = img.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        admin = new JButton("Admin");
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.setBounds(200, 50, 200, 30);
        add(admin);

        teacher = new JButton("Teacher");
        teacher.setBackground(Color.BLACK);
        teacher.setForeground(Color.WHITE);
        teacher.setBounds(200, 150, 200, 30);
        add(teacher);

        student = new JButton("Student");
        student.setBackground(Color.BLACK);
        student.setForeground(Color.WHITE);
        student.setBounds(200, 250, 200, 30);
        add(student);
        add(n5);

        admin.addActionListener(this);
        teacher.addActionListener(this);
        student.addActionListener(this);

        setSize(600, 450);
        setLocation(200, 200);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Admin")) {
            setVisible(false);
            new admin().setVisible(true);
        } else if (msg.equals("Teacher")) {
            new teacher().setVisible(true);
        } else if (msg.equals("Student")) {
            new student().setVisible(true);
        } else if (msg.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // MainPageAcceser.mainpage = new mainpage();
        // MainPageAcceser.mainpage.setVisible(false);
        new option();
    }
}
