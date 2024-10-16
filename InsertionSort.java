import javax.swing.*;
import java.util.*;

public class InsertionSort extends JPanel {

    public void executeInsertionSort(ArrayList<Integer> numbers, Background drawer, Base app) throws InterruptedException {
        for (int i = 1; i < numbers.size(); i++) {
            int currentIndex = i;
            int previousIndex = currentIndex - 1;

            while (previousIndex >= 0 && numbers.get(previousIndex) > numbers.get(currentIndex)) {
                Collections.swap(numbers, previousIndex, currentIndex);
                currentIndex--;
                previousIndex--;

                Thread.sleep(20);
                drawer.removeAll();
                drawer.updateArray(numbers);
                drawer.revalidate();
                drawer.paintImmediately(0, 30, 870, 532);
            }
        }
        app.needReset = true;
    }
}
