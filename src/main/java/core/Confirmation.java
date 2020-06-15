package core;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import org.openqa.selenium.By;

class Confirmation {

	static Properties p = new Properties();
	static Writer report;

	static void validate() throws IOException {
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./report_" + Common.getBrowser().toString().toLowerCase() + ".csv", true);
		
		
		// 01 :: First Name
		Common.writeReportLine("01", "First Name", By.id(p.getProperty("fname_id")), report);
		// 02 :: Last Name
		Common.writeReportLine("02", "Last Name", By.id(p.getProperty("lname_id")), report);
		// 03 :: Email
		Common.writeReportLine("03", "Email", By.id(p.getProperty("email_id")), report);
		// 04 :: Phone
		Common.writeReportLine("04", "Phone", By.id(p.getProperty("phone_id")), report);
		// 05 :: State
		Common.writeReportLine("05", "State", By.id(p.getProperty("state_id")), report);
		// 06 :: TitleF
		Common.writeReportLine("06", "Titlef", By.id(p.getProperty("f_title_id")), report);
		// 07 :: LabelFn
		Common.writeReportLine("07", "LabelFn", By.id(p.getProperty("f_label_fn_id")), report);
		// 08 :: LabelLn
		Common.writeReportLine("08", "LabelLn", By.id(p.getProperty("f_label_ln_id")), report);
		// 09 :: LabelEa
		Common.writeReportLine("09", "LabelEa", By.id(p.getProperty("f_label_ea_id")), report);
		// 10 :: LabelPn
		Common.writeReportLine("10", "LabelPn", By.id(p.getProperty("f_label_pn_id")), report);
		// 11 :: LabelRb
		Common.writeReportLine("11", "LabelRb", By.id(p.getProperty("rb_label_g_id")), report);
		// 12 :: Gender
		Common.writeReportLine("12", "Gender", By.id(p.getProperty("gender_id")), report);
		// 13 :: LabelF
		Common.writeReportLine("13", "LabelF", By.id(p.getProperty("f_label_s_id")), report);
		// 14 :: LabelCb
		Common.writeReportLine("14", "LabelCb", By.id(p.getProperty("cb_label_t_id")), report);
		// 15 :: Terms
		Common.writeReportLine("15", "Terms", By.id(p.getProperty("terms_id")), report);
		// 16 :: Button
		Common.writeReportLine("16", "Button", By.id(p.getProperty("back_button_id")), report);
		
		report.flush();
		report.close();
	}

		
		
}