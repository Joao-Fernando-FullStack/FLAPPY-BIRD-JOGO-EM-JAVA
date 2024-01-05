package telas;

import classes.Motor;
import classes.FlappyBird;

import javax.swing.JOptionPane;

/**
 *
 * @author João Fernandes
 */
public class Menu extends javax.swing.JFrame {

    public Motor m;

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btScore = new javax.swing.JButton();
        btNovoJogo = new javax.swing.JButton();
        btContinuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btContinuarJogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(113, 197, 207));
        jPanel1.setPreferredSize(new java.awt.Dimension(384, 512));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSair.setBackground(new java.awt.Color(205, 83, 0));
        btSair.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btSair.setForeground(new java.awt.Color(255, 255, 255));
        btSair.setText("Sair");
        btSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 320, 78));

        btScore.setBackground(new java.awt.Color(205, 83, 0));
        btScore.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btScore.setForeground(new java.awt.Color(255, 255, 255));
        btScore.setText("Pontuação");
        btScore.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btScore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btScoreActionPerformed(evt);
            }
        });
        jPanel1.add(btScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 320, 78));

        btNovoJogo.setBackground(new java.awt.Color(205, 83, 0));
        btNovoJogo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btNovoJogo.setForeground(new java.awt.Color(255, 255, 255));
        btNovoJogo.setText("Novo Jogo");
        btNovoJogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btNovoJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoJogoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovoJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 78));

        btContinuar.setBackground(new java.awt.Color(205, 83, 0));
        btContinuar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btContinuar.setText("Sobre");
        btContinuar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btContinuar.setPreferredSize(new java.awt.Dimension(40, 32));
        btContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(btContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 320, 78));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flappy-bird.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 6, -1, 146));

        btContinuarJogo.setBackground(new java.awt.Color(205, 83, 0));
        btContinuarJogo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btContinuarJogo.setForeground(new java.awt.Color(255, 255, 255));
        btContinuarJogo.setText("Continuar");
        btContinuarJogo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btContinuarJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btContinuarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContinuarJogoActionPerformed(evt);
            }
        });
        jPanel1.add(btContinuarJogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 320, 78));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 384, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoJogoActionPerformed
        // TODO add your handling code here:
        if (m == null) {
            new Motor(new FlappyBird());
            FlappyBird.saltar();
        } else {
            this.toBack();
        }

        btNovoJogo.setVisible(false);
    }//GEN-LAST:event_btNovoJogoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja Sair, do Jogo?", "Flappy Bird", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void btContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContinuarActionPerformed
        // TODO add your handling code here:
        Sobre sb = new Sobre();
        sb.show();
    }//GEN-LAST:event_btContinuarActionPerformed

    private void btScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btScoreActionPerformed
        // TODO add your handling code here:
        Pontuacao2 pt = new Pontuacao2();
        pt.show();
    }//GEN-LAST:event_btScoreActionPerformed

    private void btContinuarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContinuarJogoActionPerformed
        // TODO add your handling code here:
        this.toBack();
    }//GEN-LAST:event_btContinuarJogoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btContinuar;
    private javax.swing.JButton btContinuarJogo;
    private javax.swing.JButton btNovoJogo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btScore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
