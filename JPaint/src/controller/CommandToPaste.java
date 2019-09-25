package controller;

import model.ShapeLists;
import model.ShapeOption;
import view.interfaces.IShape;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class CommandToPaste implements ICommand, IUndoRedo{
	private ShapeLists myShapeList;
	ICommand shapeCommand;
	private List<IShape> myPastedList = new ArrayList<>();
	private List<IShape> myUndoRedoList = new ArrayList<>();
	public CommandToPaste(ShapeLists shapeList)
	{
		this.myShapeList = shapeList;
	}

	@Override
	public void run() throws IOException
	{	
		System.out.println("Running ------------->>> PASTE MODE");
		List<IShape> myCopiedList = myShapeList.getCopiedList();
	
		int offset = 100;
		for (IShape shape : myCopiedList)
		{
			IShape pastedShape = shape; //for pasting multiple times
			ShapeOption orginalOption = shape.getShapeOption();
			ShapeOptionCloned clonedObject = new ShapeOptionCloned(orginalOption);
			ShapeOptionCloned  deepCopy = (ShapeOptionCloned) clonedObject.clone();
			ShapeOption copiedOption = deepCopy.getMyClonedOption();
			
			pastedShape.setNewShapeOption(copiedOption);
			pastedShape.getShapeOption().setNewPastedStartPT(pastedShape.getShapeOption().getMyStartPT().getX()+ offset , pastedShape.getShapeOption().getMyStartPT().getY()+ offset);
			pastedShape.getShapeOption().setNewPastedEndPT(pastedShape.getShapeOption().getMyEndPT().getX() + offset, pastedShape.getShapeOption().getMyEndPT().getY()+ offset);		
			myPastedList.add(pastedShape);
		}

		for (IShape shape : myPastedList) {
			CommandToCreate newPastedShape = new CommandToCreate(shape.getShapeOption()); 
			newPastedShape.run();
			myUndoRedoList.add(newPastedShape.shape);
		}
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		for (IShape shape : myUndoRedoList) {
			myShapeList.deleteFromShapeList(shape);
		}
		myShapeList.reDrawShapes();
	}
	

	@Override
	public void redo() {
		for (IShape shape : myUndoRedoList) {
			myShapeList.addToShapeList(shape);
		}
		myShapeList.reDrawShapes();
	}
}


