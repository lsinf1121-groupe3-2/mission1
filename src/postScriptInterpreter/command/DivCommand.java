package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class DivCommand implements ICommand {

	@Override
	public String execute(IStack<String> stack,
			Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Div needs 2 operands\n";
    	}
		try {
			float op1 = Float.parseFloat(stack.pop());
			float op2 = Float.parseFloat(stack.pop());
			if(op2==0.0)
			{
				return "Error : division by zero\n";
			}
			float result = op1 / op2;
			stack.push("" + result);
		} catch (EmptyStackException ex) {
        	return "Error pop(): Stack is empty\n";
        }
        catch (NumberFormatException ex){
        	return "Division needs floats\n";    
        }
		
		
		return null;
	}

}
