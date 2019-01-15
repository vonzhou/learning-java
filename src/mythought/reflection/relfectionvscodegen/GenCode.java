package mythought.reflection.relfectionvscodegen;


import javassist.*;

import java.lang.reflect.Method;
import java.security.SecureClassLoader;

/**
 * 使用 javaassit 生成一个 IAccess 接口的实现类
 *
 * @author vonzhou
 * @date 2019/1/15
 */
public class GenCode {
    /**
     * Parameter types for call with no parameters.
     */
    private static final CtClass[] NO_ARGS = {};
    /**
     * Parameter types for call with single int value.
     */
    private static final CtClass[] INT_ARGS = {CtClass.intType};

    protected static byte[] createAccess(Class tclas, Method gmeth, Method smeth, String cname) throws Exception {

        // build generator for the new class
        String tname = tclas.getName();
        ClassPool pool = ClassPool.getDefault();
        CtClass clas = pool.makeClass(cname);

        // 需要全限定名
        clas.addInterface(pool.get("mythought.reflection.relfectionvscodegen.IAccess"));
        CtClass target = pool.get(tname);

        // add target object field to class
        CtField field = new CtField(target, "m_target", clas);
        clas.addField(field);

        // add public default constructor method to class
        CtConstructor cons = new CtConstructor(NO_ARGS, clas);
        cons.setBody(";");
        clas.addConstructor(cons);

        // add public setTarget method
        CtMethod meth = new CtMethod(CtClass.voidType, "setTarget",
                new CtClass[]{pool.get("java.lang.Object")}, clas);
        meth.setBody("m_target = (" + tclas.getName() + ")$1;");
        clas.addMethod(meth);

        // add public getValue method
        meth = new CtMethod(CtClass.intType, "getValue", NO_ARGS, clas);
        meth.setBody("return m_target." + gmeth.getName() + "();");
        clas.addMethod(meth);

        // add public setValue method
        meth = new CtMethod(CtClass.voidType, "setValue", INT_ARGS, clas);
        meth.setBody("m_target." + smeth.getName() + "($1);");
        clas.addMethod(meth);

        // return binary representation of completed class
        return clas.toBytecode();
    }

    /**
     * Simple-minded loader for constructed classes.
     */
    protected static class DirectLoader extends SecureClassLoader {
        protected DirectLoader() {
            super(GenCode.class.getClassLoader());
        }

        protected Class load(String name, byte[] data) {
            return super.defineClass(name, data, 0, data.length);
        }
    }

    public static void main(String[] args) throws Exception {
        String pname = "Value1";
        Method gmeth = HolderBean.class.getDeclaredMethod("get" + pname, null);
        Method smeth = HolderBean.class.getDeclaredMethod("set" + pname, new Class[]{int.class});
        String cname = "IAccess$impl_HolderBean_" + gmeth.getName() + "_" + smeth.getName();
        byte[] bytes = createAccess(HolderBean.class, gmeth, smeth, cname);
        Class clas = new DirectLoader().load(cname, bytes);

        IAccess access = (IAccess) clas.newInstance();

        HolderBean bean = new HolderBean();
        access.setTarget(bean);
        access.setValue(100);

        System.out.println(bean);
    }

}
