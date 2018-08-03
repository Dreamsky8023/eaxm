package UI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import dao.StudentDao;
import domain.Student;
import exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("���ѧ��(a)  ɾ��ѧ��(b)  ����ѧ��(c)");
			System.out.print("������������ͣ�");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String type= br.readLine();
			if("a".equals(type)) {
				System.out.println("������ѧ��������");
				String name=br.readLine();
				System.out.println("������ѧ��׼��֤�ţ�");
				String examid=br.readLine();
				System.out.println("������ѧ�����֤�ţ�");
				String idcard=br.readLine();
				System.out.println("������ѧ�����ڵأ�");
				String location=br.readLine();
				System.out.println("������ѧ���ɼ���");
				String grade=br.readLine();
				
				Student s=new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);
				
				StudentDao dao=new StudentDao();
				dao.add(s);
				
				System.out.println("��ӳɹ�!");
			}else if("b".equals(type)) {
				System.out.println("������Ҫɾ����ѧ����������");
				String name=br.readLine();
				try {
					StudentDao dao=new StudentDao();
					dao.delete(name);
					System.out.println("ɾ���ɹ�");
				}
				catch (StudentNotExistException e) {
					System.out.println("��Ҫɾ�����û�������!!");
				}
				
			}else if("c".equals(type)) {
				System.out.println("������Ҫ���ҵ�ѧ����׼��֤�ţ�");
				String examid=br.readLine();
				StudentDao dao=new StudentDao();
				Student s= dao.find(examid);
				System.out.println("������"+s.getName());
				System.out.println("׼��֤�ţ�"+s.getExamid());
				System.out.println("���֤�ţ�"+s.getIdcard());
				System.out.println("���ڵأ�"+s.getLocation());
				System.out.println("�ɼ���"+s.getGrade());		
			}else {
				System.out.println("��֧�����Ĳ���");
			}
		}
		catch(Exception e) //ץ���������û��Ѻ���ʾ
		{
			e.printStackTrace();
			System.out.println("������");
		}
		
	}

}
