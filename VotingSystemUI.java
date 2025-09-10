import javax.swing.*;
import java.awt.*;

public class VotingSystemUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Voting System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Voting System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 40, 40));

        JButton viewVotesBtn = new JButton("View Votes");
        JButton viewVotersBtn = new JButton("View Voters");
        JButton addCandidateBtn = new JButton("Add Candidate");

        Font btnFont = new Font("Arial", Font.PLAIN, 16);
        viewVotesBtn.setFont(btnFont);
        viewVotersBtn.setFont(btnFont);
        addCandidateBtn.setFont(btnFont);

        viewVotesBtn.setBackground(new Color(100, 149, 237));
        viewVotesBtn.setForeground(Color.WHITE);
        viewVotersBtn.setBackground(new Color(60, 179, 113));
        viewVotersBtn.setForeground(Color.WHITE);
        addCandidateBtn.setBackground(new Color(255, 165, 0));
        addCandidateBtn.setForeground(Color.WHITE);

        // Navigation Button Actions
        addCandidateBtn.addActionListener(e -> {
            frame.dispose();
            AddCandidatePage.main(new String[] {});
        });

        viewVotersBtn.addActionListener(e -> {
            frame.dispose();
            CandidatesPage.main(new String[] {});
        });

        viewVotesBtn.addActionListener(e -> {
            frame.dispose();
            VoteCountPage.main(new String[] {});
        });

        buttonPanel.add(viewVotesBtn);
        buttonPanel.add(viewVotersBtn);
        buttonPanel.add(new JLabel()); // Empty cell for alignment
        buttonPanel.add(addCandidateBtn);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
