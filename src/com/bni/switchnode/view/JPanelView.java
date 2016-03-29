
package com.bni.switchnode.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.TextField;
import java.awt.color.ColorSpace;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.bni.switchnode.constant.BlockConstant;
import com.bni.switchnode.constant.NetConstant;
import com.bni.switchnode.domain.ImageParameter;
import com.bni.switchnode.domain.MyList;
import com.bni.switchnode.domain.MyMap;

public class JPanelView extends JPanel{
	
	public JPanelView() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawOriginalImage(g);
	}
	//draw the original Image
    private void drawOriginalImage(Graphics g){
    //	g.setColor(new Color(0,0,0));
    	((Graphics2D) g).setStroke(new BasicStroke(3.0f));
    	List<Map<Integer,MyList>> allElements=ImageParameter.allElements;
    	for(Map<Integer,MyList> map:allElements){
        	java.util.Iterator<Entry<Integer,MyList>> iter=map.entrySet().iterator();
        	while(iter.hasNext()){
        		Map.Entry<Integer, MyList>entry=iter.next();
        		List<Line> lines=entry.getValue().getLists();
        		g.setColor(entry.getValue().getColor());
        		for(Line line:lines){
        			
        			g.drawLine(line.getStart().x, line.getStart().y, line.getEnd().x, line.getEnd().y);
        		}
        	}
    	}
    	//draw all the rect blocks
    	Map<Integer,MyMap> blockMap=ImageParameter.blockMap;  	
    	java.util.Iterator<Entry<Integer, MyMap>> iter=blockMap.entrySet().iterator();
    	
        while(iter.hasNext()){
          Map.Entry<Integer, MyMap>entry=iter.next();
            int[] values=entry.getValue().getT();
            g.setColor(entry.getValue().getColor());
        	g.fillRoundRect(values[0], values[1], values[2], values[3], values[4], values[5]);
        }
        
        Map<Integer,MyMap> PolygonMap=ImageParameter.PolygonMap;  	
    	java.util.Iterator<Entry<Integer, MyMap>> iterPolygon=PolygonMap.entrySet().iterator();
        while(iterPolygon.hasNext()){
          Map.Entry<Integer, MyMap>entry=iterPolygon.next();
            int[] values=entry.getValue().getT();
            Polygon filledPolygon=new Polygon();   
            
            if(values.length==6){
            	for(int i=0;i<6;i+=2)
            	filledPolygon.addPoint(values[i],values[i+1]);   
            }
            else if(values.length==8) {
            	for(int i=0;i<8;i+=2)
                	filledPolygon.addPoint(values[i],values[i+1]); 
			}
            g.setColor(entry.getValue().getColor());
            g.fillPolygon(filledPolygon);
        	
        }
       
    }

}
