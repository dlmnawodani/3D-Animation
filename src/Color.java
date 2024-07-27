
public class Color {

	
	private int red;
	
	public int getRed() {
		return red;
	}


	public void setRed(int red) {
		this.red = red;
	}


	public int getBlue() {
		return blue;
	}


	public void setBlue(int blue) {
		this.blue = blue;
	}


	public int getGreen() {
		return green;
	}


	public void setGreen(int green) {
		this.green = green;
	}


	public String getColorName() {
		return colorName;
	}


	public void setColorName(String colorName) {
		this.colorName = colorName;
	}


	private int blue;
	private int green;
	private String colorName;
	

	public Color(String colorName) {
		// TODO Auto-generated constructor stub
		this.setColorName(colorName);
		 for (FurnitureColors color : FurnitureColors.values()) {
	            if (color.toString().equals(this.colorName)) {
	            	setRGBColorsForFurniture(color);
	                break;
	            }
	            
	            for (OtherColors color2 : OtherColors.values()) {
    	            if (color2.toString().equals(this.colorName)) {
    	            	setRGBColorsForOther(color2);
    	                break;
    	            }
    	        }
	        }
		
	}
	
	
	public void setRGBColorsForOther(OtherColors color) {
		switch (color) {
        case GREEN:
        	this.red = 0;
        	this.green = 255;
        	this.blue  = 0;
        	break;
        case LIGHT_BLUE:
        	this.red = 173;
        	this.green = 216;
        	this.blue  = 230;
        	break;
        case LIGHT_PURPULE:
        	this.red = 216;
        	this.green = 191;
        	this.blue  = 216;
        	break;
        case YELLOW:
        	this.red = 255;
        	this.green = 255;
        	this.blue  = 0;
        	break;
        case WHITE:
        	this.red = 255;
        	this.green = 255;
        	this.blue  = 255;
        	break;
        default:
        	break;
    }
	}
	

	public void setRGBColorsForFurniture(FurnitureColors color) {
		switch (color) {
        case MAHOGANY:
        	this.red = 192;
        	this.green = 64;
        	this.blue  = 0;
        	break;
        case TEAK:
        	this.red = 166;
        	this.green = 128;
        	this.blue  = 100;
        	break;
        case SANDALWOOD:
        	this.red = 244;
        	this.green = 164;
        	this.blue  = 96;
        	break;
        case BROWN:
        	this.red = 139;
        	this.green = 69;
        	this.blue  = 19;
        	break;
        case RED_BROWN:
        	this.red = 165;
        	this.green = 42;
        	this.blue  = 42;
        	break;
        default:
        	break;
    }
	}
	
	

}
