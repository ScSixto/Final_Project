package models;

import java.util.ArrayList;

public class ModelManager {
	
	private ArrayList<Content> contentList;
	
	public ModelManager() {
		contentList = new ArrayList<>();
	}

	public ArrayList<Content> getContentList() {
		return contentList;
	}

	public void addContent(Content content){
		this.contentList.add(content);
	}
	
	public void showReport(){
		for (Content content : contentList) {
			System.out.println(content.getId() + ". " + content.getName());
		}
	}
}
