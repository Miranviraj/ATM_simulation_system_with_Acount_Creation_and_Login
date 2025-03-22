
package Atm_simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class First extends JFrame implements ActionListener {
    JLabel l1;
    JButton b5, b7;
    JTextField t3;
    String pin;

   First() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/atmhome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);




        b5 = new JButton("Enter");

        b7 = new JButton("EXIT");

        setLayout(null);

       b5.setBounds(170, 633, 150, 35);
       l2.add(b5);


       b7.setBounds(390, 633, 150, 35);
       l2.add(b7);



        b5.addActionListener(this);

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0); // Close the page
            }

        });

        setSize(960, 1080);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);


    }



    public void actionPerformed(ActionEvent ae) {

        try {


            if (ae.getSource() == b5) {
                this.setVisible(false);
                new home(null).setVisible(true);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public static void main (String[]args){
        new Atm_simulator.First().setVisible(true);
    }
}
