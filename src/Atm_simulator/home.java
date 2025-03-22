package Atm_simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class home extends JFrame implements ActionListener {
    JLabel l1;
    JButton b5, b7;
    JPasswordField t3;
    String pin;

    home(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Atm_simulator/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        l1 = new JLabel("Please Enter Your pin ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        t3 = new JPasswordField();
        t3.setHorizontalAlignment(JTextField.CENTER);

        b5 = new JButton("Enter");

        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235, 400, 700, 35);
        l2.add(l1);

        t3.setBounds(170, 499, 150, 35);
        l2.add(t3);

        b5.setBounds(170, 588, 150, 35);
        l2.add(b5);


        b7.setBounds(390, 633, 150, 35);
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
        setUndecorated(true);
        setVisible(true);


    }



    public void actionPerformed(ActionEvent ae) {

        try {
            String pin = t3.getText();

            if (ae.getSource() == b5) {
                if (t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Pin");
                } else {


                    Conn c1 = new Conn();
                    ResultSet rs = null;
                    try {
                        rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    boolean pinMatch = false;
                    while (true) {
                        try {
                            if (!rs.next()) break;
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            if (rs.getString("pin").equals(pin)) {
                                pinMatch = true;
                                break;
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (pinMatch) {
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid PIN");
                    }

                }
                if (ae.getSource() == b7) {
                    System.exit(0);
                }
            }


        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


        public static void main (String[]args){
            new home("").setVisible(true);
        }
    }
