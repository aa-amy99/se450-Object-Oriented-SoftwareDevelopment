package model;

import java.awt.Color;
import java.awt.Graphics2D;

import controller.Group;
import controller.Point;
import model.persistence.ApplicationState;

public class ShapeOption {
	public Graphics2D graph;
	public Point Start, End;
	public int width, height;
	public ApplicationState appState;
	public ShapeLists shapeList;
	public ShapeType shapeType;
	public ShapeShadingType shadingType;
	public ShapeColor primaryColor;
	public ShapeColor secondColor;
	public Group group;


	public ShapeOption(Graphics2D graph, ApplicationState appState, ShapeLists shapeList, Point Start, Point End, Group group)
	{	
		this.graph = graph;
		this.Start = Start;
		this.End = End;
		this.appState = appState;
		this.shapeList = shapeList;
		this.shapeType = appState.getActiveShapeType();
		this.shadingType = appState.getActiveShapeShadingType();
		this.primaryColor = appState.getActivePrimaryColor();
		this.secondColor = appState.getActiveSecondaryColor();
		this.group = group;
	}

	//Clone ShapeOption
	@Override
	public Object clone() {
		try {
			return (ShapeOption) super.clone();
		} catch (CloneNotSupportedException e) {
			return new ShapeOption(this.getMyGraphics2D(), this.getMyAppState(), this.getMyShapeList(), this.getMyStartPT(), this.getMyEndPT(), this.getMyGroup());
		}
	}

	//Getter
	public Graphics2D getMyGraphics2D() {return this.graph;}

	public Point getMyStartPT() {return this.Start;}

	public Point getMyEndPT() {return this.End;}

	public ShapeType getMyShapeType() {return this.shapeType;}

	public ShapeShadingType getMyShadingType() {return this.shadingType;}

	public Color getMyPrimaryColor() {return this.primaryColor.getColor();}

	public Color getMySecondColor() {return this.secondColor.getColor();}

	public ApplicationState getMyAppState() {return this.appState;}

	public ShapeLists getMyShapeList() {return this.shapeList;}
	
	public Group getMyGroup() {return this.group;}

	//Setter
	public void setMyShapeType( ShapeType ST) {this.shapeType = ST;}

	public void setMyShapeShadingType ( ShapeShadingType  SST) {this.shadingType = SST;}

	public void setMyPrimeColor(ShapeColor PC) {this.primaryColor = PC;}

	public void setMySecondColor( ShapeColor SC) {this.secondColor = SC;}

	public void setWidth(int x ){ this.width = x;}

	public void setHeight(int y){ this.height = y;}

	public void setStartPT(int x, int y){ this.Start.setXY(x,y);}

	public void setEndPT(int x, int y){ this.End.setXY(x,y);}

	public void setNewPastedStartPT(int x, int y){ this.Start = new Point (x,y);}

	public void setNewPastedEndPT(int x, int y){ this.End = new Point (x,y);}
	
	public void setMyGroup( Group ng) {this.group = ng;}
	
	public void resetMyGroup() {this.group = new Group ();}

}