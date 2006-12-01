public class GraphException extends Exception {
	String errorMsg;
	public GraphException()	{
		this.errorMsg = "Not set";
	}

	public GraphException(String msg){
		this.errorMsg = msg;
	}

	public String getError() {
		return this.errorMsg;
	}
}
