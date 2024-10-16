import javax.swing.*;
import java.util.*;

public class HeapSort extends JPanel {

    public void executeHeapSort(ArrayList<Integer> nums, Background draw, Base app) throws InterruptedException {
        for (int i = nums.size() / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.size(), i, draw);
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            Collections.swap(nums, 0, i);

            heapify(nums, i, 0, draw);

            Thread.sleep(50);
            draw.removeAll();
            draw.updateArray(nums);
            draw.revalidate();
            draw.paintImmediately(0, 30, 870, 532);
        }
        app.needReset = true;
    }

    private void heapify(ArrayList<Integer> nums, int n, int i, Background draw) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums.get(left) > nums.get(largest)) {
            largest = left;
        }

        if (right < n && nums.get(right) > nums.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            Collections.swap(nums, i, largest);

            heapify(nums, n, largest, draw);
        }
    }
}
