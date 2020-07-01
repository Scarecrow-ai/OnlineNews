package com.news.utils;

import java.sql.*;

/**
 * 操作数据库的工具类
 */
public class DButils {
    //连接地址
    private String url = "jdbc:mysql://localhost:3306/news?useSSL=false&serverTimezone=UTC";
    //用户名
    private String user = "root";
    //用户密码
    private String password = "abc123";

    private Connection conn=null;
    private PreparedStatement stmt=null;
    private ResultSet rs=null;

    //1.加载驱动
    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2.获取链接数据库的会话对象
    private void getConnect()  {
        try {
            conn= DriverManager.getConnection(url,user,password);//这里不要写成Connection conn=.......这相当于新建了
            //一个conn而不是最开始定义的那个全局变量conn
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int doUpdate(String sqls,Object params[])  // 3.构造sql语句
    {
        int i=0;
        //调用连接对象的函数
        getConnect();
        try {
            //4.获取执行对象
            stmt=conn.prepareStatement(sqls);

            //判断是否给占位符赋值
            if(params!=null&&params.length!=0) {
                for(int j=0;j<params.length;j++){
                    stmt.setObject(j+1,params[j]);
                }
            }
            //5.执行sql语句，并处理执行状态结果
            i=stmt.executeUpdate();

            System.out.println("执行状态:"+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //查询操作的方法
    public ResultSet doQuery(String sqls,Object params[])
    {
        //调用连接对象的函数
        getConnect();
        try {
            //4.获取执行对象
            stmt=conn.prepareStatement(sqls);
            //判断是否给占位符赋值
            if(params!=null&&params.length!=0) {
                for(int j=0;j<params.length;j++){
                    stmt.setObject(j+1,params[j]);
                }
            }
            //5.执行sql语句，并处理执行状态结果
            rs =  stmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    // 6.释放资源
    public void getClose()  {
        try {
            if(stmt!=null)
            {
                stmt.close();
            }
            if(conn!=null)
            {
                conn.close();
            }
            if(rs!=null){rs.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
