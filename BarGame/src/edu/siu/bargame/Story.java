package edu.siu.bargame;

public class Story {
	protected String forestConversations[] = {"Conversation1", "Conversation2", "Conversation3", "Conversation4"};
	protected String story[];
	public String[] getForestConversations() {
		return forestConversations;
	}
	public void setForestConversations(String[] forestConversations) {
		this.forestConversations = forestConversations;
	}
	public String[] getStory() {
		return story;
	}
	public void setStory(String[] story) {
		this.story = story;
	}

}