package view.interfaces;

import javax.swing.*;

import view.gui.EventName;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
}
