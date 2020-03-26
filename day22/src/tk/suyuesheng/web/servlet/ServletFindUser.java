package tk.suyuesheng.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ServletFindUser")
public class ServletFindUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        Map<String,Object> mm = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        if(username!=null && username!=""){
            if(username.equals("suyuesheng")){
                mm.put("username_exist", "true");
                mapper.writeValue(response.getWriter(), mm);
            }else {
                mm.put("username_exist", "false");
                mapper.writeValue(response.getWriter(), mm);
            }
        }else{
            mm.put("username_exist","no");
            mapper.writeValue(response.getWriter(), mm);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
