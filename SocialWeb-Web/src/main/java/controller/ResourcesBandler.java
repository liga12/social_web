package controller;


import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class ResourcesBandler {
    private static final String encodingFrom = "ISO-8859-1";
    private static final String encodingTo = "UTF-8";
    private static final String emailFile = "Email";

    String getResourcesEmail(String key) {
        ResourceBundle emailResources = ResourceBundle.getBundle(emailFile);
        String value = emailResources.getString(key);
        String recoded = null;
        try {
            recoded = new String(value.getBytes(encodingFrom), encodingTo);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return recoded;

    }

}
