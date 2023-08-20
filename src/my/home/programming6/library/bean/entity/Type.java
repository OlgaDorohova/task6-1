package my.home.programming6.library.bean.entity;

public enum Type {
	PAPER("paper"), EBOOK("eBook");

	private String typeName;

	private Type(String typename) {
		this.typeName = typename;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public static Type parseType(String type) {
		if(type.equalsIgnoreCase("eBook")) {
			return Type.EBOOK;
		}
		return Type.PAPER;
	}
}
