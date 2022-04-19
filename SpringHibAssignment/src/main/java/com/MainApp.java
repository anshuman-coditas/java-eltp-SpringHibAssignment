package com;

import Dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
        EmployeeDao edao= (EmployeeDao) applicationContext.getBean("edao");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.INSERT\n2.FETCH\n3.UPDATE\n4.DELETE\n5.EXIT");
            int ch= Integer.parseInt(br.readLine());
            switch (ch){
                case 1:
                    System.out.println("Enter id,name,designation,salary");
                    Employee e=new Employee();
                    e.setId(Integer.parseInt(br.readLine()));
                    e.setName(br.readLine());
                    e.setDesignation(br.readLine());
                    e.setSalary(Float.parseFloat(br.readLine()));
                    edao.save(e);
                    break;
                case 2:
                    List<Employee> employees=edao.fetchAll();
                    for(Employee employee:employees){
                        System.out.println(employee);
                    }
                    break;
                case 3:
                    System.out.println("Enter id,designation to update");
                    int id= Integer.parseInt(br.readLine());
                    String d=br.readLine();
                    edao.update(id,d);
                    break;
                case 4:
                    System.out.println("Enter Id to Delete");
                    int id1= Integer.parseInt(br.readLine());
                    edao.delete(id1);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice");

            }
        }while (true);


    }
}
