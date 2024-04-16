import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Base extends JFrame implements ActionListener {

     @SuppressWarnings("rawtypes")
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
    TreeSort tree = new TreeSort();

    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel arrayAccessesLabel;

    int noComparisons = 0;
    int noArrAccess = 0;

    boolean needReset = false;
    public int noComparisonsMerge;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Base(){

        this.setTitle("Sorting Algorithms");
        this.setSize(new Dimension(870, 622));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTtl = new JLabel("Sorting Algorithms");
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

        String[] algorithms = {"Select Algorithm", "Bubble Sort", "Insertion Sort", "Heap Sort", "Merge Sort", "Selection Sort", "Tree Sort"};
        algosDropdown = new JComboBox(algorithms);
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

        panelUpper.setBounds(0,0,870,100);
        draw.setBounds(0,100,870,522);
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
        if (e.getSource()==start & algosDropdown.getSelectedItem() != "Select Algorithm" & !needReset) {
            if (selectedAlgo.equals("Bubble")) {
                System.out.println("A");
                try {
                    bubble.executeBubbleSort(array, draw, this);
                    System.out.println("B");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    System.out.println("C");
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
            } else if (selectedAlgo == "Tree") {
                try {
                    tree.executeTreeSort(array, draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } 
        }
            if (e.getSource()==reset) {
                array = newArray.createArray();
                draw.updateArray(array);
                draw.repaint();
                needReset = false;

            }
        if (e.getSource()==algosDropdown) {
            System.out.println(algosDropdown.getSelectedItem());
            if (algosDropdown.getSelectedItem() == "Bubble Sort") {
                selectedAlgo = "Bubble";
                runtimeLabel.setText("Runtime: n**2");

            } else if (algosDropdown.getSelectedItem() == "Insertion Sort") {
                selectedAlgo = "Insertion";
                runtimeLabel.setText("Runtime: n**2");

            } else if (algosDropdown.getSelectedItem() == "Heap Sort") {
                selectedAlgo = "Heap";
                runtimeLabel.setText("Runtime: nlog(n)");

            } else if (algosDropdown.getSelectedItem() == "Merge Sort") {
                selectedAlgo = "Merge";
                runtimeLabel.setText("Runtime: nlog(n)");

            } else if (algosDropdown.getSelectedItem() == "Selection Sort") {
                selectedAlgo = "Selection";
                runtimeLabel.setText("Runtime: n**2)");

            } else if (algosDropdown.getSelectedItem() == "Tree Sort") {
                selectedAlgo = "Tree";
                runtimeLabel.setText("Runtime: nlog(n)");
            } 
        }

    }
}

