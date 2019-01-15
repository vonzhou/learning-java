package mythought.reflection.relfectionvscodegen;

import mythought.reflection.relfectionvscodegen.HolderBean;

import java.lang.reflect.Method;

/**
 * @author vonzhou
 * @date 2019/1/15
 */
public class ReflectAccess {
    public static void run(String fieldName) throws Exception {

        // create property name
        char lead = fieldName.charAt(0);
        String pname = Character.toUpperCase(lead) + fieldName.substring(1);

        // look up the get and set methods
        Method gmeth = HolderBean.class.getDeclaredMethod("get" + pname, new Class[0]);
        Method smeth = HolderBean.class.getDeclaredMethod("set" + pname, new Class[]{int.class});

        // increment value using reflection
        HolderBean bean = new HolderBean();
        Object start = gmeth.invoke(bean, null);
        int incr = ((Integer) start).intValue() + 1;
        smeth.invoke(bean, new Object[]{new Integer(incr)});

        // print the ending values
        System.out.println("Result values " + bean.getValue1() + ", " + bean.getValue2());
    }


    public static void main(String[] args) throws Exception {
        run("value1");
    }
}
