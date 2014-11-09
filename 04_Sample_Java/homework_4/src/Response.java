import java.util.LinkedList;
import java.util.List;

import javax.naming.NameNotFoundException;


public class Response {
	private String statusLine;
	private List<HttpHeader> headers = new LinkedList<HttpHeader>();
	private char[] body;
	public String getStatusLine() {
		return statusLine;
	}
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}
	public List<HttpHeader> getHeaders() {
		return headers;
	}
	public char[] getBody() {
		if(body == null){
			body = new char[getContentLength()];
		}
		return body;
	}
	private int getContentLength(){
		for(HttpHeader next : headers){
			if(next.getName().toLowerCase().equals("content-length")){
				return Integer.parseInt(next.getValue());
			}
		}
		return 0;
	}
	public String getLocation() throws NameNotFoundException{
		for(HttpHeader i : headers){
			if(i.getName().toLowerCase().equals("location"))return i.getValue();
		}
		throw new NameNotFoundException();
	}
}
