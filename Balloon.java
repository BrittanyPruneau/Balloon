package balloon;

public class Balloon
{
	private BalloonSize size;
	private BalloonType type;
	/**
	 * @param size
	 * @param type
	 */
	public Balloon(BalloonSize size, BalloonType type)
	{
		this.size = size;
		this.type = type;
	}
	@Override
	public String toString()
	{
		return type + " " + size;
	}
	/**
	 * @return the size
	 */
	public BalloonSize getSize()
	{
		return size;
	}
	/**
	 * @return the type
	 */
	public BalloonType getType()
	{
		return type;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balloon other = (Balloon) obj;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	} 
	
	
	
}
