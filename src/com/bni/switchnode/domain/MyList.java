package com.bni.switchnode.domain;

import java.awt.Color;
import java.util.List;

import com.bni.switchnode.constant.LineConstant;
import com.bni.switchnode.view.Line;

public class MyList {
	Color color=LineConstant.usingColor;
	List<Line> lists;
	public List<Line> getLists() {
		return lists;
	}
	public void setLists(List<Line> lists) {
		this.lists = lists;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public MyList(List<Line> lines){
		this.lists=lines;
		
	}
	
}
