package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.*;
import javax.swing.JToolBar.Separator;

/**
 *
 * @author Sonia
 */
public class IP extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
         new IP().setVisible(true);
            
    }
    public IP() {
       Components();
    }
   private JButton ScanButton;
    private JButton RecoveryButton;
    private JButton RefresButton;
    private JButton SearchButton;
    private JButton ShredButton;
    private JComboBox ShareWith;
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
    
    
        private void Components() {
       

        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel();
        jToolBar1 = new JToolBar();
        ScanButton = new JButton();
        RecoveryButton = new JButton();
        RefresButton = new JButton();
        SearchButton = new JButton();
        ShredButton = new JButton();
        ShareWith = new JComboBox();
        jSeparator1 = new Separator();
        jTabbedPane2 = new JTabbedPane();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLayeredPane1 = new JLayeredPane();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setFloatable(false);

        ScanButton.setText("ScanButton");
        ScanButton.setFocusable(false);
        ScanButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ScanButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ScanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ScanButton);

        RecoveryButton.setText("RecoveryButton");
        RecoveryButton.setFocusable(false);
        RecoveryButton.setHorizontalTextPosition(SwingConstants.CENTER);
        RecoveryButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(RecoveryButton);

        RefresButton.setText("RefresButton");
        RefresButton.setFocusable(false);
        RefresButton.setHorizontalTextPosition(SwingConstants.CENTER);
        RefresButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(RefresButton);
        jToolBar1.add(jSeparator1);

        SearchButton.setText("SearchButton");
        SearchButton.setFocusable(false);
        SearchButton.setHorizontalTextPosition(SwingConstants.CENTER);
        SearchButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        jToolBar1.add(SearchButton);

        ShredButton.setText("ShredButton");
        jToolBar1.add(ShredButton);

        ShareWith.setModel(new DefaultComboBoxModel(new String[] { "ShareWith", "GoupRead1", "GoupRead2" }));
        ShareWith.setPreferredSize(new Dimension(10, 10));
        ShareWith.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ShareWithActionPerformed(evt);
            }
        });
        jToolBar1.add(ShareWith);

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

        jTabbedPane2.addTab("DiskScan", jPanel2);

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

        jTabbedPane2.addTab("FileWork", jPanel3);

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

        jTabbedPane1.addTab("File", jPanel1);

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

        jTabbedPane1.addTab("Process", jLayeredPane1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>                        

    private void ScanButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void ShareWithActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

}