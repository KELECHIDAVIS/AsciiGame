import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static boolean end = false; 
	public static int a,b;
	public static int score = 0; 
	public static int dummy;
	public static int increment = 0; 
	public static int[] bigList= new int[26];
	public static ArrayList<Character> message=new ArrayList<Character>();  
	public static boolean moreLetters = true;
	
	public static void main(String[] args)
	{
		
		randomizer(bigList); 
		/*for(int i = 0; i < bigList.length;i++) 
		{
			System.out.print((char)bigList[i]+" ");
		}*/
		System.out.println();
		sorter(bigList);
		/*for(int i = 0; i < bigList.length;i++) 
		{
			System.out.print((char)bigList[i]+" ");
		}*/
		System.out.println();
		for(int i = 0 ; i<10; i++)
		{
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Input your letter");
			char letter = scan.next().charAt(0); 
			searcher(letter, bigList); 
			increment =0; 
			
		}
		
		System.out.print("Your message was : ");
		for(int i = 0; i<message.size();i++)
		{
			System.out.print(message.get(i));
		}
		System.out.println();
	}
	
	public static void randomizer(int[] arr)
	{
		Random rand = new Random(); 
		for(int i = 0;  i<arr.length; i++)
		{
			arr[i] = rand.nextInt(58)+65; 
		}
	}
	
	
	public static boolean asker()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to continue(yes/no)"); 
		if(scanner.nextLine().equals("yes"))
		{
			return true;
		}else
		{
			return false;
		}
			
		
	}
	

	public static void searcher(char target, int[] arr )
	{
		int start = 0; 
		int end = arr.length; 
		int middle = (start + end )/2; 
		int tries = 0; 
		boolean found = false;
		while(!found) 
		{
			
			if(arr[middle] < (int)target)
			{
				start = middle; 
				middle= (start + end)/2 ; 
				tries++;
				increment-=10; 
				
			}
			else if(arr[middle] > (int)target)
			{
				end = middle; 
				middle= (start + end)/2; 
				tries++; 
				increment-=10; 
				
			}
			else if(arr[middle] == (int)target)
			{
				System.out.println("Your letter was in the list at the "+middle+" index");
				message.add((char)arr[middle]); 
				System.out.println("Your letter was "+(char)arr[middle]); 
				System.out.println("It took "+tries+" tries");
				score+=arr[middle];
				score+=increment; 
				increment=0; 
				System.out.println("Score: "+score);
				found = true; 
				
			}
			 if(start==middle) 
			{
				if(arr[middle]==target)
				{
					found= true; 
				}else 
				{
				System.out.println("the target was not in the list");
				System.out.println("The target was "+target);
				// could be taken out if it doesn't count when it is not found
				System.out.println("Score: "+score);
				break; 
				}
				
			}
			 
		}
	}
	
		public static void swap(int[] arr, int a, int b)
		{
			dummy = arr[a];
			arr[a] = arr[b];
			arr[b]=dummy;
		}
		public static void sorter(int[] arr)
		{
			for(int i=0; i<arr.length;i++) 
			{
				a=i;
				b=i+1;
				if(a==arr.length||b==arr.length)
				{
					i = 0; a=i; b=i+1;
					if(arr[a]>arr[b])
					{
						
						i=0; 
					}else
					{
						break;
					}
				}
				if(arr[b]<arr[a]) 
				{
					swap(bigList, a, b);
					i=0; 
				}
			}	
		
	}
	
		
}
