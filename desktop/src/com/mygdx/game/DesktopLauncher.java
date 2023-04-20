package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Minesweeper");
		config.setWindowedMode(512, 600); //564
		config.setResizable(false);
		config.setInitialBackgroundColor(new Color(Color.GRAY));
		new Lwjgl3Application(new Boot(), config);

	}
}
