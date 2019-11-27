package basic;

public class Code_01_Array_To_Stack_Queue {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(Integer initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            this.size = 0;
            this.arr = new Integer[initSize];
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return this.arr[this.size - 1];
        }

        public void push(Integer obj) {
            if (this.size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");

            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if (this.size == 0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--size];
        }

    }

    public static class ArrayQueue {
        private Integer[] arr;
        private int size;
        private int start;
        private int end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }

            this.arr = new Integer[initSize];
            this.size = 0;
            this.start = 0;
            this.end = 0;
        }

        public void push(Integer obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");

            }
            size--;
            Integer tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }
}
