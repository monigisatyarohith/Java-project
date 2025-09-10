import javax.swing.*;
import java.awt.*;

public class CandidatesPage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Voting System - Candidates");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 480);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(245, 248, 255));
        frame.setLayout(new BorderLayout());

        // Top panel for title and buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 248, 255));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton backButton = new JButton("\u2190"); // Unicode left arrow
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setPreferredSize(new Dimension(50, 40));
        backButton.setBackground(new Color(230, 240, 250));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(130, 170, 230), 2, true));
        backButton.setFocusPainted(false);

        // Back button action - go back to VotingSystemUI
        backButton.addActionListener(e -> {
            frame.dispose();
            VotingSystemUI.main(new String[]{});
        });

        topPanel.add(backButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Voting System", JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 28));
        titleLabel.setForeground(new Color(40, 50, 150));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.setPreferredSize(new Dimension(50, 40));
        closeButton.setBackground(new Color(240, 200, 200));
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(170, 130, 130), 2, true));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> frame.dispose());
        topPanel.add(closeButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        // Main form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 248, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 8, 10, 8);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel totalLabel = new JLabel("Total no. of Candidates:");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField totalField = new JTextField("6", 10); // Default value 6
        totalField.setFont(new Font("Arial", Font.BOLD, 18));
        totalField.setBackground(new Color(230, 240, 250));
        totalField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(totalLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(totalField, gbc);

        // Pre-filled candidate data
        String[] names = {"Arjun ", "Kiaansh", "Himaja", "Dhanvi", "Jatin", "Cherish"};
        String[] ids = {"ID101", "ID102", "ID103", "ID104", "ID105", "ID106"};

        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        Font fieldFont = new Font("Arial", Font.BOLD, 16);

        for (int row = 0; row < names.length; row++) {
            JLabel nameLabel = new JLabel("Candidate name:");
            nameLabel.setFont(labelFont);
            JTextField nameField = new JTextField(names[row], 12);
            nameField.setFont(fieldFont);
            nameField.setBackground(new Color(230, 240, 250));
            nameField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));

            JLabel idLabel = new JLabel("Candidate ID:");
            idLabel.setFont(labelFont);
            JTextField idField = new JTextField(ids[row], 10);
            idField.setFont(fieldFont);
            idField.setBackground(new Color(230, 240, 250));
            idField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));

            gbc.gridx = 0;
            gbc.gridy = row + 1;
            formPanel.add(nameLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(nameField, gbc);
            gbc.gridx = 2;
            formPanel.add(idLabel, gbc);
            gbc.gridx = 3;
            formPanel.add(idField, gbc);
        }

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
