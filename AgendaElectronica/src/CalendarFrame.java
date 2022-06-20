import java.util.Calendar;
import java.awt.*;
import javax.swing.*;

class CalendarFrame {
    JFrame frame;
    JPanel  panouLuna, panouZile, panouTitlu;

    String numeLuna[] = {"January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    String numeZi[] = {"S", "M", "T", "W",
            "T", "F", "S"};
    int luna,an;

    CalendarFrame(int luna, int an) {
        this.luna = luna;
        this.an = an;

        frame = new JFrame();
        frame.setSize(300,350);
        frame.setLocation(800,400);
        frame.setVisible(true);


        panouLuna = new JPanel();
        panouLuna.setSize(800,800);
        panouLuna.setBorder(BorderFactory.createLineBorder(Color.black));
        panouLuna.setLayout(new BorderLayout());
        panouLuna.setBackground(Color.WHITE);
        panouLuna.setForeground(Color.BLACK);
        panouLuna.setSize(500,500);
        frame.add(panouLuna);


        panouTitlu = new JPanel();
        panouTitlu.setBorder(BorderFactory.createLineBorder(Color.black));
        panouTitlu.setLayout(new FlowLayout());
        panouTitlu.setBackground(Color.WHITE);

        JLabel label = new JLabel(numeLuna[luna] + " " + an);
        label.setForeground(Color.black);

        panouTitlu.add(label, BorderLayout.CENTER);
        panouLuna.add(panouTitlu, BorderLayout.NORTH);

        panouZile = new JPanel();
        panouLuna.add(panouZile);
        panouZile.setLayout(new GridLayout(0, numeZi.length));

        Calendar azi = Calendar.getInstance();
        int lunaCurenta = azi.get(Calendar.MONTH);
        int anCurent = azi.get(Calendar.YEAR);
        int ziCurenta = azi.get(Calendar.DAY_OF_MONTH);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, luna);
        calendar.set(Calendar.YEAR, an);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar iterator = (Calendar) calendar.clone();
        iterator.add(Calendar.DAY_OF_MONTH, -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

        Calendar maximum = (Calendar) calendar.clone();
        maximum.add(Calendar.MONTH, +1);

        for (int i = 0; i < numeZi.length; i++) {
            JPanel dPanel = new JPanel();
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dLabel = new JLabel(numeZi[i]);
            dPanel.add(dLabel);
            panouZile.add(dPanel);
        }

        int count = 0;
        int limit = numeZi.length * 6;

        while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
            int lunaTrecuta = iterator.get(Calendar.MONTH);
            int anulTrecut = iterator.get(Calendar.YEAR);

            JPanel dPanel = new JPanel();
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();

            if ((lunaTrecuta == luna) && (anulTrecut == an)) {
                int ziuaTrecuta = iterator.get(Calendar.DAY_OF_MONTH);
                dayLabel.setText(Integer.toString(ziuaTrecuta));
                if ((lunaCurenta == luna) && (anCurent == an) && (ziCurenta == ziuaTrecuta)) {
                    dPanel.setBackground(Color.cyan);
                } else {
                    dPanel.setBackground(Color.WHITE);
                }
            } else {
                dayLabel.setText("");
                dPanel.setBackground(Color.WHITE);
            }
            dPanel.add(dayLabel);
            panouZile.add(dPanel);
            iterator.add(Calendar.DAY_OF_YEAR, +1);
            count++;
        }

        for (int i = count; i < limit; i++) {
            JPanel dPanel = new JPanel();
            dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();
            dayLabel.setText(" ");
            dPanel.setBackground(Color.WHITE);
            dPanel.add(dayLabel);
            panouZile.add(dPanel);
        }

    }

}
