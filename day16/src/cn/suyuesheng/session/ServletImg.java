package cn.suyuesheng.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/ServletImg")
public class ServletImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 200;
        int height = 100;
        //创建图片
        BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_BGR);
        //图片背景
        //获取画笔
        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, 200, 100);
        //篮筐
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, 199, 99);
        //写字
        g.setColor(Color.BLACK);
        String o = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String c = o.toLowerCase();
        o += c;
        Random ran = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int index = ran.nextInt(o.length());
            char ind = o.charAt(index);
            stringBuffer.append(ind);
            g.drawString(ind + "", ((width / 5) * i) + 20, height / 2);
        }
        //画线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 6; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        //显示图片
        ImageIO.write(img, "jpg", response.getOutputStream());
        System.out.println(stringBuffer);
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", stringBuffer.toString());
//        Object name = this.getServletContext().getAttribute("name");
//        System.out.println((String)name);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
