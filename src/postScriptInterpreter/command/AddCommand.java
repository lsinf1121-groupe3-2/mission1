/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postScriptInterpreter.command;

import java.util.Map;
import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;

/**
 * Add the two operandes at top of the stack and push the result at the top of the stack
 * @author Tanguy
 */
public class AddCommand implements ICommand{

    @Override
    public String execute(IStack<String> stack, Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Add needs 2 operands\n";
    	}
        try {
        	float op1 = Float.parseFloat(stack.pop());
            float op2 = Float.parseFloat(stack.pop());
            float result = op1 + op2;
            stack.push("" + result);
        } catch (EmptyStackException ex) {
        	return "Error pop(): Stack is empty\n";
        }
        catch (NumberFormatException ex){
        	return "Addition needs floats\n";
        }
        return null;
    }

}
