package controller;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import controller.interfaces.ICommand;
import model.ShapeLists;
import model.StartAndEndPointMode;
import model.ShapeOption;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseHandler extends MouseAdapter{

	Graphics2D g;
	ShapeOption shapeOption;
	ShapeType shapeType;
	ShapeLists shapeList;
	ApplicationState appState;
	PaintCanvasBase paintCanvas;
	Point StartPT, EndPT; 
	Group group;


	public MouseHandler(ApplicationState applicationState, PaintCanvasBase paintCanvas, ShapeLists shapeList, Group group)
	{
		this.appState = applicationState;
		this.paintCanvas = paintCanvas;
		this.shapeList = shapeList; 
		this.group = group;
	}

	@Override
	public void mousePressed(MouseEvent event)
	{
		System.out.println("\nPressing Mouse ");
		StartPT = new Point(event.getX(), event.getY());
		System.out.println("(x0,y0) is " + "(" + event.getX()+ "," + event.getY() + ")\n");
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{

		System.out.println("Releasing Mouse ");
		EndPT = new Point(e.getX(), e.getY());
		System.out.println("(x1,y1) is " + "(" + e.getX() + "," + e.getY() + ")\n");

		Graphics2D graph = paintCanvas.getGraphics2D();
		if((graph == null || appState == null || shapeList == null || StartPT == null || EndPT == null) != true)

		shapeOption = new ShapeOption(graph, appState, shapeList, StartPT, EndPT, group);

		StartAndEndPointMode myMode = appState.getActiveStartAndEndPointMode();
		
		ICommand shapeCommand;
		
		switch (myMode) {
		case DRAW: 
			shapeCommand = new CommandToCreate(shapeOption);
			break;

		case MOVE: 
			shapeCommand = new CommandToMove(shapeOption);
			break;

		case SELECT: 
			shapeCommand = new CommandToSelect(shapeOption);
			break;

		default:
			shapeCommand = new CommandToCreate(shapeOption);

		}
		try {
			shapeCommand.run();
		} catch (IOException err) {
			err.printStackTrace();
		}
	}

}