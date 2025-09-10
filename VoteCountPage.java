import javax.swing.*;
import java.awt.*;

public class VoteCountPage {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Voting System - Vote Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 340);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center screen

        // ---------- TOP PANEL ----------
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 247, 255));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        // Back Button
        JButton backButton = new JButton("\u2190");
        backButton.setFont(new Font("Arial", Font.BOLD, 22));
        backButton.setBackground(new Color(230, 240, 250));
        backButton.setForeground(new Color(40, 50, 150));
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(44, 36));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true));
        backButton.addActionListener(e -> {
            frame.dispose();
            VotingSystemUI.main(new String[]{});
        });

        // Title
        JLabel titleLabel = new JLabel("Voting System", JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 28));
        titleLabel.setForeground(new Color(40, 50, 150));

        // Close Button
        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setBackground(new Color(240, 200, 200));
        closeButton.setForeground(new Color(120, 50, 60));
        closeButton.setFocusPainted(false);
        closeButton.setPreferredSize(new Dimension(44, 36));
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(170, 130, 130), 2, true));
        closeButton.addActionListener(e -> frame.dispose());

        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(closeButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        // ---------- CENTER PANEL - Vote Counts ----------
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(245, 247, 255));
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(14, 20, 14, 20);
        gbc.anchor = GridBagConstraints.WEST;

        String[] partyNames = {"BJP", "Congress", "JDU", "AAP"};
        String[] partyVotes = {"180", "85", "30", "45"};
        Font fieldFont = new Font("Arial", Font.BOLD, 22);
        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        for (int i = 0; i < partyNames.length; i++) {
            JLabel nameLabel = new JLabel(partyNames[i] + " :");
            nameLabel.setFont(labelFont);
            nameLabel.setForeground(new Color(40, 50, 150));
            JTextField voteField = new JTextField(partyVotes[i], 5);
            voteField.setFont(fieldFont);
            voteField.setHorizontalAlignment(JTextField.CENTER);
            voteField.setEditable(false);
            voteField.setBackground(new Color(230, 240, 250));
            voteField.setForeground(new Color(25, 25, 112));
            voteField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));

            gbc.gridx = 0;
            gbc.gridy = i;
            centerPanel.add(nameLabel, gbc);

            gbc.gridx = 1;
            centerPanel.add(voteField, gbc);
        }

        frame.add(centerPanel, BorderLayout.CENTER);

        // ---------- FRAME VISIBLE ----------
        frame.setVisible(true);
    }
}
