package com.bni.switchnode.view;

import java.awt.Color;
import java.awt.Point;

/*
 * define Line
 */
public class Line { 
	private LPoint startPoint;
	private LPoint endPoint;

	public Line(LPoint start,LPoint end,Color c){
	    this.startPoint=start;
	    this.endPoint=end;

	}
	public Line(int start_x,int start_y,int end_x,int end_y){
		startPoint=new LPoint();
		endPoint=new LPoint();
		startPoint.x=start_x;
		startPoint.y=start_y;
		endPoint.x=end_x;
		endPoint.y=end_y;
	}
	public LPoint getStart() {
		return startPoint;
	}
	public void setStart(LPoint start) {
		this.startPoint = start;
	}
	public LPoint getEnd() {
		return endPoint;
	}
	public void setEnd(LPoint end) {
		this.endPoint = end;
	}
	
	 static class LPoint{
		int x;
		int y;
	}
}
