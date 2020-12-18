package Deleted_Discarded;

public enum LEVEL {

	LAZY("view/ViewResources/levelchooser/lazy.png"),
	AVERAGE("view/ViewResources/levelchooser/average.png"),
	CRAZY("view/ViewResources/levelchooser/crazy.png");
	
	
	private String urlLevel;
	
	private LEVEL(String urlLevel) {
		this.urlLevel= urlLevel;
	}
	
	public String getUrl() {
		return this.urlLevel;
	}
	
	public String getLevel() {
		return this.name();
	}
}
