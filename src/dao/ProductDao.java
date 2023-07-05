package dao;

import connect.DBConnection;
import vo.ProductVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends DBConnection {
    public int insert(ProductVo productVo){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        int res = 0;
        String sql = "INSERT INTO PRODUCT(PRODUCT_CODE,PRODUCT_NAME,PRODUCT_PEICE,PRODUCT_COUNT,PRODUCT_FACTORY,\n" +
                "PRODUCT_DATE)"+"VALUES(?,?,?,?,?,?)";
        try {
            stmt =conn.prepareStatement(sql);
            stmt.setInt(1,productVo.getProduct_code());
            stmt.setString(2,productVo.getProduct_name());
            stmt.setInt(3,productVo.getProduct_price());
            stmt.setInt(4,productVo.getProduct_count());
            stmt.setString(5,productVo.getProduct_factory());
            stmt.setString(6, productVo.getProduct_date());
            res = stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn);
            close(stmt);
        }
        return res;
    }


    //전체 조회
    public List<ProductVo> select(){
        Connection conn = getConnection();
        String sql = "SELECT * FROM PRODUCT";
        Statement stmt = null;
        ResultSet rs = null;

        List<ProductVo> list = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                ProductVo vo = new ProductVo();
                vo.setProduct_code(rs.getInt("PRODUT_CODE"));
                vo.setProduct_name(rs.getString("PRODUCT_NAME"));
                vo.setProduct_price(rs.getInt("PRODUCT_PEICE"));
                vo.setProduct_count(rs.getInt("PRODUCT_COUNT"));
                vo.setProduct_factory(rs.getString("PRODUCT_FACTORY"));
                vo.setProduct_date(rs.getString("PRODUCT_DATE"));
                list.add(vo);
            }
    }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn);
            close(rs);
            close(stmt);
        }
        return list;
        }
        public List<ProductVo> Search(String search){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE ?";
        List<ProductVo> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%" + search + "%");

            stmt = conn.createStatement();
            rs = pstmt.executeQuery();

            while(rs.next()){

                ProductVo vo = new ProductVo();
                vo.setProduct_code(rs.getInt("PRODUT_CODE"));
                vo.setProduct_name(rs.getString("PRODUCT_NAME"));
                vo.setProduct_price(rs.getInt("PRODUCT_PEICE"));
                vo.setProduct_count(rs.getInt("PRODUCT_COUNT"));
                vo.setProduct_factory(rs.getString("PRODUCT_FACTORY"));
                vo.setProduct_date(rs.getString("PRODUCT_DATE"));
                list.add(vo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn);
            close(pstmt);
            close(rs);
            close(stmt);
        }
        return list;
        }
        public int delete(int code){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM PRODUCT "+"WHERE PRODUCT_CODE = ?";
        int res = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,code);
            res = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn);
            close(pstmt);
        }
        return res;
        }
        public int update(ProductVo vo){
        Connection conn = getConnection();
        //해당하는 상춤코드의 가격가ㅘ 수량을 수정하는 쿼리문.
        String sql = "UPDATE PRODUCT" + " SET PRODUCT_PEICE = ?, PRODUCT_COUNT = ?" + " WHERE PRODUCT_CODE = ?";

        PreparedStatement pstmt = null;
        int res = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getProduct_price());
            pstmt.setInt(2,vo.getProduct_count());
            pstmt.setInt(3,vo.getProduct_code());
            res = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(pstmt);
            close(conn);
        }
        return res;
        }
}