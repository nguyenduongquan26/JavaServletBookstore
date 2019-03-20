package model;

public class Category implements Entity {
private int id;
private String name;
private Integer parent;
private String parentName;
public Category(int id, String name, Integer parent, String parentName) {
	this.id = id;
	this.name = name;
	this.parent = parent;
	this.parentName = parentName;
}

public Category(int id, String name, Integer parent) {
	this.id = id;
	this.name = name;
	this.parent = parent;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getParent() {
	return parent;
}
public void setParent(Integer parent) {
	this.parent = parent;
}
public String getParentName() {
	return parentName;
}
public void setParentName(String parentName) {
	this.parentName = parentName;
}

}
