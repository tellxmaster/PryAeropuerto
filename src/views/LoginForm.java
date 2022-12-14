
package views;

import java.awt.Color;
import javax.swing.JOptionPane;
import models.Usuario;
import services.UsuarioService;
import util.Hash;

public class LoginForm extends javax.swing.JFrame {

    private static Usuario usuario;
    
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Content = new javax.swing.JPanel();
        LoginForm = new util.RoundPanel(25,new Color(239,239,239));
        LoginTItle = new javax.swing.JLabel();
        txtUsuario = new util.RoundJTextField();
        txtPassword = new util.RoundJPassField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RegisterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(720, 520));
        setMinimumSize(new java.awt.Dimension(720, 520));
        setPreferredSize(new java.awt.Dimension(720, 520));
        setResizable(false);

        Content.setBackground(new java.awt.Color(204, 204, 255));

        LoginForm.setBackground(new java.awt.Color(204, 204, 255));
        LoginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginTItle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LoginTItle.setForeground(new java.awt.Color(102, 102, 255));
        LoginTItle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTItle.setText("Login");
        LoginForm.add(LoginTItle, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 31, 208, -1));
        LoginForm.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 183, 208, 36));
        LoginForm.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 249, 208, -1));

        btnIngresar.setBackground(new java.awt.Color(51, 153, 255));
        btnIngresar.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        LoginForm.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 304, 208, 43));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        LoginForm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 65, 208, 110));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("??No tienes cuenta? ");
        LoginForm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        RegisterLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        RegisterLabel.setForeground(new java.awt.Color(51, 153, 255));
        RegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RegisterLabel.setText("Registrate");
        RegisterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegisterLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegisterLabelMouseExited(evt);
            }
        });
        LoginForm.add(RegisterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        UsuarioService usuarioService = new UsuarioService();
        String user = txtUsuario.getText();
        String pwd = new String(txtPassword.getPassword());

        if (!user.equals("") && !pwd.equals("")) {
            String pwdN = Hash.sha1(pwd);
            System.out.println(pwdN);
            if (usuarioService.comprobarUsuario(user) && usuarioService.login(user, pwdN)) {
                String tipo = usuarioService.recuperarUsuarioByUsername(user).getTipo_usr();
                this.dispose();
                if(tipo.equals("admin")){
                    AdminForm af = new AdminForm(usuarioService.recuperarUsuarioByUsername(user));
                    af.setVisible(true);
                }else if(tipo.equals("user")){
                    ReservaForm rf = new ReservaForm(usuarioService.recuperarUsuarioByUsername(user));
                    rf.setVisible(true); 
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contrase??a y o Usuario Incorrecto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar los campos para ingresar");
        }    
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void RegisterLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterLabelMouseEntered
        RegisterLabel.setForeground(new Color(51,158,255));
    }//GEN-LAST:event_RegisterLabelMouseEntered

    private void RegisterLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterLabelMouseExited
        RegisterLabel.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_RegisterLabelMouseExited

    private void RegisterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterLabelMouseClicked
        this.dispose();
        RegisterForm rg = new RegisterForm();
        rg.setVisible(true);
    }//GEN-LAST:event_RegisterLabelMouseClicked

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel LoginForm;
    private javax.swing.JLabel LoginTItle;
    private javax.swing.JLabel RegisterLabel;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private util.RoundJPassField txtPassword;
    private util.RoundJTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
