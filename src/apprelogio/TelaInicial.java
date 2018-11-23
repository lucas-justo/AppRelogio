
package apprelogio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import java.util.Timer;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class TelaInicial extends javax.swing.JFrame {
    
        Thread thread = new Thread(new Contagem());
        boolean pausado = false;

    private void setText(final JLabel label, final String relogio){
    tempo2.setText(relogio);
    //tempo2.paintImmediately(tempo2.getVisibleRect());
 }             
 
    public void sound()
  {
    try
    {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("glassping.wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }    
 
    public class Contagem implements Runnable {

    public void run() {
        
        String relogio = "";
        final JLabel tempo2 = new JLabel();
        int minuto = (Integer) spMinuto.getValue();
        int segundo = (Integer) spSegundo.getValue();
        
        if (minuto  == 0 && segundo == 0){
            minuto = 15;
            segundo = 0;
        }
        
        //Runnable sound2 =
        //(Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        
        if (minuto != 0){
            
        for(int u = minuto; minuto > 0; minuto-- )                                         {                                 
            if (minuto == 1) {
                //sound2.run();
                sound();                
            }
            if (u == minuto){
                 if (segundo == 0){
                    relogio = minuto + ":" + "0" + segundo;
                    setText(tempo2, relogio); 
                    try {
                            Thread.sleep(1000);
                             } catch (InterruptedException e) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(e);
                                }
                 }
                                
                    
                if(segundo != 0){                   
                    if(segundo / 10 < 1){
                        for(int s = segundo; segundo > 0; segundo -- ){
                            
                            relogio = minuto + ":" + "0" + segundo;
                            try {
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);

                             } catch (InterruptedException e) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(e);
                                }
                        }
                    }else{
                        for(int s = segundo; segundo > 0; segundo--) {
                            if (segundo / 10 >= 1){
                            relogio = minuto + ":" + segundo;}else{
                            relogio = minuto + ":" + "0" + segundo; 
                            
                          
                            
                            }
                            try {
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);
                             } catch (InterruptedException e) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(e);
                                }
                        }
                    }
                }
        try {               relogio = minuto + ":" + "00";
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);
                             } catch (InterruptedException e) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(e);
                                }        
        
                            } 
            

        for (int i = 59; i >= 0 ; i-- )        { 
            int minutoreal = minuto -1;
            relogio = "";
            relogio = Integer.toString(minutoreal);            
            
         if (i / 10 < 1)                 {   
             relogio = relogio + ":" + "0" + i;
             try {
                Thread.sleep(1000);
                setText(tempo2, relogio);
                System.out.println(relogio);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
             }
             
            }else{
            relogio = relogio + ":" + i;
            try {
                Thread.sleep(1000);
                setText(tempo2, relogio);
                System.out.println(relogio);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
             }
            }  
           }
                                              }
     
        }
        //se o minuto inserido for 0
        else {
            for(int e = minuto; e >= 0; e--){
                
                    if (segundo / 10 < 1){
                    relogio = minuto + ":" + "0" + segundo;//
                    setText(tempo2, relogio);//
                    }else{
                        relogio = minuto + ":" + segundo;//
                        setText(tempo2, relogio);//
                        }
                
                 
                if(segundo != 0){ //se o segundo inserido nao for 0
                    if(segundo / 10 < 1){
                        for(int s = segundo; segundo > 0; segundo -- ){
                            relogio = minuto + ":" + "0" + segundo;
                            try {
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);
                             } catch (InterruptedException d) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(d);
                                }
                        }
                    }else{
                        for(int s = segundo; segundo > 0; segundo--) {
                            if(segundo / 10 >= 1){
                            relogio = minuto + ":" + segundo;}else{
                            relogio = minuto + ":" + "0" + segundo;   
                            }
                            
                            try {
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);
                             } catch (InterruptedException d) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(d);
                                }
                        }
                    }
                }
                try {       relogio = minuto + ":" + "00";
                            Thread.sleep(1000);
                            setText(tempo2, relogio);
                            System.out.println(relogio);
                             } catch (InterruptedException d) {
                                 Thread.currentThread().interrupt();
                                 throw new RuntimeException(d);
                                }
            }  
        }
        sound();
        //sound2.run();
       btnIniciar1.setEnabled(true);
    }
       
}
    
    //////////////////////////
 
    public TelaInicial() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
        String pattern = "HH-mm-ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());        
        date.toString();
        date = date.replaceAll("\\D+", ":");
        hora.setText(date);
        hora.paintImmediately(hora.getVisibleRect()); 
            }
        }, 0, 1000);
        
        

        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tempo2 = new javax.swing.JLabel();
        btnPausar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spMinuto = new javax.swing.JSpinner();
        spSegundo = new javax.swing.JSpinner();
        btnIniciar1 = new javax.swing.JButton();
        hora = new javax.swing.JLabel();
        btn10 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        Reiniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn15 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(3600, 2160));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1300, 960));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Insira os minutos");

        tempo2.setFont(new java.awt.Font("Verdana", 0, 404)); // NOI18N
        tempo2.setForeground(new java.awt.Color(153, 0, 51));
        tempo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempo2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tempo2.setName(""); // NOI18N

        btnPausar.setBackground(new java.awt.Color(214, 226, 239));
        btnPausar.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        btnPausar.setForeground(new java.awt.Color(0, 0, 51));
        btnPausar.setText("PAUSAR");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Insira os segundos");

        spMinuto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        spMinuto.setModel(new javax.swing.SpinnerNumberModel(15, 0, 60, 1));

        spSegundo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        spSegundo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));

        btnIniciar1.setBackground(new java.awt.Color(214, 226, 239));
        btnIniciar1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        btnIniciar1.setForeground(new java.awt.Color(0, 0, 51));
        btnIniciar1.setText("INICIAR");
        btnIniciar1.setMaximumSize(new java.awt.Dimension(129, 39));
        btnIniciar1.setMinimumSize(new java.awt.Dimension(129, 39));
        btnIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar1ActionPerformed(evt);
            }
        });

        hora.setFont(new java.awt.Font("Verdana", 0, 102)); // NOI18N
        hora.setForeground(new java.awt.Color(0, 51, 51));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn10.setForeground(new java.awt.Color(0, 0, 51));
        btn10.setText("10 Minutos");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn1.setForeground(new java.awt.Color(0, 0, 51));
        btn1.setText("1 Minuto");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        Reiniciar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Reiniciar.setForeground(new java.awt.Color(0, 0, 51));
        Reiniciar.setText("Reiniciar");
        Reiniciar.setMaximumSize(new java.awt.Dimension(87, 30));
        Reiniciar.setMinimumSize(new java.awt.Dimension(87, 30));
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apprelogio/Agergs2.png"))); // NOI18N

        btn15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn15.setText("15 Minutos");
        btn15.setMaximumSize(new java.awt.Dimension(87, 25));
        btn15.setMinimumSize(new java.awt.Dimension(87, 25));
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btn3.setText("3 Minutos");
        btn3.setMaximumSize(new java.awt.Dimension(87, 25));
        btn3.setMinimumSize(new java.awt.Dimension(87, 25));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tempo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciar1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(171, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spSegundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spMinuto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIniciar1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn10)
                                    .addComponent(btn15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn1)
                                    .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(tempo2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        
        
        String tempoatual = tempo2.getText();
        String minutos = tempoatual.substring(0,2);
        String segundos = tempoatual.substring(2);
        String minutopausado = minutos.replaceAll("\\D+", "");
        String segundopausado = segundos.replaceAll("\\D+", "");
        int intminutopausado = Integer.parseInt(minutopausado);
        int intsegundopausado = Integer.parseInt(segundopausado);
        spMinuto.setValue(intminutopausado);
        spSegundo.setValue(intsegundopausado);
        //tempoAtual.setText("Pausado em " + tempoatual);
        
        
        if(!pausado){
        btnPausar.setText("CONTINUAR");
        thread.suspend();
        pausado = true;
        }else{
         btnPausar.setText("PAUSAR");
         thread.resume();
         pausado = false;
         //tempoAtual.setText("");
        }
        
         
        
        
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar1ActionPerformed
       //(new Thread(new Contagem())).start(); Thread thread = new Thread(new Contagem());
        btnIniciar1.setEnabled(false);
        boolean pausado = false;
        thread = new Thread(new Contagem());
        thread.start();  
    }//GEN-LAST:event_btnIniciar1ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        spMinuto.setValue(10);
         spSegundo.setValue(0);
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        spMinuto.setValue(1);
        spSegundo.setValue(0);
    }//GEN-LAST:event_btn1ActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        thread.interrupt();
        tempo2.setText("0:00");
        btnPausar.setText("PAUSAR");
         btnIniciar1.setEnabled(true);
         spMinuto.setValue(0);
         spSegundo.setValue(0);
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
       spMinuto.setValue(15);
         spSegundo.setValue(0);
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        spMinuto.setValue(3);
         spSegundo.setValue(0);
    }//GEN-LAST:event_btn3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
      
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btnIniciar1;
    private javax.swing.JButton btnPausar;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner spMinuto;
    private javax.swing.JSpinner spSegundo;
    private javax.swing.JLabel tempo2;
    // End of variables declaration//GEN-END:variables
}
