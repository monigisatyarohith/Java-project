import javax.swing.*;
import java.awt.*;
class CongratulationsGraphic extends JFrame {
    public CongratulationsGraphic() {
        setTitle("Thank You!");
        setSize(900, 780);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Congrats drawing panel
        CongratsPanel congratsPanel = new CongratsPanel();
        congratsPanel.setPreferredSize(new Dimension(800, 350));
        add(congratsPanel, BorderLayout.CENTER);

        // Confirmation message label
        JLabel messageLabel = new JLabel("Your vote has been submitted successfully.");
        messageLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        messageLabel.setForeground(new Color(90, 80, 100));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        add(messageLabel, BorderLayout.SOUTH);
    }

    static class CongratsPanel extends JPanel {
        public CongratsPanel() {
            setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            int cx = w / 2 + 40, cy = h / 2 + 25;

            // Draw confetti pieces, stars, arcs, dots (same as before)
            drawConfetti(g2, cx, cy);

            // Draw "Congratulations!" text in black script
            String congrats = "Congratulations!";
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Brush Script MT", Font.BOLD, 90));
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(congrats);
            int textX = w / 2 - textWidth / 2;
            int textY = h / 2 + 60;
            g2.drawString(congrats, textX, textY);
        }

        private void drawConfetti(Graphics2D g2, int cx, int cy) {
            g2.setStroke(new BasicStroke(7f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.setColor(new Color(243, 178, 38)); // gold
            g2.drawLine(cx - 200, cy - 20, cx - 120, cy - 20);
            g2.drawLine(cx + 180, cy - 60, cx + 70, cy - 34);

            g2.setColor(new Color(32, 161, 61)); // green
            g2.drawLine(cx - 120, cy - 48, cx - 60, cy - 48);

            g2.setColor(new Color(36, 170, 229)); // blue
            g2.drawLine(cx - 150, cy + 13, cx - 90, cy + 29);
            g2.drawLine(cx + 47, cy + 65, cx + 120, cy + 90);

            g2.setColor(new Color(139, 107, 224)); // purple
            g2.drawLine(cx + 20, cy - 63, cx + 90, cy - 92);
            g2.drawLine(cx + 90, cy - 25, cx + 157, cy - 37);

            g2.setColor(new Color(243, 178, 38)); // gold
            g2.drawLine(cx, cy - 80, cx, cy - 150);

            g2.setColor(new Color(36, 170, 229));
            g2.drawLine(cx + 50, cy - 25, cx + 140, cy - 53);

            g2.setStroke(new BasicStroke(5f));
            g2.setColor(new Color(243, 178, 38)); // gold
            g2.drawLine(cx - 110, cy + 48, cx - 70, cy + 49);
            g2.drawLine(cx - 50, cy - 90, cx - 22, cy - 80);

            g2.setColor(new Color(36, 170, 229));
            g2.drawLine(cx - 28, cy + 86, cx + 18, cy + 93);

            g2.setColor(new Color(243, 178, 38));
            g2.drawLine(cx + 100, cy + 25, cx + 138, cy + 38);

            g2.setColor(new Color(32, 161, 61));
            g2.drawLine(cx + 160, cy + 24, cx + 205, cy + 32);

            g2.setStroke(new BasicStroke(4f));
            g2.setColor(new Color(224, 45, 126)); // pink circles
            g2.drawOval(cx - 230, cy + 35, 22, 22);
            g2.drawOval(cx - 150, cy - 110, 12, 12);
            g2.drawOval(cx + 195, cy - 105, 14, 14);

            g2.setColor(new Color(243, 178, 38));
            g2.drawOval(cx - 180, cy + 85, 15, 15);
            g2.drawOval(cx + 120, cy + 88, 17, 17);

            g2.setStroke(new BasicStroke(6f));
            g2.setColor(new Color(139, 107, 224));
            g2.drawLine(cx + 145, cy - 90, cx + 165, cy - 100);
            g2.drawLine(cx + 120, cy + 60, cx + 135, cy + 110);

            g2.setColor(new Color(243, 178, 38)); // stars
            drawStar(g2, cx - 210, cy - 43, 9);
            drawStar(g2, cx - 70, cy + 26, 8);
            drawStar(g2, cx + 50, cy - 120, 7);
            drawStar(g2, cx + 110, cy - 80, 8);
            drawStar(g2, cx + 200, cy + 18, 8);

            g2.setColor(new Color(36, 170, 229)); // blue star
            drawStar(g2, cx - 70, cy - 110, 8);

            g2.setColor(new Color(224, 45, 126)); // pink star
            drawStar(g2, cx + 220, cy - 10, 9);

            // Red burst
            g2.setColor(new Color(224, 45, 126));
            g2.setStroke(new BasicStroke(3f));
            g2.drawLine(cx + 260, cy + 60, cx + 270, cy + 50);
            g2.drawLine(cx + 265, cy + 55, cx + 258, cy + 67);
            g2.drawLine(cx + 264, cy + 52, cx + 275, cy + 62);

            // Gold burst
            g2.setColor(new Color(243, 178, 38));
            g2.setStroke(new BasicStroke(3f));
            g2.drawLine(cx - 135, cy - 88, cx - 145, cy - 78);
            g2.drawLine(cx - 140, cy - 83, cx - 133, cy - 95);

            // Center gold scribble star effect
            g2.setColor(new Color(243, 178, 38));
            for (int i = -18; i <= 18; i += 7) {
                g2.setStroke(new BasicStroke(3f));
                g2.drawLine(cx + i, cy - 24, cx + i, cy - 34);
            }
        }

        private void drawStar(Graphics2D g2, int x, int y, int r) {
            Polygon star = new Polygon();
            for (int i = 0; i < 10; i++) {
                double angle = Math.PI / 5 * i;
                int ring = (i % 2 == 0) ? r : r / 2;
                star.addPoint(x + (int) (Math.sin(angle) * ring),
                              y - (int) (Math.cos(angle) * ring));
            }
            g2.fillPolygon(star);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CongratulationsGraphic().setVisible(true));
    }
}
