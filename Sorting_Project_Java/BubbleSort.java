import javax.swing.*;
import java.util.*;

public class BubbleSort extends JPanel {
    boolean swBaseed = true;
    
    public void executeBubbleSort(ArrayList<Integer> nums, Background draw, Base Base) throws InterruptedException {
        while (swBaseed) {
            swBaseed = false;
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) > nums.get(i+1)) {
                    Collections.swap(nums, i, i+1);
                    swBaseed = true;

                    Thread.sleep(15);
                    draw.removeAll();
                    draw.updateArray(nums);
                    draw.revalidate();
                    draw.paintImmediately(0,30,870,532);;
                }
            }
        }
        swBaseed = true;
        Base.needReset = true;
    }
}
