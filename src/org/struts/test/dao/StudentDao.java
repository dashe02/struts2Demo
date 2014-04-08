package org.struts.test.dao;

import org.struts.test.entity.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-4-7
 * Time: 下午11:29
 * To change this template use File | Settings | File Templates.
 */
public interface StudentDao {

    public boolean checkLogin(String name,String password);

    public List<Student> findAllStudent();

    public Student findById(Integer id);

    public void add(Student student);

    public void update(Student student);

    public void delete(Integer id);
}
