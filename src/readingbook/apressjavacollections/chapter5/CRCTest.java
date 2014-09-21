package readingbook.apressjavacollections.chapter5;

import java.io.*;
import java.security.*;

public class CRCTest {
  static private String hexDigit(byte x) {
    StringBuffer sb = new StringBuffer();
    char c;
    // First nibble
    c = (char) ((x >> 4) & 0xf);
    if (c > 9) {
      c = (char) ((c - 10) + 'a');
    } else {
      c = (char) (c + '0');
    }
    sb.append (c);
    // Second nibble
    c = (char) (x & 0xf);
    if (c > 9) {
      c = (char)((c - 10) + 'a');
    } else {
      c = (char)(c + '0');
    }
    sb.append (c);
    return sb.toString();
  }
  static private String computeDigest (MessageDigest algorithm, String filename) {
    String returnValue = "";
    try {
      algorithm.reset();
      FileInputStream fis = new FileInputStream(filename);
      BufferedInputStream bis = new BufferedInputStream(fis);
      DigestInputStream dis = new DigestInputStream(bis, algorithm);
      int ch;
      while ((ch = dis.read()) != -1);
      StringBuffer hexString = new StringBuffer();
      byte digest[] = algorithm.digest();
      int digestLength = digest.length;
      for (int i=0;i<digestLength;i++) {
        hexString.append (hexDigit(digest[i]));
        hexString.append (" ");
      }
      returnValue = hexString.toString();
    } catch (IOException e) {
      System.err.println("Error generating digest for: " + filename);
    }
    return returnValue;
  }
  public static void main (String args[]) {
    MessageDigest algorithm = null;
    Security.addProvider (new MyProvider());
    try {
      algorithm = MessageDigest.getInstance("CRC32");
    } catch (NoSuchAlgorithmException e) {
      System.err.println ("Invalid algorithm");
      System.exit (-1);
    }
    int argsLength = args.length;
    for (int i=0;i<argsLength;i++) {
      String digest = computeDigest (algorithm, args[i]);
      System.out.println(args[i] + " : " + digest);

    }
  }
}



