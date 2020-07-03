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

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    UserDao dao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求的编码为utf-8
        req.setCharacterEncoding("utf-8");

        //获取用户操作
        String caozuo = req.getParameter("caozuo");

        //判断用户想要进行的行为
        if (caozuo.equals("queryAll")) {
            System.out.println("用户的操作为" + caozuo);
            queryAll(req, resp);
        } else if (caozuo.equals("add")) {
            addUser(req, resp);
        } else if (caozuo.equals("del")) {
            delUser(req, resp);
        } else if (caozuo.equals("findUpdUserid")) {
            findUpdUserid(req, resp);
        } else if (caozuo.equals("upd")) {
            updUser(req, resp);
        }
    }


    private void queryAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //调用查询所有学生的服务
        List<User> userList = dao.selectAll();


        //将查询到的学生添加到web容器中
        req.getSession().setAttribute("userList", userList);

        //跳转到指定的页面
        resp.sendRedirect("content/content1.jsp");
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            resp.sendRedirect("addUserError.jsp");
        } else {
            //添加该用户到数据库
            int i = dao.insert(user1);
            if (i > 0) {
                queryAll(req, resp);
            } else {
                resp.sendRedirect("addUserError.jsp");
            }
        }
    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取要删除的用户id
        String strid = req.getParameter("userID");
        Integer id = Integer.parseInt(strid);
        //把id封存到实体中
        User user = new User();
        user.setUserId(id);
        dao.delete(user);
        //调用查询的函数，更新容器中的值
        queryAll(req, resp);
    }

    private void findUpdUserid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String strid = req.getParameter("userID");
        Integer id = Integer.parseInt(strid);
        User user = new User();
        user.setUserId(id);
        //调用查询单个用户的服务
        User user2 = dao.selectID(user);
        //将用户对象存入到web容器
        req.getSession().setAttribute("selectuser", user2);
        resp.sendRedirect("updUser.jsp");
    }

    private void updUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        User user = new User();

        String strid = req.getParameter("userID");
        Integer id = Integer.parseInt(strid);


        String name = req.getParameter("userName");
        String password = req.getParameter("userPWD");
        String userimg = req.getParameter("userImg");
        String phone = req.getParameter("userPhone");
        String email = req.getParameter("userEmail");

        user.setUserId(id);
        user.setUserName(name);
        user.setUserPwd(password);
        user.setUserPhone(phone);
        user.setUserEmail(email);
        user.setUserImg(userimg);

        dao.update(user);

        queryAll(req, resp);
    }

}
