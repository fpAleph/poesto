package fpaleph.poesto.ggg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SkillTreeJsonScraper {
	private static String TARGET = "http://www.pathofexile.com/passive-skill-tree";

	public static JsonObject scrapeData(String version) throws IOException {
		URL url = new URL(TARGET);
		URLConnection uc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "UTF-8"));

		String data = null;
		for (String line = in.readLine(); null != line; line = in.readLine()) {
			if (line.contains("var passiveSkillTreeData =")) {
				data = line;
				break;
			}
		}
		
		//                 var passiveSkillTreeData = {
		//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^
		data = data.replaceFirst("var passiveSkillTreeData =", "");

		// },\n
		// ^^^
		data = data.substring(0, data.length() - 2);

		return new JsonParser().parse(data).getAsJsonObject();
	}
}
