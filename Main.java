// this is Document Builder uses SOLID principles

import java.util.ArrayList;
import java.util.List;
public class Main{
    public static void main(String args[]){
        Document d = new Document();
        DocumentEditor ed = new DocumentEditor(d);
       
        ed.addText("HIIII");
        ed.addImg("path.jpg");
        System.out.println(ed.render());
        
    }
}
interface DocumentElement{
    public String render();
}


class Text implements DocumentElement{
    private String text;
    public Text(String t){
        this.text = t;
    }
    @Override
    public String render(){
        return text;
    }
    
}
class Image implements DocumentElement{
    private String imgPath;
    public Image(String t){
        this.imgPath = t;
    }
    @Override
    public String render(){
        return "Image : "+ imgPath;
    }
}
class Document{
    List<DocumentElement> docelements = new ArrayList<>();
    // private DocumentElement doc;
    public void addElement(DocumentElement el){
        docelements.add(el);
    }
    public String render(){
        StringBuilder res = new StringBuilder();
        for(DocumentElement el : docelements){
            res.append(el.render())
            .append("\n");
        }
        return res.toString();
    }
}
class DocumentEditor{
    private Document doc;
    public DocumentEditor(Document d){
        this.doc = d;
    }
    public void addText(String t){
        doc.addElement(new Text(t));
    }
    public void addImg(String path){
        doc.addElement(new Image(path));
    }
    public String render(){
        return doc.render();
    }
}