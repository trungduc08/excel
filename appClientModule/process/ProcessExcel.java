package process;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import dto.TTHachToan;

public class ProcessExcel {
	public HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
	
	public void createFileExcel(String path, List<TTHachToan> lst) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet1");
		
		int rownum = 0;
		Cell cell;
		Row row;
		
		HSSFCellStyle style = createStyleForTitle(workbook);
		
		row = sheet.createRow(rownum);
		
		// id
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("ID");
		cell.setCellStyle(style);
		
		// bds
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("BDS");
		cell.setCellStyle(style);
		
		
		// acc_num
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tài khoản GL");
		cell.setCellStyle(style);
		
		// teller id
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Teller ID");
		cell.setCellStyle(style);
		
		for (int i = 0; i < lst.size(); i++) {
			TTHachToan bean = lst.get(i);
			rownum++;
			row = sheet.createRow(rownum);
			
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(bean.getId());
			
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(bean.getBds());
			
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(bean.getAccNum());
			
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(bean.getTellerId());
		}
		
		File file = new File(path);
		file.getParentFile().mkdirs();
		FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
	}
	
	public List<TTHachToan> readFile(String path) {
		List<TTHachToan> lst = new ArrayList<TTHachToan>();
		File file = new File(path);
		System.out.println("file: " + file.getAbsolutePath());
		int indexRow = 0;
		int indexColumn = 0;
		try {
			FileInputStream inputStream = new FileInputStream(file);
			
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			// get all row
			Iterator<Row> rowIterator = sheet.iterator();
			
			
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				
				if (indexRow >= 1) {
					TTHachToan bean = new TTHachToan();
					indexColumn = 0;
					// get all column in 1 row
					Iterator<Cell> cellIterator = row.cellIterator();
					
					indexColumn++;
					Cell cell = cellIterator.next();
					bean.setId((int)cell.getNumericCellValue());
					
					indexColumn++;
					cell = cellIterator.next();
					bean.setBds(cell.getStringCellValue());
					
					indexColumn++;
					cell = cellIterator.next();
					bean.setAccNum(cell.getStringCellValue());
					
					indexColumn++;
					cell = cellIterator.next();
					bean.setTellerId(cell.getStringCellValue());
					
					lst.add(bean);
				}
				indexRow++;
				
				
			}
		} catch (Exception e) {
			System.out.println("Loi dong " + indexRow + " cot " + indexColumn + " => " + e.toString());
		}
		
		return lst;
	}
}
