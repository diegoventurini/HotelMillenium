/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Cliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class FormBuscarCliente extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    /**
     * Creates new form FormBuscarQuarto
     */
    public FormBuscarCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    public void tabelaId(){
        if (tfCpf.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, "Preencha o campo antes de pesquisar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Cliente c = FormPrincipal.clienteDAO.buscarCliente(tfCpf.getText());
        if (c != null){
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            String dataConvertida = dt.format(c.getDataNascimento());
            
            String sexo = (c.getSexo()) ? "Masculino" : "Feminino";
            modelo.addRow(new Object[]{c.getCpf(), c.getNome(), dataConvertida, sexo, c.getTelefone(), c.getEmail()});
        }
        else
           JOptionPane.showMessageDialog(null, "Quarto não encontrada.", "Atenção", JOptionPane.WARNING_MESSAGE); 
    }
    
    public void tabelaTodos(){
        for (Cliente c: FormPrincipal.clienteDAO.getList()){
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            String dataConvertida = dt.format(c.getDataNascimento());
            
            String sexo = (c.getSexo()) ? "Masculino" : "Feminino";
            modelo.addRow(new Object[]{c.getCpf(), c.getNome(), dataConvertida, sexo, c.getTelefone(), c.getEmail()});
        }
    }
    
   
    
    public Cliente pegaCliente(){
        int linha =tbCliente.getSelectedRow();
        
        Cliente c = new Cliente();
        c.setCpf((String) modelo.getValueAt(linha, 0));
        c.setNome((String) modelo.getValueAt(linha, 1));
        
        String dataTexto = (String) modelo.getValueAt(linha, 2);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataConvertida = df.parse(dataTexto);
            c.setDataNascimento(dataConvertida);
        } catch (ParseException ex) {
            
        }
        
        String sexo = (String) modelo.getValueAt(linha, 3);
        Boolean valor = (sexo.equals("Masculino")) ? true : false;
        c.setSexo(valor);
        
        c.setTelefone((String) modelo.getValueAt(linha, 4));
        c.setEmail((String) modelo.getValueAt(linha, 5));
        
        
        return c;
    }
    
    public void limparTabela(){
        for (int i = tbCliente.getRowCount() - 1; i >= 0; i--){
            modelo.removeRow(i);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        bgTipoQuarto = new javax.swing.ButtonGroup();
        lbCpfCliente = new javax.swing.JLabel();
        tfCpf = new javax.swing.JFormattedTextField();
        cbCliente = new javax.swing.JCheckBox();
        btBuscarCPF1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair1 = new javax.swing.JButton();
        lbImagemCliente = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCpfCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCpfCliente.setForeground(new java.awt.Color(0, 0, 102));
        lbCpfCliente.setText("CPF do Cliente");
        getContentPane().add(lbCpfCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 20));

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCpfActionPerformed(evt);
            }
        });
        getContentPane().add(tfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 30));

        cbCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbCliente.setForeground(new java.awt.Color(0, 0, 102));
        cbCliente.setText("Ver Todas os Clientes");
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });
        getContentPane().add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        btBuscarCPF1.setBackground(new java.awt.Color(255, 255, 255));
        btBuscarCPF1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btBuscarCPF1.setForeground(new java.awt.Color(0, 0, 102));
        btBuscarCPF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icBuscar.png"))); // NOI18N
        btBuscarCPF1.setText("Buscar");
        btBuscarCPF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCPF1ActionPerformed(evt);
            }
        });
        getContentPane().add(btBuscarCPF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 120, 50));

        tbCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tbCliente.setForeground(new java.awt.Color(0, 0, 102));
        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Data de Nascimento", "Sexo", "Telefone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.getTableHeader().setReorderingAllowed(false);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);
        if (tbCliente.getColumnModel().getColumnCount() > 0) {
            tbCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbCliente.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbCliente.getColumnModel().getColumn(3).setPreferredWidth(70);
            tbCliente.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbCliente.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 400, 140));

        btEditar.setBackground(new java.awt.Color(255, 255, 255));
        btEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btEditar.setForeground(new java.awt.Color(0, 0, 102));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icAtualizar2.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 120, 50));

        btExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btExcluir.setForeground(new java.awt.Color(0, 0, 102));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icRemoverItem.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 51));

        btSair1.setBackground(new java.awt.Color(255, 255, 255));
        btSair1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSair1.setForeground(new java.awt.Color(0, 0, 102));
        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icSair.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        getContentPane().add(btSair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 110, 51));

        lbImagemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cliente22.jpg"))); // NOI18N
        getContentPane().add(lbImagemCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 470, 390));

        setSize(new java.awt.Dimension(477, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarCPF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCPF1ActionPerformed
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        
        this.limparTabela();
        this.modelo = (DefaultTableModel) tbCliente.getModel();
        
        if (cbCliente.isSelected())
            tabelaTodos();
        else
            tabelaId();
    }//GEN-LAST:event_btBuscarCPF1ActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        Cliente c = this.pegaCliente();
        
        FormCliente fc = new FormCliente();
        fc.setVisible(true);
        fc.cli = c;
        
        this.dispose();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        String cpf = this.pegaCliente().getCpf();
        
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o cliente?", "Confirmação", JOptionPane.WARNING_MESSAGE);
        System.out.println(opcao);
        if (opcao == 0){
            FormPrincipal.clienteDAO.removerCliente(cpf);
            modelo.removeRow(tbCliente.getSelectedRow());
        }
        
        btEditar.setEnabled(false);
        btExcluir.setEnabled(false);
        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        btEditar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_tbClienteMouseClicked

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        if (cbCliente.isSelected()){
            tfCpf.setText("");
            tfCpf.setEnabled(false);
        }
        else{
            tfCpf.setEnabled(true);
        }
    }//GEN-LAST:event_cbClienteActionPerformed

    private void tfCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCpfActionPerformed

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
            java.util.logging.Logger.getLogger(FormBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBuscarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgTipoQuarto;
    private javax.swing.JButton btBuscarCPF1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair1;
    private javax.swing.JCheckBox cbCliente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCpfCliente;
    private javax.swing.JLabel lbImagemCliente;
    private javax.swing.JTable tbCliente;
    private javax.swing.JFormattedTextField tfCpf;
    // End of variables declaration//GEN-END:variables
}
