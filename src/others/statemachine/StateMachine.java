package others.statemachine;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vonzhou
 */
@Data
public class StateMachine {

    private FooDAO fooDAO;

    public void stateTransfer1(Long id, String prevStatus, String status) {
        fooDAO.updateStatusTo(id, prevStatus, status);
    }

    private static final Map<String, List<String>> PREV_STATUS = new HashMap<>();

    static {
        PREV_STATUS.put("SUCCESS", Arrays.asList("AAA", "BBB"));
        PREV_STATUS.put("FAIL", Arrays.asList("CCC"));
    }

    public void stateTransfer2(Long id, String status) {
        // do in transaction
        Foo foo1 = fooDAO.lockById(id);
        if (PREV_STATUS.get(status).contains(foo1.getStatus())) {
            fooDAO.updateStatus(id, status);
        }
    }
}