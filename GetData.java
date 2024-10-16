import java.util.ArrayList;
import java.util.Collections;

public class GetData {
    public ArrayList<Integer> createArray() {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i < 51; i++) {
            nums.add(9 * i);
        }
        Collections.shuffle(nums);

        return nums;
    }

}
