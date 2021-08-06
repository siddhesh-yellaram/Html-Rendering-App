package com.techlab.model;

import java.util.*;

public class Element implements StorageItem {
	private String name;
	private List<StorageItem> children;
	private int depth;
	private StringBuilder str = new StringBuilder();
	private String openingTag;
	private String closingTag;
	private String content;

	public Element(String name) {
		this.name = name;
		this.children = new ArrayList<StorageItem>();
		this.depth = 0;
		this.openingTag = "<" + this.name + ">";
		this.closingTag = "</" + this.name + ">";
		this.content = "";
	}

	public Element(String name, String content) {
		this.name = name;
		this.children = new ArrayList<StorageItem>();
		this.depth = 0;
		this.content = content;
		this.openingTag = "<" + this.name + ">" + "\n             ";
		this.closingTag = "</" + this.name + ">";
	}

	public void addChild(StorageItem s) {
		s.setDepth(this.getDepth() + 1);
		this.children.add(s);

	}

	@Override
	public String display() {
		for (int i = 0; i < depth; i++)
			str.append("    ");
		this.str.append(this.openingTag);
		this.str.append(this.content);
		this.str.append(System.getProperty("line.separator"));
		for (StorageItem s : this.children) {
			this.str.append(s.display());
		}
		for (int i = 0; i < depth; i++)
			str.append("    ");
		this.str.append(this.closingTag);
		this.str.append(System.getProperty("line.separator"));
		return str.toString();
	}

	public String getName() {
		return name;
	}

	public List<StorageItem> getChild() {
		return children;
	}

	@Override
	public int getDepth() {
		return this.depth;
	}

	@Override
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
