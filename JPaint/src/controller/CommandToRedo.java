package controller;

import java.io.IOException;

import controller.interfaces.ICommand;

public class CommandToRedo implements ICommand {

	@Override
	public void run() throws IOException {
		CommandHistory.redo();
	}

}
