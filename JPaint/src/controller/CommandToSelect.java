package controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoRedo;

import java.io.IOException;

import model.ShapeLists;
import model.ShapeOption;
import view.interfaces.IShape;

public class CommandToSelect implements ICommand, IUndoRedo{
	private Point startPT, endPT;
	private ShapeLists shapeList;
	private ShapeOption shapeOption;
	private List<IShape> myUndoRedoList = new ArrayList<>();
	private Group group;

	public CommandToSelect(ShapeOption shapeOption)
	{
		this.shapeOption = shapeOption;
		this.shapeList = shapeOption.shapeList;
		this.startPT = shapeOption.Start;
		this.endPT = shapeOption.End;
		this.group = shapeOption.getMyGroup();

	}

	@Override
	public void run() throws IOException
	{
		System.out.println("Running  ------------->>> SELECT MODE");
		shapeList.getSelectedList().clear();
		shapeList.getCopiedList().clear();

		List<IShape> myDrawList = shapeOption.shapeList.getShapeList();
		int startX = Math.min(startPT.getX(), endPT.getX());
		int startY = Math.min(startPT.getY(), endPT.getY()); 
		int width = Math.abs(endPT.getX() - startPT.getX());
		int height = Math.abs(endPT.getY() - startPT.getY());

		
		for (IShape shape: myDrawList)
		{ 	//AABB collision
			ShapeOption shapeOption = shape.getShapeOption();
			if (startX +  width - shapeOption.getMyStartPT().getX() >= 0 && shapeOption.getMyStartPT().getX() + shapeOption.width - startX >= 0
					&& startY + height - shapeOption.getMyStartPT().getY() >=0 && shapeOption.getMyStartPT().getY() + shapeOption.height - startY >=0 )
			{ 
				shapeList.addToSelectedList(shape);
				myUndoRedoList.add(shape);
			}

			if (group.groupList.size() > 1) {
				int minX = group.findXmaxmin()[0];
				int minY = group.findYminmax()[0];
				int w = Math.abs(group.findXmaxmin()[1]-minX);
				int h = Math.abs(group.findYminmax()[1]-minY);
				if (startX +  width - minX >= 0 && minX + w - startX >= 0 && startY + height - minY >=0 && minY + h - startY >=0 ){
					for (IShape s: group.groupList){
						shapeList.addToSelectedList(s);
						myUndoRedoList.add(s);
					}}}}
		
		List<IShape> newList = new ArrayList<IShape> (new LinkedHashSet<IShape> (shapeList.getSelectedList()));
		shapeList.setSelectedList(newList);
		shapeList.reDrawShapes();
		CommandHistory.add(this);
		System.out.println("The Shape is SELECTED");
	}	
	
	@Override
	public void undo() {
		for (IShape shape : myUndoRedoList) {
			shapeList.deleteFromSelectedList(shape);
		}
		shapeList.reDrawShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : myUndoRedoList) {
			shapeList.addToSelectedList(shape);
		}
		shapeList.reDrawShapes();
	}
}

