package view.interfaces;

import java.awt.Color;

import model.ShapeOption;

public interface IShape {
	
	void drawShape();
	ShapeOption getShapeOption();
	void fillShape(Color myColor);
	void outlineShape (Color myColor);
	void setNewShapeOption(ShapeOption newSO);
	
}
