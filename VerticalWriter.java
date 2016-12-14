
public class VerticalWriter {

	public static void main(String args[])
	{
		//writeVertically("adc");
		//starPrinter(3);
		//beackwardsWriter("abcdef");
		//countdowner(9);
		System.out.println(powers(2,-5));
	}
	public static double powers(int base, int power)
	{
		if (power == 0)
		{
			return 1;
		}
		if ( power < 0)
		{
			//System.out.print(powers(base,power+1) + " ");
			return 1/( powers(base,power * -1));
		}
		else
		{
			//System.out.print(powers(base,power-1) + " ");
			return powers(base,power-1) * base;
		}
	}
	public static void beackwardsWriter(String value) {
		
		if (value.length() == 0)
		{
		}
		else
		{
			beackwardsWriter(value.substring(1));
			System.out.print(value.substring(0,1) + " ");
		}
		
	}
	
	public static void countdowner(int value) {
		
		if (value == 0)
		{
		}
		else
		{
			System.out.print(value + " ");
			countdowner(value - 1);
		}
		
	}
	
	public static void writeVertically(String Values)
	{
		if (Values.length() == 0 )
		{
			System.out.println("");
		}else
		{
		System.out.println(Values.substring(0,1));
		writeVertically(Values.substring(1));
		}
	}
	public static void starPrinter(int B)
	{
		if (B == 0)
		{
			System.out.println("");
		}
		else
		{
			System.out.println("*");
			starPrinter(B-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
