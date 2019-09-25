package model;

import java.awt.Color;

public enum ShapeColor {
	BLACK(Color.BLACK),
    BLUE(Color.BLUE),
    CYAN(Color.CYAN),
    DARK_GRAY(Color.DARK_GRAY),
    GRAY(Color.GRAY),
    GREEN(Color.GREEN),
    LIGHT_GRAY(Color.LIGHT_GRAY),
    MAGENTA(Color.MAGENTA),
    ORANGE(Color.ORANGE),
    PINK(Color.PINK),
    RED(Color.RED),
    WHITE(Color.WHITE),
    YELLOW(Color.YELLOW);
	
	private Color myColor;
	private ShapeColor(Color myColor){
		this.myColor = myColor;
}
	public Color getColor() {
		return myColor;
	}
}





