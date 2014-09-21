package readingbook.apressjavacollections.chapter5;

import java.security.*;
import java.util.zip.CRC32;

//
public class CRC extends MessageDigest {
  CRC32 crc;
  public CRC() {
    super("CRC");
    crc = new CRC32();
  }
  protected void engineReset() {
    crc.reset();
  }
  protected void engineUpdate(byte input) {
    crc.update(input);
  }
  protected void engineUpdate(byte[] input,
      int offset, int len) {
    crc.update(input, offset, len);
  }
  protected byte[] engineDigest() {
    long l = crc.getValue();
    byte[] bytes = new byte[4];
    bytes[3] = (byte) ((l & 0xFF000000) >> 24);
    bytes[2] = (byte) ((l & 0x00FF0000) >> 16);
    bytes[1] = (byte) ((l & 0x0000FF00) >> 8);
    bytes[0] = (byte) ((l & 0x000000FF) >> 0);
    return bytes;
  }
}
