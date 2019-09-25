package model.interfaces;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeColor;
import model.ShapeLists;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;

public interface IShapeOption {
	
	Graphics2D getMyGraphics2D();
	Point getMyStartPT();
	void setMyStartPT(Point point);
	void setMyEndPT(Point point);
	Point getMyEndPT();
	ShapeType getMyShapeType();
	ShapeShadingType getMyShadingType();
	Color getMyPrimaryColor();
	ShapeColor getMySecondColor();
	ApplicationState getMyAppState();
	void SetMyShapeType( ShapeType ST);
	void SetMyShapeShadingType ( ShapeShadingType  SST);
	void SetMyPrimeColor(ShapeColor PC);
	void SetMySecondColor( ShapeColor SC);
	ShapeLists getMyShapeList();
}
