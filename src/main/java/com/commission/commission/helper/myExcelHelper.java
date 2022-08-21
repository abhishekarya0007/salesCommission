package com.commission.commission.helper;

import com.commission.commission.entity.SalesLineItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myExcelHelper {

    // File is of Excel Type or Not
    public static boolean checkExcelFormat(MultipartFile File)
    {
            String contentType = File.getContentType();
            if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                return true;
            else
                return false;
    }

    // Convert Excel into List of Products
    public static List<SalesLineItem> convertExcelToListofSalesLineItem(InputStream is)
    {
        List<SalesLineItem> list = new ArrayList<>();
        try
        {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext())
            {
                Row row = iterator.next();
                if(rowNumber==0)
                {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                SalesLineItem s=new SalesLineItem();

                while(cells.hasNext())
                {
                    Cell cell = cells.next();
                    switch (cid)
                    {
                        case 0:
                            s.setSid((int)cell.getNumericCellValue());
                                break;
                        case 1:
                            s.setPid((int)cell.getNumericCellValue());
                                break;
                        case 2:
                            s.setAmount((int)cell.getNumericCellValue());
                                break;
                        case 3:
                            s.setMonth((int)cell.getNumericCellValue());
                                break;
                        default:
                                break;
                    }
                    cid++;
                }
                 list.add(s);
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return list;
    }

}
