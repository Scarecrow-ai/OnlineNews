package com.news.action;

import com.news.dao.UserDao;
import com.news.dao.impl.UserDaoImpl;
import com.news.entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDao dao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");


        //创建实体用户对象
        User user1 = new User();

        //构造实体用户对象，完成头像文件上传
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            List<FileItem> list = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    String name2 = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");

                    switch (name2) {
                        case "userid":
                            user1.setUserName(value);
                            break;
                        case "usrtel":
                            user1.setUserPhone(value);
                            break;
                        case "email":
                            user1.setUserEmail(value);
                            break;
                        case "psw":
                            user1.setUserPwd(value);
                            break;
                    }
                } else//是文件形式
                {
                    String fileName = fileItem.getName();
                    long size = fileItem.getSize();

                    InputStream inputStream = fileItem.getInputStream();
                    String path = req.getServletContext().getRealPath("file/" + fileName);
                    //设置用户头像文件的绝对路径
                    user1.setUserImg(path);
                    OutputStream outputStream = new FileOutputStream(path);
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        outputStream.write(temp);
                    }

                    outputStream.close();
                    inputStream.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //查询用户是否已存在
        User user2 = dao.selectName(user1);
        if (user2 != null) {
            resp.sendRedirect("RegisterError.jsp");
        } else {
            //添加该用户到数据库
            int i = dao.insert(user1);
            if (i > 0) {
                resp.sendRedirect("RegisterSuccess.jsp");
            } else {
                resp.sendRedirect("RegisterError.jsp");
            }
        }
    }
}

