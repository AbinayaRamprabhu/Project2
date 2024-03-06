package library;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

  public static String generateCurrentDateAndTime() {
    return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
}
}