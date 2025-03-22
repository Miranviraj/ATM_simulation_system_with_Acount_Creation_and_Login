package Atm_simulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Final extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;
    Final(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("Thank you for Banking With Us");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));



        b7 = new JButton("EXIT");



        setLayout(null);

        l1.setBounds(235,400,700,35);
        l2.add(l1);


        b7.setBounds(390,633,150,35);
        l2.add(b7);




        b7.addActionListener(this);



        setSize(960,1080);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==b7){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Final("").setVisible(true);
    }
}