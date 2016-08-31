import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by schaud3 on 8/31/16.
 */
public class TempExcel {
    public static void main(String[] args) throws IOException {
        Workbook xlsFile = new HSSFWorkbook(); // create a workbook
        CreationHelper helper = xlsFile.getCreationHelper();
        Sheet sheet1 = xlsFile.createSheet("Sheet #1");
        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue("shreejit");
        FileOutputStream fos = new FileOutputStream("/Users/schaud3/Documents/personal/Experiments/src/main/resources/temp.xls");
        xlsFile.write(fos);
        fos.close();

//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        xlsFile.write(bos); // write excel data to a byte array
//        fos.close();
//
//// Now use your ByteArrayDataSource as
//        DataSource fds = new ByteArrayDataSource(bos.toByteArray(), "application/vnd.ms-excel");
    }

}
