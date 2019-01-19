package serialization.jackson;

/**
 * @author vonzhou
 * @date 2018/12/20
 */
public class GetMethodWillSerDemo {
    public static void main(String[] args) {
        Foo f = new Foo();
        f.setName("zs");
        String s = JacksonUtils.toJsonStr(f);
        System.out.println(s);
    }


  static class Foo{
        String name;
        public int getAge(){
            return 1;
        }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }
  }
}
