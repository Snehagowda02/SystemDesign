package UndoFunction;

public class EditorMemento {
    private final String Content;

    public EditorMemento(String con){
        this.Content= con;
    }

    public String getCOntent(){
        return Content;
    }
    
}
