package SystemDesign.UndoFunction;

public class TextEditor {
    private String Content;

    // TextEditor(String content){
    //     this.Content = content;
    // }

    public void write(String content){
         this.Content = content;
    }
    public String getText(){
        return Content;
    }
    //
}
