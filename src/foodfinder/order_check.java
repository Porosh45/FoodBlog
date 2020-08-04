/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Porosh
 */
public class order_check extends javax.swing.JFrame {

    /**
     * Creates new form order_check
     */
    public order_check() {
        initComponents();
    }
    public order_check(seller sel)
    {
        initComponents();
        this.sid = sel.getId();
        show_order();
    }
    int sid;

    String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=ff";
    String user = "porosh";
    String pass = "rhp01748218277";
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        order_table = new javax.swing.JTable();
        order_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        order_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "order_id", "user_id", "quantity", "Location", "Phone", "Price"
            }
        ));
        jScrollPane1.setViewportView(order_table);

        jLabel1.setText("order id");

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
      
      try
        {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        int id = Integer.parseInt(order_id.getText());
        String sql = "update orders set condition = true  where food_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setFloat(1, id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this,"inserted Successfully");
        
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this,e.getMessage());
        }
       
    }//GEN-LAST:event_confirmActionPerformed

    ArrayList<orders> orderlist()
       {
        ArrayList<orders> order_list = new ArrayList<orders>();
        try
            {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select *from orders";
            ResultSet rs;
                rs = con.prepareStatement(sql).executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("id");
                    int uid = rs.getInt("user_id");
                    int scid = rs.getInt("seller_id");
                    int price = rs.getInt("price");
                    int fid = rs.getInt("food_id");
                    int quantity = rs.getInt("quantity");
                    boolean state = rs.getBoolean("condition");
                    orders order;
                    if(scid==sid && state == false)
                    {
                        order = new orders(id,uid,scid,fid,quantity,price);
                        order_list.add(order);
                    }
                }
            }
        catch(Exception e)
            {
            JOptionPane.showMessageDialog(this,e.getMessage());
            }
            return order_list;
    } 
    public void show_order()
    {
        ArrayList<orders> order = orderlist();
        DefaultTableModel model = (DefaultTableModel)order_table.getModel();
        Object[] row = new Object[6];
        for(int i = 0;i<order.size();i++)
        {
            row[0] = order.get(i).getId();
            row[1] = order.get(i).getUser_id();
            row[2] = order.get(i).getSeller_id();
            row[3] = order.get(i).getFood_id();
            row[4] = order.get(i).getQuantity();
            row[5] = order.get(i).getPrice();
            model.addRow(row);
        }
    }
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
            java.util.logging.Logger.getLogger(order_check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order_check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order_check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order_check.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_check().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField order_id;
    private javax.swing.JTable order_table;
    // End of variables declaration//GEN-END:variables
}
