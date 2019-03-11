package model;

public class Client {
	
	private int id;
	private String[] isbnList;
	
	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getIsbnList() {
		return isbnList;
	}

	public void setIsbnList(String isbnList[]) {
		this.isbnList = isbnList;
	}

}
