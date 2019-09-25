package controller;


import java.io.IOException;
import java.util.List;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;
import model.ShapeLists;
import model.ShapeOption;
import view.interfaces.IShape;

public class CommandToMove implements ICommand, IUndoRedo{

	private ShapeOption shapeOption;
	private ShapeLists shapeList;
	private int offsetX, offsetY;
	private Point startPT, endPT;

	
	public CommandToMove(ShapeOption shapeOption)
	{
		this.shapeOption = shapeOption;
		this.shapeList = shapeOption.shapeList;
		this.startPT = shapeOption.Start;
		this.endPT = shapeOption.End;
		this.offsetX = endPT.getX() - startPT.getX();
		this.offsetY = endPT.getY() - startPT.getY();
	}

	private void moveSelectedShape(ShapeOption selectedShapeOption, boolean isUndo) {
		if (isUndo) {
			selectedShapeOption.setStartPT(selectedShapeOption.getMyStartPT().getX() - offsetX, selectedShapeOption.getMyStartPT().getY() - offsetY);
			selectedShapeOption.setEndPT(selectedShapeOption.getMyEndPT().getX() - offsetX ,selectedShapeOption.getMyEndPT().getY() - offsetY);
		}
		else {
			selectedShapeOption.setStartPT(selectedShapeOption.getMyStartPT().getX() + offsetX, selectedShapeOption.getMyStartPT().getY() + offsetY);
			selectedShapeOption.setEndPT(selectedShapeOption.getMyEndPT().getX() + offsetX ,selectedShapeOption.getMyEndPT().getY() + offsetY);	
		}		
	}
	
	@Override
	public void run() throws IOException
	{
		System.out.println("Running  ------------->>> MOVE MODE ");
		List<IShape> selectedList = shapeList.getSelectedList();
		
		for (IShape shape: selectedList)
		{	
			IShape SelectShape = shape;
			shapeList.deleteFromShapeList(SelectShape);
			moveSelectedShape(SelectShape.getShapeOption(), false);
			shapeList.addToShapeList(SelectShape);				
		}
		shapeList.reDrawShapes();	
		CommandHistory.add(this);
		System.out.println("The Shape is MOVED");		
	}

	
	@Override
	public void undo() {
		List<IShape> selectedList = shapeList.getSelectedList();
		for (IShape shape: selectedList)
		{
			IShape SelectShape = shape;
			shapeList.deleteFromShapeList(shape);
			moveSelectedShape(SelectShape.getShapeOption(), true);
			shapeList.addToShapeList(SelectShape);
		}
		shapeList.reDrawShapes();	
	}
	
	@Override
	public void redo() {
		List<IShape> selectedList = shapeList.getSelectedList();
		for (IShape shape: selectedList)
		{
			IShape SelectShape = shape;
			shapeList.deleteFromShapeList(shape);
			moveSelectedShape(SelectShape.getShapeOption(), false);
			shapeList.addToShapeList(SelectShape);	
		}
		shapeList.reDrawShapes();	
	}

}
