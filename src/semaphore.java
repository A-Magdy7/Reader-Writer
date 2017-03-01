
public class semaphore
{
	int val;
	
	semaphore (int value)
	{
		val = value;
	}
	
	void W (String tn)
	{
		val--;
		if(val<0)
			try { System.out.println(tn + " has blocked"); wait(); }catch (Exception ex) {}
	}
	
	void N ()
	{
		val++;
		if(val<=0)
			notify();
	}
}
