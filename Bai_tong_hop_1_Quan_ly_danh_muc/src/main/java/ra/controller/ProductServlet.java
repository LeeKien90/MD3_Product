package ra.controller;

import ra.model.entity.Product;
import ra.model.service.ProductService;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    private ProductService<Product, String> productService = new ProductServiceImp();

    public void getAllProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //        Gọi getAll của ProductService
        List<Product> productList = productService.getAll();
//        Add vào request
        request.setAttribute("listProduct",productList);
//        Chuyển dữ liệu sang trang ProductView.jsp
        request.getRequestDispatcher("views/ProductView.jsp").forward(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null && action.equals("update")){
//            Thực hiện lấy thông tin sản phẩm theo productId
            String productId = request.getParameter("productId");
            Product productUpdate = productService.getById(productId);
//            chuyển dữ liệu sang trang update.jsp
            request.setAttribute("productUpdate",productUpdate);
            request.getRequestDispatcher("views/update.jsp").forward(request,response);
        }else if (action!=null&& action.equals("delete")){
//Thực hiện xóa sản phẩm
            String productId = request.getParameter("productId");
            boolean result = productService.delete(productId);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        }
        else {
            getAllProduct(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
//            Lấy thông tin từ request
        Product pro = new Product();
        pro.setProductId(Integer.parseInt(request.getParameter("productId")));
        pro.setProductName(request.getParameter("productName"));
        pro.setPrice(Float.parseFloat(request.getParameter("price")));
//            Convert String sang java.unil.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            pro.setCreated(sdf.parse(request.getParameter("created")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        pro.setDescriptions(request.getParameter("descriptions"));
        pro.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
        if (action!=null && action.equals("Create")){
//            Thực hiện thêm mới 1 sản phẩm
            boolean result = productService.save(pro);
            if (result){
                getAllProduct(request,response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        }else if (action!=null&&action.equals("Update")){
//            Thực hiện update sản phẩm
            boolean result = productService.update(pro);
            if (result){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        }
    }
}
