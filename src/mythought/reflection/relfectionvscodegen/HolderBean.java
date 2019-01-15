package mythought.reflection.relfectionvscodegen;

/**
 * @author vonzhou
 * @date 2019/1/15
 */
public class HolderBean
{
    private int m_value1;
    private int m_value2;

    public int getValue1() {
        return m_value1;
    }
    public void setValue1(int value) {
        m_value1 = value;
    }

    public int getValue2() {
        return m_value2;
    }
    public void setValue2(int value) {
        m_value2 = value;
    }

    @Override
    public String toString() {
        return "HolderBean{" +
                "m_value1=" + m_value1 +
                ", m_value2=" + m_value2 +
                '}';
    }
}
