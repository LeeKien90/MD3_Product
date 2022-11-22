package ra.model.daoImp;

import ra.model.dao.IProductDao;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements IProductDao<Product, String> {

    @Override
    public List<Product> seachProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAll() {

        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try {
 //        Thực hiện kết nối đến CSDL
            conn = ConnectionDB.openConnection();
//            Khởi tạo đối tươợng CallableStatement để gọi procedure
            callSt = conn.prepareCall("{call getAllProduct()}");
//            Thực hiện callSt và nhận ResultSet
// --proc la cau select thi thuc hien phuong thuc executeQuery()
// --proc la cau lenh thuc hien insert, update, delete ma chi co tham so vao - executeUpdate()
// --proc la cau lenh thuc hien insert, update, delete ma co tham so ra - execute()
            ResultSet rs = callSt.executeQuery();
            productList = new ArrayList<>();
//            Duyệt resultset đẩy dữ liệu sang productList
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getInt("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setCreated(rs.getDate("created"));
                pro.setDescriptions(rs.getString("descriptions"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
//                add vào listProduct
                productList.add(pro);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
       conn = ConnectionDB.openConnection();
       callSt = conn.prepareCall("{call insertProduct(?,?,?,?,?,?)}");
//       Thực hiện set giá trị cho các tham số vào
            callSt.setInt(1,product.getProductId());
            callSt.setString(2,product.getProductName());
            callSt.setFloat(3,product.getPrice());
//            Convert java.util.Date sang java.sql.Date. Gọi new Date từ sql
            callSt.setDate(4,new Date(product.getCreated().getTime()));
            callSt.setString(5,product.getDescriptions());
            callSt.setBoolean(6,product.isProductStatus());
//           Thực hiện gọi procedure
            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateProduct(?,?,?,?,?,?)}");
//       Thực hiện set giá trị cho các tham số vào
            callSt.setInt(1,product.getProductId());
            callSt.setString(2,product.getProductName());
            callSt.setFloat(3,product.getPrice());
//            Convert java.util.Date sang java.sql.Date. Gọi new Date từ sql
            callSt.setDate(4,new Date(product.getCreated().getTime()));
            callSt.setString(5,product.getDescriptions());
            callSt.setBoolean(6,product.isProductStatus());
//           Thực hiện gọi procedure
            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteProduct(?)}");
//       Thực hiện set giá trị cho các tham số vào
            callSt.setInt(1,Integer.parseInt(id));
//           Thực hiện gọi procedure
            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public Product getById(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product productInfo = null;
        try {
            //        Thực hiện kết nối đến CSDL
            conn = ConnectionDB.openConnection();
//            Khởi tạo đối tươợng CallableStatement để gọi procedure
            callSt = conn.prepareCall("{call getProductById(?)}");
//            Set giá trị cho tham số vào
            callSt.setInt(1, Integer.parseInt(id));
//            Thực hiện callSt và nhận ResultSet
             ResultSet rs = callSt.executeQuery();
            productInfo = new Product();
//            Duyệt resultset đẩy dữ liệu sang productInfo
            if (rs.next()){
                productInfo.setProductId(rs.getInt("productId"));
                productInfo.setProductName(rs.getString("productName"));
                productInfo.setPrice(rs.getFloat("price"));
                productInfo.setCreated(rs.getDate("created"));
                productInfo.setDescriptions(rs.getString("descriptions"));
                productInfo.setProductStatus(rs.getBoolean("productStatus"));
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productInfo;
    }
}
