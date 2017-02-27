package controller;

import java.io.File;
import java.util.Arrays;
import javax.servlet.http.Part;

public class UploadFiles {

  private  String appPath = "/home/liga/Downloads/Uploads";

  public  String getFullSavePath(String saveDirectory) {
    if (saveDirectory.startsWith("/")) {
      saveDirectory = saveDirectory.substring(1);
    }
    String[] pach = saveDirectory.split("/");
    // The directory to save uploaded file
//    String fullSavePath = null;
    String fullSavePath = appPath;
    for (String s : pach) {
      fullSavePath += "/"+s;
      File fileSaveDir = new File(fullSavePath);
      fileSaveDir.mkdir();
    }
//    if (appPath.endsWith("/")) {
//      fullSavePath = appPath + saveDirectory;
//    } else {
//      fullSavePath = appPath + "/" + saveDirectory;
//    }

    // Creates the save directory if it does not exists

//    File fileSaveDir = new File(fullSavePath);
//    if (!fileSaveDir.exists()) {
//      fileSaveDir.mkdir();
//    }
    return fullSavePath;
  }
}
