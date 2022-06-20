import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Meniu extends JFrame implements ActionListener {
    JButton buton1;
    JButton buton2;
    JButton buton3;
    JButton buton4;
    JButton buton5;

    public JPanel panel1;

    Meniu(){
        JPanel topPanel = new JPanel();
        getContentPane().add(topPanel);

        topPanel.setPreferredSize(new Dimension(800, 200));
        topPanel.setBackground(Color.white);
        topPanel.setLayout(null);

        Icon calendarIcon = new ImageIcon("calendar1.png");
        buton1 = new JButton("", calendarIcon);
        buton1.addActionListener(this);
        buton1.setBounds(75,120,120,120);
        buton1.setBackground(null);

        Icon calculatorIcon = new ImageIcon("calculator1.png");
        buton2 = new JButton("", calculatorIcon);
        buton2.setBounds(205,120,120,120);
        buton2.setBackground(null);
        buton2.addActionListener(this);

        Icon agendaIcon = new ImageIcon("agenda2.png");
        buton3 = new JButton("", agendaIcon);
        buton3.setBounds(335,120,120,120);
        buton3.setBackground(null);
        buton3.addActionListener(this);

        Icon coinIcon = new ImageIcon("coin1.png");
        buton4 = new JButton("", coinIcon);
        buton4.setBounds(465,120,120,120);
        buton4.setBackground(null);
        buton4.addActionListener(this);

        Icon clockIcon = new ImageIcon("clock1.png");
        buton5 = new JButton("", clockIcon);
        buton5.setBounds(595,120,120,120);
        buton5.setBackground(null);
        buton5.addActionListener(this);

        topPanel.add(buton1);
        topPanel.add(buton2);
        topPanel.add(buton3);
        topPanel.add(buton4);
        topPanel.add(buton5);

    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == buton1){
            CalendarFrame calendar = new CalendarFrame(0,2022);
        }

        if (event.getSource() ==  buton2){
            Calculator calculator = new Calculator();
        }

        if (event.getSource() == buton3){
            Agenda agenda = new Agenda(); //agenda
        }

        if (event.getSource() == buton4){
            Convertor convertor = new Convertor();
        }

        if (event.getSource() == buton5){
            Ceas ceas = new Ceas();
        }

    }
}

