package Atm_simulator;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l2 = new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setText("Do You Want Any Other Service?");
        l2.setFont(new Font("System", Font.BOLD, 16));


        b1 = new JButton("No");
        b2=new JButton("Yes");

        setLayout(null);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);
        l2.setBounds(190, 560, 400, 35);
        l3.add(l2);


        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);
        b2.setBounds(190, 633, 150, 35);
        l3.add(b2);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}

        l1.setText("Your Current Account Balance is Rs "+balance);

        b2.addActionListener(this);
        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }else if(ae.getSource()==b1){
            this.setVisible(false);
            new Final(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
