import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserPage extends JFrame {

    private final String username;
    private final List<Tour> tours;
    private final DefaultListModel<String> tourListModel;
    private final JList<String> tourList;
    private final JTextField minPriceField;
    private final JTextField maxPriceField;
    private final JTextField searchField;

    private final JLabel welcomeLabel;

    public UserPage(String username) {
        this.username = username;

        setTitle("User Page");
        setSize(1280, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Panel for search and filter
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JLabel minPriceLabel = new JLabel("Min Price:");
        searchPanel.add(minPriceLabel);

        minPriceField = new JTextField(10);
        searchPanel.add(minPriceField);

        JLabel maxPriceLabel = new JLabel("Max Price:");
        searchPanel.add(maxPriceLabel);

        maxPriceField = new JTextField(10);
        searchPanel.add(maxPriceField);

        JLabel searchLabel = new JLabel("Search:");
        searchPanel.add(searchLabel);

        searchField = new JTextField(20);
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(Color.ORANGE);
        searchButton.addActionListener(e -> filterTours());
        searchPanel.add(searchButton);

        JButton filterButton = new JButton("Filter");
        filterButton.setForeground(Color.BLACK);
        filterButton.setBackground(Color.ORANGE);
        filterButton.addActionListener(e -> filterToursByPrice());
        searchPanel.add(filterButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setForeground(Color.BLACK);
        resetButton.setBackground(Color.ORANGE);
        resetButton.addActionListener(e -> resetFilters());
        searchPanel.add(resetButton);

        container.add(searchPanel, BorderLayout.NORTH);

        // Tour list
        tourListModel = new DefaultListModel<>();
        tourList = new JList<>(tourListModel);
        JScrollPane scrollPane = new JScrollPane(tourList);
        container.add(scrollPane, BorderLayout.CENTER);

        // Welcome label
        welcomeLabel = new JLabel("Welcome, " + "Saya" + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(welcomeLabel, BorderLayout.SOUTH);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.ORANGE);
        exitButton.addActionListener(e -> System.exit(0));
        container.add(exitButton, BorderLayout.SOUTH);

        // Load all tours initially
        tours = createTours();
        loadTours();
    }

    private void loadTours() {
        tourListModel.clear();
        for (Tour tour : tours) {
            tourListModel.addElement(tour.toString());
        }
    }

    private void filterToursByPrice() {
        try {
            double minPrice = Double.parseDouble(minPriceField.getText());
            double maxPrice = Double.parseDouble(maxPriceField.getText());

            tourListModel.clear();
            for (Tour tour : tours) {
                if (tour.getPrice() >= minPrice && tour.getPrice() <= maxPrice) {
                    tourListModel.addElement(tour.toString());
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid prices.");
        }
    }

    private void filterTours() {
        String query = searchField.getText().toLowerCase();
        if (!query.isEmpty()) {
            tourListModel.clear();
            for (Tour tour : tours) {
                if (tour.getName().toLowerCase().contains(query) || tour.getDestination().toLowerCase().contains(query)) {
                    tourListModel.addElement(tour.toString());
                }
            }
        }
    }

    private void resetFilters() {
        minPriceField.setText("");
        maxPriceField.setText("");
        searchField.setText("");
        loadTours();
    }

    private List<Tour> createTours() {
        List<Tour> tours = new ArrayList<>();
        tours.add(new Tour("Tour 1", "Excursion to Paris, France", 1000));
        tours.add(new Tour("Tour 2", "Travel to Rome, Italy", 1200));
        tours.add(new Tour("Tour 3", "Bali beach holidays, Indonesia", 1500));
        tours.add(new Tour("Tour 4", "Great Wall Tour, China", 5800));
        tours.add(new Tour("Tour 5", "Safari in Serengeti National Park, Tanzania", 2000));
        tours.add(new Tour("Tour 6", "Excursion to the ancient city of Machu Picchu, Peru", 900));
        tours.add(new Tour("Tour 7", "Everest Hike, Nepal", 1800));
        tours.add(new Tour("Tour 8", "Cruise to Greece and the Greek islands", 1100));
        tours.add(new Tour("Tour 9", "A trip to the Amazon, Brazil", 1300));
        tours.add(new Tour("Tour 10", "Rafting on the Nile, Egypt", 3700));
        tours.add(new Tour("Tour 11", "Excursion to Tokyo, Japan", 1500));
        tours.add(new Tour("Tour 12", "San Francisco Tour, USA", 1400));
        tours.add(new Tour("Tour 13", "Holidays in the Maldives", 4600));
        tours.add(new Tour("Tour 14", "Excursion to Dubai, UAE", 2700));
        tours.add(new Tour("Tour 15", "Travel to Australia: Sydney and the Great Barrier Reef", 1800));
        tours.add(new Tour("Tour 16", "Snowboarding in the Swiss Alps", 950));
        tours.add(new Tour("Tour 17", "Hiking in Kamchatka, Russia", 1350));
        tours.add(new Tour("Tour 18", "Holidays in Hawaii", 1250));
        tours.add(new Tour("Tour 19", "Venice and Lake Garda Tour, Italy", 1450));
        tours.add(new Tour("Tour 20", "Iceland Tour: Reykjavik and Lake Myvatn", 1650));
        return tours;
    }

    private static class Tour {
        private final String name;
        private final String destination;
        private final double price;

        public Tour(String name, String destination, double price) {
            this.name = name;
            this.destination = destination;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getDestination() {
            return destination;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " - " + destination + " - $" + price;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserPage userPage = new UserPage("Saya");
            userPage.setVisible(true);
        });
    }
}
