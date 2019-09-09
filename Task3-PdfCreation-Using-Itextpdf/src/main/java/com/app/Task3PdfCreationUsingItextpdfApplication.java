package com.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.app.model.Employee;
import com.app.service.EmployeeService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
@EnableAutoConfiguration
public class Task3PdfCreationUsingItextpdfApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		EmployeeService service=null;
		
		//get IOC Container
		ctx=SpringApplication.run(Task3PdfCreationUsingItextpdfApplication.class, args);

		//get service bean
		
		service=ctx.getBean("empService",EmployeeService.class);
		
		
		//String query="SELECT * FROM EMP_TAB";
		Document document=null;
		PdfWriter writer=null;
		
		//Connection con=null;
		//PreparedStatement ps=null;
		//ResultSet rs=null;
		
		
		try {
		
			document=new Document();
			writer=PdfWriter.getInstance(document,new FileOutputStream("E:\\pdftest.pdf"));
		
			document.open();
			
			
			//adding date
			
			document.add(new Paragraph(new Date().toString()));
			//add paragraph
			Paragraph para=new Paragraph("WELCOME TO ITEXT PDF CREATION LIBRARY");
			
			document.add(para);
			//adding blank lines
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			
			//adding table
			
			PdfPTable table=new PdfPTable(5);
			
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			table.addCell("ID");
			table.addCell("NAME");
			table.addCell("CITY");
			table.addCell("SALARY");
			table.addCell("ROLE");
			
			
			//getting data from database and adding it to pdf
			/*con=DBConnection.getConnection();
			
			if(con!=null) {
				
				ps=con.prepareStatement(query);
			}
			
			if(ps!=null) {
				rs=ps.executeQuery();
			}
			
			if(rs!=null) {
				
				while(rs.next()) {
					table.addCell(rs.getString(1));
					table.addCell(rs.getString(3));
					table.addCell(rs.getString(2));
					table.addCell(rs.getString(5));
					table.addCell(rs.getString(4));
				}//while
			}//if
*/	
			java.util.List<Employee> list=service.getAllEmployees();
	
			for(Employee e: list) {
				
				table.addCell(e.getEid().toString());
				table.addCell(e.getEname());
				table.addCell(e.getCity());
				table.addCell(e.getSal().toString());
				table.addCell(e.getErole());
			}
			
			document.add(table);
			
			//adding images 
			document.add(Image.getInstance("E:\\dimple.jpg"));
			
			//adding ordered list
			
			List ul=new List(List.UNORDERED);
			ul.add("C");
			ul.add("C++");
			ul.add("JAVA");
			ul.add("DOT NET");
			
			document.add(ul);
			
			
			List ol=new List(List.ORDERED);
			ol.add("READING");
			ol.add("WRITING");
			ol.add("SPEAKING");
			ol.add("PROGRAMMING");
			
			document.add(ol);
			
			document.addAuthor("SANDIP HUMBE");
			document.addLanguage("ENGLISH");
			document.addTitle("EMPLOYEE DETAILS");
			
			
			document.close();
		}
		catch(DocumentException de) {
			de.printStackTrace();
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("PDF OPERATIONS COMPLETED SUCCESSFULLY..");
	}//main()

}//class
