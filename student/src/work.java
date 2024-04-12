import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class work extends JFrame implements ActionListener {
    JButton attendance, marks_update;
    JLabel n5;

    work() {
        setSize(900, 650);
        // setLocation(450, 150);
        // setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\10.png");
        Image i3 = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        attendance = new JButton("Attendance");
        attendance.setBackground(Color.BLACK);
        attendance.setForeground(Color.WHITE);
        attendance.setBounds(100, 100, 200, 30);
        add(attendance);

        marks_update = new JButton("Marks_Update");
        marks_update.setBackground(Color.BLACK);
        marks_update.setForeground(Color.WHITE);
        marks_update.setBounds(100, 200, 200, 30);
        add(marks_update);

        attendance.addActionListener(this);
        marks_update.addActionListener(this);
        add(n5);

        setSize(400, 400);
        setLocation(200, 200);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Attendance")) {

            new attendance().setVisible(true);
            setVisible(false);

        } else if (msg.equals("Marks_Update")) {
            new teacher_opt().setVisible(true);
        } else if (msg.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new work();
    }
}
