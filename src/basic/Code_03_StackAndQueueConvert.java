package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

    public static class TwoQueueStack {
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(Integer obj) {
            queue.add(obj);
        }

        public Integer pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }
            while (queue.size() > 1) {
                help.add(queue.poll());
            }
//            for (int i = 0; i < queue.size() - 1; i++) {      //不能这样写，每次循环queueu.size()都会变
//                help.add(queue.poll());
//            }
            Integer re = queue.poll();
            swap();
            return re;
        }

        public Integer peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }

            while (queue.size() > 1) {
                help.add(queue.poll());
            }

//            for (int i = 0; i < queue.size() - 1; i++) {
//                help.add(queue.poll());
//            }
            Integer re = queue.poll();
            help.add(re);
            swap();
            return re;
        }

        public void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = help;
        }

        public static void main(String[] args) {
            TwoQueueStack mystack = new TwoQueueStack();
            mystack.push(1);
            mystack.push(2);
            mystack.push(3);
            int tmp = mystack.pop();
            System.out.println(tmp);
        }
    }

    public static class TwoStackQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public TwoStackQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void push(Integer obj) {
            push.push(obj);
        }

        public Integer peek() {
            if (pop.empty() && push.empty()){
                throw new RuntimeException("The queue is empty");
            }
            if(pop.empty()){
                pour();
            }
            return pop.peek();
        }

        public Integer poll() {
            if (pop.empty() && push.empty()){
                throw new RuntimeException("The queue is empty");
            }
            if(pop.empty()){
                pour();
            }
            return pop.pop();
        }

        public void pour() {
            while (!push.empty()) {
                pop.push(push.pop());
            }
        }
    }
}
