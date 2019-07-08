package pucp.gamesoft.rrhh.model;

import java.io.Serializable;

public class Role implements Serializable{
    private String name;
    private float minSalary;
    private float maxSalary;
        
    public Role(){
            
    }
        
    public Role(String name, float minSalary, float maxSalary){
        this.name = name;
        this.minSalary = minSalary;
	this.maxSalary = maxSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(float minSalary) {
        this.minSalary = minSalary;
    }

    public float getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
    }
}