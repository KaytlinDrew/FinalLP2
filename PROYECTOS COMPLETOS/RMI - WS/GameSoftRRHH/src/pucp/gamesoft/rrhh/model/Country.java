package pucp.gamesoft.rrhh.model;

public class Country{
	private String name;
	private Region region;
	public Country(String name){
		this.name = name;
	}
	public Country(String name, Region region){
		this.name = name;
		this.region = region;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Region getRegion(){
		return region;
	}
	public void setRegion(Region region){
		this.region = region;
	}
}