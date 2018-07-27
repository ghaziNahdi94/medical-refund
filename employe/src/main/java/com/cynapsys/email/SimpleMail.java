package com.cynapsys.email;

public class SimpleMail {

    private final String to;
    private String Subject;
    private String Content;
    
    public SimpleMail(String to) {
        this.to = to;
    }

    public String getTo() {
        return this.to;
    }

    public String getSubject() {
        return this.Subject;
    }

    public String getContent() {
        return this.Content;
    }

	public void setSubject(String subject) {
		Subject = subject;
	}

	public void setContent(String content) {
		Content = content;
	}
    
    
    
}
