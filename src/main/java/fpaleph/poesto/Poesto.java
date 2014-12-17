package fpaleph.poesto;

import java.awt.EventQueue;

import fpaleph.poesto.gui.PoestoFrame;

/**
 * TODO
 */
public class Poesto {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				PoestoFrame pf = PoestoFrame.load();
				pf.setVisible(true);
			}
		});
	}

}
