package view;

import java.awt.BasicStroke;
import java.awt.Color;
import model.ShapeOption;
import view.interfaces.IShape;

public class DrawEllipseStrategy extends AbstractShape implements IShape{

	ShapeOption shapeOption;
	
	public DrawEllipseStrategy(ShapeOption shapeOptions)
	{
		this.shapeOption = shapeOptions;
	}

	@Override
	public void drawShape(){
		checkShadingType(shapeOption);	
	}

	@Override
	public void fillShape(Color myColor) {
		shapeOption.graph.setColor(myColor);
		shapeOption.graph.fillOval(shapeOption.Start.getX(), shapeOption.Start.getY(), shapeOption.width, shapeOption.height);
	}
	@Override
	public void outlineShape (Color myColor) {
		shapeOption.graph.setStroke(new BasicStroke(5,  BasicStroke.CAP_SQUARE,  BasicStroke.JOIN_MITER));
		shapeOption.graph.setColor(myColor);
		shapeOption.graph.drawOval(shapeOption.Start.getX(), shapeOption.Start.getY(), shapeOption.width, shapeOption.height);
	}

	@Override
	public ShapeOption getShapeOption(){return shapeOption;}
	
	@Override
	public void setNewShapeOption(ShapeOption newSO){this.shapeOption = newSO;} 

}
