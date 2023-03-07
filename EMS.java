package employeeManagement;

//importing Essential libraries //

import java.util.*;
import java.io.*;


// 1. Add an Employee

class Employee_Add
{
	@SuppressWarnings("resource")
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        EmployDetail emp=new EmployDetail();
        emp.getInfo();
        try{
            File f1=new File("file"+emp.employ_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+emp.employ_id+".txt");
                
                myWriter.write("Employee ID       :"+emp.employ_id+"\n"+
                               "Employee Name     :"+emp.name+"\n"+
                               "Father's Name     :"+emp.father_name+"\n"+
                               "Employee Contact  :"+emp.employ_contact+"\n"+
                               "Email Information :"+emp.email+"\n"+
                               "Employee position :"+emp.position+"\n"+
                               "Employee Salary   :"+emp.employ_salary);
                
                myWriter.close();
                System.out.println("\nEmployee has been Added \n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e)
        {
        	System.out.println(e);
        	}
    }
}


// 2. Show an Employee

class Employee_Show
{
	@SuppressWarnings("resource")
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
   }
}

// 3. Remove an Employee

class Employee_Remove
{
    public void removeFile(String ID)
    {

    File file = new File("file"+ID+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nEmployee has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nEmployee does not exists :( ");
       }
     }
}

// 4. Update an Employee

class Employee_Update
{
	@SuppressWarnings("resource")
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine())
       {
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter("file"+s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}

// 5. Exit EMS

class CodeExit
{
  public void out()
  {
    System.out.println("\n*****************************************");
    System.out.println("  Thank You For Using my Software :) ");
    System.out.println("*****************************************");
    
    System.exit(0);
  }
}

public class EMS {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    System.out.print("\033[H\033[2J");   /** To clear the output Screen **/

	    Scanner sc=new Scanner(System.in);
	    Employee_Show epv =new Employee_Show();

	    int i=0;
	    
	    MainMenu obj1 = new MainMenu();     /*** Calling Mainmenu Class function ****/
	    obj1.menu();

	    while(i<6)     /*** Initializing loop for Menu Choices ***/
	    {

	      System.out.print("\nPlease Enter choice :");
	      i=Integer.parseInt(sc.nextLine());
	      
	      switch(i)    /** Switch Case Statements **/
	      {
	        case 1:
	        {
	        /** Creating class's object and calling Function using that object **/
	        Employee_Add ep =new Employee_Add();
	        ep.createFile();

	        System.out.print("\033[H\033[2J");
	        obj1.menu();
	        break;
	        }
	        case 2:
	        {
	          System.out.print("\nPlease Enter Employee's ID :");
	          String s=sc.nextLine();
	          try
	          {
	            epv.viewFile(s);}
	            catch(Exception e){System.out.println(e);}


	            System.out.print("\nPress Enter to Continue...");
	            sc.nextLine();
	            System.out.print("\033[H\033[2J");
	            obj1.menu();
	            break;
	          }
	        case 3:
	        {
	          System.out.print("\nPlease Enter Employee's ID :");
	          String s=sc.nextLine();
	          Employee_Remove epr =new Employee_Remove();
	          epr.removeFile(s);

	          System.out.print("\nPress Enter to Continue...");
	          sc.nextLine();
	          System.out.print("\033[H\033[2J");
	          obj1.menu();
	          break;
	        }
	        case 4:
	        {
	            System.out.print("\nPlease Enter Employee's ID :");
	            String I=sc.nextLine();
	            try
	            {
	              epv.viewFile(I);
	            }
	            catch(Exception e)
	            {
	              System.out.println(e);
	            }
	            Employee_Update epu = new Employee_Update();
	            System.out.print("Please Enter the detail you want to Update :");
	    	      System.out.print("\nFor Example :\n");
	            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
	            String s=sc.nextLine();
	            System.out.print("Please Enter the Updated Info :");
	            String n=sc.nextLine();
	            try
	            {
	              epu.updateFile(I,s,n);

	              System.out.print("\nPress Enter to Continue...");
	              sc.nextLine();
	              System.out.print("\033[H\033[2J");
	              obj1.menu();
	              break;
	            }
	            catch(IOException e)
	            {
	              System.out.println(e);
	            }
	        }
	        case 5:
	        {
	          CodeExit obj = new CodeExit();
	          obj.out();
	        }
	      }
	    }
	  }
	}


