import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


class Login extends JFrame implements ActionListener {
    JSplitPane splitPaneH;
    JPanel panelV;
    JPanel panelE;
    JTextField userField;
    JPasswordField passField;

    private JButton OK;


    Login() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        creazaPanelV();
        createPanelE();

        splitPaneH = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        topPanel.add(splitPaneH);
        splitPaneH.setLeftComponent(panelV);
        splitPaneH.setRightComponent(panelE);
    }

    public void creazaPanelV() {
        panelV = new JPanel();
        panelV.setLayout(null);
        panelV.setBackground(new Color(51, 51, 51));
        panelV.setPreferredSize(new Dimension(400, 400));

        Icon agendaIcon = new ImageIcon("agenda1.png");
        JLabel labelAgenda = new JLabel(agendaIcon);
        labelAgenda.setBounds(100, 100, 200, 200);
        panelV.add(labelAgenda);
    }

    public void createPanelE() {
        panelE = new JPanel();
        panelE.setLayout(null);
        panelE.setBackground(new Color(102, 102, 102));
        panelE.setPreferredSize(new Dimension(400, 400));

        userField = new JTextField();
        userField.setBounds(100, 130, 200, 45);
        userField.setForeground(Color.black);
        userField.setBackground(new Color(102, 102, 102));
        userField.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 1), "Username"));

        Icon userIcon = new ImageIcon("user1.png");
        JLabel labelUser = new JLabel(userIcon);
        labelUser.setBounds(70, 140, 30, 30);
        panelE.add(userField);
        panelE.add(labelUser);


        passField = new JPasswordField();
        passField.setBounds(100, 200, 200, 45);
        passField.setBackground(new Color(102, 102, 102));
        passField.setBorder(new TitledBorder(new LineBorder(Color.lightGray, 1), "Password"));

        Icon passIcon = new ImageIcon("pass1.png");
        JLabel labelPass = new JLabel(passIcon);
        labelPass.setBounds(70, 210, 30, 30);
        panelE.add(passField);
        panelE.add(labelPass);

        OK = new JButton("LOG IN");
        OK.addActionListener(this);
        OK.setBounds(150, 300, 100, 30);
        OK.setBackground(Color.lightGray);
        panelE.add(OK);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == OK) {
            if (userField.getText().equals("user123") && passField.getText().equals("pass123")) {
                this.dispose();
                Meniu menu = new Meniu();
                menu.setVisible(true);
                menu.setSize(800, 400);
                menu.setLocation(800,200);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(null, "Datele introduse sunt gresite!","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

        public static void main(String args[]){
            Login mainFrame = new Login();
            mainFrame.setLocation(600,300);
            mainFrame.pack();
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}