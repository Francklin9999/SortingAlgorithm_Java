import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private int noComparisons;

    public void executeMergeSort(ArrayList<Integer> nums, Background draw, Base Base) throws InterruptedException {
        noComparisons = 0;
        mergeSort(nums, draw, 0, nums.size() - 1, Base);
        Base.needReset = true;
        Base.noComparisonsMerge = noComparisons;
    }

    public void mergeSort(List<Integer> array, Background draw, int left, int right, Base Base) throws InterruptedException {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, draw, left, mid, Base);
            mergeSort(array, draw, mid + 1, right, Base);
            merge(array, draw, left, mid, right, Base);
        }
    }

    public void merge(List<Integer> array, Background draw, int left, int mid, int right, Base Base) throws InterruptedException {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> leftArray = Arrays.asList(new Integer[n1]);
        List<Integer> rightArray = Arrays.asList(new Integer[n2]);

        for (int i = 0; i < n1; i++) {
            leftArray.set(i, array.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightArray.set(j, array.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            noComparisons++;
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;

            draw.updateArray((ArrayList<Integer>) array);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(50);
        }

        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;

            draw.updateArray((ArrayList<Integer>) array);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(50);
        }

        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;

            draw.updateArray((ArrayList<Integer>) array);
            draw.paintImmediately(0, 30, 870, 532);
            Thread.sleep(50);
        }
    }
}