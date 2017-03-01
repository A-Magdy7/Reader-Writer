import java.util.*;

public class Threads
{
	public static void main (String arg[])
	{
		Scanner in = new Scanner(System.in);
		
		ReaderWriter buffer = new ReaderWriter();
		
		String ThreadName, Text;
		int nr, nw, cnt=0;
		
		System.out.print("Initial Buffer Content: ");
		buffer.BufferContent = in.nextLine();
		
		System.out.print("Number of reader threads: ");
		nr = in.nextInt();
		
		System.out.print("Number of writer threads: ");
		nw = in.nextInt();

		ReaderWriterTherad threads[] = new ReaderWriterTherad [nw+nr];
		
		System.out.println("Reader Threads: ");
		
		while (nr--!=0)
		{
			ThreadName = in.next();
			threads[cnt++] = new ReaderWriterTherad (ThreadName,buffer);
		}
		
		System.out.println("Writer Threads: ");

		while (nw--!=0)
		{
			ThreadName = in.next();
			Text = in.nextLine();
			threads[cnt++] = new ReaderWriterTherad (ThreadName,Text,buffer);
		}
		
		for(int i=0 ; i<cnt ; i++)
			threads[i].start();
		
		
		in.close();
	}
}
