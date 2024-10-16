import javax.swing.*;
import java.util.*;

public class QuickSort extends JPanel {
    public void executeQuickSort(ArrayList<Integer> nums, Background draw, Base app) throws InterruptedException {

        quicksort(nums, 0, nums.size() - 1, draw);
        app.needReset = true; 
    }

    private void quicksort(ArrayList<Integer> nums, int lowIndex, int highIndex, Background draw) throws InterruptedException {
        if (lowIndex < highIndex) {
            int pivotIndex = partition(nums, lowIndex, highIndex, draw);
            
            quicksort(nums, lowIndex, pivotIndex - 1, draw);
            quicksort(nums, pivotIndex + 1, highIndex, draw);
        }
    }

    private int partition(ArrayList<Integer> nums, int lowIndex, int highIndex, Background draw) throws InterruptedException {
        int pivot = nums.get(highIndex);
        int i = lowIndex - 1;
        
        for (int j = lowIndex; j < highIndex; j++) {
            if (nums.get(j) <= pivot) {
                i++;
                Collections.swap(nums, i, j);
            }
            
            Thread.sleep(50); 
            draw.removeAll();
            draw.updateArray(nums);
            draw.revalidate(); 
            draw.paintImmediately(0, 30, 870, 532); 
        }

        Collections.swap(nums, i + 1, highIndex);
        
        Thread.sleep(50);
        draw.removeAll();
        draw.updateArray(nums);
        draw.revalidate();
        draw.paintImmediately(0, 30, 870, 532);

        return i + 1;
    }

}
