
public class ReaderWriterTherad extends Thread
{
	String ThreadName, Text;
	ReaderWriter buffer;
	
	ReaderWriterTherad (String TN, ReaderWriter RW)
	{
		this.buffer = RW;
		this.ThreadName = TN;
	}
	
	ReaderWriterTherad (String TN, String T, ReaderWriter RW)
	{
		this.buffer = RW;
		this.ThreadName = TN;
		this.Text = T;
	}
	
	public void run()
	{
		if(Text == null)
			buffer.read(ThreadName);
		else
			buffer.write(ThreadName,Text);
	}
}
