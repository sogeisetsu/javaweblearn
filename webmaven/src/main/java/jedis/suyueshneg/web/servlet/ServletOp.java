package jedis.suyueshneg.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jedis.suyueshneg.domain.Province;
import jedis.suyueshneg.util.fectory.DomainFectory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletOp")
public class ServletOp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        List<Province> provinces =null;
//        try {
//            provinces = DomainFectory.getProvinceService().findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        String value = mapper.writeValueAsString(provinces);
//        System.out.println(value);
//        response.getWriter().write(value);
        String allJson = null;
        try {
            allJson = DomainFectory.getProvinceService().findAllJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(allJson);
        response.getWriter().write(allJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
