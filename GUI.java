import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class GUI {
	
	public static final int WIN_WIDTH = 1750;
    public static final int	WIN_HEIGHT = 850;
    
    private JFrame window;
    
    JPanel userBar = new JPanel();
    JLabel options = new JLabel("OPERATIONS");
    JLabel shuffleList = new JLabel ("Shuffle Data:");
    JLabel bubbleSelect = new JLabel ("Bubble Sort:");
    JLabel selectionSelect = new JLabel ("Selection Sort:");
    JLabel quickSelect = new JLabel ("Quick Sort:");
    JLabel radixSelect = new JLabel ("Radix Sort:");
    JLabel mergeSelect = new JLabel ("Merge Sort:");
    JLabel heapSelect = new JLabel ("Heap Sort:");
    JLabel insertionSelect = new JLabel ("Insertion Sort:");
    JLabel bogoSelect = new JLabel ("BOGO Sort:");
    
    
    JButton shuffle = new JButton("Shuffle Data");
    JButton bubble = new JButton("Bubble Sort");
    JButton selection = new JButton("Selection Sort");
    JButton quick = new JButton("Quick Sort");
    JButton radix = new JButton("Radix Sort");
    JButton merge = new JButton("Merge Sort");
    JButton heap = new JButton("Heap Sort");
    JButton insertion = new JButton("Insertion Sort");
    JButton bogo = new JButton("BOGO Sort");
    JButton exit = new JButton("EXIT");

    SortingAlgo sortingAlgo;
	
	
	public GUI()
	{
		//set up window
		window = new JFrame("Sorting Algorithms Visualized!");
		window.setSize(WIN_WIDTH, WIN_HEIGHT);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.getContentPane().setLayout(null);
		
		//create user bar for operations
		userBar.setLayout(null);
		userBar.setBounds(0, 0, 250, 850);
		userBar.setBorder(BorderFactory.createEtchedBorder());
		userBar.setBackground(new Color(207, 207, 207));
	
		//add title to userbar
		options.setHorizontalAlignment(JLabel.CENTER);
		options.setBounds(40,20,160,25);
		userBar.add(options);
		
		//add shuffle label
		shuffleList.setHorizontalAlignment(JLabel.LEFT);
		shuffleList.setBounds(5, 60, 100, 25);
		userBar.add(shuffleList);
		
		//add shuffle button
		shuffle.setBounds(100, 60, 125, 25);
		userBar.add(shuffle);
		
		//add bubble sort label
		bubbleSelect.setHorizontalAlignment(JLabel.LEFT);
		bubbleSelect.setBounds(5, 120, 100, 25);
		userBar.add(bubbleSelect);
		
		//add bubble sort button
		bubble.setBounds(100,120,125,25);
		userBar.add(bubble);
		
		//add selection sort label
		selectionSelect.setHorizontalAlignment(JLabel.LEFT);
		selectionSelect.setBounds(5, 180, 125, 25);
		userBar.add(selectionSelect);
		
		//add selection sort button
		selection.setBounds(100,180,125,25);
		userBar.add(selection);
		
		//add quick sort label
		insertionSelect.setHorizontalAlignment(JLabel.LEFT);
		insertionSelect.setBounds(5, 240, 125, 25);
		userBar.add(insertionSelect);
		
		//add quick sort button
		insertion.setBounds(100,240,125,25);
		userBar.add(insertion);
		
		//add radix sort label
		radixSelect.setHorizontalAlignment(JLabel.LEFT);
		radixSelect.setBounds(5, 300, 125, 25);
		userBar.add(radixSelect);
		
		//add radix sort button
		radix.setBounds(100,300,125,25);
		userBar.add(radix);
		
		//add merge sort label
		mergeSelect.setHorizontalAlignment(JLabel.LEFT);
		mergeSelect.setBounds(5, 360, 125, 25);
		userBar.add(mergeSelect);
				
		//add merg sort button
		merge.setBounds(100,360,125,25);
		userBar.add(merge);
		
		//add heap sort label
		heapSelect.setHorizontalAlignment(JLabel.LEFT);
		heapSelect.setBounds(5, 420, 125, 25);
		userBar.add(heapSelect);
						
		//add heap sort button
		heap.setBounds(100,420,125,25);
		userBar.add(heap);
				
		//add insertion sort label
		quickSelect.setHorizontalAlignment(JLabel.LEFT);
		quickSelect.setBounds(5, 480, 125, 25);
		userBar.add(quickSelect);
						
		//add insertion sort button
		quick.setBounds(100,480,125,25);
		userBar.add(quick);
		
		//add bogo sort label
		bogoSelect.setHorizontalAlignment(JLabel.LEFT);
		bogoSelect.setBounds(5, 540, 125, 25);
		userBar.add(bogoSelect);
								
		//add bogo sort button
		bogo.setBounds(100,540,125,25);
		userBar.add(bogo);
		
		//add exit button
		exit.setBounds(50,650,150,60);
		userBar.add(exit);
		
		
		
		window.getContentPane().add(userBar);
		
		sortingAlgo = new SortingAlgo();
		sortingAlgo.setBounds(250, 0, WIN_WIDTH, WIN_HEIGHT);
		sortingAlgo.setBorder(BorderFactory.createLineBorder(Color.black));
		
		window.getContentPane().add(sortingAlgo);
		
		shuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sortingAlgo.shuffle();
			}
		});
		
		bubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sortingAlgo.setSelector(1);
			}
		});
		
		
		selection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sortingAlgo.setSelector(2);
			}
		});
		
		
		insertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sortingAlgo.setSelector(3);
			}
		});
		
		
		radix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sortingAlgo.setSelector(4);
			}
		});
		
		merge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//sortingAlgo.setSelector(5);
			}
		});
		
		quick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//sortingAlgo.setSelector(7);
			}
		});
		
		bogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//sortingAlgo.setSelector(8);
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		
		

	}
	
	
	public static void main(String[] args) {
			
		GUI sortingGUI = new GUI();
	}

}
