import java.util.Iterator;

public class GasPriceSimulator {

	/**
	 * Tank that is always filled
	 */
	private GasTank tank1;
	
	/**
	 * Tank that is only filled when empty
	 */
	private GasTank tank2;

	public GasPriceSimulator() {
		this.tank1 = new GasTank(20);
		this.tank2 = new GasTank(20);
	}
	
	/**
	 * Tops of first tank and fills second if empty
	 * @param fillPrice
	 */
	public void fillTanks(double gasPrice) {
		tank1.topOff(gasPrice);
		if(tank2.isEmpty()) {
			tank2.topOff(gasPrice);
		}
	}
	
	public void useGas(int gallons) {
		tank1.useGas(gallons);
		tank2.useGas(gallons);
	}
	
	public String results() {
		return "Tank 1: Always filled"
				+ "\n\tCurrent fill level: " + tank1.getFillLevel()
				+ "\n\tTotal spent: $" + tank1.getTotalSpent()
				+ "\n\tAverage price of gallon: $" + tank1.pricePerGallon()
				+ "\nTank 2: Only filled when empty: "
				+ "\n\tCurrent fill level: " + tank2.getFillLevel()
				+ "\n\tTotal spent: $" + tank2.getTotalSpent()
				+ "\n\tAverage price of gallon: $" + tank2.pricePerGallon()
				+ "\nDifference in amount spent: $" + (tank1.getTotalSpent() - tank2.getTotalSpent());
		
	}
	
	public String printPrices() {
		return tank1.getTotalSpent() + "," + tank2.getTotalSpent();
	}
	
	public String printPricePerGal() {
		return tank1.pricePerGallon() + "," + tank2.pricePerGallon();
	}
	
	public static void main(String[] args) {
		
		GasPriceSimulator gasSim = new GasPriceSimulator();
		Iterator<Double> prices = gasSim.priceIterator(2.0, 0.05);
		
		System.out.println("i\tTank1\tTank2");
		for(int i = 0; i < 1000; i++) {
			gasSim.fillTanks(prices.next());
			gasSim.useGas(1);
			//System.out.println(i + "," + gasSim.printPrices());
			System.out.println(i + "," + gasSim.printPricePerGal());
		}
		
		System.out.println(gasSim.results());
	}
	
	public Iterator<Double> priceIterator(double startPrice, double priceIncrement){
		final double price = startPrice;
		final double increment = priceIncrement;
		return new Iterator<Double>() {
			double next = price;
			double inc = increment;
			
			@Override
			public boolean hasNext() {
				return true;
			}

			@Override
			public Double next() {
				double price = next;
				next += inc;
				return price;
			}
			
		};
	}

}
