import javax.swing.*;
import java.util.*;

public class SelectionSort extends JPanel {

    public void executeSelectionSort(ArrayList<Integer> numbers, Background drawer, Base base) throws InterruptedException {
        int anchorIndex = 0;

        while (anchorIndex < numbers.size() - 1) {
            int lowestValue = numbers.get(anchorIndex);
            int lowestIndex = anchorIndex;

            for (int i = anchorIndex + 1; i < numbers.size(); i++) {
                if (numbers.get(i) < lowestValue) {
                    lowestValue = numbers.get(i);
                    lowestIndex = i;
                }
            }
            Collections.swap(numbers, anchorIndex, lowestIndex);
            anchorIndex++;

            Thread.sleep(150);
            drawer.removeAll();
            drawer.updateArray(numbers);
            drawer.revalidate();
            drawer.paintImmediately(0, 30, 870, 532);
        }
        base.needReset = true;
    }
}
