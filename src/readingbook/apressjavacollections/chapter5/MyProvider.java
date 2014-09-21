package readingbook.apressjavacollections.chapter5;

import java.security.Provider;
public class MyProvider extends Provider {
  public MyProvider() {
    super("Zukowski", 1.0,"Zukowski Collections Example");
    put("MessageDigest.CRC32", "CRC");
  }
}
