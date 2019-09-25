package controller;

import model.ShapeLists;
import model.ShapeOption;
import view.ShapeFactory;
import view.interfaces.IShape;
import java.util.List;

import controller.interfaces.ICommand;

import java.io.IOException;


public class CommandToCopy implements ICommand {

	private ShapeLists myShapeList;

	public CommandToCopy(ShapeLists shapeList)
	{
		this.myShapeList = shapeList;
	}

	@Override
	public void run() throws IOException
	{	
		System.out.println("Running ------------->>> COPY MODE");
		List<IShape> mySelectedList = myShapeList.getSelectedList();
		myShapeList.getCopiedList().clear();
		for (IShape shape : mySelectedList)
		{ 	
			ShapeOption orginalOption = shape.getShapeOption();
			ShapeOptionCloned clonedObject = new ShapeOptionCloned(orginalOption);
			ShapeOptionCloned  deepCopy = (ShapeOptionCloned) clonedObject.clone();
			ShapeOption copiedOption = deepCopy.getMyClonedOption();
			if (!(orginalOption.equals(copiedOption))) {
				ShapeFactory shapeFactory = new ShapeFactory();
				IShape copiedShape = shapeFactory.createShape(copiedOption);
				myShapeList.addToCopiedList(copiedShape);
			}
		}
		System.out.println("The shapes are COPIED");
	}
}


	
	










