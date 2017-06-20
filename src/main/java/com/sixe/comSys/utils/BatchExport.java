package com.sixe.comSys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


/**
 * 基于模板的批量导出
 * @author haorongxiang
 * @date 2017年3月27日17:45:13
 *
 */
public class BatchExport implements ResourceLoaderAware{

	/*public static void main(String[] args) {
		try {
			
			List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < 50000; i++) {
				Map<String, Object> temp = new LinkedHashMap<String, Object>();
				temp.put("userName"+i, "test"+i);
				temp.put("passwd"+i, "test"+i);
			}
			PatchExport expot = new PatchExport();
			expot.readWorkbookTemplate("test.xlsx");
			expot.write(new FileOutputStream("D:/temp/test.xlsx"), datas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * 默认获取方法格式
	 */
	public static final String DEFAULT_GET = "get";
	/**
	 * excel模板存放位置
	 */
	public static final String DEFAULT_RESOURCE_PATH = "excel/";
	/**
	 * 默认xlsx单个sheet最大数据行数
	 */
	public static Integer DEFAULT_XLSX_SHEET_MAX_ROWNUM = 1048575;
	/**
	 * 默认xls单个sheet最大数据行数
	 */
	public static Integer DEFAULT_XLS_SHEET_MAX_ROWNUM = 65535; 

	/**
	 * 内置workbook
	 */
	private Workbook workbook;
	/**
	 * workbook类型: xls, xlsx
	 */
	private String workbookType;
	private ResourceLoader resourceLoader = new DefaultResourceLoader();
	
	public BatchExport(){
	}
	public BatchExport(String fileName) throws Exception{
		readWorkbookTemplate(fileName);
	}
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	/**
	 * 设置excel导出模板
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public BatchExport readWorkbookTemplate(String fileName ) throws Exception{
		Resource path = resourceLoader.getResource("excel/");
		File file = new File(path.getFile() + "/" + fileName);
		return readWorkbookTemplateByAbsolutely(file);
	}
	
	/**
	 * 设置excel导出模板
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public BatchExport readWorkbookTemplateByAbsolutely(File filePath) throws Exception{
		if (!filePath.exists()) {
			throw new RuntimeException("excel模板文档不存在! 请检查." + filePath.getAbsolutePath());
		}
		Workbook wb = null;
		String fileName = filePath.getName();
		InputStream is = new FileInputStream(filePath);
		if(fileName.toLowerCase().endsWith("xls")){
			this.workbookType = "xls";
			wb = new HSSFWorkbook(is);    
        }else if(fileName.toLowerCase().endsWith("xlsx")){ 
        	this.workbookType = "xlsx";
        	wb = new XSSFWorkbook(is);
        }else{  
        	throw new RuntimeException("文档格式不正确!");
        } 
		this.workbook = wb;
		return this;
	}
	
	
	
	/**
	 * 将指定数据生成excel表格, 并输出到输出流
	 * @param outputStream
	 * @param datas
	 * @throws Exception
	 */
	public <T>BatchExport write(OutputStream outputStream, List<T> datas) throws Exception {
		if (null == this.workbook) {
			throw new RuntimeException("没有指定excel模板文件.");
		}
		Map<String, Object> format = getFormate(this.workbook);
		this.proccess(this.workbook, format, datas);//生成excel内存文件
		this.workbook.write(outputStream);//输出文件到流中
		return this;
	}
	
	/**
	 * 输出到客户端
	 * @param fileName 输出文件名
	 * @throws Exception 
	 */
	public <T> BatchExport write(HttpServletResponse response, String fileName, List<T> datas) throws Exception{
		response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName,"UTF-8"));
        write(response.getOutputStream(), datas);
		return this;
	}
	/**
	 * 填充表格
	 * @param wb
	 * @param format
	 * @param datas
	 * @throws Exception 
	 */
	private <T> void proccess(Workbook wb, Map<String, Object> format, List<T> datas) throws Exception{
		if (null == datas || datas.isEmpty() || format == null || format.isEmpty()) {//数据非空校验
			return ;
		} 
		//数据长度校验
		if ("xls".equals(this.workbookType) && datas.size()>DEFAULT_XLS_SHEET_MAX_ROWNUM) {
			throw new RuntimeException(".xls 文件单个工作薄不能大于" + DEFAULT_XLS_SHEET_MAX_ROWNUM + " 行!");
		}
		if ("xlsx".equals(this.workbookType) && datas.size()>DEFAULT_XLSX_SHEET_MAX_ROWNUM) {
			throw new RuntimeException(".xls 文件单个工作薄不能大于" + DEFAULT_XLSX_SHEET_MAX_ROWNUM + " 行!");
		}
		
		int indexRow = (Integer) format.get("rowNum");
		Sheet sheet = null;
		Map<String, Object> fields = format.get("fields")==null? null:(Map<String, Object>)format.get("fields") ;
		if (null != wb) {
			sheet = wb.getSheetAt(0);
		} else {
			throw new RuntimeException("导入文档为空!");
		}
		for (Object obj : datas) {
			Row row = sheet.createRow(indexRow);
			int column = 0;
			for (String key : fields.keySet()) {
				String fieldVal = getFieldValue(fields.get(key)+"", obj);
				Cell cell = row.createCell(column);
				cell.setCellValue(fieldVal);
				column++;
			}
			indexRow++;
		}
	}
	/**
	 * 获取模板格式
	 * key说明:
	 * rowNum: 从第几行开始填充数据
	 * n : 第几列填充的数据名称
	 * @param wb
	 * @return
	 */
	private Map<String, Object> getFormate(Workbook wb){
		Sheet sheet = null;
		Map<String, Object> temp = new HashMap<String, Object>();
		Map<String, Object> field = new LinkedHashMap<String, Object>();
		if (null != wb) {
			sheet = wb.getSheetAt(0);
		} else {
			throw new RuntimeException("导入文档为空!");
		}
		for (int i = 0; i < sheet.getLastRowNum()+1; i++) {
			Row row = sheet.getRow(i);
			if (null == row) continue;
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
					if ((cell.getStringCellValue()+"").indexOf(".")>0) {
						temp.put("rowNum", i);
						String cellstr = (cell.getStringCellValue()+"");
						field.put(j+"", cellstr.substring(cellstr.indexOf(".")+1));
						cell.setCellValue("");
					}
				}
			}
			
			//判断循环循环提前退出条件
			if (null != temp.get("rowNum")) {
				temp.put("fields", field);
				break;
			}
		}
		return temp;
	}
	/**
	 * 获取指定对象的属性值
	 * @param fieldName 属性名称
	 * @param object 指定对象
	 * @return value
	 * @throws Exception
	 */
	private String getFieldValue(String fieldName, Object object) throws Exception{
		if (object instanceof Map) {//如果对象是Map
			return ((Map)object).get(fieldName) + "";
			
		} else {//如果目标对象是普通对象
			try {
				String methodName = DEFAULT_GET + (fieldName.charAt(0)+"").toUpperCase() + fieldName.substring(1);
				Method method = object.getClass().getMethod(methodName, null) ;
				Object value = method.invoke(object);
				return value==null?"":value+"";
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(fieldName+"属性没有找到get方法.");
			}
		}
	}
}
