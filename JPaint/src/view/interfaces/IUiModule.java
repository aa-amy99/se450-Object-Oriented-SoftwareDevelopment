package view.interfaces;

import view.gui.EventName;

public interface IUiModule {
    void addEvent(EventName eventName, IEventCallback command);
    <T> T getDialogResponse(IDialogChoice dialogChoice);
}
