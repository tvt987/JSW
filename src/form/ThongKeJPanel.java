package form;

import chart.ChartJPanel;
import chart.ModelChart;
import com.snethlios.dao.PhieuXuatDAO;
import com.snethlios.dao.ThongKeDAO;
import com.snethlios.utils.Auth;
import com.snethlios.utils.JdbcHelper;
import com.snethlios.utils.XDate;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Model_Card;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeJPanel extends javax.swing.JPanel {

    public ThongKeJPanel() {
        initComponents();
        init();
        fillTableBang();
        //tieu de chart
//        chart.addLegend("Tổng giá bán", new Color(245, 189, 135));
//        chart.addLegend("Expense", new Color(135, 189, 245));
//        chart.addLegend("Profit", new Color(189, 135, 245));
//        chart.addLegend("Cost", new Color(139, 229, 222));

        //data chart
//        chart.addData(new ModelChart("Tháng 1", new double[]{1800, 150, 0, 0}));
//        chart.addData(new ModelChart("Tháng 2", new double[]{1200, 750, 90, 150}));
//        chart.addData(new ModelChart("Tháng 3", new double[]{2400, 350, 460, 900}));
//        chart.addData(new ModelChart("Tháng 4", new double[]{480, 150, 750, 700}));
//        chart.addData(new ModelChart("Tháng 5", new double[]{350, 540, 300, 150}));
//        chart.addData(new ModelChart("Tháng 6", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 7", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 8", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 9", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 10", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 11", new double[]{190, 280, 81, 200}));
//        chart.addData(new ModelChart("Tháng 12", new double[]{190, 280, 81, 200}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        date1 = new com.raven.datechooser.DateChooser();
        date2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        card1 = new component.CardJPanel();
        card2 = new component.CardJPanel();
        card3 = new component.CardJPanel();
        card4 = new component.CardJPanel();
        Tabs = new javax.swing.JTabbedPane();
        pnlDoanhThu = new javax.swing.JPanel();
        pnlCard = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        chart = new chart.ChartJPanel();
        Năm = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        Năm1 = new javax.swing.JLabel();
        ThongKe_rdoBang = new javax.swing.JRadioButton();
        ThongKe_rdoBieuDo = new javax.swing.JRadioButton();
        btnfileExcel = new javax.swing.JButton();
        pnlSanPham = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTuNgay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDenNgay = new javax.swing.JTextField();
        btnTuNgay = new javax.swing.JButton();
        btnDenNgay = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();

        date1.setTextRefernce(txtTuNgay);

        date2.setForeground(new java.awt.Color(0, 51, 255));
        date2.setTextRefernce(txtDenNgay);

        setBackground(new java.awt.Color(247, 247, 247));

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(21, 96, 192));
        card1.setColor2(new java.awt.Color(185, 43, 39));
        jPanel1.add(card1);

        card2.setColor1(new java.awt.Color(56, 239, 125));
        card2.setColor2(new java.awt.Color(17, 153, 142));
        jPanel1.add(card2);

        card3.setColor1(new java.awt.Color(255, 153, 102));
        card3.setColor2(new java.awt.Color(255, 94, 98));
        jPanel1.add(card3);

        card4.setColor1(new java.awt.Color(195, 20, 50));
        card4.setColor2(new java.awt.Color(36, 11, 53));
        jPanel1.add(card4);

        pnlDoanhThu.setOpaque(false);

        pnlCard.setLayout(new java.awt.CardLayout());

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel51.setText("CHI TIẾT DOANH THU");

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tháng", "Tổng số bán", "Tổng giá bán", "Tổng giảm giá"
            }
        ));
        jScrollPane12.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel51)
                .addGap(304, 304, 304))
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCard.add(jPanel35, "card3");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlCard.add(jPanel7, "card2");

        Năm.setText("Năm");

        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        Năm1.setText("Lựa chọn hiển thị ");

        buttonGroup1.add(ThongKe_rdoBang);
        ThongKe_rdoBang.setSelected(true);
        ThongKe_rdoBang.setText("Bảng");
        ThongKe_rdoBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKe_rdoBangActionPerformed(evt);
            }
        });

        buttonGroup1.add(ThongKe_rdoBieuDo);
        ThongKe_rdoBieuDo.setText("Biểu đồ");
        ThongKe_rdoBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThongKe_rdoBieuDoActionPerformed(evt);
            }
        });

        btnfileExcel.setBackground(new java.awt.Color(0, 153, 0));
        btnfileExcel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnfileExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnfileExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        btnfileExcel.setText("Xuất file excel");
        btnfileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfileExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDoanhThuLayout = new javax.swing.GroupLayout(pnlDoanhThu);
        pnlDoanhThu.setLayout(pnlDoanhThuLayout);
        pnlDoanhThuLayout.setHorizontalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Năm)
                    .addComponent(cboNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Năm1)
                    .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                        .addComponent(ThongKe_rdoBang)
                        .addGap(18, 18, 18)
                        .addComponent(ThongKe_rdoBieuDo))
                    .addComponent(btnfileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(776, Short.MAX_VALUE))
            .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlDoanhThuLayout.setVerticalGroup(
            pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(Năm)
                .addGap(18, 18, 18)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Năm1)
                .addGap(28, 28, 28)
                .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThongKe_rdoBang)
                    .addComponent(ThongKe_rdoBieuDo))
                .addGap(40, 40, 40)
                .addComponent(btnfileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(pnlDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDoanhThuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Tabs.addTab("Doanh thu", pnlDoanhThu);

        pnlSanPham.setOpaque(false);

        jLabel52.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel52.setText("CHI TIẾT SẢN PHẨM");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng đã bán", "Số lượng còn lại"
            }
        ));
        jScrollPane13.setViewportView(tblSanPham);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Từ:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Đến:");

        btnTuNgay.setText("...");
        btnTuNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuNgayActionPerformed(evt);
            }
        });

        btnDenNgay.setText("...");
        btnDenNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenNgayActionPerformed(evt);
            }
        });

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                        .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(210, 210, 210))
                            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                            .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                                        .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(299, 299, 299))))
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabs.addTab("Sản phẩm", pnlSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tabs)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ThongKe_rdoBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKe_rdoBieuDoActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlCard.getLayout();
        layout.last(pnlCard);

    }//GEN-LAST:event_ThongKe_rdoBieuDoActionPerformed

    private void ThongKe_rdoBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThongKe_rdoBangActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) pnlCard.getLayout();
        layout.first(pnlCard);

    }//GEN-LAST:event_ThongKe_rdoBangActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        fillTableDoanhThu();
        fillTableBang();
        fillBieuDo();
    }//GEN-LAST:event_cboNamActionPerformed

    private void btnfileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfileExcelActionPerformed
        // TODO add your handling code here:
        this.creatDoanhThuExcel();
    }//GEN-LAST:event_btnfileExcelActionPerformed

    private void btnTuNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuNgayActionPerformed
        // TODO add your handling code here:
        date1.showPopup();
    }//GEN-LAST:event_btnTuNgayActionPerformed

    private void btnDenNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenNgayActionPerformed
        // TODO add your handling code here:
        date2.showPopup();
    }//GEN-LAST:event_btnDenNgayActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        this.fillTableSanPhamTheoNgay();
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Năm;
    private javax.swing.JLabel Năm1;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JRadioButton ThongKe_rdoBang;
    private javax.swing.JRadioButton ThongKe_rdoBieuDo;
    private javax.swing.JButton btnDenNgay;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTuNgay;
    private javax.swing.JButton btnfileExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private component.CardJPanel card1;
    private component.CardJPanel card2;
    private component.CardJPanel card3;
    private component.CardJPanel card4;
    private javax.swing.JComboBox<String> cboNam;
    private chart.ChartJPanel chart;
    private com.raven.datechooser.DateChooser date1;
    private com.raven.datechooser.DateChooser date2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlDoanhThu;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDenNgay;
    private javax.swing.JTextField txtTuNgay;
    // End of variables declaration//GEN-END:variables
    ThongKeDAO dao = new ThongKeDAO();
    PhieuXuatDAO pxdao = new PhieuXuatDAO();

    void init() {
        this.fillComboBoxNam();
        fillTableDoanhThu();
        fillTableSanPham();
        fillTableBang();

        if (!Auth.isManager()) {
            Tabs.remove(0);
        }
    }
/////////////////////// 4 BẢNG VUÔNG /////////////////////////////////

    public void fillTableBang() {
        String doanhThuNam = null;
        String doanhThuTBThang = null;
        String doanhThuTBNgay = null;
        String tongKhachHang1Ngay = null;
        String tongHoaDon1Ngay = null;
        try {
            if (!Auth.isManager()) {
                doanhThuNam = "$0";
                doanhThuTBThang = "$0";
                doanhThuTBNgay = "$0";
                tongKhachHang1Ngay = String.valueOf(dao.tongKhachHang1Ngay());
                tongHoaDon1Ngay = String.valueOf(dao.tongHoaDon1Ngay());
            } else {
                int nam = (int) cboNam.getSelectedItem();
                doanhThuNam = "$" + dao.doanhThuNam(nam);
                doanhThuTBThang = "$" + String.format("%.1f", dao.doanhThuTBThang(nam));
                doanhThuTBNgay = "$" + String.format("%.1f", dao.doanhThuTBNgay(nam));
                tongKhachHang1Ngay = String.valueOf(dao.tongKhachHang1Ngay());
                tongHoaDon1Ngay = String.valueOf(dao.tongHoaDon1Ngay());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/customer (1).png")), "Tổng hóa đơn/ngày", tongHoaDon1Ngay, ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/letter-d.png")), "TB doanh thu/ngày", doanhThuTBNgay, ""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/letter-m.png")), "TB doanh thu/tháng", doanhThuTBThang, ""));
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/letter-y.png")), "Tổng doanh thu/năm", doanhThuNam, ""));

    }
/////////////////////// COMBOBOX /////////////////////////////////

    private void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<Integer> list = pxdao.selectYears();
        for (Integer year : list) {
            model.addElement(year);
        }

    }

/////////////////////// DOANH THU /////////////////////////////////
    private void fillTableDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        int nam = (Integer) cboNam.getSelectedItem();
        List<Object[]> list = dao.getDoanhThu(nam);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    private void fillBieuDo() {
        int nam = (Integer) cboNam.getSelectedItem();
        chart.removeData();
        chart.removeLegend();

        chart.addLegend("Tổng giá bán", new Color(245, 189, 135));
        chart.addLegend("Tổng giảm giá", new Color(135, 189, 245));
        List<Object[]> list = dao.getDoanhThu(nam);

        for (Object[] row : list) {
            String month = (String) "Tháng " + row[0];
            int tongGiaBan = (int) row[2];
            int tongGiamGia = (int) row[3];
            chart.addData(new ModelChart(month, new double[]{tongGiaBan, tongGiamGia, 0, 0}));
        }
    }

/////////////////////// SẢN PHẨM /////////////////////////////////
    private void fillTableSanPham() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        List<Object[]> list = dao.getSanPham();
        for (Object[] row : list) {
            model.addRow(row);
        }

    }
    
    private void fillTableSanPhamTheoNgay() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        String tuNgay = txtTuNgay.getText();
        String denNgay = txtDenNgay.getText();
        
        String SanPhamTheoNgay = "select sp.MASP, sp.TENSP, sum(ct.SOLUONG), SUM(sp.SOLUONG)" +
                                " from PHIEUXUAT px inner join CTPX ct on px.SOPX = ct.SOPX inner join SANPHAM sp on ct.MASP = sp.MASP " +
                                " where NGAYTAO >= convert(date,?,105) and NGAYTAO <= convert(date,?,105)" + 
                                " group by sp.TENSP, sp.MASP ";
        try {
            ResultSet rs = JdbcHelper.query(SanPhamTheoNgay, tuNgay, denNgay);
            while(rs.next()){
                Object[] row = new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/////////////////////// EXCEL /////////////////////////////////
    private void creatDoanhThuExcel() {
        int nam = (Integer) cboNam.getSelectedItem();
        List<Object[]> list = dao.getDoanhThu(nam);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("baocaoDT");
            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(2);// xuống 2 dòng
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            int year = (int) cboNam.getSelectedItem();
            cell.setCellValue("Báo cáo doanh thu " + year);

            row = sheet.createRow(3);// xuống 3 dòng
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Tháng");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng số bán");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tổng giá bán");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tổng giảm giá");

            int rowid = 4;
            for (Object[] row1 : list) {
                row = sheet.createRow(rowid++);
                int cellid = 0;
                for (Object obj : row1) {
                    cell = row.createCell(cellid++);
                    cell.setCellValue((int) obj);
                }
            }
            String path = "BaoCaoDoanhThu11111.xlsx";
            File file = new File(path);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(this, "Xuất qua file excel thành công");
                try {
                    if (file.exists()) {
                        Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
                        pro.waitFor();
                    } else {
                        JOptionPane.showMessageDialog(this, "File excel không tồn tại");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Mở file excel không thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }
    
}
