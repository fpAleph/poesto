package fpaleph.poesto.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

import com.google.gson.JsonObject;

import fpaleph.poesto.SkillTree;
import fpaleph.poesto.SkillTreeBuilder;
import fpaleph.poesto.ggg.SkillTreeJsonScraper;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public MainFrame() {
		Container pane = getContentPane();
		BorderLayout bl = new BorderLayout();
		pane.setLayout(bl);
		
		JsonObject jo = null;
		try {
			jo = SkillTreeJsonScraper.scrapeData(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SkillTree st = SkillTreeBuilder.fromJson(jo);
		
		SkillTreePanel skillTreePane = new SkillTreePanel(st);
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
