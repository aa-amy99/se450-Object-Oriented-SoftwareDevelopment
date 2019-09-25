package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.ShapeOption;
import model.ShapeType;
import view.interfaces.IShape;

public class SelectedShapeDecorator implements IShape{

	private final IShape decShape;

	public SelectedShapeDecorator (IShape shapeTobeDecorated)
	{
		this.decShape = shapeTobeDecorated;
	}
	
	@Override
    public void drawShape() {
		decShape.drawShape();
        outlineSelectedShape();
    }
	private void outlineSelectedShape() {
		Graphics2D graph = decShape.getShapeOption().graph;
		ShapeOption decOption = decShape.getShapeOption();
		graph.setStroke(new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10.0f, new float[]{10.0f}, 0));
		graph.setColor(Color.BLACK);
		if (decOption.getMyShapeType().equals(ShapeType.RECTANGLE))
			graph.drawRect(decOption.Start.getX()-5, decOption.Start.getY()-5, decOption.width +10, decOption.height+10);
		else if (decOption.getMyShapeType().equals(ShapeType.ELLIPSE))
			graph.drawOval(decOption.Start.getX()-5, decOption.Start.getY()-5, decOption.width+10, decOption.height+10);
		
		//Triangle outline needs different offsets from Rectangle and Ellipse
		else if (decOption.getMyShapeType().equals(ShapeType.TRIANGLE)) {
			int[] xPoints = {decOption.Start.getX() - 5,decOption.End.getX()+12, decOption.Start.getX()-5};
			int[] yPoints = {decOption.Start.getY()-10,decOption.End.getY()+5,decOption.End.getY()+5};
			graph.drawPolygon(xPoints, yPoints, 3);
		}
	}
	
	@Override
	public void fillShape(Color myColor) {decShape.fillShape(myColor);	
	}
	@Override
	public void outlineShape(Color myColor) {decShape.outlineShape(myColor);}
	
	@Override
	public ShapeOption getShapeOption(){return decShape.getShapeOption();}

	@Override
	public void setNewShapeOption(ShapeOption newSO){ decShape.setNewShapeOption(newSO);} 	
	
}


