import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends JFrame {
    private final JButton backButton;

    public AboutUs() {
        setTitle("About Us");
        setSize(1280, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\User\\IdeaProjects\\Magic Travel\\src\\about.png");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1280, 800);
        add(background);

        JLabel titleLabel = new JLabel("About Us");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setBounds(500, 50, 500, 60);
        background.add(titleLabel);

        JTextArea aboutUsText = new JTextArea();
        aboutUsText.setText("Magic Travel is your ultimate travel companion, \n" +
                "providing you with unforgettable experiences and seamless journeys.\n"
                + "Our innovative platform offers a wide range of services, \n" +
                "including flight bookings, hotel reservations, and tour packages.\n"
                + "With Magic Travel, you can explore the world with confidence, \n" +
                "knowing that every aspect of your trip is taken care of.\n"
                + "Whether you're planning a relaxing beach getaway or \n" +
                "an adventurous trekking expedition, we've got you covered.\n"
                + "Join Magic Travel today and embark \n" +
                "on your next adventure!\n\n"
                + "For inquiries and bookings, \n" +
                "please contact our dedicated team:\n\n"
                + "Manager: Mustafa Zhansaya\n"
                + "Email: saya_m@gmail.com\n");
        aboutUsText.setFont(new Font("Arial", Font.PLAIN, 22));
        aboutUsText.setBounds(50, 120, 550, 500);
        aboutUsText.setEditable(false);
        aboutUsText.setOpaque(false);
        background.add(aboutUsText);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 22));
        backButton.setSize(250, 40);
        backButton.setLocation(250, 600);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.white);
        background.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                Main mainPageFrame = new Main();
                mainPageFrame.setVisible(true);
            }
        });

        setLayout(null);
    }

    public static void main(String[] args) {
        AboutUs aboutUsPage = new AboutUs();
        aboutUsPage.setVisible(true);
    }
}