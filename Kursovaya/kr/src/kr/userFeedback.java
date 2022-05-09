package kr;

public class userFeedback {
	private String id;
    private String name;
    private String email;
    private String question;
    private String answer;
    
    public userFeedback(){ }
    public userFeedback(String id, String name,String email,String question, String answer){
    	this.id=id;
    	this.name = name;
        this.email = email;
        this.question=question;
        this.answer=answer;
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
    public  String getEmail() {
        return email;
    }
    public  void setEmail(String email) {
         this.email=email;
    }
    public  String getQuestion() {
        return question;
    }
    public  void setQuestion(String question) {
         this.question=question;
    }
    public  String getAnswer() {
        return answer;
    }
    public  void setAnswer(String answer) {
         this.answer=answer;
    }
}
