

package postScriptInterpreter;

import postScriptInterpreter.exception.EmptyStackException;

/**
 * Define the methods that a Stack class must implements to be manipulated by an Interpreter.
 * @param <E> the type of elements that the Stack will contains.
 */
public interface IStack<E> {
    /**
     * Return the number of elements in the stack.
     * @pre --
     * @post return number of elements in the stack.
     * @return number of elements in the stack.
     */
    public int size();
    
    /**
     * Return wheter the stack is empty.
     * @pre --
     * @post return true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * Inspect the element at the top of the stack.
     * @pre --
     * @post return top element of the stack, run a exception if the stack is empty.
     * @return top element of the stack, run a exception if the stack is empty.
     * @throws EmptyStackException if the stack is empty.
     */
    public E top() throws EmptyStackException;
    
    /**
     * Insert an element at the top of the stack.
     * @param element to be inserted.
     * @pre --
     * @post the stack has a new element in the front.
     */
    public void push(E element);
    
    /**
     * Remove the top lement from the stack.
     * @pre --
     * @post Element at the front of the queue is removed, return element remover and run an excpetion if the stak is empty.
     * @return element removed.
     * @throws EmptyStackException if the stack is empty.
     */
    public E pop() throws EmptyStackException;
    
    /**
     * Create a string that represent the stack.
     * @pre --
     * @post --
     * @return string representing the stack.
     */
    @Override
    public String toString();
}
