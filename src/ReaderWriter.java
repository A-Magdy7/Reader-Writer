import java.util.concurrent.Semaphore;

public class ReaderWriter
{
	String BufferContent;
	int cnt=0;
	Semaphore rmutex = new Semaphore(1);
	Semaphore wmutex = new Semaphore(1);

	
	public void read (String ThreadName)
	{
		System.out.println(ThreadName + " Start Reading");
		
		try { rmutex.acquire(); }catch(InterruptedException ex) {}
		
		cnt++;
		
		if(cnt == 1)
			try { wmutex.acquire(); }catch(InterruptedException ex) {}
		
		rmutex.release();
		
		System.out.println(ThreadName + " Read: " + BufferContent);
		System.out.println(ThreadName + " Finished reading");
		
		try { rmutex.acquire(); }catch(InterruptedException ex) {}
		
		cnt--;
		
		if(cnt == 0)
			wmutex.release();

		rmutex.release();
	}
	
	public void write (String ThreadName, String Text)
	{
		System.out.println(ThreadName + " Start Writing");
		
		try { wmutex.acquire(); }catch(InterruptedException ex) {}
		
		BufferContent += " " + Text;
		System.out.println(ThreadName + " Writing : " + BufferContent);
		System.out.println(ThreadName + " Finished  writing");
		
		wmutex.release();
	}
}
