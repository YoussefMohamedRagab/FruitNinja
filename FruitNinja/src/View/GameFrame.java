/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Controller.GameController;
import Controller.GameMode;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author abdelrahman
 */
public class GameFrame extends javax.swing.JFrame {

    private GameController controller = new Controller();
    
    
    /**
     * Creates new form GameFrame
     */
    
    public GameFrame() {
        
       initComponents();
/*       gamePanel1.setFrame(this);
       gamePanel1.setController(controller);
       controller.setpanel(gamePanel1);
       controller.setframe(this);
       controller.readbest();
       controller.createGameObjects(2);
       gamePanel1.render();
       Best_Score.setText("Best : " +controller.getbestscore());
       */
       setTitle("Fruit Ninja");
         ImageIcon icon=new ImageIcon("logo.png");
         setIconImage(icon.getImage());
       gui();
        
    }
    public void newgame(int a,int b){

       controller.newgame(a, b);
 
    }
    public void initializegame(){
        
       gamePanel1.setFrame(this);
       gamePanel1.setController(controller);
       controller.setpanel(gamePanel1);
       controller.setframe(this);
       controller.readbest();
       controller.createGameObjects(2);
       gamePanel1.render();
       Best_Score.setText("Best : " +controller.getbestscore());
        
    }
    public void setmode(GameMode mode){
        
        mode.setPanel(gamePanel1);
        gamePanel1.setMode(mode);
                
    }
    public void settime (float x ){
        
        gamePanel1.settime(x);
        
    }
 
    public void loadgame(){
        
       gamePanel1.setFrame(this);
       gamePanel1.setController(controller);
       controller.setpanel(gamePanel1);
       controller.setframe(this);
       controller.loadgame();
       Best_Score.setText("Best : " +controller.getbestscore());
       gamePanel1.render();
        
    }
    
    public void gui(){
         Font f1=new Font("BOLD",Font.BOLD,30); 
          Font f2=new Font("BOLD",Font.BOLD,20); 
         ResetBtn.setBackground(Color.GRAY);
         ResetBtn.setForeground(Color.ORANGE);
         ResetBtn.setFont(f1);
         Save.setBackground(Color.GRAY);
         Save.setForeground(Color.ORANGE);
         Save.setFont(f1);
         Exit.setBackground(Color.GRAY);
         Exit.setForeground(Color.ORANGE);
         Exit.setFont(f1);
         gamePanel1.setBackground(Color.DARK_GRAY);
         Best_Score.setFont(f2);
         Best_Score.setForeground(Color.YELLOW);
}
      public void msgbox(String s){
       
          JOptionPane.showMessageDialog(null, s);
         
    }
   public static final String song="over.mp3";
    MP3Player mp3over=new MP3Player(new File(song));
     
      
    public void lost(){
        mp3over.play();
        msgbox("GameOver :\nYour Score : " +controller.getScore());
        controller.savescore();
        System.exit(0);
      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel1 = new View.GamePanel();
        Current_Score = new javax.swing.JLabel();
        Timer = new javax.swing.JLabel();
        ResetBtn = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Best_Score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gamePanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                gamePanel1MouseDragged(evt);
            }
        });
        gamePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gamePanel1MousePressed(evt);
            }
        });

        Current_Score.setText("jLabel1");

        Timer.setText("jLabel2");

        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Best_Score.setText("jLabel1");

        javax.swing.GroupLayout gamePanel1Layout = new javax.swing.GroupLayout(gamePanel1);
        gamePanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Current_Score, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Best_Score, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Timer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanel1Layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        gamePanel1Layout.setVerticalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addComponent(Current_Score, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Best_Score, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                .addGroup(gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetBtn)
                    .addComponent(Save)
                    .addComponent(Exit)))
            .addGroup(gamePanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Timer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gamePanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamePanel1MousePressed
        
        
        
    }//GEN-LAST:event_gamePanel1MousePressed

    private void gamePanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamePanel1MouseDragged
        int x = evt.getX();
        int y = evt.getY();
        controller.click(x, y);
    }//GEN-LAST:event_gamePanel1MouseDragged

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed

        controller.resetgame();
        gamePanel1.resetgame();
        
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        controller.savegame();
    }//GEN-LAST:event_SaveActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        StartMenu start=new StartMenu();
         setVisible(false);
         gamePanel1.t.stop();
        start.setVisible(true);
        
    }//GEN-LAST:event_ExitActionPerformed

    public void setscorelabel(int x){
        
        
        Current_Score.setText("" + x);
         Font f1=new Font("BOLD",Font.BOLD,30);
         Current_Score.setForeground(Color.yellow);
         Current_Score.setFont(f1);
        
    }
    public void settimerlabel(float x){
        
        
        int minutes = (int) (x/60);
        int seconds = (int) ( x - (minutes*60));
        
        Timer.setText(minutes + " : " + seconds);
        Font f1=new Font("BOLD",Font.BOLD,20);
        Timer.setForeground(Color.yellow);
        Timer.setFont(f1);
        Timer.setBounds(100, 100, 100,30);
        Timer.setLocation(900,40);
    }
    
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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  new StartMenu().setVisible(true);
            //    new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Best_Score;
    private javax.swing.JLabel Current_Score;
    private javax.swing.JButton Exit;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton Save;
    private javax.swing.JLabel Timer;
    private View.GamePanel gamePanel1;
    // End of variables declaration//GEN-END:variables
}
