package kr;

public class users {
	private String id;
    private String surname;
    private String name;
    private String adres;
    private String email;
    private String telnumb;
    private String password;
    private String role;

    public users(){ }
    public users(String id,String surname,String name,String adres,String email, 
    String telnumb,String password,String role){
    	this.id=id;
    	this.surname = surname;
        this.name = name;
        this.adres=adres;
        this.email = email;
        this.telnumb=telnumb;
        this.password=password;
        this.role=role;  
    }
    public  String getID() {
        return id;
    }
    public  void setID(String id) {
         this.id=id;
    }
    public  String getSurname() {
        return surname;
    }
    public  void setSurname(String surname) {
         this.surname=surname;
    }
    public String getName() {
        return name;
    }
    public  void setName(String name) {
        this.name=name;
   }
    public  String getAdres() {
        return adres;
    }
    public  void setAdres(String adres) {
        this.adres=adres;
   }
    public  String getEmail() {
        return email;
    }
    public  void setEmail(String email) {
        this.email=email;
   }
    public  String getTelnumb() {
        return telnumb;
    }
    public  void setTelnumb(String telnumb) {
        this.telnumb=telnumb;
   }
    public  String getPassword() {
        return password;
    }
    public  void setPassword(String password) {
        this.password=password;
   }
    public  String getRole() {
        return role;
    }
    public  void setRole(String role) {
        this.role=role;
   }
    
}
