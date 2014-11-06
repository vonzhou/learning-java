package thinkinginjava.io;

import java.nio.*;
import static thinkinginjava.util.Print.*;


/// »á½Ø¶Ï´¦Àí
public class ViewBuffers2 {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer
				.wrap(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 'a' });
		bb.rewind();
		printnb("Byte Buffer ");
		while (bb.hasRemaining())
			printnb(bb.position() + " -> " + bb.get() + ", ");
		print();
		
		CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
		printnb("Char Buffer ");
		while (cb.hasRemaining())
			printnb(cb.position() + " -> " + cb.get() + ", ");
		print();
		
		FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
		printnb("Float Buffer ");
		while (fb.hasRemaining())
			printnb(fb.position() + " -> " + fb.get() + ", ");
		print();
		
		IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
		printnb("Int Buffer ");
		while (ib.hasRemaining())
			printnb(ib.position() + " -> " + ib.get() + ", ");
		print();
		
		LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
		printnb("Long Buffer ");
		while (lb.hasRemaining())
			printnb(lb.position() + " -> " + lb.get() + ", ");
		print();
		
		ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
		printnb("Short Buffer ");
		while (sb.hasRemaining())
			printnb(sb.position() + " -> " + sb.get() + ", ");
		print();
		
		DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
		printnb("Double Buffer ");
		while (db.hasRemaining())
			printnb(db.position() + " -> " + db.get() + ", ");
	}
} 
