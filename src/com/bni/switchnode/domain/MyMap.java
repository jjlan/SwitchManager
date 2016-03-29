package com.bni.switchnode.domain;

import java.awt.Color;
import java.util.Map;

import com.bni.switchnode.constant.LineConstant;

public class MyMap {
	int [] t;
	public int[] getT() {
		return t;
	}
	public void setT(int[] t) {
		this.t = t;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	Color color=LineConstant.usingColor;
	public MyMap(int[] m ){
		t=m;
	}
	
}
