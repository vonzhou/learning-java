package mythought.reflection.relfectionvscodegen;

/**
 * @author vonzhou
 * @date 2019/1/15
 */
public class AccessValue1 implements IAccess {
    private HolderBean m_target;

    public void setTarget(Object target) {
        m_target = (HolderBean) target;
    }

    public int getValue() {
        return m_target.getValue1();
    }

    public void setValue(int value) {
        m_target.setValue1(value);
    }
}
