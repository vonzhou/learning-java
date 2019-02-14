package lang.enumsingleton;

import lang.enumsingleton.ColorEnum;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED.name());
        System.out.println(ColorEnum.RED == ColorEnum.valueOf("RED"));
        System.out.println(ColorEnum.RED == Enum.valueOf(ColorEnum.class, "RED")); // true
    }
}
