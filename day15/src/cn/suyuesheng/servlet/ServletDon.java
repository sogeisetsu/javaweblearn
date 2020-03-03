package cn.suyuesheng.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/ServletDon")
public class ServletDon extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取文件在服务器中的位置
        ServletContext servletContext = this.getServletContext();
        String filename = request.getParameter("filename");
        String realPath = servletContext.getRealPath("/img/" + filename);
        System.out.println(realPath);
        //获取文件输入流
        FileInputStream inputStream = new FileInputStream(realPath);
        //获取response输出流
        ServletOutputStream outputStream = response.getOutputStream();
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);//响应的数据类型
        response.setHeader("content-disposition","attachment;filename="+filename);//以什么方式下载，如attachment为以附件方式下载
        byte[] b = new byte[1024];
        int index =0;
        while((index=inputStream.read(b))!=-1){
            outputStream.write(b, 0, index);
        }
        outputStream.close();
        inputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
