package socit.web;

import java.io.*;

public class HtmlToString {
    private static final InputStream resourcesHtml = HtmlToString.class.getClassLoader().
            getResourceAsStream("emailHtml.html");

    public String getEmailStringHtml() {
        String stringHtml = null;
        BufferedReader in;
        String string;
        StringBuffer stringBuffer = null;
        try {
            in = new BufferedReader(new InputStreamReader(resourcesHtml));
            stringBuffer = new StringBuffer();
            while ((string = in.readLine()) != null) {
                stringBuffer.append(string + "\n");
            }
            stringHtml = stringBuffer.toString();
            System.out.println(stringHtml);
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stringHtml;
    }

    public void run() {
        String testFilePath = getResourcePath("emailHtml.html");
        System.out.println(testFilePath);

    }

    String getResourcePath(String file) {
        return getClass().getResource("/").getPath() + "../resourses/" + file;
    }

    public String getPathToThis() {
        return this.getClass().getName().replace(".", "/") + ".java";
    }


}
