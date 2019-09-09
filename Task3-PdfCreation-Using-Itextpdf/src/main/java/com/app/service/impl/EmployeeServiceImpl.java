package com.app.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import com.app.service.EmployeeService;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	@Transactional
	public void save(Employee e) {

		repository.save(e);
	}

	@Override
	@Transactional
	public void update(Employee e) {
        repository.save(e);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
        repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getEmployeeById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		return (List<Employee>) repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public void mergePdfs() {
		
		try {
			PdfReader report1=new PdfReader("E://pdftest.pdf");
            PdfReader report2=new PdfReader("E://pdf2.pdf");
            PdfCopyFields copy=new PdfCopyFields(new FileOutputStream("E://mergedPdf.pdf"));
            copy.addDocument(report1);
            copy.addDocument(report2);
            copy.close();
		} catch (IOException e) {
				e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//mergePdfs()

}//class
