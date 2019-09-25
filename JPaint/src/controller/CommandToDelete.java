package controller;

import model.ShapeLists;
import view.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;
import java.io.IOException;

public class CommandToDelete implements ICommand, IUndoRedo {

	private ShapeLists shapeList;	
	private List<IShape> myUndoRedoList = new ArrayList<>();
	public CommandToDelete(ShapeLists shapeList)
	{
        this.shapeList = shapeList;
	}

	@Override
	public void run() throws IOException
	{
		System.out.println("Running ------------->>> DELETE MODE");
		List<IShape> mySelectedList = shapeList.getSelectedList();
		for (IShape shape : mySelectedList) {
			myUndoRedoList.add(shape);
			shapeList.deleteFromShapeList(shape);
		}
		shapeList.getSelectedList().clear();
		shapeList.reDrawShapes();
		CommandHistory.add(this);
		System.out.println("The shapes are DELETED");

	}

	@Override
	public void undo() {
		for (IShape shape : myUndoRedoList) {
			shapeList.addToShapeList(shape);
			shapeList.addToSelectedList(shape);
		}
		shapeList.reDrawShapes();
	}
		
	

	@Override
	public void redo() {
		for (IShape shape : myUndoRedoList) {
			shapeList.deleteFromShapeList(shape);
			shapeList.deleteFromSelectedList(shape);
		}
		shapeList.reDrawShapes();
	}
}
