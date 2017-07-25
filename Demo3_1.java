package ThreadSparit;

import java.lang.management.ManagementFactory;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import util.SQL;

public class Demo3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://ipsearch.ipd.gov.hk/trademark/jsp/fssr01001s_schi.jsp?SOAPQC=-1&FILE_NO_TYPE=A&FILE_NO={0}&FILE_NO_SMM=5&FILE_NO={1}&FILE_NO_SMM=3&TM_TEXT=&TM_TEXT_SMM=0&TM_TEXT_OP=0&TM_TEXT=&TM_TEXT_SMM=0&TM_TEXT_OP=0&TM_TEXT=&TM_TEXT_SMM=0&TM_CODE=&TM_CODE_OP=1&CLASS_NO=&MARK_TYPE=Y&SPECIAL_SIGNS=Y&COLOUR_CLAIM_DESCRIP_STYLE=&COLOUR_CLAIM_DESCRIP_STYLE_SMM=0&APPL_NAME=&APPL_NAME_SMM=0&LICENCEE=&LICENCEE_SMM=0&ADD_FOR_SERVICE=&ADD_FOR_SERVICE_SMM=0&FILE_DT=&FILE_DT_SMM=5&FILE_DT=&FILE_DT_SMM=3&RREG_DT=&RREG_DT_SMM=5&RREG_DT=&RREG_DT_SMM=3&EXP_DT=&EXP_DT_SMM=5&EXP_DT=&EXP_DT_SMM=3&PUB_DT=&PUB_DT_SMM=5&PUB_DT=&PUB_DT_SMM=3&TM_SPEC=&TM_SPEC_SMM=0&TM_DIS=&TM_DIS_SMM=6&STYPE=S&TYPE=S&LIVE_STATUS=Y";
		long i = 10000000;
		String url2 = "";
		SQL sql = new SQL();
		Statement sta = sql.addJDBC("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "sherlock");
		Demo3__1 d = new Demo3__1();
		for(i = 10000000; i<=19910000; i++){
			url2 = MessageFormat.format(url, String.valueOf(i), String.valueOf(i));
			String s = "insert into url (url) values ('"+ url2 +"')";
			System.out.println(s);
			sql.change(s, sta);
		}
	}

}
