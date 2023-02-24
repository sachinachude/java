import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class FileScan {
public static void main(String args[]) throws Exception
{
	long count=0;
	String os_name=System.getProperty("os.name");
	System.out.println(os_name);
	File all[]=File.listRoots();
	OutputStream out= new FileOutputStream("D:\\list.txt");
	PrintStream p=new PrintStream(out);
	InputStream in=new FileInputStream("D:\\list.txt");
    BufferedReader br=new BufferedReader(new InputStreamReader(in));
    OutputStream output=new FileOutputStream("D:\\Output.txt");
    PrintStream p2=new PrintStream(output);
    for(int i=0;i<all.length;i++)
    {
    	File fa[]=all[i].listFiles();
    	for(int j=0;j<fa.length;j++)
    	{
    		if(fa[j].isDirectory())
    		{
    		p.print(fa[j].toString() +"\\" +"\n");
    		p.flush();
    		}
    		else
    		{
    			System.out.println(fa[j]);
    			p2.print(fa[j].toString() +"\n");
    			count++;
    		}
    	}
    }
    String read;
	while((read=br.readLine())!=null)
	{
		File f1=new File(read);
		if ((f1.isDirectory()))
		{
			try {
			//System.out.println(f1.list());
			File flist1[]=f1.listFiles();
			for(int k=0;k<flist1.length;k++)
			{
				if(flist1[k].isDirectory())
				{
				p.print(flist1[k].toString() +"\\" +"\n");
				p.flush();
				}
				else
				{
					System.out.println(flist1[k].toString());
					p2.print(flist1[k].toString() +"\n");
					count++;
				}
			}
			}
			catch (NullPointerException npe)
			{
				
			}
		}
		else {
			p2.print(f1.toString() +"\n");
			System.out.println(f1.toString());
			count++;
		}
	}

	System.out.println(count +" total files found...");

}


}
