package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class NeCommand implements ICommand{

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Ne needs 2 operands\n";
    	}
		try {
			String op1 = stack.pop();
			String op2 = stack.pop();
			if(!op1.equals(op2)){
				stack.push("" + true);
			}
			else{
				stack.push("" + false);
			}
		} catch (EmptyStackException e) {
        	return "Error pop(): Stack is empty\n";
		}
		return null;
	}

}
