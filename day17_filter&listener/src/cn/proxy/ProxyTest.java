package cn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        //1.创建真实对象
        HpCompany hp = new HpCompany();

        //动态代理增强hp对象，
        /**
         *  三个参数：
         *      1.类加载器：真实对象.getClass().getClassLoader()
         *      2.接口数组：真实对象.getClass().getInterfaces()
         *      3.处理器：new InvocationHandle(){}
         */
        Object proxyInstance = Proxy.newProxyInstance(hp.getClass().getClassLoader(), hp.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法: 代理对象调用的所有方法都会触发该方法执行
             *  proxy：代理对象
             *  method:代理对象调用的方法，被封装为的对象
             *  args:代理对象调用方法时调用的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了！！！"+method.getName());//sale
//                System.out.println(args[0]);//8000

                //1.增强方法
                if (method.getName().equals("sale")) {
                    //拿到sale方法中的参数
                    double money = (double) args[0];
                    money = money * 0.85;

                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(hp, money); //hp电脑
                    //2.增强返回值
                    return obj+"鼠标垫";
                }else {
                    Object obj = method.invoke(hp, args);
                    return obj;
                }
            }
        });
        //强转为接口
        SaleComputer proxy_hp = (SaleComputer) proxyInstance;

//        //2.调用方法
        String computer = proxy_hp.sale(8000);
        System.out.println(computer);

//        proxy_hp.show();
    }
}
