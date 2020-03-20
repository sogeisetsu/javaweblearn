package tk.suyuesheng.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println(ISale.class.getInterfaces());
        System.out.println(ISale.class);
        SaleProxy saleProxy = new SaleProxy(new Saleimpl());
        ISale o = (ISale)Proxy.newProxyInstance(ISale.class.getClassLoader(), new Class[]{ISale.class}, saleProxy);
        o.get("家电");
        double count = o.count(12.5);
        System.out.println(count);
    }
    @Test
    public void TestSProxy(){
        Object proxy = new SProxy(new Saleimpl()).getProxy();
        ISale sale = (ISale) proxy;
        sale.get("洗衣机");
    }

}
