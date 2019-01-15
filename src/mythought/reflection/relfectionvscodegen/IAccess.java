package mythought.reflection.relfectionvscodegen;

/**
 * @author vonzhou
 * @date 2019/1/15
 */
public interface IAccess {
    void setTarget(Object target);

    int getValue();

    void setValue(int value);
}
