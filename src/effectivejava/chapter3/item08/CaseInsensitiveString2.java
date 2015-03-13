// Broken - violates symmetry! - Pages 30
package effectivejava.chapter3.item08;

public final class CaseInsensitiveString2 {
	private final String s;

	public CaseInsensitiveString2(String s) {
		if (s == null)
			throw new NullPointerException();
		this.s = s;
	}

	// This version is correct.
	@Override
	public boolean equals(Object o) {
		return o instanceof CaseInsensitiveString2
				&& ((CaseInsensitiveString2) o).s.equalsIgnoreCase(s);
	}

	public static void main(String[] args) {
		CaseInsensitiveString2 cis = new CaseInsensitiveString2("Polish");
		String s = "polish";
		System.out.println(cis.equals(s) + "  " + s.equals(cis));
	}
}
