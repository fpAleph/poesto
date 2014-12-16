package fpaleph.poesto;

import java.awt.EventQueue;
import java.io.IOException;

import com.google.gson.JsonObject;

import fpaleph.poesto.ggg.SkillTreeJsonScraper;
import fpaleph.poesto.gui.MainFrame;

/**
 * TODO
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
	}

}
