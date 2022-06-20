import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton numarButon[] = new JButton[10]; //array pentru numere
    JButton functieButton[] = new JButton[8]; //array pentru functiile calculatorului
    JButton sumaButon, difButon, inmButon, impButon; //functiile de calcull ale calculatorului
    JButton virgulaButon, egalButon, delButon, clrButon;//functiile calculatorului

    JPanel panou;

    double numar1 = 0, numar2 = 0, rezultat = 0;
    char semn;

    Calculator() {
        frame = new JFrame();
        frame.setSize(430, 550);
        frame.setLocation(400,200);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(70, 25, 300, 50);
        textfield.setEditable(false);

        sumaButon = new JButton("+");
        difButon = new JButton("-");
        inmButon = new JButton("*");
        impButon = new JButton("/");
        virgulaButon = new JButton(".");
        egalButon = new JButton("=");
        delButon = new JButton("Delete");
        clrButon = new JButton("Clear");

        functieButton[0] = sumaButon;
        functieButton[1] = difButon;
        functieButton[2] = inmButon;
        functieButton[3] = impButon;
        functieButton[4] = virgulaButon;
        functieButton[5] = egalButon;
        functieButton[6] = delButon;
        functieButton[7] = clrButon;

        for (int i = 0; i < 8; i++) {
            functieButton[i].addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numarButon[i] = new JButton(String.valueOf(i));
            numarButon[i].addActionListener(this);
        }

        delButon.setBounds(70, 430, 145, 50);
        clrButon.setBounds(225, 430, 145, 50);

        panou = new JPanel();
        panou.setBounds(70, 100, 300, 300);
        panou.setLayout(new GridLayout(4, 4, 10, 10));

        panou.add(numarButon[1]);
        panou.add(numarButon[2]);
        panou.add(numarButon[3]);
        panou.add(sumaButon);
        panou.add(numarButon[4]);
        panou.add(numarButon[5]);
        panou.add(numarButon[6]);
        panou.add(difButon);
        panou.add(numarButon[7]);
        panou.add(numarButon[8]);
        panou.add(numarButon[9]);
        panou.add(inmButon);
        panou.add(virgulaButon);
        panou.add(numarButon[0]);
        panou.add(egalButon);
        panou.add(impButon);


        frame.add(panou);
        frame.add(delButon);
        frame.add(clrButon);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            if (event.getSource() == numarButon[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (event.getSource() == virgulaButon) {
            textfield.setText(textfield.getText().concat("."));
        }

        if (event.getSource() == sumaButon) {
            numar1 = Double.parseDouble(textfield.getText());
            semn = '+';
            textfield.setText("");
        }

        if (event.getSource() == difButon) {
            numar1 = Double.parseDouble(textfield.getText());
            semn = '-';
            textfield.setText("");
        }

        if (event.getSource() == inmButon) {
            numar1 = Double.parseDouble(textfield.getText());
            semn = '*';
            textfield.setText("");
        }

        if (event.getSource() == impButon) {
            numar1 = Double.parseDouble(textfield.getText());
            semn = '/';
            textfield.setText("");
        }

        if (event.getSource() == egalButon) {
            numar2 = Double.parseDouble(textfield.getText());

            switch (semn) {
                case '+':
                    rezultat = numar1 + numar2;
                    break;

                case '-':
                    rezultat = numar1 - numar2;
                    break;

                case '*':
                    rezultat = numar1 * numar2;
                    break;

                case '/':
                    rezultat = numar1 / numar2;
                    break;
            }

            textfield.setText(String.valueOf(rezultat));
            numar1 = rezultat;
        }

        if (event.getSource() == clrButon){
            textfield.setText("");
        }

        if (event.getSource() == delButon){
            String text = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < text.length() - 1; i++){
                textfield.setText(textfield.getText() + text.charAt(i));
            }
        }
    }
}