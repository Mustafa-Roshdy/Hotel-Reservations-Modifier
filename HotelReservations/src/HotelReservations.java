import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HotelReservations extends JFrame {
    private JPanel mainPage, secondPage, thirdPage;
    private JTextField nameField, idField;
    private JComboBox<String> arrivalDateBox, leaveDateBox;
    private JButton nextPageButton1, nextPageButton2, closeButton;
    private JCheckBox[] doorCheckboxes;
    private JLabel arrivalDateLabel, leaveDateLabel;

    public HotelReservations() {
        // Set up the main page
        mainPage = new JPanel();
        mainPage.setBackground(Color.ORANGE);
        mainPage.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Hotel Reservations");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 80));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPage.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        JLabel name = new JLabel("Name:");
        formPanel.add(name);
        name.setFont(new Font("Arial", Font.BOLD, 50));
        nameField = new JTextField();
        formPanel.add(nameField);

        JLabel id = new JLabel("ID:");
        formPanel.add(id);
        id.setFont(new Font("Arial", Font.BOLD, 50));
        idField = new JTextField();
        formPanel.add(idField);

        JLabel arrivalDate = new JLabel("Arrival Date:");
        formPanel.add(arrivalDate);
        arrivalDate.setFont(new Font("Arial", Font.BOLD, 50));
        String[] arrivalDates = {"2023-12-10", "2023-12-11", "2023-12-12"};
        arrivalDateBox = new JComboBox<>(arrivalDates);
        formPanel.add(arrivalDateBox);

        JLabel leaveDate = new JLabel("Leaving Date:");
        formPanel.add(leaveDate);
        leaveDate.setFont(new Font("Arial", Font.BOLD, 50));
        String[] leaveDates = {"2023-12-13", "2023-12-14", "2023-12-15"};
        leaveDateBox = new JComboBox<>(leaveDates);
        formPanel.add(leaveDateBox);

        mainPage.add(formPanel, BorderLayout.CENTER);

        nextPageButton1 = new JButton("Next");
        nextPageButton1.setBackground(Color.black);
        nextPageButton1.setForeground(Color.white);
        nextPageButton1.setFont(new Font("Arial", Font.BOLD, 50));
        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage1();
            }
        });
        mainPage.add(nextPageButton1, BorderLayout.SOUTH);

        // Set up the second page
        secondPage = new JPanel();
        secondPage.setBackground(Color.ORANGE);
        secondPage.setLayout(new BorderLayout());
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(4, 2));
        doorCheckboxes = new JCheckBox[20];
        for (int i = 0; i < 20; i++) {
            doorCheckboxes[i] = new JCheckBox("Door " + (i + 1));
            secondPanel.add(doorCheckboxes[i]);
        }

        nextPageButton2 = new JButton("Next");
        nextPageButton2.setBackground(Color.black);
        nextPageButton2.setForeground(Color.white);
        nextPageButton2.setFont(new Font("Arial", Font.BOLD, 50));
        nextPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage2();
            }
        });
        secondPanel.add(nextPageButton2);
        secondPage.add(secondPanel, BorderLayout.CENTER);
        secondPage.add(secondPanel);
        secondPage.add(nextPageButton2, BorderLayout.SOUTH);

        // Set up the third page
        thirdPage = new JPanel();
        thirdPage.setBackground(Color.ORANGE);
        thirdPage.setLayout(new BorderLayout());
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new GridLayout(4, 2));

        JLabel messageLabel = new JLabel("Thank you for using our app!");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPanel.add(messageLabel);
        thirdPage.add(messageLabel, BorderLayout.NORTH);

        arrivalDateLabel = new JLabel();
        thirdPanel.add(arrivalDateLabel);

        leaveDateLabel = new JLabel();
        thirdPanel.add(leaveDateLabel);

        messageLabel.setFont(new Font("Arial", Font.BOLD, 50));
        arrivalDateLabel.setFont(new Font("Arial", Font.BOLD, 50));
        leaveDateLabel.setFont(new Font("Arial", Font.BOLD, 50));

        closeButton = new JButton("Close");
        closeButton.setBackground(Color.black);
        closeButton.setForeground(Color.white);
        closeButton.setFont(new Font("Arial", Font.BOLD, 50));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeApp();
            }
        });
        thirdPanel.add(closeButton);
        thirdPage.add(thirdPanel, BorderLayout.CENTER);
        thirdPage.add(thirdPanel);
        thirdPage.add(closeButton, BorderLayout.SOUTH);

        // Set up the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        switchToMainPage();
    }

    private void switchToMainPage() {
        getContentPane().removeAll();
        getContentPane().add(mainPage);
        setTitle("Hotel Reservations");
        setVisible(true);
    }

    private void switchToSecondPage() {
        getContentPane().removeAll();
        getContentPane().add(secondPage);
        setTitle("Hotel Reservations");
        setVisible(true);
    }

    private void switchToThirdPage() {
        getContentPane().removeAll();
        getContentPane().add(thirdPage);
        setTitle("Hotel Reservations");
        setVisible(true);
    }

    private void nextPage1() {
        String name = nameField.getText();
        String id = idField.getText();
        String arrivalDate = arrivalDateBox.getSelectedItem().toString();
        String leaveDate = leaveDateBox.getSelectedItem().toString();

        // Create a process to handle the task
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new ProcessTask(name));
        executor.submit(new ThreadTask(name));

        arrivalDateLabel.setText("Arrival Date: " + arrivalDate);
        leaveDateLabel.setText("Leave Date: " + leaveDate);

        switchToSecondPage();
    }

    private void nextPage2() {
        switchToThirdPage();
    }

    private void closeApp() {
        System.exit(0);
    }

    private class ProcessTask implements Runnable {
        private final String name;

        public ProcessTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task on thread 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Executing task on thread 2");
        }
    }

    private class ThreadTask implements Runnable {
        private final String name;

        public ThreadTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task on thread 3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Executing task on thread 4");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                long start= System.currentTimeMillis();
                new HotelReservations();
                long stop = System.currentTimeMillis();
                System.out.println("Time task take is : "+ (stop-start));
            }
        });
    }
}