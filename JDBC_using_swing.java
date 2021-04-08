// textField1 for user ID
// textField2 for user Name
// textField3 for operation compeletion



package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Main {

    public static String url = "jdbc:mysql://localhost:3306/small";
    public static String user = "root";
    public static String pass = "bitu";
    public static String sql;

    static void J() {
        JFrame frame = new JFrame();
        frame.setSize(500,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        frame.setContentPane(panel);
        panel.setLayout(null);

        JLabel label1 = new JLabel("Enter ID");
        label1.setBounds(50,50,70,25);
        panel.add(label1);

        JLabel label2 = new JLabel("Enter Name");
        label2.setBounds(50,80,70,25);
        panel.add(label2);

        JTextField textField1 = new JTextField();
        textField1.setBounds(200,50,100,25);
        panel.add(textField1);


        JTextField textField2 = new JTextField();
        textField2.setBounds(200,80,100,25);
        panel.add(textField2);

        JLabel label3 = new JLabel("Operation");
        label3.setBounds(50,110,70,25);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(200,110,100,25);
        panel.add(textField3);

        JButton button1 = new JButton("Insert Data");
        button1.setBounds(50,170,100,30);
        button1.addActionListener(e -> {
            int id;
            String name;
            id = Integer.parseInt(textField1.getText());
            name = textField2.getText();
            try {
                Connection con = DriverManager.getConnection(url,user,pass);
                Statement stmt = con.createStatement();
                sql = "INSERT INTO name(id,name) values("+id+",'"+name+"')";
                stmt.executeUpdate(sql);
                textField3.setText("Record Inserted");

                stmt.close();
                con.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton button2 = new JButton("Clear");
        button2.setBounds(200,170,100,30);
        button2.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        });

        JButton button3 = new JButton("Exit");
        button3.setBounds(350,170,100,30);
        button3.addActionListener(e -> System.exit(0));

        JButton button4 = new JButton("Update");
        button4.setBounds(50,220,100,30);
        button4.addActionListener(e -> {
            String name;
            int id;
            name = textField2.getText();
            id = Integer.parseInt(textField1.getText());
            try {
                Connection con = DriverManager.getConnection(url,user,pass);
                Statement stmt = con.createStatement();
                sql = "update name set name = '"+name+"' where id = "+id+"";
                stmt.executeUpdate(sql);
                textField3.setText("Record Updated");

                con.close();
                stmt.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton button5 = new JButton("Delete");
        button5.setBounds(200,220,100,30);
        button5.addActionListener(e -> {
            int id;
            id = Integer.parseInt(textField1.getText());
            try {
                Connection con = DriverManager.getConnection(url,user,pass);
                Statement stmt = con.createStatement();
                sql = "delete from name where id = "+id+";";
                stmt.executeUpdate(sql);
                textField3.setText("Record Deleted");
                stmt.close();
                con.close();
            }catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        panel.add(button5);
        panel.add(button4);
        panel.add(button3);
        panel.add(button2);
        panel.add(button1);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        J();
    }
}
