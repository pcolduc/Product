package controller;

import dao.ProductDao;
import vo.ProductVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDao dao = new ProductDao();
        while(true){

            System.out.println("-------------------- 재고관리 프로그램 --------------------");
            System.out.println("1.제품등록|2.제품조회|3.제품검색|4.제품삭제|5.제품수정|6.종료");
            System.out.println("1. 제품등록");
            System.out.println("2. 제품조회");
            System.out.println("3. 제품검색");
            System.out.println("4. 제품삭제");
            System.out.println("5. 제품수정");
            System.out.println("6. 프로그램 종료");
            System.out.println("-------------------------------------------------------");
            System.out.println("메뉴를 선택해 주세요 >> ");

            int choice = sc.nextInt();

            if (choice == 1){
                System.out.println("제품코드 등록 : ");
                int code = sc.nextInt();

                System.out.println("제품이름 등록 : ");
                String name = sc.next();

                System.out.println("제품가격 등록 : ");
                int price = sc.nextInt();

                System.out.println("제품수량 등록 : ");
                int count = sc.nextInt();

                System.out.println("제품제조사 등록 : ");
                String factory = sc.next();

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date now = new Date();
                String time = format.format(now);

                ProductVo vo = new ProductVo(code,name,price,count,factory,time);
                if (dao.insert(vo) > 0){
                    System.out.println("성공");
                }else {
                    System.out.println("실패");
                }


            } else if (choice == 2) {
                List<ProductVo> list = dao.select();
                for (ProductVo vo : list) {
                    System.out.println("--------------------------------");
                    System.out.println("제품코드 : " + vo.getProduct_code());
                    System.out.println("제품이름 : " + vo.getProduct_name());
                    System.out.println("제품가격 : " + vo.getProduct_price());
                    System.out.println("제품수량 : " + vo.getProduct_count());
                    System.out.println("제조사  : "  + vo.getProduct_factory());
                    System.out.println("입고날자 : " + vo.getProduct_date());
                }
            } else if (choice == 3) {
                System.out.println("검색할 상품을 입력해주세요 : ");
                String str = sc.next();
                List<ProductVo> search_list = new ArrayList<>();

                for (ProductVo vo : search_list) {
                    System.out.println("--------------------------------");
                    System.out.println("제품코드 : " + vo.getProduct_code());
                    System.out.println("제품이름 : " + vo.getProduct_name());
                    System.out.println("제품가격 : " + vo.getProduct_price());
                    System.out.println("제품수량 : " + vo.getProduct_count());
                    System.out.println("제조사  : "  + vo.getProduct_factory());
                    System.out.println("입고날자 : " + vo.getProduct_date());
                }

            } else if (choice == 4) {
                System.out.println("삭제할 제품코드를 입력해주세여 :");
                int code = sc.nextInt();
                dao.delete(code);

            } else if (choice == 5) {


                System.out.println("수정할 제품 코드를 입력해 주세요.");
                int update_code = sc.nextInt();

                System.out.println("제품 가격을 입력해 주세요.");
                int update_price = sc.nextInt();

                System.out.println("제품 수량을 입력해 주세요.");
                int update_count = sc.nextInt();

                ProductVo updateVo = new ProductVo(update_code,update_price,update_count);
                dao.update(updateVo);

            } else if (choice == 6) {
                System.out.println("프로그램 종료.");
                System.exit(0);
            }
        }
    }
}
