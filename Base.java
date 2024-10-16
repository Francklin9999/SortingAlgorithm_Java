import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Base extends JFrame implements ActionListener {

    JComboBox algosDropdown;
    JLabel lblTtl;
    JLabel name;
    String selectedAlgo = "";
    JPanel panelUpper = new JPanel();
    GetData newArray = new GetData();
    ArrayList<Integer> array = newArray.createArray();
    Background draw = new Background(array);

    JButton start;
    JButton reset;

    BubbleSort bubble = new BubbleSort();
    SelectionSort selection = new SelectionSort();
    InsertionSort insertion = new InsertionSort();
    MergeSort merge = new MergeSort();
    HeapSort heap = new HeapSort();
    QuickSort quick = new QuickSort();

    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel arrayAccessesLabel;

    int noComparisons = 0;
    int noArrAccess = 0;

    boolean needReset = false;
    public int noComparisonsMerge;

    private Map<String, String[]> algorithmsMap = new HashMap<>() {{
        put("Bubble Sort", new String[]{"Bubble", "Runtime: n**2"});
        put("Insertion Sort", new String[]{"Insertion", "Runtime: n**2"});
        put("Heap Sort", new String[]{"Heap", "Runtime: nlog(n)"});
        put("Merge Sort", new String[]{"Merge", "Runtime: nlog(n)"});
        put("Selection Sort", new String[]{"Selection", "Runtime: n**2"});
        put("Quick Sort", new String[]{"Quick", "Runtime: nlog(n)"});
    }};

    public Base() {

        this.setTitle("Sorting an Algorithms");
        this.setSize(new Dimension(950, 622));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTtl = new JLabel("Sorting an Algorithms");
        lblTtl.setBounds(235,0,400,60);
        lblTtl.setFont(new Font("Cascade Firm", Font.BOLD, 30));
        lblTtl.setForeground(Color.black);
        panelUpper.add(lblTtl);

        name = new JLabel("Franck Fongang");
        name.setBounds(327,50,206,40);
        name.setFont(new Font("Cascade Firm", Font.BOLD, 20));
        name.setForeground(Color.black);
        panelUpper.add(name);

        runtimeLabel = new JLabel("Runtime: null");
        runtimeLabel.setBounds(10,10,200,30);
        runtimeLabel.setFont(new Font("Cascade Firm", Font.BOLD, 15));
        runtimeLabel.setForeground(Color.black);
        panelUpper.add(runtimeLabel);

        String[] algorithms = {"Select an Algorithm", "Bubble Sort", "Insertion Sort", "Heap Sort", "Merge Sort", "Selection Sort", "Quick Sort"};
        algosDropdown = new JComboBox<>(algorithms);
        algosDropdown.setBounds(690,0,155,30);
        algosDropdown.addActionListener(this);
        panelUpper.add(algosDropdown);

        start = new JButton("Sort");
        start.setBounds(700, 30, 140,30);
        start.addActionListener(this);
        panelUpper.add(start);

        reset = new JButton("Shuffle");
        reset.setBounds(700, 60, 140, 30);
        reset.addActionListener(this);
        panelUpper.add(reset);

        panelUpper.setBounds(0,0,1000,100);
        draw.setBounds(0,100,1000,522);
        panelUpper.setBackground(Color.green);
        draw.setBackground(Color.green);
        panelUpper.setLayout(new BorderLayout());
        this.add(draw);
        this.add(panelUpper);
        this.validate();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start & algosDropdown.getSelectedItem() != "Select an Algorithm" & !needReset) {
            if (selectedAlgo =="Bubble") {
                try {
                    bubble.executeBubbleSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Selection") {
                try {
                    selection.executeSelectionSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Insertion") {
                try {
                    insertion.executeInsertionSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Merge") {
                try {
                    merge.executeMergeSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo == "Heap") {
                try {
                    heap.executeHeapSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo == "Quick") {
                try {
                    quick.executeQuickSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } 
        }
            if (e.getSource() == reset) {
                array = newArray.createArray();
                draw.updateArray(array);
                draw.repaint();
                needReset = false;
            }
        if (e.getSource() == algosDropdown)  {
            String selectedItem = (String) algosDropdown.getSelectedItem();
            if (algorithmsMap.containsKey(selectedItem)) {
                String[] algoInfo = algorithmsMap.get(selectedItem);
                selectedAlgo = algoInfo[0];
                runtimeLabel.setText(algoInfo[1]);
            }
        }

    }
}

