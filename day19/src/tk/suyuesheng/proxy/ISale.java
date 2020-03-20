package tk.suyuesheng.proxy;

/**
 * 一个sale接口
 * @author 苏月晟
 */
public interface ISale {
    //定义两个方法，一个有返回值，一个没有返回值

    /**
     * 进货
     * @param goodsName 商品名称
     */
    void get(String goodsName);//进货

    /**
     * 数钱 注：成本一律6块2
     * @param money 收的钱
     * @return
     */
    double count(double money);//数钱
}
