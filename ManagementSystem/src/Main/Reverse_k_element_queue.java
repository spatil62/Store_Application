package Main;

import java.util.*;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Reverse_k_element_queue {
    static Queue<Integer> queue;
 
    // Function to reverse the first
    // K elements of the Queue
    static void reverseQueueFirstKElements(int k)
    {
        if (queue.isEmpty() == true || k > queue.size())
            return;
        if (k <= 0)
            return;
 
        Stack<Integer> stack = new Stack<Integer>();
 
        // Push the first K elements into a Stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.peek());
            queue.remove();
        }
 
        // Enqueue the contents of stack
        // at the back of the queue
        while (!stack.empty()) {
            queue.add(stack.peek());
            stack.pop();
        }
 
        // Remove the remaining elements and enqueue
        // them at the end of the Queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }
 
    // Utility Function to print the Queue
    static void Print()
    {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }
 
    // Driver code
    public static void main(String args[])
    {
        queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
 
        int k = 4;
        reverseQueueFirstKElements(k);
        Print();
    }
}