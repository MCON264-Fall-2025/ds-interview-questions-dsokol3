package org.example;

import java.util.Stack;

public class MinimumStack {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();

        public void push(int x) {
            st.push(x);

            // If the minSt is empty or the new element is smaller than
            // the top of minSt, push it onto minSt
            if (minSt.isEmpty() || x <= minSt.peek()) {
                minSt.push(x);
            } else {

                // Otherwise, push the top element of minSt
                // again to keep the minimum unchanged
                minSt.push(minSt.peek());
            }
        }

        // Pop the top element from the stack
        public void pop() {
            if (st.isEmpty()) {
                return;
            }
            // Pop from both stacks
            st.pop();
            minSt.pop();
        }

        // Return the top element of the stack without removing it
        public int peek() {
            if (st.isEmpty()) {
                return -1;
            }
            return st.peek();
        }

        // Get the minimum element in the stack
        public int getMin() {
            if (minSt.isEmpty()) {
                return -1;
            }
            return minSt.peek();
        }

        //toString() so i can print it neatly in Main
        public String getStacksString() {
            return st + "\t" + minSt + "\t" + getMin();
        }
    }

