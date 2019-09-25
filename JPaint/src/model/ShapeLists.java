package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import view.interfaces.IShape;

public class ShapeLists {
	Graphics2D graph;
	List<IShape> myShapeList;
	List<IShape> mySelectedList;
	List<IShape> myCopiedList;
	
	public ShapeLists() {
		this.myShapeList = new ArrayList<IShape>();
		this.mySelectedList = new ArrayList<IShape>();
		this.myCopiedList = new ArrayList<IShape>();
	}

	public void reDrawShapes()
	{
		ShapeDrawer sd = new ShapeDrawer (graph, myShapeList, mySelectedList);
		sd.drawShapesInList(); 		
	}
	
	// Shape list 
	public void addToShapeList(IShape shape) {
		this.myShapeList.add(shape);
		this.graph = shape.getShapeOption().graph;
	}
	
	public void deleteFromShapeList(IShape shape) { this.myShapeList.remove(shape);}
	
	
	public List<IShape> getShapeList() {return this.myShapeList;}
	
	//Copied List
	
	public void addToCopiedList(IShape shape) {this.myCopiedList.add(shape);}
	
	
	public List<IShape> getCopiedList() {return this.myCopiedList;}
	
	// Select list 
	
	public void addToSelectedList(IShape s) {this.mySelectedList.add(s);}
	
	public void deleteFromSelectedList(IShape s) {this.mySelectedList.remove(s);}
	
	public void setSelectedList(List<IShape> l) {this.mySelectedList = l;}
	
	public List<IShape> getSelectedList() {return mySelectedList;}
	
	
	
	
}
