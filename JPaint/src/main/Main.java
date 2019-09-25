package main;

import controller.Group;
import controller.JPaintController;
import controller.MouseHandler;
import controller.interfaces.IJPaintController;
import model.ShapeLists;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	
    	ShapeLists shapeList = new ShapeLists();
    	Group group = new Group();
    	PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, group);
        
        MouseHandler mouse = new MouseHandler(appState, paintCanvas, shapeList, group);
    	paintCanvas.addMouseListener(mouse);
        controller.setup();
        
        // Clears the Canvas
        //paintCanvas.repaint();
    }
}