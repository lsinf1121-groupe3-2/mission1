package postScriptInterpreter.command;

import java.util.Map;

import postScriptInterpreter.ICommand;
import postScriptInterpreter.IStack;
import postScriptInterpreter.exception.EmptyStackException;


/**
 * Implementation of the interface : ICommand
 */
public class SubCommand implements ICommand {

	@Override
    public String execute(IStack<String> stack, Map<String, Float> definedConstantsMap) {
    	if(stack.size() < 2){
    		return "Sub needs 2 operands\n";
    	}
        try {
        	
        	float op1 = Float.parseFloat(stack.pop());
            float op2 = Float.parseFloat(stack.pop());
            float result = op1 - op2;
            stack.push("" + result);
        } catch (EmptyStackException ex) {
        	return "Error pop(): Stack is empty\n";
        }
        catch (NumberFormatException ex){
        	return "Substraction needs floats\n";   
        }
        return null;
    }

}
