import java.util.ArrayList;
import java.util.List;

import dto.TTHachToan;
import process.ProcessExcel;


public class Main {
	public static void main(String[] args) {
		List<TTHachToan> lst = new ArrayList<TTHachToan>();
		lst.add(new TTHachToan(1, "120", "017433103", "149447"));
		lst.add(new TTHachToan(2, "990", "289076542", "15380"));
		
//		try {
//			ProcessExcel process = new ProcessExcel();
//			process.createFileExcel("D:/tthachtoan248.xls", lst);
//		} catch(Exception e) {
//			System.out.println(e.toString());
//			//e.printStackTrace();
//		}
		
		
		ProcessExcel process = new ProcessExcel();
		lst =  process.readFile("D:\\tthachtoan248.xls");
		System.out.println(lst.size());
		for (int i = 0; i < lst.size(); i++) {
			TTHachToan bean = lst.get(i);
			System.out.println("bean.getId() " + bean.getId());
			System.out.println("bean.getBds() " + bean.getBds());
			System.out.println("bean.getAccNum() " + bean.getAccNum());
			System.out.println("bean.getTellerId() " + bean.getTellerId());
		}
	
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}