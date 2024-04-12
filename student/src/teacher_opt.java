import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class teacher_opt extends JFrame implements ActionListener {
    JButton java, cn, mp, dbms, nnfl;
    JLabel n5, id8;

    teacher_opt() {
        setBackground(Color.white);
        setLayout(null);

        n5 = new JLabel();
        n5.setBounds(0, 0, 900, 700);
        n5.setLayout(null);
        ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\7.png");
        Image i3 = img.getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        n5.setIcon(icc3);

        id8 = new JLabel("Subjects:");
        id8.setBounds(230, 70, 500, 50);
        id8.setFont(new Font("serif", Font.ITALIC, 40));
        id8.setForeground(Color.black);
        n5.add(id8);

        java = new JButton("JAVA");
        java.setBackground(Color.BLACK);
        java.setForeground(Color.WHITE);
        java.setBounds(200, 150, 200, 30);
        add(java);

        cn = new JButton("CN");
        cn.setBackground(Color.BLACK);
        cn.setForeground(Color.WHITE);
        cn.setBounds(200, 220, 200, 30);
        add(cn);

        mp = new JButton("Microprocessor");
        mp.setBackground(Color.BLACK);
        mp.setForeground(Color.WHITE);
        mp.setBounds(200, 290, 200, 30);
        add(mp);

        dbms = new JButton("DBMS");
        dbms.setBackground(Color.BLACK);
        dbms.setForeground(Color.WHITE);
        dbms.setBounds(200, 360, 200, 30);
        add(dbms);

        nnfl = new JButton("NNFL");
        nnfl.setBackground(Color.BLACK);
        nnfl.setForeground(Color.WHITE);
        nnfl.setBounds(200, 430, 200, 30);
        add(nnfl);
        add(n5);

        java.addActionListener(this);
        cn.addActionListener(this);
        mp.addActionListener(this);
        dbms.addActionListener(this);
        nnfl.addActionListener(this);

        setSize(600, 600);
        setLocation(200, 200);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("JAVA")) {
            new marks_update().setVisible(true);
            setVisible(false);
        } else if (msg.equals("CN")) {
            new cn().setVisible(true);
        } else if (msg.equals("Microprocessor")) {
            new micro().setVisible(true);
        } else if (msg.equals("DBMS")) {
            new dbms().setVisible(true);
        } else if (msg.equals("NNFL")) {
            new nnfl().setVisible(true);
        } else if (msg.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new teacher_opt();
    }
}
