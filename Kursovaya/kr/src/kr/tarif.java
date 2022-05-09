package kr;

public class tarif {
	private String id;
    private String name;
    private String speed;
    private String price;
    
    public tarif(){ }
    public tarif(String id, String name,String speed,String price){
    	this.id=id;
    	this.name = name;
        this.speed = speed;
        this.price=price;
    }
    public  String getID() {
        return id;
    }
    public  void setID(String id) {
         this.id=id;
    }
    public  String getName() {
        return name;
    }
    public  void setName(String name) {
         this.name=name;
    }
    public  String getSpeed() {
        return speed;
    }
    public  void setSpeed(String speed) {
         this.speed=speed;
    }
    public  String getPrice() {
        return price;
    }
    public  void setPrice(String price) {
         this.price=price;
    }
}
