package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import view.SelectedShapeDecorator;
import view.interfaces.IShape;

public class ShapeDrawer  {
	
	Graphics2D graph;
	List<IShape> shapeList;
	List<IShape> selectedList;
	List<IShape> groupList;
	
	public  ShapeDrawer (Graphics2D graph, List<IShape> shapeList, List<IShape> selectList )
	{
		this.graph = graph;
		this.shapeList = shapeList;
		this.selectedList = selectList;
		this.groupList = shapeList.get(0).getShapeOption().group.groupList;
	}
	
	public void drawShapesInList () {
		graph.setColor(Color.WHITE);
    	graph.fillRect(0, 0, 200000, 200000);
    	for (IShape shape: shapeList) {shape.drawShape();}  
    	for (IShape shape: selectedList) {
    		IShape outlinedShape = new SelectedShapeDecorator (shape);
    		outlinedShape.drawShape();
    		
    		}  
	}
}
