import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SortingAlgo extends JPanel{
	
	public static final int WIN_WIDTH = 1500;
    public static final int	WIN_HEIGHT = 850;
    private static final int BAR_WIDTH = 5;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
    
    private int x = 0;
    private int y = 0;
    private int s = 0;
    
    private int[] array;
    
    public void setSelector(int n)
    {
    	s = n;
    	repaint();
    }
    	
    
	public SortingAlgo()
	{
		setBackground(Color.DARK_GRAY);
		array = new int[NUM_BARS];
		
		for(int x = 0; x < NUM_BARS; x++)
	      {
	        array[x] = x;
	      }
		
		shuffle();
	}
	
	public void shuffle()
	 {
		  x = 0;
		  y = 0;
		  s = 0;
		  
		  for(int x = 0; x < NUM_BARS; x++)
		        {
		         int randomNumber = (int)(Math.random()*NUM_BARS-1);
		         int temp = array[x];
		         array[x] = array[randomNumber];
		         array[randomNumber] = temp;
		        }
		  	
		  	repaint();
	  
	 }
	
	public void swap(int array[], int x, int y)
	{
		
		int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
	}

	 public void bubble() 
	 { 
			 if(x < NUM_BARS - 1)
			{
				for(int y = 0; y < (NUM_BARS - x - 1); y++)
				{
					if(array[y] > array[y+1])
				    {
				    	swap(array, y, y+1);   
				    }
				}
				
				try {
					Thread.sleep(20);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else x = 0;
			 
			repaint();
			x++;
			
	 }
	 
	 public void selection()
	 {
		  int n = array.length; 
	
	       if(x < NUM_BARS - 1)
	        { 
	            int min = x; 
	            
	            for (int j = x+1; j < n; j++)
	            {
	            	if (array[j] < array[min]) 
	                    min = j; 
	            }
	                
	            swap(array, min, x);
	            
	            try {
	            	Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        } else x = 0;
	       
	       repaint();
	       x++;
	        
	 }

	
	 public void insertion() 
	 { 
		 int n = array.length; 
	       
	        if(x < NUM_BARS-1) {
	        	
	            int key = array[x]; 
	            int j = x - 1; 
	    
	            while (j >= 0 && array[j] > key) { 
	                array[j + 1] = array[j]; 
	                j = j - 1; 
	            } 
	            array[j + 1] = key; 
	            
	            try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        } else x = 1;
	        	
	        repaint();
	        x++;
	        	
	        
	 }
	 
	 public int digitPosition(int nthplace, int numberArray)
	 {
		 
		 for(int x = 1; x < numberArray; x++)
		 {
			 nthplace = nthplace / 10;
		 }
			  
		 return nthplace%10;
		 
		 
	 }
	 
	 public int maxPosition(int[] array)
	 {
		 int max; 
		 
		 if(array.length == 1)
		 {
			max = array[0]; 
		 }
		 
		 else if (array.length == 0)
			 return -1;
		 
		 else
		 {
			 max = array[0];

			 for(int x = 1; x < array.length; x++)
			 {
				 if(array[x] > max)
				 {
					 max = array[x];
				 }
				 
			 }
		 
		 }
		 
		 int power = 1;
		 
		 while(max >= Math.pow(10, power))
		 {
			 power++;
		 }
		 
		 return power;
		 
	 }
		 
		 
	 public void radix() // looks at ones place, and sorts the numbers. Once sorted, goes to tens place, then sorts. Process repeats until whole list is sorted
	 {
		 int counter = 0;
			
			if(x < maxPosition(array)+1)
			{
				int[] temp = new int[NUM_BARS];
				counter=0;
				
				for(int numberSearch = 0; numberSearch < 10; numberSearch++)
				{
					
				 for(int z = 0; z < NUM_BARS; z++)
				 {
					 if(digitPosition(array[z],x) == numberSearch)
					 {
						temp[counter] = array[z];
						counter++;
						
					 }
					 
				 }
				 
				}
				
				array = temp;
				
				repaint();
				
				
			} else x = 1;
			
			try {
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			x++;
	 }
	 
	 
	  
	
	public void paintComponent(Graphics g) {

	Graphics2D graphics = (Graphics2D)g;
	super.paintComponent(g);
	
	graphics.setColor(Color.white);
	
	if(s == 1)
	{
		bubble();
		graphics.setColor(Color.green);
	}
	
	if(s == 2)
	{
		selection();
		graphics.setColor(Color.cyan);
	}
	
	if(s == 3)
	{
		insertion();
		graphics.setColor(new Color(255, 105, 180));
	}
	
	
	if(s == 4)
	{
		radix();
		graphics.setColor(Color.yellow);
	}
	
	
	
	for(int x = 0; x < NUM_BARS; x++)
	{		
		
		int height = (int) (array[x]*2.5);
		int xBegin = x + (BAR_WIDTH-1) * x;
		int yBegin = WIN_HEIGHT - height;
		
		graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);

	}
				
			
}
	
}
				