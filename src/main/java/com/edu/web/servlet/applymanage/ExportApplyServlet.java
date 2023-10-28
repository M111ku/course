package com.edu.web.servlet.applymanage;

import com.alibaba.fastjson.JSON;
import com.edu.pojo.Apply;
import com.edu.service.ApplyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@WebServlet("/exportApply")//导出申请记录为excel表格
public class ExportApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();

    private List<List<String>> convertToExcelData(List<Apply> applyList) {
        List<List<String>> excelData = new ArrayList<List<String>>();

        // Add headers for student ID and course ID
        List<String> headerRow = new ArrayList<String>();
        headerRow.add("学生编号");
        headerRow.add("课程编号");
        excelData.add(headerRow);

        for (Apply apply : applyList) {
            List<String> dataRow = new ArrayList<String>();
            dataRow.add(apply.getStudentid());
            dataRow.add(apply.getCourseid());
            // add other fields as needed
            excelData.add(dataRow);
        }

        return excelData;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apply> applyList = applyService.selectStateIsFiveOrSeven();
        List<List<String>> excelData = convertToExcelData(applyList);

        //将已申请成功的申请导出为Excel 导出的第一列为学生编号 第二列为课程编号
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Apply Data");
        int rowNum = 0;
        for (List<String> row : excelData) {
            Row excelRow = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String cellValue : row) {
                Cell cell = excelRow.createCell(colNum++);
                cell.setCellValue(cellValue);
            }
        }
        //输出文件
        FileOutputStream outputStream = new FileOutputStream("E:\\IntelliJ IDEA 2022.3.3\\maven-homework\\apply_data.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        response.sendRedirect("applyManage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
