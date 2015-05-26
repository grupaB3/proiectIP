package menuBar;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

public class HelpHighlighter {
	private List<JTextArea> textAreaList;
	public void highlight(String componentName,String keyword){
		for(JTextArea textArea:textAreaList){
			if(!textArea.getName().equals("") && textArea.getName().equals(componentName)){
		      Highlighter highlighter = textArea.getHighlighter();
		      HighlightPainter painter = 
		             new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
		      int p0 =textArea.getText().indexOf(keyword);
		      int p1 = p0 + keyword.length();
		      try {
				highlighter.addHighlight(p0, p1, painter );
		      } catch (BadLocationException e) {
		      }
			}
		}
	}
	public void removeHighlighters() {
		for(JTextArea textArea:textAreaList){
			 Highlighter highlighter = textArea.getHighlighter();
			 highlighter.removeAllHighlights();
		}
	}
	public void setTextAreaList(List<JTextArea> indexableTextAreas) {
		textAreaList=indexableTextAreas;
	}
}
