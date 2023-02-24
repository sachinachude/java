import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Binary {
public static void main(String args[]) throws Exception
{
	Rstring r=new Rstring();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String input=br.readLine();
	int number=Integer.parseInt(input);
	boolean stop=false;
	String result="";
	int rem=0;
	while(stop==false)
	{
		if (number==1)
		{
			rem=1;
			result+=Integer.toString(rem);
			r.sprint(result);
			System.exit(1);
		}
		else if(number==0)
		{
			rem=0;
			result+=Integer.toString(rem);
			r.sprint(result);
			System.exit(1);
		}
		else
		{
		rem=number%2;
		number=number/2;
		result+=Integer.toString(rem);
		}
	}
	
	
}
}
class Rstring
{
	public void sprint(String input)
	{
		for(int i=input.length()-1;i>=0;i--)
		{
			System.out.print(input.charAt(i));
		}
	System.out.print("\n");
	}
}