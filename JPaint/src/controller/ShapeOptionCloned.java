package controller;

import model.ShapeColor;
import model.ShapeOption;
import model.ShapeShadingType;
import model.ShapeType;

public class ShapeOptionCloned {
	
	private ShapeOption clonedOption;
	private  ShapeType shapeType;
	private  ShapeShadingType shadingType;
	private ShapeColor primaryColor;
	private  ShapeColor secondColor;
	
	public ShapeOptionCloned(ShapeOption shapeOption) {
		this.clonedOption = shapeOption;
		this.primaryColor = clonedOption.primaryColor;
		this.secondColor = clonedOption.secondColor;
		this.shadingType = clonedOption.shadingType;
		this.shapeType = clonedOption.shapeType;
	}
	
	@Override
	public Object clone() {
		ShapeOptionCloned clone = null;
	    try {
	    	clone = (ShapeOptionCloned) super.clone();
	    } catch (CloneNotSupportedException e) {
	       clone = new ShapeOptionCloned (this.getMyClonedOption());
	    }
	    clone.clonedOption = (ShapeOption) this.clonedOption.clone();
	    return clone ;
	}
	
	public ShapeOption getMyClonedOption() {
		this.clonedOption.setMyPrimeColor(primaryColor);
		this.clonedOption.setMySecondColor(secondColor);
		this.clonedOption.setMyShapeShadingType(shadingType);
		this.clonedOption.setMyShapeType(shapeType);
		return this.clonedOption;
	}
}
