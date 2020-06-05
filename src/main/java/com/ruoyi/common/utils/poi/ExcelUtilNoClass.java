package com.ruoyi.common.utils.poi;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.reflect.ReflectUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import io.swagger.models.auth.In;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/5/28 14:58
 * @Version 1.0
 */

public class ExcelUtilNoClass {
    private static final Logger log = LoggerFactory.getLogger(ExcelUtilNoClass.class);

    /**
     * 工作薄对象
     */
    private Workbook wb;
    /**
     * 对excel表单默认第一个索引名转换成list
     *
     * @param is 输入流
     * @return 转换后集合
     */
    public List<String> importExcel(InputStream is) throws Exception
    {
        return importExcel(StringUtils.EMPTY, is);
    }

    /**
     * 创建Workbook对象
     * @param is
     * @param postfix
     * @return
     */
    public void createWb(InputStream is,String postfix) throws Exception {
        if(postfix!=null||postfix.equals(".xls")||postfix.equals(".csv")){
            this.wb=new HSSFWorkbook(is);
        }else{
            this.wb=WorkbookFactory.create(is);
        }
    }


    /**
     * 对excel表单指定表格索引名转换成list
     *
     * @param sheetName 表格索引名
     * @param is 输入流
     * @return 转换后集合
     */
    public List<String> importExcel(String sheetName, InputStream is) throws Exception
    {
        this.wb = WorkbookFactory.create(is);
//        createWb(is,".xls");
        List<String> result=new ArrayList<>();
        Sheet sheet = null;
        if (StringUtils.isNotEmpty(sheetName))
        {
            // 如果指定sheet名,则取指定sheet中的内容.
            sheet = wb.getSheet(sheetName);
        }
        else
        {
            // 如果传入的sheet名不存在则默认指向第1个sheet.
            sheet = wb.getSheetAt(0);
        }

        if (sheet == null)
        {
            throw new IOException("文件sheet不存在");
        }
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows > 0)
        {
            // 获取表头
            Row heard = sheet.getRow(0);
            int columns = heard.getPhysicalNumberOfCells();
            for (int i = 0; i < rows; i++)
            {
                Row row = sheet.getRow(i);
                String str="";
                if(row==null){
                    break;
                }
                for (int j = 0; j < columns; j++) {
                    String val = this.getCellValue(row, j);
                    str+=val;
                    if(j<columns-1){
                        str+=";";
                    }
                }
                result.add(str);
            }
        }
        return result;
    }


    /**
     * 反向解析值 男=0,女=1,未知=2
     *
     * @param propertyValue 参数值
     * @param converterExp 翻译注解
     * @return 解析后值
     * @throws Exception
     */
    public static String reverseByExp(String propertyValue, String converterExp) throws Exception
    {
        try
        {
            String[] convertSource = converterExp.split(",");
            for (String item : convertSource)
            {
                String[] itemArray = item.split("=");
                if (itemArray[1].equals(propertyValue))
                {
                    return itemArray[0];
                }
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return propertyValue;
    }

    /**
     * 获取单元格值
     *
     * @param row 获取的行
     * @param column 获取单元格列号
     * @return 单元格值
     */
    public String getCellValue(Row row, int column)
    {
        Object val = "";
        try
        {
            Cell cell = row.getCell(column);
            if (cell != null)
            {
                if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
                {
                    val = cell.getNumericCellValue();
                    if (HSSFDateUtil.isCellDateFormatted(cell))
                    {
                        // POI Excel 日期格式转换
                        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        val = sim.format(DateUtil.getJavaDate((Double) val));
                    }
                    else
                    {
                        if ((Double) val % 1 > 0)
                        {
                            val = new DecimalFormat("0.0000000").format(val);
                        }
                        else
                        {
                            val = new DecimalFormat("0").format(val);
                        }
                    }
                }
                else if (cell.getCellTypeEnum() == CellType.STRING)
                {
                    val = cell.getStringCellValue();
                }
                else if (cell.getCellTypeEnum() == CellType.BOOLEAN)
                {
                    val = cell.getBooleanCellValue()+"";
                }
                else if (cell.getCellTypeEnum() == CellType.ERROR)
                {
                    val = cell.getErrorCellValue()+"";
                }

            }
        }
        catch (Exception e)
        {
            return val.toString();
        }
        return val.toString();
    }

    public Workbook createworkbook(InputStream inp) throws IOException, InvalidFormatException {
        if (!inp.markSupported()) {
            inp = new PushbackInputStream(inp, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(inp)) {
            return new HSSFWorkbook(inp);
        }
        throw new IllegalArgumentException("你的excel版本目前poi解析不了");
    }


    public static void main(String[] args) {
        ExcelUtilNoClass excelUtilNoClass=new ExcelUtilNoClass();
        try {
//            File file=new File("C:\\Users\\hxsdd-20\\Desktop\\test2.xlsx");
            File file=new File("C:\\Users\\hxsdd-20\\Desktop\\test3.xls");
//            excelUtilNoClass.createworkbook(new FileInputStream(file));
            InputStream inputStream=new FileInputStream(file);
            List<String> list = excelUtilNoClass.importExcel(inputStream);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
