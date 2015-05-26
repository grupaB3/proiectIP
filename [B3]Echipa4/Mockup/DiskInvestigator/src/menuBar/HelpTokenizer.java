package menuBar;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class HelpTokenizer {
	public HelpTokenizer(StandardAnalyzer analyzer){
		generateTokens(analyzer);
	}
	private void generateTokens(StandardAnalyzer analyzer) {
		Path path = Paths.get("tmp/testindex");
	  	Directory directory = null;
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    IndexWriter iwriter = null;

		try {
			directory = FSDirectory.open(path);
			iwriter = new IndexWriter(directory, config);
		} catch (IOException e) {
		}
		
		Observer observer=new NewObserver();
		DiskInvestigatorInfoStartupPanel panel1=new DiskInvestigatorInfoStartupPanel(new Dimension(100,100),observer);
		tokenize(panel1.getIndexableTextAreas(),analyzer,iwriter,panel1);
		DiskInvestigatorInfoFilePanel panel2=new DiskInvestigatorInfoFilePanel(new Dimension(100,100));
		tokenize(panel2.getIndexableTextAreas(),analyzer,iwriter,panel2);
		DiskInvestigatorInfoProcessPanelPart1 panel3=new DiskInvestigatorInfoProcessPanelPart1(new Dimension(100,100),observer);
		tokenize(panel3.getIndexableTextAreas(),analyzer,iwriter,panel3);
		DiskInvestigatorInfoProcessPanelPart2 panel4=new DiskInvestigatorInfoProcessPanelPart2(new Dimension(100,100),observer);
		tokenize(panel4.getIndexableTextAreas(),analyzer,iwriter,panel4);
		DiskInvestigatorInfoProcessPanelPart3 panel5=new DiskInvestigatorInfoProcessPanelPart3(new Dimension(100,100),observer);
		tokenize(panel5.getIndexableTextAreas(),analyzer,iwriter,panel5);
		 try {
			iwriter.close();
		} catch (IOException e) {
		}  
	}
	private void tokenize(List<JTextArea> textAreaList, StandardAnalyzer analyzer,IndexWriter iwriter,JPanel panel) {
		for (JTextArea c : textAreaList) {
	        StringTokenizer Tok = new StringTokenizer(c.getText()," .,");
	        while (Tok.hasMoreElements()){
				Document doc = new Document();
				String copy= (String)Tok.nextElement();
				doc.add(new TextField(panel.getClass().toString(),copy, Field.Store.YES));
				doc.add(new StringField("componentName", c.getName(), Field.Store.YES));
			    try {
					iwriter.addDocument(doc);
				} catch (IOException e) {
				}
	        }
		}
	}
	private class NewObserver implements Observer{
		@Override
		public void update(Observable arg0, Object arg1) {
		}
	}
}
