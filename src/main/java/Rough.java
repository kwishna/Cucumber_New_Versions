import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Rough {
	private static void findTextInThisWorkSpace(String workSpace, String textToFind) {
	List<File> l = (List<File>) FileUtils.listFiles(new File(workSpace), new String[]{"java"}, true);
        l.parallelStream().filter(a -> {
		String allData = "";
		try {
                allData = new String(Files.readAllBytes(a.toPath()));

		} catch (IOException e) {
			System.err.println("Error Here : " + a.getAbsolutePath());
			System.err.println("Error Here : " + e.getMessage());
		}
		return allData.toLowerCase().contains(textToFind.toLowerCase());
	}).forEach(x -> System.out.println(x.getAbsolutePath()));
}

	public static void main(String[] args) {

		findTextInThisWorkSpace("E:\\Bhole_Nath\\Eclipse_WorkSpace", "/jira/rest/agile/1.0/issue/");
	}
}
