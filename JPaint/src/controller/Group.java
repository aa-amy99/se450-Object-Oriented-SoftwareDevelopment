package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import model.ShapeOption;
import view.AbstractShape;
import view.interfaces.IShape;

public class Group extends AbstractShape implements IShape {

	//Grouped Shapes
	public List<IShape> groupList = new ArrayList<IShape>();
	private ShapeOption shapeOption;


	//adding shape 
	public void add(IShape shape){ 
		this.groupList.add(shape);	
	}

	//removing shape from drawing
	public void remove(IShape shape){ groupList.remove(shape);}

	//removing all the shapes
	public void clear(){ this.groupList.clear();}
	
	public int[] findXmaxmin() {
		int[] res = new int [2];
		int Xmin = groupList.get(0).getShapeOption().getMyStartPT().getX();
		int Xmax = -1;
		int len = groupList.size();
		for (int i = 1; i< len; i++) {
			IShape s = groupList.get(i);
			int Xshape = s.getShapeOption().getMyStartPT().getX();
			int w =  s.getShapeOption().width;
			Xmin = Math.min(Xshape, Xmin);
			Xmax = Math.max(Xshape + w -1  , Xmax);
		}
			res[0] = Xmin;
			res[1] = Xmax;
		
		return res;
	}
	
	public int [] findYminmax() {
		int[] res = new int [2];
		int Ymin = groupList.get(0).getShapeOption().getMyStartPT().getY();
		int Ymax = -1;
		int len = groupList.size();
		for (int i = 1; i< len; i++) {
			IShape s = groupList.get(i);
			int Yshape = s.getShapeOption().getMyStartPT().getY();
			int h = s.getShapeOption().height;
			Ymin = Math.min(Yshape, Ymin);
			Ymax = Math.max(Yshape + h -1, Ymin);
		}
		res[0] = Ymin;
		res[1] = Ymax;
		return res;
	}
	
	@Override
	public void drawShape(){
		for (IShape shape: groupList)
			shape.drawShape();	
	}
	@Override
	public void fillShape(Color myColor) {
		for (IShape shape: groupList)
		shape.fillShape(myColor);	
	}
	@Override
	public void outlineShape(Color myColor) {
		for (IShape shape: groupList)
			shape.outlineShape(myColor);}

	@Override
	public ShapeOption getShapeOption(){return shapeOption;}

	@Override
	public void setNewShapeOption(ShapeOption newSO){this.shapeOption = newSO;} 

}
