/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postScriptInterpreter;

import java.util.Map;

/**
 * Describe what a command do
 * @author Tanguy
 */
public interface ICommand {
    
    /**
     * Execute a command and return a String if the command has a textual result.
     * The command can pop and push elements of the stack.
     * The command can consult or add elements to the definedConstantsMap.
     * @pre --
     * @post return String if the command has a textual result, null otherwise
     * @param stack of elements (operandes)
     * @param definedConstantsMap map of constants
     * @return String result if the command has a textual result, null otherwise.
     */
    public String execute(IStack<String> stack, Map<String, Float> definedConstantsMap);
    
}
