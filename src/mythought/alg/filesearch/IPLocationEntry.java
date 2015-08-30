package mythought.alg.filesearch;

public class IPLocationEntry {
	private String beginIP;
	private String endIP;
	private String country;
	private String province;
	private String city;
	
	public IPLocationEntry(String beginIP, String endIP, String country, String province, String city){
		this.beginIP = beginIP;
		this.endIP = endIP;
		this.country = country;
		this.province = province;
		this.city = city;
	}
	
	public String getBeginIP() {
		return beginIP;
	}
	public void setBeginIP(String beginIP) {
		this.beginIP = beginIP;
	}
	public String getEndIP() {
		return endIP;
	}
	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return "IP Range:" + beginIP + "-" + endIP + ",Country:" + country + "Province:" + province + ",City:"+ city;
	}
	

}
