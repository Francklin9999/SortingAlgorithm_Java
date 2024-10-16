import javax.swing.*;
import java.util.*;

public class BubbleSort extends JPanel {
    private boolean isSwapped = true;

    public void executeBubbleSort(ArrayList<Integer> numbers, Background drawer, Base base) throws InterruptedException {
        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    Collections.swap(numbers, i, i + 1);
                    isSwapped = true;

                    Thread.sleep(15);
                    drawer.removeAll();
                    drawer.updateArray(numbers);
                    drawer.revalidate();
                    drawer.paintImmediately(0, 30, 870, 532);
                }
            }
        }
        isSwapped = true;
        base.needReset = true;
    }
}

