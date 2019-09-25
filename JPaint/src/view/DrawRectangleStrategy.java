package view;

import java.awt.*;
import model.ShapeOption;
import view.interfaces.IShape;

public class DrawRectangleStrategy extends AbstractShape implements IShape {

	ShapeOption shapeOption;

	public DrawRectangleStrategy(ShapeOption shapeOptions)
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
		shapeOption.graph.fillRect(shapeOption.Start.getX(), shapeOption.Start.getY(), shapeOption.width, shapeOption.height);
	}
	@Override
	public void outlineShape (Color myColor) {
		shapeOption.graph.setStroke(new BasicStroke(5,  BasicStroke.CAP_SQUARE,  BasicStroke.JOIN_MITER));
		shapeOption.graph.setColor(myColor);
		shapeOption.graph.drawRect(shapeOption.Start.getX(), shapeOption.Start.getY(), shapeOption.width, shapeOption.height);
	}
	
	@Override
	public ShapeOption getShapeOption(){return shapeOption;}
	
	@Override
	public void setNewShapeOption(ShapeOption newSO){this.shapeOption = newSO;} 
}
