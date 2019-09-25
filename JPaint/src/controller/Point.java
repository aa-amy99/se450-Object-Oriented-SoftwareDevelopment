package controller;

public class Point {

	private int x;
	private int y;
	Point point;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()  { return x; }
	public int getY()  { return y; }

	public void setXY(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public Point getPoint(){ return point;}

}
