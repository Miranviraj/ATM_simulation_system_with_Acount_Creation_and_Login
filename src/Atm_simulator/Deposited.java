package Atm_simulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Deposited extends JFrame implements ActionListener{

    JLabel l1,l3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;
    Deposited(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel(" Your Cash Deposited Successfully");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l3 = new JLabel("Do You Want Any Other Service?");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));



        b7 = new JButton("No");
        b8 = new JButton("Yes");


        setLayout(null);

        l1.setBounds(235,400,700,35);
        l2.add(l1);
        l3.setBounds(235,560,700,35);
        l2.add(l3);



        b7.setBounds(390,633,150,35);
        l2.add(b7);

        b8.setBounds(170,633,150,35); // Changed position of b8
        l2.add(b8);



        b7.addActionListener(this);
        b8.addActionListener(this);


        setSize(960,1080);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b8){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }else if(ae.getSource()==b7){
            this.setVisible(false);
            new Final(pin).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Deposited("").setVisible(true);
    }
}