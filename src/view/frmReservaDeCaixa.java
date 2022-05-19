/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.Usuario;
import modelo.dao.UsuariosDAO;
import produzconexao.RefazerConexao;
import util.ConfirmarReservaDeCaixa;
import util.SelecionarReservaDeCaixa;
import util.SoNumeros;
import static view.frmPrincipal.btnAdministrador;
import static view.frmPrincipal.btnCaixa;
import static view.frmPrincipal.btnEntrar;
import static view.frmPrincipal.btnLogin;
import static view.frmPrincipal.dtpDescktop;
import static view.frmPrincipal.mnCaixa;
import static view.frmPrincipal.mnEntrar;
import static view.frmPrincipal.mnFecharEntrar;
import static view.frmPrincipal.mnFecharNovousuario;
import static view.frmPrincipal.mnFecharRelatorios;
import static view.frmPrincipal.mnFecharcaixa;
import static view.frmPrincipal.mnMovimento;
import static view.frmPrincipal.mnNovousuario;
import static view.frmPrincipal.mnRelatorios;
import static view.frmPrincipal.btnRelatorio;

/**
 *
 * @author Pituba
 */
public class frmReservaDeCaixa extends javax.swing.JInternalFrame {
    SelecionarReservaDeCaixa selecionarreservadecaixa = new SelecionarReservaDeCaixa();
    ConfirmarReservaDeCaixa confirmarreservadecaixa = new ConfirmarReservaDeCaixa();
    private String agora, horaagora, lognickentrar;
    private int iddata, idusuario;

    public void setAgora(String agora) {
        this.agora = agora;
    }

    public void setHoraagora(String horaagora) {
        this.horaagora = horaagora;
    }

    public void setIddata(int iddata) {
        this.iddata = iddata;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public void setLognickentrar(String lognickentrar){
         this.lognickentrar = lognickentrar;
    }
  
    public frmReservaDeCaixa() {
        initComponents();
        selecionarreservadecaixa.SelecionarUltimoCaixaReservado();
        btnAdministrador.setEnabled(false);
    }
    
    public void setPosicao(){
    
         Dimension dimensao = dtpDescktop.getSize();
           this.setSize(dimensao);
               this.toFront();               
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
        txtReservaemnotas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtReservaemmoedas = new javax.swing.JTextField();
        lblDatadareserva = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirmaresair = new javax.swing.JButton();
        ftxtConfirmanotasreservadas = new javax.swing.JFormattedTextField();
        ftxtConfirmamoedasreservadas = new javax.swing.JFormattedTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caixa.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Notas:");

        txtReservaemnotas.setEditable(false);
        txtReservaemnotas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtReservaemnotas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Moedas:");

        txtReservaemmoedas.setEditable(false);
        txtReservaemmoedas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtReservaemmoedas.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblDatadareserva.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDatadareserva.setText("Reservado em: ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirme o caixa!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Notas:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Moedas:");

        btnConfirmaresair.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConfirmaresair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/button_ok2-32x32x24.png"))); // NOI18N
        btnConfirmaresair.setText("Confirmar e sair");
        btnConfirmaresair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaresairActionPerformed(evt);
            }
        });
        btnConfirmaresair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmaresairKeyPressed(evt);
            }
        });

        ftxtConfirmanotasreservadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtConfirmanotasreservadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtConfirmanotasreservadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ftxtConfirmanotasreservadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftxtConfirmanotasreservadasMouseClicked(evt);
            }
        });
        ftxtConfirmanotasreservadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtConfirmanotasreservadasKeyPressed(evt);
            }
        });

        ftxtConfirmamoedasreservadas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtConfirmamoedasreservadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtConfirmamoedasreservadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ftxtConfirmamoedasreservadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftxtConfirmamoedasreservadasMouseClicked(evt);
            }
        });
        ftxtConfirmamoedasreservadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtConfirmamoedasreservadasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtConfirmanotasreservadas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirmaresair, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtConfirmamoedasreservadas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtConfirmamoedasreservadas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtConfirmanotasreservadas, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(btnConfirmaresair, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatadareserva, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReservaemnotas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReservaemmoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDatadareserva, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReservaemnotas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReservaemmoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaresairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaresairActionPerformed
        String tipousuario = "";
        if(!ftxtConfirmanotasreservadas.getText().equals("") && !ftxtConfirmamoedasreservadas.getText().equals("")){
        confirmarreservadecaixa.ConfirmarReservaDeCaixa(agora, horaagora, iddata, idusuario);
        
        RefazerConexao rfc = new RefazerConexao();
        rfc.refazerconexao();
        //List<Usuario> selecionandousuario = new ArrayList<>();
        UsuariosDAO usdao = new UsuariosDAO();
        String selecionandousuario = usdao.selecionarusuarioadmin(lognickentrar);

        /*for(Usuario usuarios : selecionandousuario){
                       tipousuario = usuarios.getAdmin();
                      }*/
           if(selecionandousuario.equalsIgnoreCase("Administrador")){
              btnCaixa.setEnabled(true);
              mnCaixa.setEnabled(true);
              mnFecharcaixa.setEnabled(false);
              btnRelatorio.setEnabled(true);
              mnRelatorios.setEnabled(true);
              mnFecharRelatorios.setEnabled(false);
              mnMovimento.setEnabled(true);
              btnAdministrador.setEnabled(false);
           }else{
              btnAdministrador.setEnabled(true);
           }
           btnEntrar.setEnabled(false);
           mnEntrar.setEnabled(false);
           mnFecharEntrar.setEnabled(false);
           btnLogin.setEnabled(false);
           mnNovousuario.setEnabled(false);
           mnFecharNovousuario.setEnabled(false);
          this.dispose();
     }else{
        JOptionPane.showMessageDialog(null, "É necessário confirmar o caixa reservado!\n"
                + "por favor confirme os valores.");
        ftxtConfirmanotasreservadas.setText("");
        ftxtConfirmamoedasreservadas.setText("");
        ftxtConfirmanotasreservadas.requestFocus();
     }
    }//GEN-LAST:event_btnConfirmaresairActionPerformed

    private void ftxtConfirmanotasreservadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtConfirmanotasreservadasKeyPressed
        if(ftxtConfirmanotasreservadas.getText().equals("")){
            ftxtConfirmanotasreservadas.setDocument(new SoNumeros());
        }else{
              if(evt.getKeyCode()== evt.VK_ENTER){
                 ftxtConfirmamoedasreservadas.requestFocus();
              }
        }
    }//GEN-LAST:event_ftxtConfirmanotasreservadasKeyPressed

    private void ftxtConfirmamoedasreservadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtConfirmamoedasreservadasKeyPressed
        if(ftxtConfirmamoedasreservadas.getText().equals("")){
            ftxtConfirmamoedasreservadas.setDocument(new SoNumeros());
        }else{
             if(evt.getKeyCode()== evt.VK_ENTER){
                btnConfirmaresair.requestFocus();
             }
        }
    }//GEN-LAST:event_ftxtConfirmamoedasreservadasKeyPressed

    private void ftxtConfirmanotasreservadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftxtConfirmanotasreservadasMouseClicked
        ftxtConfirmanotasreservadas.setDocument(new SoNumeros());
    }//GEN-LAST:event_ftxtConfirmanotasreservadasMouseClicked

    private void ftxtConfirmamoedasreservadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftxtConfirmamoedasreservadasMouseClicked
        ftxtConfirmamoedasreservadas.setDocument(new SoNumeros());
    }//GEN-LAST:event_ftxtConfirmamoedasreservadasMouseClicked

    private void btnConfirmaresairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmaresairKeyPressed
        if(evt.getKeyCode()== evt.VK_ENTER){
           btnConfirmaresair.doClick();
        }
    }//GEN-LAST:event_btnConfirmaresairKeyPressed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmaresair;
    public static javax.swing.JFormattedTextField ftxtConfirmamoedasreservadas;
    public static javax.swing.JFormattedTextField ftxtConfirmanotasreservadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblDatadareserva;
    public static javax.swing.JTextField txtReservaemmoedas;
    public static javax.swing.JTextField txtReservaemnotas;
    // End of variables declaration//GEN-END:variables
}
