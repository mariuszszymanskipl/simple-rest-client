package api;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Mariusz Szymanski
 */
class ICDClient {

    private static final String ICD9_SERVICE_URL
            = "https://danepubliczne.gov.pl/dataset"
            + "/a5f6b1ae-211a-4481-885e-ba9ff54c5ad4"
            + "/resource/a3647fe8-8e50-4836-b816-ec6861fac35f"
            + "/download/icd-9plw.5.33.xls";

    int getICD() {

        try {
            InputStream inputStream = new URL(ICD9_SERVICE_URL).openStream();
            HSSFWorkbook wb = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows = sheet.getPhysicalNumberOfRows(); // No of rows
            int cols = sheet.getRow(2).getPhysicalNumberOfCells(); // No of columns

            return rows;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
