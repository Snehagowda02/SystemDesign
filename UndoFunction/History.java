package UndoFunction;

import java.util.Stack;

public class History {

    private final Stack<EditorMemento> history= new Stack<>();

    public void saveText(EditorMemento e){
        history.add(e);
    }
    public void undo(EditorMemento e){
        if(!history.empty()){
            e.
        }
    }
    
}
