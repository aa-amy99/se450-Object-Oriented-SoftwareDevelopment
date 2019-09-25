package controller;

import java.io.IOException;

import controller.interfaces.IJPaintController;
import model.ShapeLists;
import model.interfaces.IApplicationState;
import view.gui.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ShapeLists shapeList;
    private Group group;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeLists shapeList, Group group) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.group = group;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> {
			try {new CommandToCopy(shapeList).run();
			} catch (IOException e) { e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.PASTE, () -> {
			try { new CommandToPaste(shapeList).run();
			} catch (IOException e) {e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.DELETE, () -> {
			try { new CommandToDelete(shapeList).run();
			} catch (IOException e) {e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.GROUP, () -> {
			try { new CommandToGroup(shapeList).run();
			} catch (IOException e) {e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.UNGROUP, () -> {
			try { new CommandToUngroup(shapeList).run();
			} catch (IOException e) {e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.REDO, () -> {
			try { new CommandToRedo().run();
			} catch (IOException e) {e.printStackTrace();}
		});
        
        uiModule.addEvent(EventName.UNDO, () -> {
			try { new CommandToUndo().run();
			} catch (IOException e) {e.printStackTrace();}
		});
    }
}
