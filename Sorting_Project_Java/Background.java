import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Background extends JPanel {
    private ArrayList<Integer> nums;

    public Background(ArrayList<Integer> array) {
        nums = array;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int idx = 0; idx < nums.size(); idx++) {
            g.setColor(Color.blue);
            g.fillRect(10 + 15 * idx + 2 * idx, 502 - nums.get(idx), 15, nums.get(idx));
        }
    }

    public void updateArray(ArrayList<Integer> array) {
        nums = array;
        repaint();
    }
}

