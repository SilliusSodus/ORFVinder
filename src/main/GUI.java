/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Python.Blast;
import filin.FileOpener.Cancel;
import filin.FileOpener.notFasta;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sequentie.Sequentie;

/**
 * Voor de graphische user interface
 * (bit of a mess, but you know.. gui builders, can't live with them, can't live without them)
 * JComboBox, voor de menus
 * currentSeq, De huidige sequentie die uitgebeeld is.
 * @author Erik, Ruben, Sebastiaan
 */
public class GUI extends javax.swing.JFrame {
	
	protected JComboBox comboBox;
	protected Sequentie currentSeq;

    /**
     * Creates new form NewJFrame
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jTextArea = new javax.swing.JTextArea();
        jTextAreados =  new javax.swing.JTextArea();
        

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jScrollPane1.setViewportView(jTextArea);
        jScrollPane2.setViewportView(jTextAreados);
        
        jTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

        
        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jFrame1.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("File");

        jMenuItem1.setText("Open from file");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem9.setText("Open from database");
        jMenu2.add(jMenuItem9);

        jMenuItem2.setText("Save");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Save to database");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem3ActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("BLAST");

        jMenuItem5.setText("BLASTn");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("BLASTx");
        jMenu3.add(jMenuItem6);

        jMenuItem8.setText("tBLASTx");
        jMenu3.add(jMenuItem8);

        jMenuItem7.setText("tBLASTn");
        jMenu3.add(jMenuItem7);
        
        for(int i=0;i<jMenu3.getItemCount();i++){
        	
        	jMenu3.getItem(i).addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenu3ActionPerformed(evt, jMenu3);
                }
            });
        }

        jMenuBar1.add(jMenu3);
        
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }
    /**
     * Action performed op alle blast mogelijkheden
     * @param evt, het event dat de functie aanslaat
     * @param menu, het menu waaruit gekozen is
     */
    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JMenu menu){
    	try{
    		String seq = JOptionPane.showInputDialog("Copy and paste the ORF you wish to blast:");
	    	if (seq.length()>0){
	    		Blast.Blast(currentSeq.getTitel().split(" ")[0], seq, evt.getActionCommand().toLowerCase(), "BLOSUM62", "nr");
	    		JOptionPane.showMessageDialog(null, "You can find the blast results in the \"BlastResults\" folder.");
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null,"You left it blank you silly.");
	    	}
    	}
    	catch(Exception e){
    		JOptionPane.showMessageDialog(null,"Meanie");
    	}
    }
/**
 * Data base, nvm
 * @param evt
 * @throws ClassNotFoundException
 * @throws SQLException
 * @throws UnsupportedEncodingException
 */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        //database.DataUpload.main(currentSeq);
    }

    /**
     * Het tekenen van de gui
     */
    public static void draw() {
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea,jTextAreados;
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
			currentSeq = new Sequentie();
			visualize();
			for(int i =0; i<currentSeq.getOrflijst().size();i++){
				jTextAreados.setText(jTextAreados.getText()+"\n \n Frame "+(i+1)+":");
			    for(int j = 0; j<currentSeq.getOrflijst().get(i).size();j++){
			    	jTextAreados.setText(jTextAreados.getText()+"\n "+currentSeq.getOrflijst().get(i).get(j).getSeq() + "  Locatie: "+currentSeq.getOrflijst().get(i).get(j).getBegin() + " - " + currentSeq.getOrflijst().get(i).get(j).getEnd());
			    }
			}
		} catch (notFasta e) {
			JOptionPane.showMessageDialog(null, e);
		}
          catch(Cancel e){
        	 ;
          }
      
		
    }
    /**
     * Visualiseert de verscheidene frames en sequentie (forward en reverse) in de gui
     */
    public void visualize(){
    	StringBuilder visu = new StringBuilder();
    	int end =0;
    	int begin = 0;
    	visu.append("seq:5'"+currentSeq.getSequentie1()+"3'\n") ;
    	for(int i= 0; i < currentSeq.getOrflijst().size(); i++){
    		if (i == 3){
    			visu.append("\n");
    		}
    		visu.append("frame"+(i+1));
    		end = 0;
    		for(int j = 0; j < currentSeq.getOrflijst().get(i).size(); j++){
    			begin = currentSeq.getOrflijst().get(i).get(j).getBegin();
    			
    			for(int k = end; k < begin; k++){
    				visu.append(" ");
    			}
    			
    			end = currentSeq.getOrflijst().get(i).get(j).getEnd();
    			visu.append(currentSeq.getOrflijst().get(i).get(j).getSeq());
    			
    			
    		}
    		visu.append("\n");
    	}
    	System.out.println("done");
    	visu.append("seq:3'"+new StringBuilder(currentSeq.getSequentie1()).reverse().toString()+ "5'");
    	
    	jTextArea.setText(visu.toString());
    }
    
    
}
