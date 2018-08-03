package UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import dao.StudentDao;
import domain.Student;
import exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("添加学生(a)  删除学生(b)  查找学生(c)");
			System.out.print("请输入操作类型：");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String type= br.readLine();
			if("a".equals(type)) {
				System.out.println("请输入学生姓名：");
				String name=br.readLine();
				System.out.println("请输入学生准考证号：");
				String examid=br.readLine();
				System.out.println("请输入学生身份证号：");
				String idcard=br.readLine();
				System.out.println("请输入学生所在地：");
				String location=br.readLine();
				System.out.println("请输入学生成绩：");
				String grade=br.readLine();
				
				Student s=new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao=new StudentDao();
				dao.add(s);
				
				System.out.println("添加成功!");
			}else if("b".equals(type)) {
				System.out.println("请输入要删除的学生的姓名：");
				String name=br.readLine();
				try {
					StudentDao dao=new StudentDao();
					dao.delete(name);
					System.out.println("删除成功");
				}
				catch (StudentNotExistException e) {
					System.out.println("你要删除的用户不存在!!");
				}
				
			}else if("c".equals(type)) {
				System.out.println("请输入要查找的学生的准考证号：");
				String examid=br.readLine();
				StudentDao dao=new StudentDao();
				Student s= dao.find(examid);
				System.out.println("姓名："+s.getName());
				System.out.println("准考证号："+s.getExamid());
				System.out.println("身份证号："+s.getIdcard());
				System.out.println("所在地："+s.getLocation());
				System.out.println("成绩："+s.getGrade());		
			}else {
				System.out.println("不支持您的操作");
			}
		}
		catch(Exception e) //抓起来，给用户友好提示
		{
			e.printStackTrace();
			System.out.println("出错了");
		}
		
	}

}
