package model;

public enum LEVEL {

	LAZY("view/resources/levelchooser/lazy.png"),
	AVERAGE("view/resources/levelchooser/average.png"),
	CRAZY("view/resources/levelchooser/crazy.png");
	
	
	private String urlLevel;
	
	private LEVEL(String urlLevel) {
		this.urlLevel= urlLevel;
	}
	
	public String getUrl() {
		return this.urlLevel;
	}
}
