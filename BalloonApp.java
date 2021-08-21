package balloon;

public class BalloonApp
{

	public static void main(String[] args)
	{
		Balloon b1 = new Balloon(BalloonSize.L, BalloonType.AIR);
		Balloon b2 = new Balloon(BalloonSize.L, BalloonType.AIR); 
		
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		
		System.out.println("b1.equals(b2) = " + b1.equals(b2));

	}

}
