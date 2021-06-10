package com.cykj.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet()
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1获取方法名
        String methodName = req.getParameter("methodName");
//        System.out.println(methodName);
//        System.out.println(this);
        // 获取指定类的字节码对象
        Class clazz = this.getClass();//这里的this指的是继承BaseServlet对象
        try {
            //判断 参数是否为空  若为空,执行默认的方法
            if (methodName != null && !"".equals(methodName.trim())) {
                //2通过类的字节码对象获取方法的字节码对象(获取方法对象)
                Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                //3让方法执行,接受返回值
                String url = (String) method.invoke(this, req, resp);//返回一条路径，根据路径去做跳转
                //4判断返回值是否为空 若不为空统一处理请求转发
                if (url != null) {
                    req.getRequestDispatcher(url).forward(req, resp);
                }

            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


}
