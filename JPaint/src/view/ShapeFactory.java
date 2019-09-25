package view;

import model.ShapeOption;
import model.ShapeType;
import view.interfaces.IShape;

public class ShapeFactory {
    public IShape createShape(ShapeOption shapeOption) {
        ShapeType shapeType = shapeOption.getMyShapeType();
        IShape shape = null;

        if(shapeType.equals(ShapeType.RECTANGLE)) {
        	 shape = new DrawRectangleStrategy(shapeOption);
        }
        else if(shapeType.equals(ShapeType.ELLIPSE)) {
        	 shape = new DrawEllipseStrategy(shapeOption);
        }
        else if(shapeType.equals(ShapeType.TRIANGLE)) {
        	 shape = new DrawTriangleStrategy(shapeOption);
        }
        return shape;
    }
}
