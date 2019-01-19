package framework.vavr;

import io.vavr.Tuple2;
import io.vavr.collection.Queue;
import io.vavr.control.Option;

/**
 * @author vonzhou
 * @date 2018/12/17
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = Queue.of(1, 2, 3)
                .enqueue(4)
                .enqueue(5);

        System.out.println(queue);

        queue = Queue.of(1, 2, 3);

// = (1, Queue(2, 3))
        Tuple2<Integer, Queue<Integer>> dequeued =
                queue.dequeue();
        System.out.println(dequeued);


        // = Some((1, Queue()))
        Queue.of(1).dequeueOption();

// = None
        Queue.empty().dequeueOption();
//        Queue.empty().dequeue();

        f2();
    }

    private static void f2() {
        // = Queue(1)
        Queue<Integer> queue = Queue.of(1);

// = Some((1, Queue()))
        Option<Tuple2<Integer, Queue<Integer>>> dequeued =
                queue.dequeueOption();

// = Some(1)
        Option<Integer> element = dequeued.map(Tuple2::_1);

// = Some(Queue())
        Option<Queue<Integer>> remaining =
                dequeued.map(Tuple2::_2);
        System.out.println("x");
    }
}
