import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class VotingPage extends JFrame {
    private JPanel mainPanel;
    private String selectedParty = null;

    public VotingPage() {
        setTitle("Voting System");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        mainPanel.add(createPartyPanel("1. Bhartiya Janata Party (BJP)", "bjp1.png"));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(createPartyPanel("2. Congress", "congress.png"));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(createPartyPanel("3. Janta Dal (United) JDU", "jdu2.png"));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        mainPanel.add(createPartyPanel("4. Aam Aadmi Party (AAP)", "aap.png"));

        // Submit button panel
        JPanel submitPanel = new JPanel();
        submitPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JButton submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(140, 40));
        submitBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        submitBtn.setBackground(new Color(66, 133, 244));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitPanel.add(submitBtn);
        mainPanel.add(submitPanel);

        submitBtn.addActionListener(e -> {
            if (selectedParty == null) {
                JOptionPane.showMessageDialog(this, "Please select a party by clicking Vote button.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            dispose();
            new CongratulationsGraphic().setVisible(true);
        });
    }

    private JPanel createPartyPanel(String partyName, String imageFile) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.BOTH;

        JLabel nameLabel = new JLabel(partyName);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameLabel, gbc);

        JLabel logoLabel;
        try {
            ImageIcon icon = new ImageIcon(imageFile);
            if (icon.getIconWidth() > 0) {
                Image scaledImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                logoLabel = new JLabel(new ImageIcon(scaledImage));
            } else {
                logoLabel = new JLabel("[Logo Missing]");
                logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                logoLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            }
        } catch (Exception ex) {
            logoLabel = new JLabel("[Logo Missing]");
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            logoLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        }
        gbc.gridx = 1; gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(logoLabel, gbc);

        JButton voteBtn = new JButton("Vote");
        voteBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        voteBtn.setPreferredSize(new Dimension(100, 40));
        voteBtn.setBackground(new Color(25, 118, 210));
        voteBtn.setForeground(Color.WHITE);
        voteBtn.setFocusPainted(false);
        gbc.gridx = 2; gbc.weightx = 0.2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(voteBtn, gbc);

        voteBtn.addActionListener(e -> {
            selectedParty = partyName;
            JOptionPane.showMessageDialog(this, "You voted for: " + partyName,
                    "Vote Cast", JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }
}
