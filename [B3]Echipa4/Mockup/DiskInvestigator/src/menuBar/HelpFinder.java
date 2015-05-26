package menuBar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JPanel;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class HelpFinder {
	private StandardAnalyzer analyzer;
	private IndexSearcher isearcher;
	private DirectoryReader ireader;
	public HelpFinder(StandardAnalyzer analyzer){
		this.analyzer=analyzer;
		init();
	}
	private void init(){
		Path path = Paths.get("tmp/testindex");
	  	Directory directory = null;
		try {
			directory = FSDirectory.open(path);
		} catch (IOException e) {
		}
		try {
			ireader = DirectoryReader.open(directory);
		} catch (IOException e) {
		}
	    isearcher = new IndexSearcher(ireader);
	}
	public void find(String keyword,JPanel panel,HelpHighlighter highlighter){
	    QueryParser parser = new QueryParser(panel.getClass().toString(), analyzer);
	    Query query = null;
	  	try {
			query = parser.parse(keyword);
		} catch (ParseException e) {
		}
	    ScoreDoc[] hits = null;
		try {
			hits = isearcher.search(query, null, 1000).scoreDocs;
			highlighter.removeHighlighters();
			if(hits.length!=0){
			    for (int i = 0; i < hits.length; i++) {
				     try {
						Document hitDoc = isearcher.doc(hits[i].doc);
						highlighter.highlight(hitDoc.get("componentName"), hitDoc.get(panel.getClass().toString()));
					} catch (IOException e) {
						System.out.println("Error!");
					}
			    }
			   
		}
		} catch (IOException e) {
		} catch (NullPointerException e){
			
		}
	};
	public void close(){
		try {
			ireader.close();
		} catch (IOException e) {
			System.out.println("Error!");
		}
	}
}
