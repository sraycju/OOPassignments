import java.io.Serializable;

class EmployeeD implements Serializable{
    private String emp_id;
    private String name;
    private double basic_salary;
    private char grade;
    private String dept_code;
    static int count=0;
    public void setValue(String id,String n,Double b,Character g,String c)
    {
        emp_id=String.valueOf(id);
        name=String.valueOf(n);
        basic_salary=b;
        grade=g;
        dept_code=String.valueOf(c);
        count++;
    }
    public String retEmpId(){
        return emp_id;
    }
    public String retName(){
        return name;
    }
    public Double retSalary(){
        return basic_salary;
    }
    public Character retGrade(){
        return grade;
    }
    public String retDepartment(){
        return dept_code;
    }

    public String toString(){
        return "Employee id : "+emp_id+"\nName : "+name+"\nBasic Salary : "+basic_salary+"\nDepartment : "+dept_code+"\nGrade : "+grade;
    }
}