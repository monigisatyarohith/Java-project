import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AddCandidatePage {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Voting System - Add Candidate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 360);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(245, 247, 255));
        frame.setLayout(new BorderLayout());

        // Top panel with title and buttons
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 247, 255));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton backButton = new JButton("\u2190");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setPreferredSize(new Dimension(50, 38));
        backButton.setBackground(new Color(230, 240, 250));
        backButton.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true));
        backButton.setFocusPainted(false);

        // Back button action - go back to VotingSystemUI
        backButton.addActionListener(e -> {
            frame.dispose();
            VotingSystemUI.main(new String[]{});
        });

        topPanel.add(backButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Voting System", JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 26));
        titleLabel.setForeground(new Color(40, 50, 150));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton("X");
        closeButton.setFont(new Font("Arial", Font.BOLD, 20));
        closeButton.setPreferredSize(new Dimension(50, 38));
        closeButton.setBackground(new Color(240, 200, 200));
        closeButton.setBorder(BorderFactory.createLineBorder(new Color(170, 130, 130), 2, true));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(e -> frame.dispose());
        topPanel.add(closeButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 247, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(13, 14, 13, 14);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel addLabel = new JLabel("Add Candidates");
        addLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addLabel.setForeground(new Color(25, 42, 132));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(addLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Candidate Name field
        JLabel candidateNameLabel = new JLabel("Candidate name:");
        candidateNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField candidateNameField = new JTextField(14);
        candidateNameField.setFont(new Font("Arial", Font.BOLD, 16));
        candidateNameField.setBackground(new Color(230, 240, 250));
        candidateNameField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(candidateNameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(candidateNameField, gbc);

        // Party Name field
        JLabel partyNameLabel = new JLabel("Party name:");
        partyNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JTextField partyNameField = new JTextField(14);
        partyNameField.setFont(new Font("Arial", Font.BOLD, 16));
        partyNameField.setBackground(new Color(230, 240, 250));
        partyNameField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(partyNameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(partyNameField, gbc);

        // Symbol upload button
        JLabel symbolLabel = new JLabel("Symbol:");
        symbolLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton uploadButton = new JButton("Upload file");
        uploadButton.setFont(new Font("Arial", Font.BOLD, 15));
        uploadButton.setBackground(new Color(224, 224, 255));
        uploadButton.setBorder(BorderFactory.createLineBorder(new Color(142, 142, 180), 1));
        uploadButton.setFocusPainted(false);

        final File[] uploadedFile = new File[1]; // to hold selected file reference
        uploadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                uploadedFile[0] = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Selected file:\n" + uploadedFile[0].getAbsolutePath());
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(symbolLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(uploadButton, gbc);

        // Add Button
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(new Color(140, 204, 255));
        addButton.setForeground(new Color(10, 50, 120));
        addButton.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> {
            String name = candidateNameField.getText().trim();
            String party = partyNameField.getText().trim();
            if (name.isEmpty() || party.isEmpty() || uploadedFile[0] == null) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields and upload the symbol file.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Candidate Added:\nName: " + name + "\nParty: " + party + "\nSymbol file: " + uploadedFile[0].getAbsolutePath());
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(addButton, gbc);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
