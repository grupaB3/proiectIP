import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.JToolBar.Separator;


public class FileToolBar extends JFrame{

	private JLayeredPane jLayeredPane1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JToolBar jToolBar1;
    private Separator jSeparator1;
    
    private DiskScan diskScan;
    private FileWorker fileWorker;
    
    public FileToolBar(){
    	
    	diskScan=new DiskScan();
    	fileWorker = new FileWorker();
    	
    	jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jToolBar1 = new JToolBar();
        jSeparator1 = new Separator();
        jTabbedPane2 = new JTabbedPane();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLayeredPane1 = new JLayeredPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        
        setToolBar();
        setLayout();
             
    }
    
    public void setToolBar(){
    	jToolBar1.add(diskScan.getScanButton());
        jToolBar1.add(diskScan.getRecoveryButton());
        jToolBar1.add(diskScan.getRefreshButton());
        
        jToolBar1.add(jSeparator1);
        
        jToolBar1.add(fileWorker.getSearchButton());
        jToolBar1.add(fileWorker.getShredButton());
        jToolBar1.add(fileWorker.getShareWith());
        
        jToolBar1.setFloatable(false);
    }
	
    
    public void setLayout(){
    	 GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
         jPanel2.setLayout(jPanel2Layout);
         
         jPanel2Layout.setHorizontalGroup(
             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 873, Short.MAX_VALUE)
         );
         jPanel2Layout.setVerticalGroup(
             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 471, Short.MAX_VALUE)
         );
         
      
         GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
         jPanel3.setLayout(jPanel3Layout);
         jPanel3Layout.setHorizontalGroup(
             jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 873, Short.MAX_VALUE)
         );
         jPanel3Layout.setVerticalGroup(
             jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 471, Short.MAX_VALUE)
         );
         

         GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         
         jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(jToolBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(jTabbedPane2, GroupLayout.Alignment.TRAILING)
         );
         jPanel1Layout.setVerticalGroup(
             jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(jPanel1Layout.createSequentialGroup()
                 .addComponent(jToolBar1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jTabbedPane2))
         );
         

         GroupLayout jLayeredPane1Layout = new GroupLayout(jLayeredPane1);
         jLayeredPane1.setLayout(jLayeredPane1Layout);
         jLayeredPane1Layout.setHorizontalGroup(
             jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 878, Short.MAX_VALUE)
         );
         jLayeredPane1Layout.setVerticalGroup(
             jLayeredPane1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGap(0, 532, Short.MAX_VALUE)
         );
         
         addTabs();
         
         GroupLayout layout = new GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(jTabbedPane1)
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(jTabbedPane1)
         );

         pack();
    }
    
    public void addTabs(){
    	jTabbedPane2.addTab("DiskScan", jPanel2);
    	jTabbedPane2.addTab("FileWork", jPanel3);
    	jTabbedPane1.addTab("File", jPanel1);
    	jTabbedPane1.addTab("Process", jLayeredPane1);
    }
}
