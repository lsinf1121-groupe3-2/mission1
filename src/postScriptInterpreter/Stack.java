package postScriptInterpreter;

import postScriptInterpreter.exception.EmptyStackException;

/**
 * Implementation of the interface : IStack
 *
 */
public class Stack implements IStack<String> {

	private int size;
	private Node first;
	
	private class Node {
		private String element;
		private Node next;
	}
	
	public Stack() {
		this.size = 0;
		this.first = null;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public String top() throws EmptyStackException {
		return this.first.element;
	}

	@Override
	public void push(String element) {
		Node current = first;
		first = new Node();
		first.element = element;
		first.next= current;
		size++;
		
	}

	@Override
	public String pop() throws EmptyStackException {
		if(this.isEmpty()) throw new EmptyStackException();
		String element = first.element;
		first = first.next;
		size--;
		return element;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = first;
		while(tmp != null) {
			sb.append(tmp.element).append(" ");
			tmp = tmp.next;
		}
		return sb.toString()+"\n";
	}

}
