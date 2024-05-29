package com.example.demo.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entiry.product;

public class productexelHelper {
	public static boolean checkExcelFormat(MultipartFile file) {
		String contenttype = file.getContentType();
		if (contenttype.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else
			return false;
	}

	// it converts excel to list
	public static List<product> getList(InputStream iost) {
		List<product> list = new ArrayList<>();
		try {
			XSSFWorkbook workboot = new XSSFWorkbook(iost);
			XSSFSheet sheet = workboot.getSheet("Sheet1");
			int rownum = 0;
			Iterator<Row> itr = sheet.iterator();
			
			while (itr.hasNext()) {
				Row row = itr.next();
				if (rownum == 0) {
					rownum++;
					continue;
				}
				Iterator<Cell> cell = row.iterator();
				int cid = 0;
				product p = new product();
				while (cell.hasNext()) 
				{
					
					Cell cells = cell.next();
					switch (cid) {
					case 0:
						p.setProductId((long) cells.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cells.getStringCellValue());
						break;
					case 2:
						p.setProductDesc(cells.getStringCellValue());
						break;
					case 3:
						p.setProductPrice(cells.getNumericCellValue());
						break;
					default:
						break;
					}
					cid++;
					
				}
				list.add(p);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}
}
