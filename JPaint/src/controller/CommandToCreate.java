package controller;

import model.ShapeLists;
import model.ShapeOption;
import view.ShapeFactory;
import view.interfaces.IShape;
import java.io.IOException;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;

public class CommandToCreate implements ICommand, IUndoRedo{
	
	private ShapeFactory shapeFactory;
	public IShape shape;
	private ShapeLists shapeList;
	private ShapeOption shapeOption;
	
	public CommandToCreate(ShapeOption shapeOption)
	
	{
		this.shapeOption = shapeOption;
		this.shapeList = shapeOption.shapeList;
		this.shapeFactory = new ShapeFactory();
	}
	
	@Override
	public void run() throws IOException
	{
		System.out.println("Running ------------->>> DRAW MODE");
        int x = Math.min(shapeOption.Start.getX(), shapeOption.End.getX());
        int y = Math.min(shapeOption.Start.getY(), shapeOption.End.getY()); 
        int maxX = Math.max(shapeOption.Start.getX(), shapeOption.End.getX());
        int maxY = Math.max(shapeOption.Start.getY(), shapeOption.End.getY()); 
        int width = Math.abs(maxX - x);
        int height = Math.abs(maxY - y);
        shape = shapeFactory.createShape(shapeOption);
        shape.getShapeOption().setStartPT(x, y);
        shape.getShapeOption().setEndPT(maxX , maxY);
        shape.getShapeOption().setWidth(width);
        shape.getShapeOption().setHeight(height);
        shapeList.addToShapeList(shape);
		shape.drawShape();
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		shapeList.deleteFromShapeList(shape);
		shapeList.reDrawShapes();
	}

	@Override
	public void redo() {
		shapeList.addToShapeList(shape);
		shapeList.reDrawShapes();
	}
}
