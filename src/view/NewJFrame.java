/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Pituba
 */
import controle.ControleMovimento;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.bean.Usuario;
import modelo.dao.UrlDao;
import modelo.dao.UsuariosDAO;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import org.apache.poi.util.SystemOutLogger;
import org.firebirdsql.management.FBBackupManager;
import produzconexao.ConexaoFirebird;
import produzconexao.RefazerConexao;
import util.ConfigDB;
import util.GerenciadordeJanelas;
import util.GuardarUrl;
import static view.frmEntrar.txtLognickentrar;
import static view.frmLogin.btnCadastro;
import static view.frmLogin.btnNovoEntrar;
import static view.frmLogin.cbxAdministrador;
import static view.frmLogin.txtConfsenha;
import static view.frmLogin.txtLognick;
import static view.frmLogin.txtLogsenha;
import static view.frmLogin.txtNome;
import static view.frmLogin.txtSenha;
import static view.frmLogin.txtNome;
import static view.frmLogin.txtSenha;
import static view.frmMovimento.btnCancelarreserva;
import static view.frmMovimento.btnExcluir;
import static view.frmMovimento.btnFecharMovimento;
import static view.frmMovimento.btnFecharcaixa;
import static view.frmMovimento.btnReservarcaixa;
import static view.frmMovimento.ftxtValor;
import static view.frmMovimento.tblMovimento;
import static view.frmMovimentodia.btnMovimentododiaSair;
import static view.frmPrincipal.btnAdministrador;
import static view.frmPrincipal.btnCaixa;
import static view.frmPrincipal.btnEntrar;
import static view.frmPrincipal.btnLogin;
import static view.frmPrincipal.dtpDescktop;
import static view.frmPrincipal.mnCaixa;
import static view.frmPrincipal.mnEntrar;
import static view.frmPrincipal.mnFecharEntrar;
import static view.frmPrincipal.mnFecharNovousuario;
import static view.frmPrincipal.mnFecharcaixa;
import static view.frmPrincipal.mnNovousuario;

public class NewJFrame extends javax.swing.JFrame {
GuardarUrl guardarurl = new GuardarUrl();
    GerenciadordeJanelas gerenciadordejanelas;
    //frmLogin frmlogin = new frmLogin();
    //frmMovimento frmusuario = new frmMovimento();
    frmMovimentodia frmmovimentodia;
    frmRelatorios frmrelatorios;
    //frmEntrar frmentrar = new frmEntrar();
    ControleMovimento controlemovimento = new ControleMovimento();
    public NewJFrame() {
        initComponents();
         this.setExtendedState(MAXIMIZED_BOTH);
        this.gerenciadordejanelas = new GerenciadordeJanelas(dtpDescktop);
        guardarurl.setContador(0);
        String resultado = guardarurl.GetProp("conectar"); 
        String ip = guardarurl.GetProp("IP");
        try {
            if (!resultado.equals("")) {
                ConexaoFirebird conect = new ConexaoFirebird(resultado, ip);
            } else {
                String servidor = JOptionPane.showInputDialog(null,"Digite aqui o IP do servidor, caso exista um!");
                UrlDao url = new UrlDao();
                //url.pegaurl();
                if(!"".equals(servidor)){
                url.pegaurl(servidor);
                }else{
                url.pegaurl("localhost");
                }
            }
        } catch (ClassNotFoundException ex) {
            //UrlDao url = new UrlDao();
            //url.pegaurl();
            String servidor = JOptionPane.showInputDialog(null,"Digite aqui o IP do servidor, caso exista um!");
                UrlDao url = new UrlDao();
                if(servidor != ""){
                url.pegaurl(servidor);
                }else{
                url.pegaurl("localhost");
                }
            
        } catch (SQLException ex) {
            System.exit(0);
        }  
        
        String resultsec = guardarurl.GetPropsecr("internalizar");
           if(!resultsec.equals("dentro")){
              System.exit(0);
           }
        
        List<Usuario> selecionandousuario = new ArrayList<>();
        UsuariosDAO usdao = new UsuariosDAO();
        selecionandousuario = usdao.selecionaradmin();
        if(!selecionandousuario.isEmpty()){
           abrirentrar(); 
           txtLognickentrar.requestFocus();
           mnEntrar.setEnabled(false);
           mnFecharEntrar.setEnabled(true);
           mnNovousuario.setEnabled(true);
           mnFecharNovousuario.setEnabled(false);
           btnEntrar.setEnabled(false);

           if(frmLogin.getInstancia().isSelected()){
              gerenciadordejanelas.fecharjanelas(frmLogin.getInstancia());
           }
        }
        if(selecionandousuario.isEmpty()){
            abrirlogin();
            //frmLogin frmlogin = new frmLogin();
            txtLognick.requestFocus();
            cbxAdministrador.setSelected(false);
            txtNome.setEnabled(true);
            txtNome.requestFocus();
            txtSenha.setEnabled(true);
            txtConfsenha.setEnabled(true);
            cbxAdministrador.setEnabled(true);
            btnCadastro.setEnabled(true);
            txtLognick.setText("");
            txtLogsenha.setText("");
            //frmlogin.setClosable(true);
            mnNovousuario.setEnabled(false);
            mnFecharNovousuario.setEnabled(true);
            mnEntrar.setEnabled(true);
            mnFecharEntrar.setEnabled(false);
            btnEntrar.setEnabled(false);
            btnLogin.setEnabled(false);
            
            RefazerConexao rfcinicio = new RefazerConexao();
            rfcinicio.refazerconexao();
            List<Usuario> selecionandoadministrador = new ArrayList<>();
            UsuariosDAO admindao = new UsuariosDAO();
            selecionandoadministrador = admindao.selecionaradmin();
            if(selecionandoadministrador.isEmpty()){
              cbxAdministrador.setSelected(true);
              cbxAdministrador.setEnabled(false);
            }
            if(frmEntrar.getInstancia().isSelected()){
               gerenciadordejanelas.fecharjanelas(frmEntrar.getInstancia());
            }
           
        }
    }
    public void abrirlogin(){
        try {
             gerenciadordejanelas.abrirlogin(frmLogin.getInstancia());
             frmLogin.getInstancia().setSelected(true);
             btnAdministrador.setEnabled(false);
        } catch (PropertyVetoException ex) {
             Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void abrirentrar(){
        try {
             gerenciadordejanelas.abrirentrar(frmEntrar.getInstancia());
             frmEntrar.getInstancia().setSelected(true);
        } catch (PropertyVetoException ex) {
             Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                                                               
    
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
