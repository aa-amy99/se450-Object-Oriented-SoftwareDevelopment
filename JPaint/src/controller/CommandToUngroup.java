package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;
import model.ShapeLists;
import view.interfaces.IShape;

public class CommandToUngroup implements ICommand, IUndoRedo {
	private ShapeLists myShapeList;
	private List<IShape> myUndoRedoList = new ArrayList<>();
	Group group = new Group ();

	public CommandToUngroup(ShapeLists shapeList)
	{
		this.myShapeList = shapeList;

	}

	@Override
	public void run() throws IOException {
		System.out.println("Running ------------->>> UNGROUP MODE");
		List<IShape> selectedList = myShapeList.getSelectedList();
		group = selectedList.get(0).getShapeOption().getMyGroup();

		for (IShape shape: selectedList)
		{   
			myUndoRedoList.add(shape);
			myShapeList.addToShapeList(shape);
		}
		group.clear();
		myShapeList.getSelectedList().clear();
		myShapeList.reDrawShapes();
		CommandHistory.add(this);
		System.out.println("The Shape is UNGROUPED");		
	}


	@Override
	public void undo() {

		for (IShape shape : myUndoRedoList) {
			myShapeList.addToSelectedList(shape);
			myShapeList.deleteFromShapeList(shape);
			group.add(shape);
		}
		myShapeList.reDrawShapes();
	}


	@Override
	public void redo() {
		for (IShape shape : myUndoRedoList) {
			myShapeList.deleteFromSelectedList(shape);
			myShapeList.addToShapeList(shape);
			group.remove(shape);
		}
		myShapeList.getSelectedList().clear();
		myShapeList.reDrawShapes();
	}

}
