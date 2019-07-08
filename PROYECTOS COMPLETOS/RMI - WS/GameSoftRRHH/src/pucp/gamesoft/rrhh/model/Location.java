package pucp.gamesoft.rrhh.model;

public class Location{
	private String address;
	private String postalCode;
	private String city;
	private String province;
	private Country country;
	
	public Location(String address, String postalCode, String city, String province, Country country){
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
		this.country = country;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getPostalCode(){
		return postalCode;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public String getProvince(){
		return province;
	}
	
	public void setProvince(String province){
		this.province = province;
	}
}