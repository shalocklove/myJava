package Intact;

public class Bean {
	private String Mark;
	private String IRN;
	private String Origin;
	private String Holder;
	private String Transacition;
	private String Gazette;
	public String getMark() {
		return Mark;
	}
	public void setMark(String mark) {
		Mark = mark;
	}
	public String getIRN() {
		return IRN;
	}
	public void setIRN(String iRN) {
		IRN = iRN;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getHolder() {
		return Holder;
	}
	public void setHolder(String holder) {
		Holder = holder;
	}
	public String getTransacition() {
		return Transacition;
	}
	public void setTransacition(String transacition) {
		Transacition = transacition;
	}
	public String getGazette() {
		return Gazette;
	}
	public void setGazette(String gazette) {
		Gazette = gazette;
	}
	public String toString(){
		String str = "";
		str = Mark + "  " + IRN + "  " + Origin + "  " + Holder + "  " + Transacition + "  " + Gazette;
		return str;
	}
	
}
