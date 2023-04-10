package com.pidev.welend.services;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.pidev.welend.entities.Loan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import static org.apache.poi.ss.util.CellUtil.createCell;

@Service
public class LoanExcelExportService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Loan> loanList;

    public LoanExcelExportService(List <Loan> loanList) {
        this.loanList = loanList;
        workbook = new XSSFWorkbook();

    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Loan");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Loan_ID", style);
        createCell(row, 1, "Loan number", style);
        createCell(row, 2, "Loan Amount", style);
        createCell(row, 3, "Loan Status", style);
        createCell(row, 4, "interestRate", style);
        createCell(row, 5, "durationInMonths", style);
        createCell(row, 6, "collaterals", style);

    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Loan loan : loanList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, loan.getLoanID(), style);
            createCell(row, columnCount++, loan.getLoanNumber(), style);
            createCell(row, columnCount++, loan.getLoanAmount(), style);
            createCell(row, columnCount++, loan.getLoanStatus().toString(), style);
            createCell(row, columnCount++, loan.getInterestRate(), style);
            createCell(row, columnCount++, loan.getDurationInMonths(), style);
            createCell(row, columnCount++, loan.getCollaterals() , style);

        }
    }
   public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }


}
