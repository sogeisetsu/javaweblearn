package cn.suyuesheng.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/CheckOutDemo")
public class ServletCheckOutDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建图片
        BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_BGR);
        //图片背景
        //获取画笔
        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        //显示图片
        ImageIO.write(img, "jpg", response.getOutputStream());
    }
}
