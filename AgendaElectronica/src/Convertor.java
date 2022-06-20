import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Convertor implements ActionListener{
    JFrame frame;
    JPanel panou;
    JTextField text1, text2;
    JButton convertButton;
    JComboBox currency1, currency2;
    String c1[] = {"EURO", "RON"};
    String c2[] = {"RON", "EURO"};
    JLabel label1, label2, label3;

    double amount = 0, ron = 0, euro = 0;

    Convertor(){
        frame = new JFrame();
        frame.setSize(400,400);
        frame.setLayout(null);

        panou = new JPanel();
        panou.setLayout(null);
        panou.setBounds(25,25,330,310 );
        panou.setBackground(Color.lightGray);
        panou.setBorder(BorderFactory.createSoftBevelBorder(1));

        label1 = new JLabel("From:");
        label1.setBounds(20,20,50,20);

        label2 = new JLabel("To:");
        label2.setBounds(20,60,50,20);

        currency1 = new JComboBox(c1);
        currency1.setSelectedItem(null);
        currency1.setBounds(80, 20, 100, 20);
        currency1.addActionListener(this);

        currency2 = new JComboBox(c2);
        currency2.setSelectedItem(null);
        currency2.setBounds(80, 60, 100, 20);
        currency2.addActionListener(this);

        label3 = new JLabel("Amount:");
        label3.setBounds(20, 110, 50, 20);

        text1 = new JTextField();
        text1.setBounds(80, 110, 100,20);

        convertButton = new JButton("Convert");
        convertButton.setBounds(80, 250, 100,30);
        convertButton.addActionListener(this);
        convertButton.setBorder(BorderFactory.createSoftBevelBorder(1));

        text2 = new JTextField();
        text2.setBounds(80, 150, 200,80);
        text2.setEditable(false);

        panou.add(text2);
        panou.add(convertButton);
        panou.add(label3);
        panou.add(text1);
        panou.add(currency1);
        panou.add(currency2);
        panou.add(label1);
        panou.add(label2);
        frame.add(panou);
        frame.setVisible(true);
    }

    double convertAmount(JTextField text){
        if (text.getText() != "") {
            amount = Double.parseDouble(text.getText());
        }
        return amount;
    }

    public void actionPerformed(ActionEvent event){
        double value = convertAmount(text1);
        if (currency1.getSelectedItem() == "EURO" && currency2.getSelectedItem() == "RON"){
            euro = value;
            ron = euro * 4.94;
            if (event.getSource() == convertButton){
                text2.setText("Valoarea in RON este " + String.valueOf(ron));
            }
        }

        if (currency1.getSelectedItem() == "RON" && currency2.getSelectedItem() == "EURO"){
            ron = value;
            euro = ron * 0.20;
            if (event.getSource() == convertButton){
                text2.setText("Valoarea in RON este " + String.valueOf(euro));
            }
        }

        if (currency1.getSelectedItem() == currency2.getSelectedItem()){
            if (event.getSource() == convertButton){
                text2.setText("Valoarea este: " + value);
            }
        }

    }
}