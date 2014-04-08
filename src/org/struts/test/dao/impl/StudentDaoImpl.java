package org.struts.test.dao.impl;

import org.struts.test.dao.StudentDao;
import org.struts.test.database.MyDataSource;
import org.struts.test.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-4-7
 * Time: 下午11:29
 * To change this template use File | Settings | File Templates.
 */
public class StudentDaoImpl implements StudentDao{
    private MyDataSource ds=new MyDataSource();
    public void close(Connection connection,PreparedStatement statement,ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try{
              statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
              connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public boolean checkLogin(String name, String password) {
        Connection connection=ds.getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from Student where name=? and password=?";
        boolean isExist=false;
        try{
        	statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            rs=statement.executeQuery();
            while(rs.next()){
                isExist=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,statement,rs);
        }
        return isExist;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Student> findAllStudent() {
        Connection connection=ds.getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from Student";
        List<Student> list=new ArrayList<Student>();
        try{
           statement=connection.prepareStatement(sql);
           rs=statement.executeQuery();
           while(rs.next()){
               Student student=new Student();
               student.setId(rs.getInt("id"));
               student.setName(rs.getString("name"));
               student.setPassword(rs.getString("password"));
               student.setAge(rs.getInt("age"));
               student.setBirthday(rs.getDate("birthday"));
               list.add(student);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,statement,rs);
        }
        return list;
    }

    public Student findById(Integer id) {
        Connection connection=ds.getConnection();
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from Student where id=?";
        Student student=null;
        try{
           statement=connection.prepareStatement(sql);
           statement.setInt(1,id);
           rs=statement.executeQuery();
            while(rs.next()){
                student=new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setAge(rs.getInt("age"));
                student.setBirthday(rs.getDate("birthday"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,statement,rs);
        }
        return student;
    }

    public void add(Student student) {
        Connection connection=ds.getConnection();
        PreparedStatement statement=null;
        String sql="insert into Student(name,password,age,birthday)values(?,?,?,?)";
        try{
        statement=connection.prepareStatement(sql);
        statement.setString(1,student.getName());
        statement.setString(2,student.getPassword());
        statement.setInt(3,student.getAge());
        statement.setDate(4,new java.sql.Date(student.getBirthday().getTime()));
        statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,statement,null);
        }
    }
    public void update(Student student) {
       Connection connection=ds.getConnection();
       PreparedStatement statement=null;
       String sql="update Student set name=?,password=?,age=?,birthday=? where id=?";
       try{
       statement=connection.prepareStatement(sql);
       statement.setString(1,student.getName());
       statement.setString(2,student.getPassword());
       statement.setInt(3,student.getAge());
       statement.setDate(4,new java.sql.Date(student.getBirthday().getTime()));
       statement.setInt(5,student.getId());
       statement.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           close(connection,statement,null);
       }
    }
    public void delete(Integer id) {
        Connection connection=ds.getConnection();
        PreparedStatement statement=null;
        String sql="delete from Student where id=?";
        try{
           statement=connection.prepareStatement(sql);
           statement.setInt(1,id);
           statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(connection,statement,null);
        }
    }
}
