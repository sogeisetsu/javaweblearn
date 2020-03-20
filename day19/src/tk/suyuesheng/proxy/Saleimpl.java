package tk.suyuesheng.proxy;
//代理设计模式的真实对象
public class Saleimpl implements ISale {
    @Override
    public void get(String goodsName) {
        System.out.println("商品名称是："+goodsName);
    }

    @Override
    public double count(double money) {
        System.out.println("开始数钱");
        double count = money - 6.2;
        return count;//返回真正的利润
    }
}
