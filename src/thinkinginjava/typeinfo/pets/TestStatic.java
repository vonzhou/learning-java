package thinkinginjava.typeinfo.pets;

public class TestStatic {
	private static long counter = 0;
	private final long id = counter++;
	private String name;

	public TestStatic(String name) {
		this.name = name;
	}

	// 'name' is optional:
	public TestStatic() {
	}

	public String toString() {
		return getClass().getSimpleName() + (name == null ? "" : " " + name);
	}

	public long id() {
		System.out.println("=========" + this.counter);
		return id;
	}

	public boolean equals(Object o) {
		return o instanceof TestStatic && id == ((TestStatic) o).id;
	}

	public int hashCode() {
		int result = 17;
		if (name != null)
			result = 37 * result + name.hashCode();
		result = 37 * result + (int) id;
		return result;
	}

	public static void main(String[] args) {
		TestStatic t1 = new TestStatic("asdf");
		TestStatic t2 = new TestStatic("hello");
		System.out.println(t1.id());
		System.out.println(t2.id());
	}

}
