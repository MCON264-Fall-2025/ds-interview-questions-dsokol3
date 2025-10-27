package edu.touro.mcon264.s7_min_stack;

public class Main {
    public static final int NUM1 = 18;
    public static final int NUM2 = 19;
    public static final int NUM3 = 29;
    public static final int NUM4 = 15;
    public static final int NUM5 = 16;

    public static void main(String[] args) {
        Solution stack = new Solution();

        System.out.println("Operation\tStack (st)\tMin Stack (minSt)\tCurrent Min");

        stack.push(NUM1);
        System.out.println("push(18)\t" + stack.getStacksString());

        stack.push(NUM2);
        System.out.println("push(19)\t" + stack.getStacksString());

        stack.push(NUM3);
        System.out.println("push(29)\t" + stack.getStacksString());

        stack.push(NUM4);
        System.out.println("push(15)\t" + stack.getStacksString());

        stack.push(NUM5);
        System.out.println("push(16)\t" + stack.getStacksString());
    }
}
