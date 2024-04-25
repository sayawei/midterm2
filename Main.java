import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Main Page");
        setSize(1280, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\User\\IdeaProjects\\Magic Travel\\src\\main.png");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1280, 800);
        add(background);

        JLabel titleLabel = new JLabel("Magic Travel - Explore Your World");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setBounds(0, 20, 1300, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        background.add(titleLabel);

        JLabel exploreWorldLabel = new JLabel("Explore Your World with Magic Travel! \uD83D\uDE0A");
        exploreWorldLabel.setFont(new Font("Arial", Font.BOLD, 20));
        exploreWorldLabel.setBounds(0, 70, 1300, 80);
        exploreWorldLabel.setForeground(Color.black);
        exploreWorldLabel.setHorizontalAlignment(SwingConstants.CENTER);
        background.add(exploreWorldLabel);

        JLabel findAffordableLabel = new JLabel("Find affordable flights and amazing destinations");
        findAffordableLabel.setFont(new Font("Arial", Font.BOLD, 20));
        findAffordableLabel.setBounds(0, 100, 1300, 80);
        findAffordableLabel.setForeground(Color.black);
        findAffordableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        background.add(findAffordableLabel);

        int buttonY = 200;
        int buttonHeight = 40;
        int buttonWidth = 200;
        int buttonSpacing = 20;
        String[] buttonLabels = {"Registration", "Login", "About Us", "Contacts", "News"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBounds(900, buttonY, buttonWidth, buttonHeight);
            button.setBackground(Color.ORANGE);
            button.setForeground(Color.black);
            background.add(button);
            buttonY += buttonHeight + buttonSpacing;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(label);
                }
            });
        }

        setLayout(null);
    }

    private void handleButtonClick(String buttonLabel) {
        switch (buttonLabel) {
            case "Registration":
                SignUp signUpPage = new SignUp();
                signUpPage.setVisible(true);
                break;
            case "Login":
                SignIn signInPage = new SignIn();
                signInPage.setVisible(true);
                break;
            case "About Us":
                AboutUs aboutUsPage = new AboutUs();
                aboutUsPage.setVisible(true);
                break;
            case "Contacts":
                JOptionPane.showMessageDialog(null, "This is the Contacts page.\nYou can reach out to us at contact @magictravel.com.");
                break;
            case "News":
                JOptionPane.showMessageDialog(null, "This is the News page.\nStay tuned for our latest travel updates.");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Main mainPage = new Main();
        mainPage.setVisible(true);
    }
}
