package tk.suyuesheng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SProxy {
    private Object obj;//真实对象
    public SProxy(Object obj){
       this.obj=obj;
    }
    public Object getProxy(){
        /*
        * ​ClassLoader loader：指定当前目标对象使用类加载器，获取加载器的方法是固定的。

          Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方式确认类型。

          InvocationHandler h：事件处理。执行目标对象的方法时，会触发事件处理器的方法，会把当前执行目标对象的方法作为参数传入。
        */
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(">----------------------------");
                        System.out.println(args);
                        System.out.println(proxy.getClass().getName());
                        System.out.println("开始");
                        Object invoke = method.invoke(obj, args);
                        System.out.println(invoke);
                        System.out.println(method);
                        System.out.println("结束");
                        return invoke;
                    }
                });
    }
}
