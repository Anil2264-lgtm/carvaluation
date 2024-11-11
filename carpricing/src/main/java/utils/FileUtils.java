package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

	public String readTextFile(String fileName) {
		String filePath = "src/main/resources/files/"+fileName+".txt";
		String fileContent = "";
        try {
        	fileContent = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
		return fileContent;
	}
	
	public List<String> extractPatternMatcher(String fileContent) {
		List<String> patterns = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\b[A-Z]{2}\\d{2} [A-Z]{3}\\b");
        Matcher matcher = pattern.matcher(fileContent);
        while (matcher.find()) {
        	patterns.add(matcher.group());
            
        }
        return patterns;
	}
}
