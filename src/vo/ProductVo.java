package vo;

public class ProductVo {
    private int product_code;
    private String product_name;
    private int product_peice;
    private int product_count;
    private String product_factory;
    private String product_date;

    public ProductVo(){

    }

    public ProductVo(int product_code, String product_name, int product_price,
                     int product_count, String product_factory, String product_date) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_peice = product_price;
        this.product_count = product_count;
        this.product_factory = product_factory;
        this.product_date = product_date;
    }
    public ProductVo(int product_peice, int product_count, int product_code){
        this.product_peice = product_peice;
        this.product_count = product_count;
        this.product_code = product_code;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_peice;
    }

    public void setProduct_price(int product_price) {
        this.product_peice = product_price;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public String getProduct_factory() {
        return product_factory;
    }

    public void setProduct_factory(String product_factory) {
        this.product_factory = product_factory;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }
}
