import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

class Ceas implements ActionListener{
    JFrame frame;
    JPanel panou;


    SimpleDateFormat timeFormat;
    JLabel timeLabel, setAlarm, hourLabel, minuteLabel;
    JTextField hourField, minuteField;
    String time;
    JButton setAlarmButton;

    int hour = 0, minute = 0;

    Ceas() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setLocation(800, 500);

        panou = new JPanel();
        panou.setLayout(null);
        panou.setBorder(BorderFactory.createSoftBevelBorder(1));
        panou.setBackground(Color.lightGray);
        panou.setBounds(45, 150, 300, 150);

        timeFormat = new SimpleDateFormat("hh:mm a");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setBounds(65, 30, 250, 50);

        setAlarm = new JLabel("Set Alarm");
        setAlarm.setBounds(115, 5, 60, 30);

        hourLabel = new JLabel("HH");
        hourLabel.setBounds(70, 30, 50, 50);

        hourField = new JTextField();
        hourField.setBounds(90, 45, 50, 20);


        minuteLabel = new JLabel("MM");
        minuteLabel.setBounds(150, 30, 50, 50);

        minuteField = new JTextField();
        minuteField.setBounds(175, 45, 50, 20);

        setAlarmButton = new JButton("Set Alarm!");
        setAlarmButton.addActionListener(this);
        setAlarmButton.setBounds(100, 90, 100, 30);


        panou.add(setAlarmButton);
        panou.add(setAlarm);
        panou.add(hourLabel);
        panou.add(hourField);
        panou.add(minuteLabel);
        panou.add(minuteField);

        frame.add(panou);
        frame.add(timeLabel);
        frame.setVisible(true);
        setTime();
    }

    public void actionPerformed(ActionEvent event){
        if (event.getSource() == setAlarmButton) {
            if (hourField.getText() != "" && minuteField.getText() != ""){
                setAlarm();
            }
        }
    }

    public void setTime() {
        time = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);
    }

    public void setAlarm() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        hour = Integer.parseInt(hourField.getText()); //
        minute = Integer.parseInt(minuteField.getText());

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){//sarcina care poate fi programata de un timer pentru o singura executie sau o executie repetata la un moment dat
          public void run(){
              JOptionPane.showMessageDialog(null, "ALARMA",null, JOptionPane.INFORMATION_MESSAGE);
          }
        };

        Calendar alarma = Calendar.getInstance();

        alarma.set(Calendar.HOUR_OF_DAY,hour);
        alarma.set(Calendar.MINUTE, minute);
        alarma.set(Calendar.SECOND, 0);
        alarma.set(Calendar.MILLISECOND,0);
        alarma.set(Calendar.YEAR, year);
        alarma.set(Calendar.MONTH, month);
        alarma.set(Calendar.DAY_OF_MONTH,day);

        timer.schedule(task, alarma.getTime());
    }

}