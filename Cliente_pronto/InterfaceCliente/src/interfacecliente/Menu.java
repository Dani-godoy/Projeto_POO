/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfacecliente;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nick
 */
public class Menu extends javax.swing.JFrame {

    private String cpf;
    Clientes cliente = new Clientes();
    Pedidos pedido = new Pedidos();
    
   
    int variavel;
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnNovoPedido = new javax.swing.JButton();
        btnAlterarExistente = new javax.swing.JButton();
        btnConsultarPedido = new javax.swing.JButton();
        btnCancelarExistente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Escolha o que fazer a seguir:");

        btnNovoPedido.setFont(new java.awt.Font("Cambria Math", 3, 14)); // NOI18N
        btnNovoPedido.setForeground(new java.awt.Color(0, 0, 51));
        btnNovoPedido.setText("Fazer novo pedido");
        btnNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPedidoActionPerformed(evt);
            }
        });

        btnAlterarExistente.setFont(new java.awt.Font("Cambria Math", 3, 14)); // NOI18N
        btnAlterarExistente.setForeground(new java.awt.Color(0, 0, 51));
        btnAlterarExistente.setText("Alterar pedido existente");
        btnAlterarExistente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterarExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarExistenteActionPerformed(evt);
            }
        });

        btnConsultarPedido.setFont(new java.awt.Font("Cambria Math", 3, 14)); // NOI18N
        btnConsultarPedido.setForeground(new java.awt.Color(0, 0, 51));
        btnConsultarPedido.setText("Consultar pedido");
        btnConsultarPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsultarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPedidoActionPerformed(evt);
            }
        });

        btnCancelarExistente.setFont(new java.awt.Font("Cambria Math", 3, 14)); // NOI18N
        btnCancelarExistente.setForeground(new java.awt.Color(0, 0, 51));
        btnCancelarExistente.setText("Cancelar pedido  existente");
        btnCancelarExistente.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCancelarExistente.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnCancelarExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarExistenteActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacecliente/Burguer_usu.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultarPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnNovoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterarExistente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarExistente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarExistente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPedidoActionPerformed
        pedido.setVisible(true);
        pedido.setCpf(cpf);
        this.setVisible(false);
        // pedido.setComida(pedido.getComida())
    }//GEN-LAST:event_btnNovoPedidoActionPerformed

    private void btnAlterarExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarExistenteActionPerformed
       boolean pedidofeito = cliente.buscarPedido(cpf);
        if(pedidofeito){
            ArrayList<Integer> pedidos = new ArrayList();
            pedidos = cliente.pegarPedido(cpf);
            pedido.completarPedido(pedidos);
            pedido.setVisible(true); 
            pedido.setCpf(cpf);
            this.setVisible(false);
       }
        else{
            JOptionPane.showMessageDialog(null,"Você não tem pedidos", "Peça já!", JOptionPane.INFORMATION_MESSAGE);
       }
    }//GEN-LAST:event_btnAlterarExistenteActionPerformed

    private void btnConsultarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPedidoActionPerformed
        PedidoPronto pedidoPronto = new PedidoPronto();
        System.out.println(cpf);
        pedidoPronto.setVisible(true);
        pedidoPronto.setCpf(cpf);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultarPedidoActionPerformed

    private void btnCancelarExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarExistenteActionPerformed
        Pessoa pessoa = new Pessoa(cpf, cliente.getSenha(cpf), cliente.getNome(cpf));
        boolean pedidofeito = cliente.buscarPedido(cpf);
        if(pedidofeito){
        String[] opcoes = {"Sim, cancelar pedido", "Não, voltar"};
        int cap = JOptionPane.showOptionDialog(null, cliente.PrintExtratoCliente(cpf), "Deseja cancelar esse pedido?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
        if(cap==0){
        this.setVisible(false);
        boolean encontrou = cliente.remover(cpf);
        cliente.inserir(pessoa);
        JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado!", "Até a próxima", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(true);
        }
        else{
            this.setVisible(true);
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"Você não tem pedidos", "Peça já!", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarExistenteActionPerformed

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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarExistente;
    private javax.swing.JButton btnCancelarExistente;
    private javax.swing.JButton btnConsultarPedido;
    private javax.swing.JButton btnNovoPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
