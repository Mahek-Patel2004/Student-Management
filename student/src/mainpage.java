import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class mainpage extends JFrame implements ActionListener {

    JTable t1;
    JButton add, update, delete, cancel;

    String x[] = { "Roll No", "Name", "Last Name", "Date of Birth", "Address", "Phone", "Gender", "Attendance", "java",
            "cn", "micro", "dbms", "nnfl" };
    String y[][] = new String[20][13];
    int i = 0, j = 0;

    public mainpage() {
        setSize(900, 650);
        setLocation(450, 150);
        setBackground(Color.white);
        setLayout(null);

        // Create the content pane with a background image
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("C:\\Users\\MAHEK\\OneDrive\\Desktop\\Android\\19.jpg");
                Image image = img.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setOpaque(false);
        contentPane.setLayout(null);
        setContentPane(contentPane);

        add = new JButton("Add Student");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(170, 450, 200, 30);
        contentPane.add(add);

        update = new JButton("Update Student");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(420, 450, 200, 30);
        contentPane.add(update);

        delete = new JButton("Delete Student");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(670, 450, 200, 30);
        contentPane.add(delete);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(920, 450, 200, 30);
        contentPane.add(cancel);

        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        cancel.addActionListener(this);

        try {
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root",
                    "@Mayra#1918.Sis");
            Statement s = c1.createStatement();
            String s1 = "select * from details";
            ResultSet rs = s.executeQuery(s1);

            while (rs.next()) {
                y[i][j++] = rs.getString("rollno");
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("lastname");
                y[i][j++] = rs.getString("dob");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("phone");
                y[i][j++] = rs.getString("gender");
                y[i][j++] = rs.getString("attend");
                y[i][j++] = rs.getString("java_mark");
                y[i][j++] = rs.getString("cn_mark");
                y[i][j++] = rs.getString("microp");
                y[i][j++] = rs.getString("dbms");
                y[i][j++] = rs.getString("nnfl");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);
            JScrollPane sp = new JScrollPane(t1);
            sp.setBounds(20, 20, 1200, 330);
            contentPane.add(sp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        setSize(1260, 650);
        setLocation(200, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Add Student")) {
            new addstudent().setVisible(true);
            setVisible(false);
        } else if (msg.equals("Update Student")) {
            new update().setVisible(true);
        } else if (msg.equals("Delete Student")) {
            new delete().setVisible(true);
        } else if (msg.equals("Cancel")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new mainpage();
    }
}
