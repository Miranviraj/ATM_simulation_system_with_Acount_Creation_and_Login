package Atm_simulator;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bankservices extends JFrame implements ActionListener {
    JLabel l1;
    JButton b5, b7;
    JTextField t3;
    String pin;

    Bankservices() {
        // Set FlatLaf look and feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        b5 = new JButton("My Account");
        b7 = new JButton("Use ATM");

        // Set button properties
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.WHITE);

        b7.setFont(new Font("Arial", Font.BOLD, 20));
        b7.setBackground(Color.GREEN);
        b7.setForeground(Color.WHITE);

        setLayout(null);



        b5.setBounds(170, 633, 150, 35);
        l2.add(b5);

        b7.setBounds(590, 633, 150, 35);
        l2.add(b7);

        b5.addActionListener(this);

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                this.setVisible(false);
                new First().setVisible(true);
            }

            private void setVisible(boolean b) {
            }
        });

        setSize(960, 1080);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b5) {
                this.setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Atm_simulator.Bankservices().setVisible(true);
    }
}
