import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class code {
    public static void main(String []args){
        try{
            String connStr="jdbc:mysql://localhost/ariline_data?user=root";
            Connection conn = DriverManager.getConnection(connStr);
            System.out.println("Noi ket thanh cong");
           
           // thực hiện câu lệnh truy vấn 
            Statement stmt = conn.createStatement();
            String sql="SELECT * FROM ql_chuyenbay";
            stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Danh sach chuyen bay: ");
            while (rs.next()) {
                System.out.println("ID: "+rs.getString("CB_id")) ;
                System.out.println("Noi di: "+rs.getString("CB_noidi")) ;
                System.out.println("Noi den: "+rs.getString("CB_noiden")) ;
                System.out.println("Ngay bay: "+rs.getString("CB_ngaybay")) ;
                System.out.println("So ghe ngoi: "+rs.getInt("CB_soGhengoi")) ;
                System.out.println("\n") ;
            }
            
            
            String sql1="SELECT * FROM ql_hanhkhach";
            stmt.executeQuery(sql1);
            ResultSet rs1 = stmt.executeQuery(sql1);
            System.out.println("Danh sach hanh khach: ");
            while (rs1.next()) {
                System.out.println("ID: "+rs1.getInt("HK_id")) ;
                System.out.println("Ho ten: "+rs1.getString("HK_ten")) ;
                System.out.println("Gioi tinh: "+rs1.getString("HK_gioitinh")) ;
                System.out.println("So ho chieu: "+rs1.getString("HK_sohochieu")) ;
                System.out.println("So dien thoai: "+rs1.getString("HK_sdt")) ;
                System.out.println("Dia chi: "+rs1.getString("HK_diachi")) ;
                System.out.println("Quoc tich: "+rs1.getString("HK_quoctich")) ;
                System.out.println("\n") ;
            }
            
            String sql2="SELECT * FROM ql_datve";
            stmt.executeQuery(sql2);
            ResultSet rs2 = stmt.executeQuery(sql2);
            System.out.println("Danh sach dat ve: ");
            while (rs2.next()) {
                System.out.println("ID dat ve: "+rs2.getInt("DV_id")) ;
                System.out.println("ID hanh khach: "+rs2.getInt("HK_id")) ;
                System.out.println("Ho ten: "+rs2.getString("HK_ten")) ;
                System.out.println("ID chuyen bay: "+rs2.getString("CB_id")) ;
               // System.out.println("Gioi tinh: "+rs2.getString("HK_gioitinh")) ;
                System.out.println("So ho chieu: "+rs2.getString("HK_sohochieu")) ;
                System.out.println("Quoc tich: "+rs2.getString("HK_quoctich")) ;
                System.out.println("So luong ve: "+rs2.getInt("DV_soluong")) ;
                System.out.println("Ngay dat: "+rs2.getString("DV_ngaydat")) ;
                System.out.println("Loai ve: "+rs2.getString("LV_loai")) ;
                System.out.println("\n") ;
            }
            
            String sql3="SELECT * FROM ql_loaive";
            stmt.executeQuery(sql3);
            ResultSet rs3 = stmt.executeQuery(sql3);
            System.out.println("Danh sach loai ve: ");
            while (rs3.next()) {
                System.out.println("Loai ve: "+rs3.getString("LV_loai")) ;
                System.out.println("Gia: "+rs3.getInt("LV_gia")) ;
                System.out.println("Phi phuc vu: "+rs3.getInt("LV_phipv")) ;
                System.out.println("Phi phu thu: "+rs3.getInt("LV_phuthu"));
                System.out.println("\n") ;
            }
            
           
            String sql4 = "INSERT INTO ql_chuyenbay VALUES(?, ?, ?, ?, ?)";
            String selectAll = "SELECT * FROM ql_chuyenbay";
            PreparedStatement pStmt =  conn.prepareStatement(sql4);
            //thực hiện câu lệnh truy vấn
            pStmt.setString(1, "110"); //thiết đặt giá trị cho tham số thứ 1
            pStmt.setString(2, "SB Cần Thơ");
            pStmt.setString(3, "SB Vinh");
            pStmt.setString(4, "2022-05-02");
            pStmt.setInt(5, 120);
            pStmt.execute();
            System.out.println("Danh sach chuyen bay: ");
          
            pStmt= conn.prepareStatement(selectAll);
            ResultSet rs4 = pStmt.executeQuery();
            while (rs4.next()) {
                System.out.println("ID: "+rs4.getString(1)) ;
                System.out.println("Noi di: "+rs4.getString(2)) ;
                System.out.println("Noi den: "+rs4.getString(3)) ;
                System.out.println("Ngay bay: "+rs4.getString(4)) ;
                System.out.println("So ghe ngoi: "+rs4.getInt(5)) ;
                System.out.println("\n") ;
            }

        //1. Gọi hàm thêm chuyến bay
        Scanner n5=new Scanner(System.in);
        System.out.println("Nhap vao id chuyen bay can them");
        String CB_id5=n5.nextLine();
         System.out.println("Nhap vao noi di can them");
        String CB_noidi5=n5.nextLine();
         System.out.println("Nhap vao noi den can them");
        String CB_noiden5=n5.nextLine();
         System.out.println("Nhap vao ngay bay can them");
        String CB_ngaybay5=n5.nextLine();
            n5.nextLine();
        System.out.println("Nhap vao so ghe ngoi can them");
        int CB_soGhengoi5=n5.nextInt();
        
            CallableStatement cStmt5 = conn.prepareCall("{call themCB(?,?,?,?,?)}");
            cStmt5.setString(1, CB_id5);//"CB010"
            cStmt5.setString(2, CB_noidi5);//"SB Tan Son Nhat"
            cStmt5.setString(3, CB_noiden5);//"SB Campuchia"
            cStmt5.setString(4, CB_ngaybay5);//"2022-05-01"
            cStmt5.setInt(5, CB_soGhengoi5);//100
            cStmt5.execute();
            ResultSet rs5 = cStmt5.executeQuery("SELECT * FROM ql_chuyenbay");
            System.out.println("Danh sach chuyen bay: :");
            while (rs5.next()) {
                System.out.println("ID: "+rs5.getString(1)) ;
                System.out.println("Noi di: "+rs5.getString(2)) ;
                System.out.println("Noi den: "+rs5.getString(3)) ;
                System.out.println("Ngay bay: "+rs5.getString(4)) ;
                System.out.println("So ghe ngoi: "+rs5.getInt(5)) ;
                System.out.println("\n") ;
            }
            
        //2. Gọi hàm xoá chuyến bay
        Scanner n6=new Scanner(System.in);
        System.out.println("Nhap vao id chuyen bay can xoa");
        String CB_id6=n6.nextLine();
            CallableStatement cStmt6 = conn.prepareCall("{call xoaCB(?)}");
            cStmt6.setString(1,CB_id6);//"CB010" 
            cStmt6.execute();
            ResultSet rs6 = cStmt6.executeQuery("SELECT * FROM ql_chuyenbay");
            System.out.println("Danh sach chuyen bay: :");
            while (rs6.next()) {
                System.out.println("ID: "+rs6.getString(1)) ;
                System.out.println("Noi di: "+rs6.getString(2)) ;
                System.out.println("Noi den: "+rs6.getString(3)) ;
                System.out.println("Ngay bay: "+rs6.getString(4)) ;
                System.out.println("So ghe ngoi: "+rs6.getInt(5)) ;
                System.out.println("\n") ;
            }


        //3.Gọi hàm cập nhật chuyến bay: số ghế, ngày bay
        Scanner n7=new Scanner(System.in);
        System.out.println("Nhap vao id chuyen bay can cap nhat");
        String CB_id7=n7.nextLine(); 
        n7.nextLine();
        System.out.println("Nhap vao so ghe can cap nhat");
        int CB_soGhengoi7=n7.nextInt();
            CallableStatement cStmt7 = conn.prepareCall("{call ud_soghe(?,?)}");
            cStmt7.setString(1,CB_id7); //CB002
            cStmt7.setInt(2,CB_soGhengoi7); //75
            cStmt7.execute();
            ResultSet rs7 = cStmt7.executeQuery("SELECT * FROM ql_chuyenbay");
            System.out.println("Danh sach chuyen bay: :");
            while (rs7.next()) {
                System.out.println("ID: "+rs7.getString(1)) ;
                System.out.println("Noi di: "+rs7.getString(2)) ;
                System.out.println("Noi den: "+rs7.getString(3)) ;
                System.out.println("Ngay bay: "+rs7.getString(4)) ;
                System.out.println("So ghe ngoi: "+rs7.getInt(5)) ;
                System.out.println("\n") ;
            }
            //ngày bay
        Scanner n8=new Scanner(System.in);
        System.out.println("Nhap vao id chuyen bay can cap nhat");
        String CB_id8=n8.nextLine();
      
        System.out.println("Nhap vao ngay bay can cap nhat");
        String CB_ngaybay8=n8.nextLine();
        
        CallableStatement cStmt8 = conn.prepareCall("{call ud_ngaybay(?,?)}");
        cStmt8.setString(1,CB_id8);// "CB002"
        cStmt8.setString(2,CB_ngaybay8);// "2022-05-05"
        cStmt8.execute();
        ResultSet rs8 = cStmt8.executeQuery("SELECT * FROM ql_chuyenbay");
        System.out.println("Danh sach chuyen bay: :");
        while (rs8.next()) {
            System.out.println("ID: "+rs8.getString(1)) ;
            System.out.println("Noi di: "+rs8.getString(2)) ;
            System.out.println("Noi den: "+rs8.getString(3)) ;
            System.out.println("Ngay bay: "+rs8.getString(4)) ;
            System.out.println("So ghe ngoi: "+rs8.getInt(5)) ;
            System.out.println("\n") ;
        }
            
          //4.  Tìm kiếm chuyến bay
        Scanner n9=new Scanner(System.in);
        System.out.println("Nhap vao id chuyen bay can tim");
        String CB_id9=n9.nextLine();
      
        CallableStatement cStmt9 = conn.prepareCall("{call tim_CB(?)}");
        cStmt9.setString(1,CB_id9); //"CB003"
        cStmt9.executeQuery();
        ResultSet rs9 = cStmt9.getResultSet();
        System.out.println("Can tim chuyen bay :");
        while (rs9.next()) {
            System.out.println("ID: "+rs9.getString(1)) ;
            System.out.println("Noi di: "+rs9.getString(2)) ;
            System.out.println("Noi den: "+rs9.getString(3)) ;
            System.out.println("Ngay bay: "+rs9.getString(4)) ;
            System.out.println("So ghe ngoi: "+rs9.getInt(5)) ;
            System.out.println("\n") ;
        }
        //5.Thêm hành khách 
        Scanner n10=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can them");
        int HK_id10=n10.nextInt();
        n10.nextLine();
         System.out.println("Nhap vao ho ten hanh khach can them");
        String HK_ten10=n10.nextLine();
         System.out.println("Nhap vao gioi tinh hanh khach can them");
        String HK_gioitinh10=n10.nextLine();
         System.out.println("Nhap vao so ho chieu hanh khach can them");
        String HK_sohochieu10=n10.nextLine();
        System.out.println("Nhap vao so dien thoai hanh khach can them");
        String HK_sdt10=n10.nextLine();
        System.out.println("Nhap vao dia chi hanh khach can them");
        String HK_diachi10=n10.nextLine();
        System.out.println("Nhap vao quoc tich hanh khach can them");
        String HK_quoctich10=n10.nextLine();
            CallableStatement cStmt10 = conn.prepareCall("{call themHK(?,?,?,?,?,?,?)}");
            cStmt10.setInt(1, HK_id10);// 800
            cStmt10.setString(2, HK_ten10);//"Đo Hong Hoai Thuong"
            cStmt10.setString(3, HK_gioitinh10);//"Nu"
            cStmt10.setString(4, HK_sohochieu10); //"888888"
            cStmt10.setString(5, HK_sdt10);//"012345678"
            cStmt10.setString(6, HK_diachi10);//"Ben Tre"
            cStmt10.setString(7, HK_quoctich10);//"Viet Nam"
            cStmt10.execute();
            ResultSet rs10 = cStmt10.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach:");
            while (rs10.next()) {
                System.out.println("ID: "+rs10.getInt(1)) ;
                System.out.println("Ho ten: "+rs10.getString(2)) ;
                System.out.println("Gioi tinh: "+rs10.getString(3)) ;
                System.out.println("So ho chieu: "+rs10.getString(4)) ;
                System.out.println("So dien thoai: "+rs10.getString(5)) ;
                System.out.println("Dia chi: "+rs10.getString(6)) ;
                System.out.println("Quoc tich: "+rs10.getString(7)) ;
                System.out.println("\n") ;
            }
            
            //6. Xoá hành khách
            Scanner n11=new Scanner(System.in);
            System.out.println("Nhap vao id hanh khach can xoa");
            int HK_id11=n11.nextInt();
            CallableStatement cStmt11 = conn.prepareCall("{call xoaHK(?)}");
            cStmt11.setInt(1, HK_id11);//800
            cStmt11.execute();
            ResultSet rs11 = cStmt11.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi xoa:");
            while (rs11.next()) {
                System.out.println("ID: "+rs11.getInt(1)) ;
                System.out.println("Ho ten: "+rs11.getString(2)) ;
                System.out.println("Gioi tinh: "+rs11.getString(3)) ;
                System.out.println("So ho chieu: "+rs11.getString(4)) ;
                System.out.println("So dien thoai: "+rs11.getString(5)) ;
                System.out.println("Dia chi: "+rs11.getString(6)) ;
                System.out.println("Quoc tich: "+rs11.getString(7)) ;
                System.out.println("\n") ;
            }
            //7. Cập nhật hành khách
            //theo tên
        Scanner n12=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can cap nhat ten");
        int HK_id12=n12.nextInt();
        n12.nextLine();
        System.out.println("Nhap vao ten hanh khach can cap nhat");
        String HK_ten12=n12.nextLine(); 
            CallableStatement cStmt12 = conn.prepareCall("{call ud_ten(?,?)}");
            cStmt12.setInt(1, HK_id12);//600
            cStmt12.setString(2, HK_ten12);//"Chey"
            cStmt12.execute();
            ResultSet rs12 = cStmt12.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi cap nhat:");
            while (rs12.next()) {
                System.out.println("ID: "+rs12.getInt(1)) ;
                System.out.println("Ho ten: "+rs12.getString(2)) ;
                System.out.println("Gioi tinh: "+rs12.getString(3)) ;
                System.out.println("So ho chieu: "+rs12.getString(4)) ;
                System.out.println("So dien thoai: "+rs12.getString(5)) ;
                System.out.println("Dia chi: "+rs12.getString(6)) ;
                System.out.println("Quoc tich: "+rs12.getString(7)) ;
                System.out.println("\n") ;
            }

            //theo giới tính
        Scanner n22=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can cap nhat gioi tinh");
        int HK_id22=n22.nextInt();
        n22.nextLine();
        System.out.println("Nhap vao gioi tinh hanh khach can cap nhat");
        String HK_sdt13=n22.nextLine(); 
            CallableStatement cStmt22 = conn.prepareCall("{call ud_sdt(?,?)}");
            cStmt22.setInt(1, HK_id22);//600
            cStmt22.setString(2, HK_sdt13);//"012345676"
            cStmt22.execute();
            ResultSet rs22 = cStmt22.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi cap nhat:");
            while (rs22.next()) {
                System.out.println("ID: "+rs22.getInt(1)) ;
                System.out.println("Ho ten: "+rs22.getString(2)) ;
                System.out.println("Gioi tinh: "+rs22.getString(3)) ;
                System.out.println("So ho chieu: "+rs22.getString(4)) ;
                System.out.println("So dien thoai: "+rs22.getString(5)) ;
                System.out.println("Dia chi: "+rs22.getString(6)) ;
                System.out.println("Quoc tich: "+rs22.getString(7)) ;
                System.out.println("\n") ;
            }
            
            //theo địa chỉ
        Scanner n14=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can cap nhat dia chi");
        int HK_id14=n14.nextInt();
        n14.nextLine();
        System.out.println("Nhap vao dia chi hanh khach can cap nhat");
        String HK_diachi14=n14.nextLine(); 
            CallableStatement cStmt14 = conn.prepareCall("{call ud_diachi(?,?)}");
            cStmt14.setInt(1,HK_id14); //100
            cStmt14.setString(2, HK_diachi14);//"Cần Thơ"
            cStmt14.execute();
            ResultSet rs14 = cStmt14.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi cap nhat dia chi:");
            while (rs14.next()) {
                System.out.println("ID: "+rs14.getInt(1)) ;
                System.out.println("Ho ten: "+rs14.getString(2)) ;
                System.out.println("Gioi tinh: "+rs14.getString(3)) ;
                System.out.println("So ho chieu: "+rs14.getString(4)) ;
                System.out.println("So dien thoai: "+rs14.getString(5)) ;
                System.out.println("Dia chi: "+rs14.getString(6)) ;
                System.out.println("Quoc tich: "+rs14.getString(7)) ;
                System.out.println("\n") ;
            }
          //theo số hộ chiếu
        Scanner n15=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can cap nhat so ho chieu ");
        int HK_id15=n15.nextInt();
        n15.nextLine();
        System.out.println("Nhap vao so ho chieu hanh khach can cap nhat");
        String HK_sohochieu15=n15.nextLine();  
            CallableStatement cStmt15 = conn.prepareCall("{call ud_sohochieu(?,?)}");
            cStmt15.setInt(1, HK_id15);//100
            cStmt15.setString(2, HK_sohochieu15);//"111111"
            cStmt15.execute();
            ResultSet rs15 = cStmt15.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi cap nhat:");
            while (rs15.next()) {
                System.out.println("ID: "+rs15.getInt(1)) ;
                System.out.println("Ho ten: "+rs15.getString(2)) ;
                System.out.println("Gioi tinh: "+rs15.getString(3)) ;
                System.out.println("So ho chieu: "+rs15.getString(4)) ;
                System.out.println("So dien thoai: "+rs15.getString(5)) ;
                System.out.println("Dia chi: "+rs15.getString(6)) ;
                System.out.println("Quoc tich: "+rs15.getString(7)) ;
                System.out.println("\n") ;
            }
            //theo quốc tịch
        Scanner n16=new Scanner(System.in);
        System.out.println("Nhap vao id hanh khach can cap nhat quoc tich ");
        int HK_id16=n16.nextInt();
        n16.nextLine();
        System.out.println("Nhap vao quoc tich hanh khach can cap nhat");
        String HK_quoctich16=n16.nextLine();  
            CallableStatement cStmt16 = conn.prepareCall("{call ud_quoctich(?,?)}");
            cStmt16.setInt(1, HK_id16);//100
            cStmt16.setString(2, HK_quoctich16);//"Việt Nam"
            cStmt16.execute();
            ResultSet rs16 = cStmt16.executeQuery("SELECT * FROM ql_hanhkhach");
            System.out.println("Danh sach hanh khach sau khi cap nhat quoc tich:");
            while (rs16.next()) {
                System.out.println("ID: "+rs16.getInt(1)) ;
                System.out.println("Ho ten: "+rs16.getString(2)) ;
                System.out.println("Gioi tinh: "+rs16.getString(3)) ;
                System.out.println("So ho chieu: "+rs16.getString(4)) ;
                System.out.println("So dien thoai: "+rs16.getString(5)) ;
                System.out.println("Dia chi: "+rs16.getString(6)) ;
                System.out.println("Quoc tich: "+rs16.getString(7)) ;
                System.out.println("\n") ;
            }
            
               //8. Tìm kiếm hành khách
            Scanner n17=new Scanner(System.in);
            System.out.println("Nhap vao id hanh khach can tim");
            int HK_id17=n17.nextInt();
            CallableStatement cStmt17 = conn.prepareCall("{call tim_HK(?)}");
            cStmt17.setInt(1, HK_id17);//100
            cStmt17.executeQuery();
            ResultSet rs17 = cStmt17.getResultSet();
            System.out.println("Hanh khach can tim:");
            while (rs17.next()) {
                System.out.println("ID: "+rs17.getInt(1)) ;
                System.out.println("Ho ten: "+rs17.getString(2)) ;
                System.out.println("Gioi tinh: "+rs17.getString(3)) ;
                System.out.println("So ho chieu: "+rs17.getString(4)) ;
                System.out.println("So dien thoai: "+rs17.getString(5)) ;
                System.out.println("Dia chi: "+rs17.getString(6)) ;
                System.out.println("Quoc tich: "+rs17.getString(7)) ;
                System.out.println("\n") ;
            }
            //9. Đặt vé
            Scanner n18=new Scanner(System.in);
            System.out.println("Nhap vao id ve can dat");
            int DV_id18=n18.nextInt();
            System.out.println("Nhap vao id hanh khach can dat");
            int HK_id18=n18.nextInt();
            System.out.println("Nhap vao ho ten hanh khach can dat");
            String HK_ten18=n18.nextLine();
            System.out.println("Nhap vao id chuyen bay can dat");
            String CB_id18=n18.nextLine();
            System.out.println("Nhap vao gioi tinh hanh khach can dat");
            String HK_gioitinh18=n18.nextLine();
            System.out.println("Nhap vao so ho chieu hanh khach can dat");
            String HK_sohochieu18=n18.nextLine();
            System.out.println("Nhap vao quoc tich hanh khach can dat");
            String HK_quoctich18=n18.nextLine();
            System.out.println("Nhap vao so luong ve can dat");
            int DV_soluong18=n18.nextInt();
            System.out.println("Nhap vao ngay dat");
            String DV_ngaydat18=n18.nextLine();
            System.out.println("Nhap vao loai ve");
            String LV_loai18=n18.nextLine();
            
            CallableStatement cStmt18 = conn.prepareCall("{call datve(?,?,?,?,?,?,?,?,?)}");
            cStmt18.setInt(1,DV_id18); //666
            cStmt18.setInt(2,HK_id18 );//600
            cStmt18.setString(3,HK_ten18);//"Chey"
            cStmt18.setString(4,CB_id18);//"CB006"
//            cStmt18.setString(5,HK_gioitinh18);//"Nam"
            cStmt18.setString(5, HK_sohochieu18);//"666666"
            cStmt18.setString(6, HK_quoctich18);//"Campuchia"
            cStmt18.setInt(7, DV_soluong18);//2
            cStmt18.setString(8, DV_ngaydat18);//"2022-04-28"
            cStmt18.setString(9, LV_loai18);//"NN_vip"
            cStmt18.execute();
            ResultSet rs18 = cStmt18.executeQuery("SELECT * FROM ql_datve");
            System.out.println("Danh sach dat ve:");
            while (rs18.next()) {
                System.out.println("ID ve: "+rs18.getInt(1)) ;
                System.out.println("ID hanh khach: "+rs18.getInt(2)) ;
                System.out.println("Ho ten: "+rs18.getString(3)) ;
                System.out.println("ID chuyen bay: "+rs18.getString(4)) ;
               // System.out.println("Gioi tinh: "+rs18.getString(5)) ;
                System.out.println("So ho chieu: "+rs18.getString(6)) ;
                System.out.println("Quoc tich: "+rs18.getString(7)) ;
                System.out.println("So luong ve: "+rs18.getInt(8)) ;
                System.out.println("Ngay dat ve: "+rs18.getString(9)) ;
                System.out.println("Loai ve: "+rs18.getString(10)) ;
                System.out.println("\n") ;
            }
            //10. Huỷ vé
            Scanner n19=new Scanner(System.in);
            System.out.println("Nhap vao id ve can huy");
            int DV_id19=n19.nextInt();
             CallableStatement cStmt19 = conn.prepareCall("{call huyve(?)}");
            cStmt19.setInt(1, DV_id19);//666
            cStmt19.execute();
            ResultSet rs19 = cStmt19.executeQuery("SELECT * FROM ql_datve");
            System.out.println("Danh sach con lai:");
            while (rs19.next()) {
                System.out.println("ID ve: "+rs19.getInt(1)) ;
                System.out.println("ID hanh khach: "+rs19.getInt(2)) ;
                System.out.println("Ho ten: "+rs19.getString(3)) ;
                System.out.println("ID chuyen bay: "+rs19.getString(4)) ;
                System.out.println("Gioi tinh: "+rs19.getString(5)) ;
                System.out.println("So ho chieu: "+rs19.getString(6)) ;
                System.out.println("Quoc tich: "+rs19.getString(7)) ;
                System.out.println("So luong ve: "+rs19.getInt(8)) ;
                System.out.println("Ngay dat ve: "+rs19.getString(9)) ;
                System.out.println("Loai ve: "+rs19.getString(10)) ;
                System.out.println("\n") ;
            }
            
            //11.Lọc hành khách theo giới tính
            Scanner n20=new Scanner(System.in);
            System.out.println("Nhap vao gioi tinh can loc");
            String HK_gioitinh20=n20.nextLine();
            CallableStatement cStmt20 = conn.prepareCall("{call tim_theogt(?)}");
            cStmt20.setString(1, HK_gioitinh20);//"Nữ"
            cStmt20.executeQuery();
            ResultSet rs20 = cStmt20.getResultSet();
            System.out.println("Danh sach loc theo gioi tinh:");
            while (rs20.next()) {
                 System.out.println("ID: "+rs20.getInt(1)) ;
                System.out.println("Ho ten: "+rs20.getString(2)) ;
                System.out.println("Gioi tinh: "+rs20.getString(3)) ;
                System.out.println("So ho chieu: "+rs20.getString(4)) ;
                System.out.println("So dien thoai: "+rs20.getString(5)) ;
                System.out.println("Dia chi: "+rs20.getString(6)) ;
                System.out.println("Quoc tich: "+rs20.getString(7)) ;
                System.out.println("\n") ;
            }

            //11.2 Lọc hành khách theo loại vé
            Scanner n21=new Scanner(System.in);
            System.out.println("Nhap vao loai ve can loc ");
            String DV_loai21=n21.nextLine();
            CallableStatement cStmt21 = conn.prepareCall("{call tim_hkloaive(?)}");
            cStmt21.setString(1, DV_loai21);//"TN_t"
            cStmt21.executeQuery();
            ResultSet rs21 = cStmt21.getResultSet();
            System.out.println("Danh sach loc theo loai ve:");
            while (rs21.next()) {
                System.out.println("ID ve: "+rs21.getInt(1)) ;
                System.out.println("ID hanh khach: "+rs21.getInt(2)) ;
                System.out.println("Ho ten: "+rs21.getString(3)) ;
                System.out.println("ID chuyen bay: "+rs21.getString(4)) ;
                System.out.println("Gioi tinh: "+rs21.getString(5)) ;
                System.out.println("So ho chieu: "+rs21.getString(6)) ;
                System.out.println("Quoc tich: "+rs21.getString(7)) ;
                System.out.println("So luong ve: "+rs21.getInt(8)) ;
                System.out.println("Ngay dat ve: "+rs21.getString(9)) ;
                System.out.println("Loai ve: "+rs21.getString(10)) ;
                System.out.println("\n") ;
            }
           
            //12. Lọc chuyến bay theo ngày
                 Scanner n30=new Scanner(System.in);
            System.out.println("Nhap vao ngay can loc ");
            String CB_ngaybay30=n30.nextLine();
            CallableStatement cStmt30 = conn.prepareCall("{call tim_cbtheongay(?)}");
            cStmt30.setString(1, CB_ngaybay30);//"2022-05-03"
            cStmt30.executeQuery();
            ResultSet rs30 = cStmt30.getResultSet();
            System.out.println("Chuyen bay trong ngay:");
            while (rs30.next()) {
                System.out.println("ID: "+rs30.getString(1)) ;
                System.out.println("Noi di: "+rs30.getString(2)) ;
                System.out.println("Noi den: "+rs30.getString(3)) ;
                System.out.println("Ngay bay: "+rs30.getString(4)) ;
                System.out.println("So ghe ngoi: "+rs30.getInt(5)) ;
                System.out.println("\n") ; 
            }
            
//            13.Tính giá tiền mỗi hành khách phải trả
            //1 hành khách
            Scanner n23=new Scanner(System.in);
            System.out.println("Nhap hanh khach can tinh tien ");
            int DV_id23=n23.nextInt();
            CallableStatement cStmt23 = conn.prepareCall("{?=call tinh_tien(?)}");
            cStmt23.registerOutParameter(1,Types.DOUBLE);
            cStmt23.setInt(2,DV_id23);//111
            cStmt23.executeQuery();
            ResultSet rs23 = cStmt23.getResultSet();
            System.out.println("Tien hanh khach can tra:");
            while (rs23.next()) {
                System.out.println("ID dat ve: "+DV_id23) ;
                System.out.println("Gia ve: "+rs23.getDouble(1)) ;
                System.out.println("");
            }

         
            CallableStatement cStmt24 = conn.prepareCall("{?=call tinh_tien(DV_id)}");
            cStmt24.registerOutParameter(1,Types.DOUBLE);     
            cStmt24.executeQuery(" select DV_id,HK_id,HK_ten,CB_id, DV_soluong,ql_datve.LV_loai, DV_soluong*(LV_gia+LV_phipv+LV_phuthu+((LV_gia+LV_phipv+LV_phuthu)*0.1)) from ql_datve inner join ql_loaive on ql_datve.LV_loai=ql_loaive.LV_loai ");
            ResultSet rs24 = cStmt24.getResultSet();
            System.out.println("Danh gia tien hanh khach can tra:");
            while (rs24.next()) {
                System.out.println("ID dat ve: "+rs24.getInt(1)) ;
                System.out.println("ID hanh khach: "+rs24.getInt(2)) ;
                System.out.println("Ho ten: "+rs24.getString(3)) ;
                System.out.println("ID chuyen bay: "+rs24.getString(4)) ;
                System.out.println("So luong ve: "+rs24.getInt(5)) ;
                System.out.println("Loai ve: "+rs24.getString(6)) ;
                System.out.println("Gia ve: "+rs24.getDouble(7)) ;
                System.out.println("");
            }          
            
            //14. Quản lý hành khách chưa đặt lại vé
            CallableStatement cStmt25 = conn.prepareCall("{call ds_chuacove()}");
            cStmt25.executeQuery();
            ResultSet rs25 = cStmt25.getResultSet();
            System.out.println("Danh gia hanh khach chua co ve:");
            while (rs25.next()) {
                System.out.println("ID: "+rs25.getInt(1)) ;
                System.out.println("Ho ten: "+rs25.getString(2)) ;
                System.out.println("Gioi tinh: "+rs25.getString(3)) ;
                System.out.println("So ho chieu: "+rs25.getString(4)) ;
                System.out.println("So dien thoai: "+rs25.getString(5)) ;
                System.out.println("Dia chi: "+rs25.getString(6)) ;
                System.out.println("Quoc tich: "+rs25.getString(7)) ;
                System.out.println("\n") ;
            }      
            
            //15.Doanh thu tiền đặt vé trong ngày
            //1 ngày
            Scanner n26=new Scanner(System.in);
            System.out.println("Nhap vao ngay can loc ");
            String DV_ngaydat26=n26.nextLine();
            CallableStatement cStmt26 = conn.prepareCall("{?= call doanhthu_ngay(?)}");
            cStmt26.registerOutParameter(1,Types.DOUBLE); 
            cStmt26.setString(2, DV_ngaydat26);//"2022-04-28"
            cStmt26.executeQuery();
            ResultSet rs26 = cStmt26.getResultSet();
            System.out.println("Chuyen bay trong ngay:");
            while (rs26.next()) {
                System.out.println("Ngay bay: "+rs26.getString(1)) ;
                System.out.println("Gia ve: "+rs26.getDouble(1));
                System.out.println("\n") ; 
            }
            //tất cả các ngày
            CallableStatement cStmt27 = conn.prepareCall("{?= call doanhthu_ngay(DV_ngaydat)}");
            cStmt27.registerOutParameter(1,Types.DOUBLE); 
            cStmt27.executeQuery("select distinct DV_ngaydat,doanhthu_ngay(DV_ngaydat) from ql_datve");
            ResultSet rs27 = cStmt27.getResultSet();
            System.out.println("Doanh thu trong ngay:");
            while (rs27.next()) {
                System.out.println("Ngay bay: "+rs27.getString(1)) ;
                System.out.println("Gia ve: "+rs27.getDouble(2));
                System.out.println("\n") ; 
            }
            //Ngay co doanh thu cao nhat
            CallableStatement cStmt28 = conn.prepareCall("{?= call doanhthu_ngay(DV_ngaydat)}");
            cStmt28.registerOutParameter(1,Types.DOUBLE); 
            cStmt28.executeQuery("select distinct DV_ngaydat,max(doanhthu_ngay(DV_ngaydat)) from ql_datve");
            ResultSet rs28 = cStmt28.getResultSet();
            System.out.println("Ngay co doanh thu cao nhat:");
            while (rs28.next()) {
                System.out.println("Ngay bay: "+rs28.getString(1)) ;
                System.out.println("Gia ve: "+rs28.getDouble(2));
                System.out.println("\n") ; 
            }
            //16.Doanh thu tiền trong tháng
            CallableStatement cStmt29 = conn.prepareCall("{?= call doanhthu_ngay(DV_ngaydat)}");
            cStmt29.registerOutParameter(1,Types.DOUBLE); 
            cStmt29.executeQuery("select distinct month(DV_ngaydat),sum(doanhthu_ngay(DV_ngaydat)) from ql_datve");
            ResultSet rs29 = cStmt29.getResultSet();
            System.out.println("Doanh thu trong ngay:");
            
            while (rs29.next()) {
                System.out.println("Ngay bay: "+rs29.getString(1)) ;
                System.out.println("Gia ve: "+rs29.getDouble(2));
                System.out.println("\n") ; 
            }
         
    
            
        }
        catch (SQLException e) { //xử lý ngoại lệ nếu có
            System.out.println("Error: "+ e.getMessage());
        }
        
   
    }
}
   

