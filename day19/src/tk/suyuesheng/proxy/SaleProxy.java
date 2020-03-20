package tk.suyuesheng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介类，或称作调用处理器，或乘坐调用帮手
 */
public class SaleProxy implements InvocationHandler {
    ISale ss;//真实对象
    public SaleProxy(){

    }
    public SaleProxy(ISale ss){
        //调用处理器要指定真实对象
        this.ss=ss;
    }

    /*
        代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
            参数：
                1. proxy:代理对象
                2. method：代理对象调用的方法，被封装为的对象
                3. args:代理对象调用的方法时，传递的实际参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("count")) {
            //增强参数
            double money = (double) args[0];
            System.out.println("八五折");
            money*=0.85;
            System.out.println(method.getName());
            Object invoke = method.invoke(ss, args);
            return invoke;
        } else {
            System.out.println(method.getName());
            System.out.println("before");
            Object invoke = method.invoke(ss, args);
            System.out.println("after");
            return invoke;
        }
    }
}
