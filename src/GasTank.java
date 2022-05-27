
public class GasTank {
	
	/**
	 * How full the tank is
	 */
	private int fillLevel;
	
	/**
	 * Average price of the gas in the tank
	 */
	private double avgGasPrice;
	
	/**
	 * Total money spent filling tank
	 */
	private double totalSpent;
	
	/**
	 * Size of tank
	 */
	private int capacity;
	
	/**
	 * Total gallons purchased
	 */
	private int totalPurchased;
	
	/**
	 * Constructor.
	 * @param capacity
	 */
	public GasTank(int capacity) {
		this.capacity = capacity;
		this.fillLevel = 0;
		this.avgGasPrice = 0;
		this.totalSpent = 0;
		this.totalPurchased = 0;
	}
	
	public GasTank(int capacity, int initialFill, double gasPrice) {
		this.capacity = capacity;
		this.fillLevel = initialFill;
		this.avgGasPrice = gasPrice;
		this.totalSpent = 0.0;
		this.totalPurchased = 0;
	}
	
	/**
	 * Fill the tank using gas at provided price.
	 * 
	 * @param gasPrice double price of new gas per gallon
	 */
	public void topOff(double gasPrice) {
		double diff = capacity - fillLevel;
		avgGasPrice = (diff * gasPrice + fillLevel * avgGasPrice) / capacity;
		totalSpent += diff * gasPrice;
		fillLevel = capacity;
		totalPurchased += diff;
	}
	
	public void useGas(int gallons) {
		if(gallons <= fillLevel) fillLevel -= gallons;
	}
	
	public double getTotalSpent() {
		return totalSpent;
	}
	
	public int getFillLevel() {
		return fillLevel;
	}
	
	public double getAvgGasPrice() {
		return avgGasPrice;
	}
	
	public int getTotalPurchased() {
		return totalPurchased;
	}
	
	/**
	 * Amount spent per gallon for all gas purchased
	 * @return double average price of a gallon
	 */
	public double pricePerGallon() {
		return totalSpent / totalPurchased;
	}
	
	public boolean isEmpty() {
		return fillLevel == 0;
	}
}
