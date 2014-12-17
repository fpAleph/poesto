package fpaleph.poesto.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

import com.google.gson.JsonObject;

import fpaleph.poesto.data.SkillTree;
import fpaleph.poesto.integ.SkillTreeJsonScraper;

@SuppressWarnings("serial")
public class OBSPoestoFrame extends JFrame {

	public OBSPoestoFrame() {
		Container pane = getContentPane();
		BorderLayout bl = new BorderLayout();
		pane.setLayout(bl);

		JsonObject jo = null;
		try {
			jo = SkillTreeJsonScraper.scrapeData(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SkillTree st = SkillTree.loadFromJson(jo);

		OBSSkillTreePanel skillTreePane = new OBSSkillTreePanel(st);
		addMouseListener(skillTreePane);
		addMouseMotionListener(skillTreePane);
		skillTreePane.setOpaque(false);
		pane.add(skillTreePane);

		setTitle("PoE Skill Tree Optimizer");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
