package view;

import java.awt.BasicStroke;
import java.awt.Color;
import model.ShapeOption;
import view.interfaces.IShape;

public class DrawTriangleStrategy extends AbstractShape implements IShape {

	ShapeOption shapeOption;

	public DrawTriangleStrategy(ShapeOption shapeOptions)
	{
		this.shapeOption = shapeOptions;
	}

	@Override
	public void drawShape(){
		checkShadingType(shapeOption);	
	}

	@Override
	public void fillShape(Color myColor) {
		int[] xPoints = {shapeOption.Start.getX(),shapeOption.End.getX(),shapeOption.Start.getX()};
		int[] yPoints = {shapeOption.Start.getY(),shapeOption.End.getY(),shapeOption.End.getY()};
		shapeOption.graph.setColor(myColor);
		shapeOption.graph.fillPolygon(xPoints, yPoints, 3);
	}
	
	@Override
	public void outlineShape (Color myColor) {
		int[] xPoints = {shapeOption.Start.getX(),shapeOption.End.getX(),shapeOption.Start.getX()};
		int[] yPoints = {shapeOption.Start.getY(),shapeOption.End.getY(),shapeOption.End.getY()};
		shapeOption.graph.setStroke(new BasicStroke(5,  BasicStroke.CAP_SQUARE,  BasicStroke.JOIN_MITER));
		shapeOption.graph.setColor(myColor);
		shapeOption.graph.drawPolygon(xPoints, yPoints, 3);
	}

	@Override
	public ShapeOption getShapeOption(){return shapeOption;}
	
	@Override
	public void setNewShapeOption(ShapeOption newSO){this.shapeOption = newSO;} 

}
