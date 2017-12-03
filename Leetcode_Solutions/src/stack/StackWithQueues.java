package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * (One Queue, push - O(n), pop O(1) )
 *
 */

//one queue solution
public class StackWithQueues {
	private Queue<Integer> q1 = new LinkedList<Integer>();
	
	/*
	push 3 ---> 3
	-> reverse: 3

	push 5 ---> 3,5
	->reverse: 5,3

	push 2 ---> 5,3,2
	->reverse: 2,5,3

	pop ---> 5,3
	*/
	
	//push elements x onto stack
	public void push(int x) {
		q1.add(x);
		for (int i = 1; i < q1.size(); i++) { //rotate the queue
			q1.add(q1.poll());
		}
	}
	
	//remove the element on top of the stack
	public void pop() {
		q1.poll();
	}
	
	//get the element
	public int peek() {
		return q1.peek();
	}
	
	public boolean isEmpty() {
		return q1.isEmpty();
	}

}
