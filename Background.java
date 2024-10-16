import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Background extends JPanel {
    private ArrayList<Integer> nums;

    public Background(ArrayList<Integer> array) {
        nums = array;
        this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int barWidth = Math.max(1, getWidth() / (2 * nums.size()));
        int xOffset = 10;
        int spacing = barWidth / 2;
        
        for (int idx = 0; idx < nums.size(); idx++) {
            g.setColor(Color.blue);
            int height = nums.get(idx);
            int xPosition = xOffset + (barWidth + spacing) * idx;
            int yPosition = getHeight() - height;
            g.fillRect(xPosition, yPosition, barWidth, height);
        }
    }

    public void updateArray(ArrayList<Integer> array) {
        nums = array;
        repaint();
    }
}
