/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.Usuario;
import produzconexao.ConexaoFirebird;
import util.GuardarUrl;
import static view.frmLogin.txtLogsenha;

/**
 *
 * @author Pituba
 */
public class UsuariosDAO {
    
    
    public void salvar_usuarios(String usuario, String senha, String admin){
    
        Connection cnfb = ConexaoFirebird.getConnection();
        
        PreparedStatement pstm = null;
        
        try{
            pstm = cnfb.prepareStatement("INSERT INTO USUARIOS(USUARIO, SENHA, ADIMIN)\n" +
                                         "VALUES(?, ?, ?)");  
            
            pstm.setString(1, usuario);
            pstm.setString(2, senha);
            pstm.setString(3, admin);
            pstm.executeUpdate();
        }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Erro ao tentar salvar usuário! " + ex,
                    "Bragança", JOptionPane.ERROR_MESSAGE);
        }finally{
               ConexaoFirebird.closeConnection(cnfb, pstm);
        }
    }
    
    public List<Usuario> selecionaradmin(){
         Connection con = ConexaoFirebird.getConnection();
         //JOptionPane.showMessageDialog(null, "conexão dentro do selecionar, " + con);
         PreparedStatement stmt = null;
         ResultSet rs = null;
         List<Usuario> selecionausuario = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT ID, USUARIO, ADIMIN FROM USUARIOS WHERE ADIMIN = 'sim'");
           
            rs = stmt.executeQuery();
            Usuario usuarioadmin = new Usuario();
                             while (rs.next()){
                              usuarioadmin.setId(rs.getInt("ID"));
                              usuarioadmin.setUsuario(rs.getString("USUARIO")); 
                              usuarioadmin.setAdmin(rs.getString("ADIMIN"));
                              selecionausuario.add(usuarioadmin);
                             }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no processo de busca! " + ex,
                    "TechScan", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConexaoFirebird.closeConnection(con, stmt, rs);
            
        }                                                    
        return selecionausuario;
    }
    
    public List<Usuario> selecionarusuario(String usuario){

         Connection con = ConexaoFirebird.getConnection();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         List<Usuario> selecionausuario = new ArrayList<>();
         Usuario usuarionome = new Usuario();
         //String usuariosenha = "";
        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO = ?");
           
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            
                             while (rs.next()){
                              usuarionome.setId(rs.getInt("ID"));
                              usuarionome.setUsuario(rs.getString("USUARIO"));
                              usuarionome.setSenha(rs.getString("SENHA"));
                              usuarionome.setAdmin(rs.getString("ADIMIN"));
                              selecionausuario.add(usuarionome);
                             }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no processo de busca! " + ex,
                    "Bragança", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConexaoFirebird.closeConnection(con, stmt, rs);
            
        }                                                    
        return selecionausuario;
    }
    
    public String selecionarusuarioadmin(String usuario){
         Connection con = ConexaoFirebird.getConnection();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         //List<Usuario> selecionausuario = new ArrayList<>();
         Usuario usuarionome = new Usuario();
        try {
            stmt = con.prepareStatement("SELECT ID, USUARIO, SENHA, ADIMIN FROM USUARIOS \n"+
                    "WHERE USUARIO = ?");
           
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();
            
                             //while (rs.next()){
                              //usuarionome.setId(rs.getInt("ID"));
                             // usuarionome.setUsuario(rs.getString("USUARIO"));
                              usuarionome.setSenha(rs.getString("SENHA"));
                              usuarionome.setAdmin(rs.getString("ADIMIN"));
                              //selecionausuario.add(usuarionome);
                             //}
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no processo de busca! " + ex,
                    "Bragança", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConexaoFirebird.closeConnection(con, stmt, rs);
            
        }        
        if(usuarionome.getAdmin().equals("sim") && usuarionome.getSenha().equals(String.valueOf(txtLogsenha.getPassword()))){
            return "Administrador";
        }else if(usuarionome.getAdmin().equals("não")){
            return "não";
        }else{
            return null;
        }
    }
}
