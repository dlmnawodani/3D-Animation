
public class Furniture {

	private String category;
	private String type;
	private FurnitureColors furniColor;
	
	public FurnitureColors getFurniColor() {
		return furniColor;
	}


	public void setFurniColor(FurnitureColors furniColor) {
		this.furniColor = furniColor;
	}


	public OtherColors getSeatColor() {
		return seatColor;
	}


	public void setSeatColor(OtherColors seatColor) {
		this.seatColor = seatColor;
	}


	private int furniRed;
	private int furniBlue;
	private int furniGreen;
	
	private OtherColors seatColor;
	private int seatRed;
	private int seatBlue;
	private int seatGreen;
	
	private int quantity;
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getFurniRed() {
		return furniRed;
	}


	public void setFurniRed(int furniRed) {
		this.furniRed = furniRed;
	}


	public int getFurniBlue() {
		return furniBlue;
	}


	public void setFurniBlue(int furniBlue) {
		this.furniBlue = furniBlue;
	}


	public int getFurniGreen() {
		return furniGreen;
	}


	public void setFurniGreen(int furniGreen) {
		this.furniGreen = furniGreen;
	}


	public int getSeatRed() {
		return seatRed;
	}


	public void setSeatRed(int seatRed) {
		this.seatRed = seatRed;
	}


	public int getSeatBlue() {
		return seatBlue;
	}


	public void setSeatBlue(int seatBlue) {
		this.seatBlue = seatBlue;
	}


	public int getSeatGreen() {
		return seatGreen;
	}


	public void setSeatGreen(int seatGreen) {
		this.seatGreen = seatGreen;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	private double unitPrice;
	
	
	public Furniture(String category, String type, FurnitureColors furniColor, int furniRed, int furniBlue,
			int furniGreen, OtherColors seatColor, int seatRed, int seatBlue, int seatGreen, int quantity,
			double unitPrice) {
		super();
		this.category = category;
		this.type = type;
		this.furniColor = furniColor;
		this.furniRed = furniRed;
		this.furniBlue = furniBlue;
		this.furniGreen = furniGreen;
		this.seatColor = seatColor;
		this.seatRed = seatRed;
		this.seatBlue = seatBlue;
		this.seatGreen = seatGreen;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	
	

}
