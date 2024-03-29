/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Sandhya
 */
public class TabbedFrame extends javax.swing.JFrame {

    /**
     * Creates new form TabbedFrame
     */
    static Set<String> upcCodes=new LinkedHashSet<String>();
    static List<String> upcCodesList;
	
	static int SourceFileRowsStartingFrom=2;
	static int OutputFileRowsStartingFrom=3;
	static Set<String> colorList=new HashSet<String>();
        
        static String sourceFile,destFile,upcFile,upcFileDelimiter;
        public TabbedFrame() {
        initComponents();
        
        progressBar.setVisible(false);
        progressBar.setStringPainted(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sourceFileTextField = new javax.swing.JTextField();
        destFileTextField = new javax.swing.JTextField();
        upcFileTextField = new javax.swing.JTextField();
        upcDelimiterTextField = new javax.swing.JTextField();
        destFileButton = new javax.swing.JButton();
        sourceFileButton = new javax.swing.JButton();
        upcFileButton = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        sourceFileErrorLabel = new javax.swing.JLabel();
        destFileErrorLabel = new javax.swing.JLabel();
        upcFileErrorLabel = new javax.swing.JLabel();
        upcErrorLabel = new javax.swing.JLabel();
        upcFileDelimiterErrorLabel = new javax.swing.JLabel();
        stausTextField = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("**Note");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.red);
        jLabel2.setText("**Enter Excel file path in Source and Destination Text Field");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.red);
        jLabel3.setText("**UPC code Delimiter should not be *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.blue);
        jLabel4.setText("Enter Source File Path");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.blue);
        jLabel5.setText("Enter Destination File Path");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.blue);
        jLabel6.setText("Enter UPC File Path");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.blue);
        jLabel7.setText("Enter UPC Delimiter");

        sourceFileTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sourceFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceFileTextFieldActionPerformed(evt);
            }
        });

        destFileTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        destFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destFileTextFieldActionPerformed(evt);
            }
        });

        upcFileTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        upcFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcFileTextFieldActionPerformed(evt);
            }
        });

        upcDelimiterTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        destFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cbeyondgui2/images/FilesS-icon.png"))); // NOI18N
        destFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destFileButtonActionPerformed(evt);
            }
        });

        sourceFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cbeyondgui2/images/FilesS-icon.png"))); // NOI18N
        sourceFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceFileButtonActionPerformed(evt);
            }
        });

        upcFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cbeyondgui2/images/FilesS-icon.png"))); // NOI18N
        upcFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcFileButtonActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        sourceFileErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sourceFileErrorLabel.setForeground(java.awt.Color.red);

        destFileErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        destFileErrorLabel.setForeground(java.awt.Color.red);

        upcFileErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        upcFileErrorLabel.setForeground(java.awt.Color.red);

        upcErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        upcErrorLabel.setForeground(java.awt.Color.red);
        upcErrorLabel.setText("     ");

        upcFileDelimiterErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        upcFileDelimiterErrorLabel.setForeground(java.awt.Color.red);
        upcFileDelimiterErrorLabel.setText("          ");

        stausTextField.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        stausTextField.setForeground(java.awt.Color.red);
        stausTextField.setText("                    ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stausTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upcFileTextField)
                            .addComponent(destFileTextField)
                            .addComponent(sourceFileTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(submit)
                                .addGap(0, 97, Short.MAX_VALUE))
                            .addComponent(upcDelimiterTextField))))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sourceFileButton)
                    .addComponent(destFileButton)
                    .addComponent(upcFileButton))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upcFileDelimiterErrorLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(upcErrorLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(upcFileErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(235, 235, 235))
                        .addComponent(sourceFileErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(destFileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {destFileErrorLabel, sourceFileErrorLabel, upcErrorLabel, upcFileDelimiterErrorLabel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(stausTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(sourceFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sourceFileButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sourceFileErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(destFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(destFileButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(destFileErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upcFileErrorLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(upcFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(upcFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(upcErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(upcDelimiterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(upcFileDelimiterErrorLabel))
                        .addGap(57, 57, 57)
                        .addComponent(submit)))
                .addGap(187, 187, 187)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {destFileButton, destFileTextField, jLabel4, jLabel5, jLabel6, jLabel7, sourceFileButton, sourceFileTextField, upcDelimiterTextField, upcFileButton, upcFileTextField});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {upcErrorLabel, upcFileDelimiterErrorLabel});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceFileTextFieldActionPerformed

    private void destFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destFileTextFieldActionPerformed

    private void upcFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upcFileTextFieldActionPerformed

    private void sourceFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(this);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel FILES", "xls", "xlsx");
        fc.setFileFilter(filter);
        sourceFileTextField.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_sourceFileButtonActionPerformed

    private void destFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(this);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel FILES", "xls", "xlsx");
        fc.setFileFilter(filter);
        
        destFileTextField.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_destFileButtonActionPerformed

    private void upcFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcFileButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(this);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text FILES", "txt", "csv");
        fc.setFileFilter(filter);
        upcFileTextField.setText(fc.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_upcFileButtonActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        
        
        // TODO add your handling code here:
        sourceFile=sourceFileTextField.getText();
        destFile=destFileTextField.getText();
        upcFile=upcFileTextField.getText();
        upcFileDelimiter=upcDelimiterTextField.getText();
        boolean flag=false;
               
        //Check For Empty Fields and File Exisitance
        if(sourceFile.isEmpty() || !(new File(sourceFile)).exists() || !(sourceFile.endsWith(".xls")|| sourceFile.endsWith(".xlsx")))
        {
            sourceFileErrorLabel.setText("**Please Enter Correct Excel File Path");
            flag=true;
        }else{
            sourceFileErrorLabel.setText("");
        }
        if(destFile.isEmpty()|| !(new File(destFile)).exists() || !(sourceFile.endsWith(".xls")|| sourceFile.endsWith(".xlsx")))
        {
            destFileErrorLabel.setText("**Please Enter Correct Excel File Path");
            flag=true;
        }else
        {
            destFileErrorLabel.setText("");
        }
        if(upcFile.isEmpty()|| !(new File(upcFile)).exists() || !upcFile.endsWith(".txt"))
        {
            upcErrorLabel.setText("**Please Enter Correct Text File Path");
            flag=true;
        }else{
            upcErrorLabel.setText("");
        }
        if(upcFileDelimiter.isEmpty() || upcFileDelimiter.equals("*"))
        {
            
            upcFileDelimiterErrorLabel.setText("**Please Enter UPC File Delimiter(should not be *)");
            flag=true;
        }
        else{
            upcFileDelimiterErrorLabel.setText("");
        }
        
        if(!sourceFile.isEmpty() && !destFile.isEmpty()&& sourceFile.equals(destFile))
        {
           stausTextField.setText("  ** Please Enter Different Source and Destination Path ");
           flag=true;
        }
        
        if(!flag){
            stausTextField.setText(" ");
            //exportSourceDataToDestFile(sourceFile,destFile,upcFile,upcFileDelimiter);
         
            //progressBar.setStringPainted(sourceFileTextField);
            Sleeper task = new Sleeper();
            task.execute();
        
            progressBar.setVisible(true);
            submit.setEnabled(false);
            destFileTextField.setEnabled(false);
            sourceFileTextField.setEnabled(false);
            upcFileTextField.setEnabled(false);
            upcDelimiterTextField.setEnabled(false);
            sourceFileButton.setEnabled(false);
            destFileButton.setEnabled(false);
            upcFileButton.setEnabled(false);
      //  System.out.println("  file "+sourceFile+"\n"+destFile);
        }
    }//GEN-LAST:event_submitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabbedFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton destFileButton;
    private javax.swing.JLabel destFileErrorLabel;
    private javax.swing.JTextField destFileTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton sourceFileButton;
    private javax.swing.JLabel sourceFileErrorLabel;
    private javax.swing.JTextField sourceFileTextField;
    private javax.swing.JLabel stausTextField;
    private javax.swing.JButton submit;
    private javax.swing.JTextField upcDelimiterTextField;
    private javax.swing.JLabel upcErrorLabel;
    private javax.swing.JButton upcFileButton;
    private javax.swing.JLabel upcFileDelimiterErrorLabel;
    private javax.swing.JLabel upcFileErrorLabel;
    private javax.swing.JTextField upcFileTextField;
    // End of variables declaration//GEN-END:variables

    private Void exportSourceDataToDestFile(String sourceFile, String destinationFile, String upcFile, String upcFileDelimiter) {
 //To change body of generated methods, choose Tools | Templates.
        getColorsAsList();		
	//Change UPC list to Set
	getUPCFromFile(upcFile,upcFileDelimiter);
	upcCodesList=new ArrayList<String>(upcCodes);
        
        //getColorsAsList();
	//Read Source file
	try {
		    //Source File,workbook and Sheet
		  FileInputStream file = new FileInputStream(new File(sourceFile));
		  XSSFWorkbook sourceWorkbook = new XSSFWorkbook(file);
		  XSSFSheet sourceSheet = sourceWorkbook.getSheetAt(0);
		  //Destination File, workbook and Sheet
		  FileInputStream out = new FileInputStream(new File(destinationFile));
		  XSSFWorkbook destinationWorkbook = new XSSFWorkbook(out);
                  XSSFSheet destinationSheet = destinationWorkbook.getSheetAt(0);
	        
	        
		  Iterator<Row> sourceRowIterator = sourceSheet.iterator();
		  Set<String> skuItem=new LinkedHashSet<String>();
		  //Set<Product> listOfProducts=new LinkedHashSet<Product>();
		  int i=0,upcSetIndex=0;
		  String previousSKU="",CurrentSku;
		  int destinationRowNum = OutputFileRowsStartingFrom;
		  while (sourceRowIterator.hasNext()) 
		  {
			//Product product=new Product();
			Row sourceRow = null;
			if(i<SourceFileRowsStartingFrom-1)
			{
				sourceRow = sourceRowIterator.next();
				i++;
				continue;
			}
			i++;
		
			sourceRow = sourceRowIterator.next();
			Cell sourceSkuItem=sourceRow.getCell(1);
			Cell sourceProductSize=sourceRow.getCell(12);
	        
			//size col-12 ,SKU col-1
	    	//Generate Sku Item For output Files
	    	//skuItem.add(sourceSkuItem.getStringCellValue().split("/")[1]);
			
			CurrentSku=(sourceSkuItem.getStringCellValue()!=null && !sourceSkuItem.getStringCellValue().isEmpty())?(sourceSkuItem.getStringCellValue().contains("/")?sourceSkuItem.getStringCellValue().split("/")[1]:sourceSkuItem.getStringCellValue()):"";
			
			if(!CurrentSku.equals(previousSKU) )
			{
				Row destinationRow=destinationSheet.createRow(destinationRowNum++);
				
				//Cell 0 for SkuItem cell
				destinationRow.createCell(0).setCellValue(CurrentSku);
				
				//Cell 1 for SkuItem Name cell
				Cell destinationItemNamecell=destinationRow.createCell(1);
		    	Cell sourceProdNameCell=sourceRow.getCell(10);
		    	
		    			    	
		    	//check Color exsist in Product Name
		    	String productName=sourceProdNameCell.getStringCellValue(),checkColor="";
		    	//System.out.println(productName);
		    	for(String color:colorList)
		    	{
		    		
		    		if(productName.toLowerCase().contains(color.toLowerCase().trim()))
		    		{
		    			
		    			checkColor=color;
		    			//System.out.println("color :"+color);
		    			productName=productName.replaceAll(color.trim(), " ");
		    			//System.out.println(productName);
		    		}
		    		//System.out.println("color"+color);
		    	}
		    	//Cell 2 for Product Name
		    	destinationItemNamecell.setCellValue("HEAVEN"+" "+productName);
		    	
		    	//Cell 4 for Brand Name
		    	Cell destinationBrandName=destinationRow.createCell(4);
		    	destinationBrandName.setCellValue("HEAVEN");
		    	
		    	//Cell 67 for Parent-Child
		    	Cell destinationParentChildRelName=destinationRow.createCell(67);
		    	destinationParentChildRelName.setCellValue("Parent");
		    	
		    	//Cell 70 for Variation Theme
		    	Cell destinationVariationThemeCell=destinationRow.createCell(70);
		    	destinationVariationThemeCell.setCellValue("SizeColor");
		    				    						
			}
			else{
				
				//create destination row
		    	Row destinationRow=destinationSheet.createRow(destinationRowNum++);
		    	
		    	//Cell 0 for SkuItem cell
		    	Cell destinationSkucell=destinationRow.createCell(0);
		    	
		    	
				//System.out.println(sourceSkuItem!=null ?sourceSkuItem.getStringCellValue():"-"+"  "+sourceProductSize.getStringCellValue());
				//System.out.println(sourceSkuItem.getStringCellValue().split("/")[1]);
				if(sourceSkuItem.getStringCellValue().contains("/"))
				{
					//System.out.println(sourceProductSize!=null?sourceProductSize.getStringCellValue():" ");
					String s=sourceSkuItem.getStringCellValue().split("/")[1];
					s=s.concat("-");
					s=s.concat(sourceProductSize!=null?sourceProductSize.getStringCellValue():" ");
					skuItem.add(s);
					destinationSkucell.setCellValue(s);
					//skuItem.add(sourceSkuItem.getStringCellValue().split("/")[1]+"-"+sourceProductSize!=null?sourceProductSize.getStringCellValue():" ");
					//destinationSkucell.setCellValue(sourceSkuItem.getStringCellValue().split("/")[1]+"-"+sourceProductSize!=null?sourceProductSize.getStringCellValue():" ");
				}else
				{
					//skuItem.add(sourceSkuItem.getStringCellValue()+"-"+sourceProductSize.getStringCellValue());
					//destinationSkucell.setCellValue(sourceSkuItem.getStringCellValue()+"-"+sourceProductSize.getStringCellValue());
					
					System.out.println("Source Sku Item doesnt contain proper format for :"+sourceSkuItem.getStringCellValue());
					
					continue;
				}
	    	
	    	//Item Name derived from "Brand Name"+"Product Name"+","+" "+"Color"+", "+"Size"
	    	Cell destinationItemNamecell=destinationRow.createCell(1);
	    	Cell sourceProdNameCell=sourceRow.getCell(10);
	    	Cell sourceSizeCell=sourceRow.getCell(12);
	    	Cell sourceColorCell=sourceRow.getCell(13);
	    	
	    	
	    	//check Color exsist in Product Name
	    	//CollectionUtils.find(colorList, arg1);
	    	String productName=sourceProdNameCell!=null?sourceProdNameCell.getStringCellValue():"",checkColor="";
	    	//System.out.println(productName);
	    	for(String color:colorList)
	    	{
	    		if(productName.toLowerCase().contains(color.toLowerCase().trim()))
	    		{
	    			checkColor=color;
	    			
	    			productName=productName.replaceAll(color.trim(), " ");
	    			//System.out.println("COLOR---"+color+"---replace--"+productName.replaceAll(color.trim(), " "));
	    		}
	    	}
	    	//Cell 1 for SkuItem Name cell
	    	//System.out.println(productName);
	    	if(checkColor.isEmpty())
	    	{
	    		destinationItemNamecell.setCellValue("HEAVEN"+" "+productName+", "+(sourceColorCell!=null?sourceColorCell.getStringCellValue():" ")+", "+(sourceSizeCell!=null?sourceSizeCell.getStringCellValue():""));
	    	}else{
	    		destinationItemNamecell.setCellValue("HEAVEN"+" "+productName+", "+checkColor+", "+(sourceSizeCell!=null?sourceSizeCell.getStringCellValue():""));
	    	}
	    	
	    	//Cell 2 for external_product_id
	    	//check UPC Code are available
			if(upcCodesList.size()==upcSetIndex)
			{
				System.out.println("No more UPC code Left");
			}else{
				Cell destinationExtProdIdCell=destinationRow.createCell(2);
	    		destinationExtProdIdCell.setCellValue(upcCodesList.get(upcSetIndex++));
			}
			
	    	//cell 3 for External_product_type_id
	    	Cell destinationExtProdTypeIdCell=destinationRow.createCell(3);
	    	destinationExtProdTypeIdCell.setCellValue("UPC");
	    	
	    	//Cell 4 For Brand Name always "HEAVEN"
	    	Cell destinationBrandName=destinationRow.createCell(4);
	    	destinationBrandName.setCellValue("HEAVEN");
	    	
	    	//Cell 8 for Selling Price
	    	Cell destinationSellingPriceCell=destinationRow.createCell(8);
	    	destinationSellingPriceCell.setCellValue(sourceRow.getCell(15).getStringCellValue());
	  
	    	//Cell 9 for List Price
	    	Cell destinationListPriceCell=destinationRow.createCell(9);
	    	destinationListPriceCell.setCellValue(sourceRow.getCell(14).getStringCellValue());
	    	
	       	//cell 10 for Currency
	    	Cell destinationCurrencyCell=destinationRow.createCell(10);
	    	destinationCurrencyCell.setCellValue("USD");
	    	
	    	//cell 11 for Product_Tax_code
	    	Cell destinationProdTaxCodeCell=destinationRow.createCell(11);
	    	destinationProdTaxCodeCell.setCellValue("A_GEN_NOTAX");
	    	
	    	//cell 16 for quantity
	    	Cell destinationQuantityCell=destinationRow.createCell(16);
	    	destinationQuantityCell.setCellValue(sourceRow.getCell(18).getStringCellValue());
	    	
	    	//cell 17 for Sale Price
	    	Cell destinationSalePriceCell=destinationRow.createCell(17);
	    	destinationSalePriceCell.setCellValue(sourceRow.getCell(16).getStringCellValue());
	    	
	    	//Cell 29 for item weight Unit
	    	Cell destinationShippingWieghtUnitCell=destinationRow.createCell(29);
	    	destinationShippingWieghtUnitCell.setCellValue("LB");
	    	
	       	//Cell 30 for item weight
	    	Cell destinationShippingWieghtCell=destinationRow.createCell(30);
	    	destinationShippingWieghtCell.setCellValue(sourceRow.getCell(20).getStringCellValue());
	    		    	
	    	//Cell 67 for Parent-Child
	    	Cell destinationParentChildRelName=destinationRow.createCell(67);
	    	destinationParentChildRelName.setCellValue("Child");
	    	
	    	//Cell 68 for Parent SKU
	    	Cell destinationParentSKUCell=destinationRow.createCell(68);
	    	destinationParentSKUCell.setCellValue(CurrentSku);
	    	
	    	//Cell 69 for Relationship Type
	    	Cell destinationRelTypeCell=destinationRow.createCell(69);
	    	destinationRelTypeCell.setCellValue("Variation");
	    	
	    	//Cell 70 for Variation Theme
	    	Cell destinationVariationThemeCell=destinationRow.createCell(70);
	    	destinationVariationThemeCell.setCellValue("SizeColor");
	    	
	    	//Cell 86 for Color_name
	    	Cell destinationColorNameCell=destinationRow.createCell(86);
	    	destinationColorNameCell.setCellValue((sourceColorCell!=null?sourceColorCell.getStringCellValue():""));
	    	
	    	//Cell 94 for department Name gen 3-6
	    	//Cell destinationDepartmentNameCell=destinationRow.createCell(91);
	    	
		 }	
		 previousSKU=CurrentSku;
	   		
				
	    }
		
			//writeToExcelFile(skuItem);
			file.close();
			out.close();
			
			//write destination sheet to file
			FileOutputStream outFile = new FileOutputStream(new File(destinationFile));
			destinationWorkbook.write(outFile);
			
			System.out.println(destinationFile+" written successfully on disk.");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		//Write to Excel
        return null;
		
		
	
    }

    private void getUPCFromFile(String UPCListFile, String upcFileDelimiter) {
         //To change body of generated methods, choose Tools | Templates.
        try {
			Scanner scan =new Scanner(new BufferedReader(new FileReader(UPCListFile)));
			scan.useDelimiter(upcFileDelimiter);
			while(scan.hasNext())
			{
				upcCodes.add(scan.next());
			}
			
			//System.out.println(upcCodes2.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void getColorsAsList() {
         //To change body of generated methods, choose Tools | Templates.
        try {
			Scanner scan =new Scanner(new BufferedReader(new FileReader("ColorList.txt")));
			scan.useDelimiter("\n");
			while(scan.hasNext())
			{
				colorList.add(scan.next().toString());
			}
			
			
	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            System.err.println("Color List File Not Found");
            System.exit(0);
        }
    }

    private  class Sleeper extends SwingWorker{@Override
        public Void doInBackground() throws InterruptedException {
               
           /* try
            {     
                int progress = 0;
                while (progress < 100) {

                    //pause thread and then update the progress
                    Thread.sleep(100);
                    progress++;
                    
                    //Call the process method to update the GUI
                    publish(progress);

                }                       
            }
            catch(InterruptedException e)
            {
            }*/
            return exportSourceDataToDestFile(sourceFile,destFile,upcFile,upcFileDelimiter);
        }
        
        @Override
        protected void process(List chunks) {
            for (Iterator it = chunks.iterator(); it.hasNext();) {
                Integer chunk = (Integer) it.next();
                progressBar.setValue(chunk);
             }
     }
        //when the 'task' has finished re-enable the go button
        @Override
        public void done() {
            submit.setEnabled(true);
            destFileTextField.setEnabled(true);
            sourceFileTextField.setEnabled(true);
            upcFileTextField.setEnabled(true);
            upcDelimiterTextField.setEnabled(true);
            progressBar.setVisible(false);
            sourceFileButton.setEnabled(true);
            destFileButton.setEnabled(true);
            upcFileButton.setEnabled(true);
            
            stausTextField.setVisible(true);
            stausTextField.setText("Data Exported Succesfully!!!!");
        }}
}
