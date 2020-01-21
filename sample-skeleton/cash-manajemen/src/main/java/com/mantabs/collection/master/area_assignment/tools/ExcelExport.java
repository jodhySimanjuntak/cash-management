package com.mantabs.collection.master.area_assignment.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {
	public static File generate(String title, Object[] objects){
		final String fileName = title+".xlsx";
		List<String> fieldNames = new ArrayList<String>();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet 1");
		XSSFCellStyle cs = workbook.createCellStyle();
		cs.setWrapText(true);
		cs.setAlignment(HorizontalAlignment.CENTER);
		cs.setVerticalAlignment(VerticalAlignment.CENTER);
		int rowNum=0, colNum=0;
		
		Row row = sheet.createRow(rowNum++);
		for(Field x : objects[0].getClass().getDeclaredFields()){
			Cell cell = row.createCell(colNum++);
			cell.setCellValue(x.getName());
			cell.setCellStyle(cs);
			fieldNames.add(x.getName());
		}
		
		for(Object y: objects){
			row = sheet.createRow(rowNum++);
			colNum=0;
			for(String z: fieldNames){
				try {
					Field field = y.getClass().getDeclaredField(z);
					field.setAccessible(true);
					Cell cell = row.createCell(colNum++);
					try {
						cell.setCellValue(field.get(y).toString());
						cell.setCellStyle(cs);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					catch(NullPointerException e){
						cell.setCellValue("");
					}
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
			row.setHeight((short)-1);
		}
		
		for(int i=0; i<fieldNames.size(); i++){
			sheet.autoSizeColumn(i);
		}
		
		try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            return new File(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
}
