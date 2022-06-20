import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Agenda implements ActionListener {
    JFrame frame;
    JTabbedPane tabbedPane;
    JButton addButton;
    String tabName;

    Agenda() {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);

        addButton = new JButton("+");
        addButton.setBorder(null);
        addButton.setContentAreaFilled(false);
        addButton.setPreferredSize(new Dimension(30, 30));
        addButton.addActionListener(this);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("", null);
        tabbedPane.setTabComponentAt(0, addButton);

        frame.add(tabbedPane);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton) {
            tabName = JOptionPane.showInputDialog("Enter a Tab name");
            if (tabName != null) {
                JLabel tabTitle = new JLabel(tabName);
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setBackground(Color.lightGray);

                JLabel nume = new JLabel("Nume");
                nume.setBounds(20, 20, 50, 30);
                JTextField numeField = new JTextField();
                numeField.setBounds(80, 20, 100, 30);

                JLabel prenume = new JLabel("Prenume");
                prenume.setBounds(20, 60, 70, 30);
                JTextField prenumeField = new JTextField();
                prenumeField.setBounds(80, 60, 100, 30);

                JLabel tel = new JLabel("Telefon");
                tel.setBounds(20, 100, 70, 30);
                JTextField telField = new JTextField();
                telField.setBounds(80, 100, 100, 30);

                JLabel email = new JLabel("E-mail");
                email.setBounds(20, 140, 70, 30);
                JTextField emailField = new JTextField();
                emailField.setBounds(80, 140, 150, 30);

                JLabel notite = new JLabel("Notite");
                notite.setBounds(20, 180, 70, 30);
                JTextArea notiteArea = new JTextArea();
                notiteArea.setBounds(80,220,300,100);
                notiteArea.setBorder(BorderFactory.createSoftBevelBorder(1));

                panel.add(notite);
                panel.add(notiteArea);
                panel.add(email);
                panel.add(emailField);
                panel.add(tel);
                panel.add(telField);
                panel.add(prenume);
                panel.add(prenumeField);
                panel.add(nume);
                panel.add(numeField);

                tabbedPane.addTab(tabName, panel);
                tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tabTitle);

            }
        }

    }
}
