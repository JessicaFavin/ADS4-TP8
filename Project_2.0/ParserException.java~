public class ParserException extends Exception {
	private int pos;


    public ParserException(String s, int pos) {
		super(s);
		this.pos=pos;
    }
	public int getPos(){
		return this.pos;
	}

	@Override
	public String getLocalizedMessage(){
		return "\nError at position "+pos+"\n"+super.getLocalizedMessage();
	}
}
