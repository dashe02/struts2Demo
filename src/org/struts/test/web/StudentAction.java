package org.struts.test.web;
import org.struts.test.dao.StudentDao;
import org.struts.test.dao.impl.StudentDaoImpl;
import org.struts.test.entity.Student;
import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-4-7
 * Time: 下午11:31
 * To change this template use File | Settings | File Templates.
 */
public class StudentAction{

    private StudentDao studentDao=new StudentDaoImpl();

    private Student student=new Student();

    private List<Student> studentList=new ArrayList<Student>();

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public String login(){
        boolean isExist=studentDao.checkLogin(student.getName(),student.getPassword());
        if(isExist){
        	return goStudentList();
        }else
            return "login";
    }

	private String goStudentList() {
		studentList=studentDao.findAllStudent();
		return "success";
	}
    public String goAddStudent(){
        return "goAddStudent";
    }
    public String addStudent(){
        studentDao.add(student);
        return goStudentList();
    }
    public String goUpdateStudent(){
    	student=studentDao.findById(student.getId());
        return "goUpdateStudent";
    }
    public String updateStudent(){
    	studentDao.update(student);
    	return goStudentList();
    }
    public String deleteStudent(){
        studentDao.delete(student.getId());
        return goStudentList();
    }
}
