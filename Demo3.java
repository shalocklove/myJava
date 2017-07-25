package ThreadSparit;

import java.io.IOException;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Sparit;

public class Demo3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Pattern r = null;
		Matcher m = null;
		Sparit sparit = new Sparit();
		int i;
		String url = "http://ipsearch.ipd.gov.hk/trademark/jsp/fssr01001s_schi.jsp?SOAPQC=-1&FILE_NO_TYPE=A&FILE_NO=18970189&FILE_NO_SMM=5&FILE_NO=18970189&FILE_NO_SMM=3&TM_TEXT=&TM_TEXT_SMM=0&TM_TEXT_OP=0&TM_TEXT=&TM_TEXT_SMM=0&TM_TEXT_OP=0&TM_TEXT=&TM_TEXT_SMM=0&TM_CODE=&TM_CODE_OP=1&CLASS_NO=&MARK_TYPE=Y&SPECIAL_SIGNS=Y&COLOUR_CLAIM_DESCRIP_STYLE=&COLOUR_CLAIM_DESCRIP_STYLE_SMM=0&APPL_NAME=&APPL_NAME_SMM=0&LICENCEE=&LICENCEE_SMM=0&ADD_FOR_SERVICE=&ADD_FOR_SERVICE_SMM=0&FILE_DT=&FILE_DT_SMM=5&FILE_DT=&FILE_DT_SMM=3&RREG_DT=&RREG_DT_SMM=5&RREG_DT=&RREG_DT_SMM=3&EXP_DT=&EXP_DT_SMM=5&EXP_DT=&EXP_DT_SMM=3&PUB_DT=&PUB_DT_SMM=5&PUB_DT=&PUB_DT_SMM=3&TM_SPEC=&TM_SPEC_SMM=0&TM_DIS=&TM_DIS_SMM=6&STYPE=S&TYPE=S&LIVE_STATUS=Y";
		String url2 = "http://ipsearch.ipd.gov.hk/trademark/jsp/fssr01001s_schi.jsp?SAVED_CRI=&FROM_SEARCH_RESULT=0&TYPE=S&STYPE=S&SOAPQC=1&LIVE_STATUS=Y&PAGE_NO=2";
		
		URLConnection conn = sparit.Connection("http://ipsearch.ipd.gov.hk/trademark/jsp/ereg_main_schi.jsp?SAVED_CRI=&FROM_SEARCH_RESULT=0&ITEM_KEY=102405376&FILE_NO=19903148&FILE_NO_TYPE=TM_APPL&SOAPQC=7");
		String result = sparit.sendGet(conn);
		String[] s = new String[6];
		s[0] = "<td width=\"460\">[0-9]{0,8}";
		s[1] = "<b>状况：<br>Status:</b></td>[\\s]*<td>[\\s\\S]{0,25}</td>";
		s[2] = "<IMG src=\"[\\S]*\" border=\"0\" alt=\"image\">";
		s[3] = "<td nowrap><b>商标种类：<br>Mark Type:</b></td>[\\s]*<td>[\\s]*[\\S]*<br>";
		System.out.println(s[4]);
		r = Pattern.compile(s[4]);
		m = r.matcher(result);
		if(m.find())
			System.out.println(m.group());
		System.out.println(result);
		
	}

}
