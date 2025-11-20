/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ferragem;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author N09
 */
public class ProdutosVenda extends javax.swing.JFrame {

    Connection con = null;
   Statement st = null;
   PreparedStatement pst = null;
   ResultSet rs = null;
    
    public ProdutosVenda() {
        initComponents();
   
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo","root","");
             showRecord();
            st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=st.executeQuery("SELECT Id,Nome,Quantidade,PreçoCompra,Preço FROM 'tblprodutos' ");
            if(rs.next()){
               
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
       
   
    }
    
    
    int BNum;
    private void CountVen(){
        try {
            st=con.createStatement();
            rs=st.executeQuery("select Max(BNum)from print");
            rs.next();
            BNum = rs.getInt(1)+1;
        } catch (Exception e) {
        }
    }
   

    
    
    
    private void InsertTT(){
        {
            if(Nome.getText().isEmpty() || Quant.getText().isEmpty() || Preco.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this,"Preencha os Campos Vazios");
            }
        
        else{
        
        
        try {
            CountVen();
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exemplo","root","");
            PreparedStatement pst = con.prepareStatement("insert into print values (?,?,?,?,?)");
             pst.setInt(1, BNum);
             pst.setString(2, Nome.getText());
            
              pst.setString(3, Quant.getText());
               pst.setString(4, Preco.getText());
                pst.setInt(5,GrdTot);
            int row = pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto Facturado!!!");
            con.close();
            showRecord();
            
            
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
                }
    }}
    
    public void showRecord(){
        try {
            pst=con.prepareStatement("select * from tblprodutos");
            rs=pst.executeQuery();
            ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
            int n =rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) tblTabela.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector obj = new Vector();
                for(int i=1;i<n;i++){
                    
                obj.add(rs.getString(1));
                obj.add(rs.getString(2));
                obj.add(rs.getString(3));
                obj.add(rs.getString(4));    
                obj.add(rs.getString(5)); 
                }
                df.addRow(obj);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Nome = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Preco = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Print = new javax.swing.JButton();
        carinho = new javax.swing.JButton();
        Quant = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TT = new javax.swing.JTable();
        LblTotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Id = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Estoque", "Preço por 1", "Valor de Compra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabela);
        if (tblTabela.getColumnModel().getColumnCount() > 0) {
            tblTabela.getColumnModel().getColumn(3).setResizable(false);
        }

        txtbuscar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtbuscar.setForeground(new java.awt.Color(0, 204, 204));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 204, 204));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Insira o Nome do produto");

        jLabel23.setBackground(new java.awt.Color(0, 204, 204));
        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("No Campo a Baixo");

        Nome.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Nome.setForeground(new java.awt.Color(0, 204, 204));
        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(0, 204, 204));
        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Nome");

        jLabel25.setBackground(new java.awt.Color(0, 204, 204));
        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("PREÇO");

        Preco.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Preco.setForeground(new java.awt.Color(0, 204, 204));
        Preco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrecoMouseClicked(evt);
            }
        });
        Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoActionPerformed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(0, 204, 204));
        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Grande Ferragem");

        jLabel27.setBackground(new java.awt.Color(0, 204, 204));
        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Estoque de Produtos");

        jLabel28.setBackground(new java.awt.Color(0, 204, 204));
        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Para Buscar");

        jLabel29.setBackground(new java.awt.Color(0, 204, 204));
        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Carinho");

        Print.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Print.setForeground(new java.awt.Color(0, 204, 204));
        Print.setText("Vender");
        Print.setBorder(null);
        Print.setBorderPainted(false);
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        carinho.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        carinho.setForeground(new java.awt.Color(0, 204, 204));
        carinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/2x/adicionar-ficheiro.png"))); // NOI18N
        carinho.setText("Carinho");
        carinho.setBorder(null);
        carinho.setBorderPainted(false);
        carinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carinhoActionPerformed(evt);
            }
        });

        Quant.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Quant.setForeground(new java.awt.Color(0, 204, 204));
        Quant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 204, 204));
        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Quantidade");

        TT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Quantidade", "Preço", "Total "
            }
        ));
        TT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TT);

        LblTotal.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        LblTotal.setForeground(new java.awt.Color(255, 255, 255));
        LblTotal.setText("Total");
        LblTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblTotalMouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/my icons/logout.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Id.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Id.setForeground(new java.awt.Color(0, 204, 204));
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(0, 204, 204));
        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(carinho, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel24)
                                .addComponent(Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Preco)
                                .addComponent(Quant)
                                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(carinho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(LblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed
      int Key = 0;
      
      
      
      
    private void tblTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabelaMouseClicked

     
        
        
        
         DefaultTableModel mode1 = (DefaultTableModel)tblTabela.getModel();
        int selectedrow=tblTabela.getSelectedRow();
        Key = Integer.parseInt(mode1.getValueAt(selectedrow,0).toString());
        
      
       Id.setText((String) tblTabela.getValueAt(selectedrow, 0));
        Nome.setText((String) tblTabela.getValueAt(selectedrow, 1));
      //  txtQuant.setText((String) tblTabela.getValueAt(selectedrow, 2));
        Preco.setText((String) tblTabela.getValueAt(selectedrow, 3));
      //  txtCompra.setText((String) tblTabela.getValueAt(selectedrow, 4));
        

   
    }//GEN-LAST:event_tblTabelaMouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
DefaultTableModel ob = (DefaultTableModel) tblTabela.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tblTabela.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtbuscar.getText()));        
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
  
        
        



        try {
            InsertTT();
            TT.print();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_PrintActionPerformed
    int txtId;
    Statement Stl =null;
    ResultSet Rsl =null;
    
    
    private void Contagem(){
        try {
            Stl = con.createStatement();
            Rsl=Stl.executeQuery("select Max(SID)from tblTabela");
            Rsl.next();
            txtId = Rsl.getInt(1)+1;
        } catch (Exception e) {
        }
}
    
     
    int GrdTot=0;
    private void carinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carinhoActionPerformed

        if(Nome.getText().isEmpty() || Quant.getText().isEmpty() || Preco.getText().isEmpty() ){
            
            JOptionPane.showMessageDialog(this, "Campo Vazio!");
            
            
        }else{ 
           int Total = Integer.valueOf(Preco.getText()) * Integer.valueOf( Quant.getText());
           GrdTot = GrdTot + Total;
           LblTotal.setText(GrdTot +"  Mts");

           DefaultTableModel model = (DefaultTableModel)TT.getModel();

           String nextRowId = Integer.toString(model.getRowCount());

           model.addRow(new Object[]{
  
               Integer.valueOf(nextRowId)+1,
    
               Nome.getText(),
   
               Quant.getText(),
    
               Preco.getText(),
   
               Total
        
    
           });  
        }
        
       

    

    
        
    }//GEN-LAST:event_carinhoActionPerformed
    
    
    private void QuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantActionPerformed
  
   // int e =2;
     //       
       //     e++;
       //Float Preco = Float.parseFloat(txtPreco.getText());
       //Float Quant = (float)(Preco);
       
       
      // txtQuant.setText(Quant.toString());
       
       //float total = (Quant);
       
       //txtTotal.setText(Float.toString(total));
    }//GEN-LAST:event_QuantActionPerformed

    private void PrecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrecoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoMouseClicked
   
    private void PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoActionPerformed
      
       
       
       
       
       
       
        
    }//GEN-LAST:event_PrecoActionPerformed

    private void TTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTMouseClicked

    }//GEN-LAST:event_TTMouseClicked

    private void LblTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LblTotalMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutosVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutosVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JLabel LblTotal;
    private javax.swing.JTextField Nome;
    private javax.swing.JTextField Preco;
    private javax.swing.JButton Print;
    private javax.swing.JTextField Quant;
    private javax.swing.JTable TT;
    private javax.swing.JButton carinho;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblTabela;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
