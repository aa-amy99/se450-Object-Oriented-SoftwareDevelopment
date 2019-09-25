package view;

import model.ShapeOption;
import model.ShapeShadingType;
import view.interfaces.IShape;

public abstract class AbstractShape implements IShape{
	
	public abstract void drawShape();
	
	public void checkShadingType(ShapeOption shapeOption) {
		
		ShapeShadingType myShadingType = shapeOption.getMyShadingType();
		if (myShadingType.equals(ShapeShadingType.FILLED_IN)) 
			fillShape(shapeOption.getMyPrimaryColor());
		else if (myShadingType.equals(ShapeShadingType.OUTLINE)) 
			outlineShape(shapeOption.getMyPrimaryColor());
		else if (myShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
			fillShape (shapeOption.getMyPrimaryColor());
			outlineShape(shapeOption.getMySecondColor());
		}
	}
}

