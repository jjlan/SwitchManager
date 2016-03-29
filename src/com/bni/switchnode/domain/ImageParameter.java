package com.bni.switchnode.domain;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bni.switchnode.constant.BlockConstant;
import com.bni.switchnode.constant.LineConstant;
import com.bni.switchnode.view.Line;

public class ImageParameter { 
	//save all the lines
	public static List<Map<Integer,MyList>> allElements=new ArrayList<Map<Integer,MyList>>();
	//save the fiber level lines
	public static Map<Integer,MyList> fiberMap=new HashMap<Integer,MyList>();
	
	//save the band level lines
	public static Map<Integer,MyList> bandMap=new HashMap<Integer,MyList>();
	//save the length level lines
	public static Map<Integer,MyList> lengthMap=new HashMap<Integer,MyList>();
	//save all the rect 
	public static Map<Integer, MyMap> blockMap=new HashMap<Integer,MyMap>();
	public static Map<Integer,MyMap> PolygonMap=new HashMap<>();
	private static int[] tempPoint=new int[10]; 

	private static List<Line> temp=new ArrayList<Line>();
	
	public static void initImage(){ 
		
		int offset;
		//鐢诲厜绾ょ骇鐭╁舰
		tempPoint[0]=175;//Rect->x 
		tempPoint[1]=15;//Rect->y
		tempPoint[2]=167;//Rect->width
		tempPoint[3]=150;//Rect->height
		tempPoint[4]=20;//arc
		tempPoint[5]=20;//arc
		blockMap.put(BlockConstant.BLOCK_FIBER,new MyMap(tempPoint));
		
		//娉㈠甫绾�

		blockMap.put(BlockConstant.BLOCK_BAND,new MyMap( new int[]{175,300,167,95,20,20}));
		//娉㈤暱绾�
		blockMap.put(BlockConstant.BLOCK_WAVE, new MyMap(new int[]{175,515,167,105,20,20}));
		//TX (195, 660), CPoint(245, 700), CPoint(10, 10)
		blockMap.put(BlockConstant.TX,new MyMap( new int[]{195,660,50,40,10,10}));
		blockMap.put(BlockConstant.RX, new MyMap(new int[]{272,660,50,40,10,10}));
		
		
		//Fiber_IN_1
		FiberAddLine(LineConstant.FIBER_IN_1, 50,65,175,65,  170,60,175,65,  170,70,175,65);
		
		//Fiber_IN_2
		FiberAddLine(LineConstant.FIBER_IN_2, 50,115,175,115,  170,110,175,115,  170,120,175,115);
		//Fiber_IN_3
		FiberAddLine(LineConstant.FIBER_IN_3, 285,200,285,165,  280,170,285,165,  290,170,285,165,  445,275,285,200, 445,325,445,275,  420,325,445,325);
		
		//Fiber_IN_4
		
		FiberAddLine(LineConstant.FIBER_IN_4, 310,165,310,195,  305,170,310,165,  315,175,310,165,  475,275,310,195, 475,370,475,275, 415,370,475,370);
        
		//Fiber_OUT_1 
		
		FiberAddLine(LineConstant.FIBER_OUT_1, 240,165,240,200,  240,200,80,275,   80,275,80,325,  80,325,110,325, 110,325,105,330, 110,325,105,320);
		temp.clear();
		//Fiber_out_2
		FiberAddLine(LineConstant.FIBER_OUT_2, 215, 165,215,195,  215,195, 50, 275,  50, 275, 50, 370,  50, 370, 110, 370,  110, 370, 105, 375,  110, 370, 105, 365);
		
		//Fiber_out_3
		FiberAddLine(LineConstant.FIBER_OUT_3, 342, 65, 452, 65,  447, 60, 452, 65,  447, 70, 452, 65);
		
		//Fiber_out_4
		FiberAddLine(LineConstant.FIBER_OUT_4,342, 115, 452, 115,  447, 110, 452, 115,   447, 120, 452, 115);
		//WSS1

		//AddLine(LineConstant.WSS1, 110,312,110, 338,  110,312,125,307,  110,338,125,343,  125,307,125,343);
		PolygonMap.put(BlockConstant.WSS1, new MyMap( new int[]{ 110,312,110,338, 125,343,125,307}));

		
		//Wave_Band_IN
		BandAddLine(LineConstant.WAVEBAND_IN_1, 125, 316, 175, 316,175, 316, 170, 311,175, 316, 170, 321);
		
		BandAddLine(LineConstant.WAVEBAND_IN_2,125,325 , 175, 325,175,325 , 170, 320,175,325 , 170, 330);

		BandAddLine(LineConstant.WAVEBAND_IN_3, 125,334 , 175, 334,175,334 , 170, 329,175,334 , 170, 339);
		
		//WSS2

		//AddLine(LineConstant.WSS_2, 110,358,110,384,  110,358,125,353,  110,384,125,389,125,353,125,389);
		PolygonMap.put(BlockConstant.WSS2, new MyMap(new int[]{110,358,110,384, 125,389,125,353}));
		

		//WAVE_BAND_IN
		BandAddLine(LineConstant.WAVEBAND_IN_4, 125,362,175,362,  175,362,170,357,  175,362,170,367);
		
		BandAddLine(LineConstant.WAVEBAND_IN_5, 125,371,175,371,  175,371,170,366,  175,371,170,376);
		
		BandAddLine(LineConstant.WAVEBAND_IN_6, 125,380,175,380,  175,380,170,375,  175,380,170,385);
		
		BandAddLine(LineConstant.WAVEBAND_IN_7, 295,395,295,430,   295,430,435,500,  435,500,435, 545,  435, 545,405,545, 295,395,290,400,  295,395,300,400);
		BandAddLine(LineConstant.WAVEBAND_IN_8,320,395,320, 425,   320,425,470,500,  470,500,470,590,   470,590,405,590,  320,395,315,400,  320,395,325,400 );
		
		//鐢讳笁瑙掑舰

		//AddLine(LineConstant.HUB_1, 420,325,375,305,  375,305,375,345,  420,325,375,345);
		//AddLine(LineConstant.HUB_2,420,370,375,350,   375,350,375,390,  420,370,375,390 );
		
		PolygonMap.put(BlockConstant.HUB_1,new MyMap( new int[] {420,325,375,305,375,345,420,325}));
		PolygonMap.put(BlockConstant.HUB_2,new MyMap( new int[]{420,370,375,350,375,390, 420,370}));

		
		
		//WAVE_BAND_OUT
		BandAddLine(LineConstant.WAVEBAND_OUT_1,342,315,375,315,  375,315,370,310,  375,315,370,320);
		BandAddLine(LineConstant.WAVEBAND_OUT_2,342,325,375,325,  375,325,370,320,  375,325,370,330);
		BandAddLine(LineConstant.WAVEBAND_OUT_3,342,335,375,335,  375,335,370,330,  375,335,370,340);
		
		BandAddLine(LineConstant.WAVEBAND_OUT_4,342,360,375,360,  375,360,370,355,  375,360,370,365);
		BandAddLine(LineConstant.WAVEBAND_OUT_5,342,370,375,370,  375,370,370,365,  375,370,370,375);
		BandAddLine(LineConstant.WAVEBAND_OUT_6,342,380,375,380,  375,380,370,375,  375,380,370,385);
		
		BandAddLine(LineConstant.WAVEBAND_OUT_8,200,395,200,425,  200,425,50,500,  50,500,50,590,  50,590,110,590,  110,590,105,585,  110,590,105,595);
		BandAddLine(LineConstant.WAVEBAND_OUT_7, 225,395,225,430,  225,430,80,500,  80,500,80,545,  80,545,110,545,  110,545,105,540,  110,545,105,550);
		
		//DWDM

		PolygonMap.put(BlockConstant.DWDM_1,new MyMap( new int[]{110, 530,110, 560,  130, 565 ,  130, 525}));
		
		PolygonMap.put(BlockConstant.DWDM_2, new MyMap(new int[]{110, 530+45,110,560+45,   130,565+45,130,525+45}));

		PolygonMap.put(BlockConstant.DWDM_3, new MyMap(new int[]{385,525,385,565,   405,560,405,530}));
		
		PolygonMap.put(BlockConstant.DWDM_4, new MyMap(new int[]{385,525+45,385,565+45,   405,560+45,405,530+45}));
		
		
		//WAVELENGTH_  
		LengthAddLine(LineConstant.WAVELENGTH_IN_1, 130,535,175,535,  175,535,170,530,  175,535,170,540);
		LengthAddLine(LineConstant.WAVELENGTH_IN_2, 130,545,175,545,  175,545,170,540,  175,545,170,550);
		LengthAddLine(LineConstant.WAVELENGTH_IN_3, 130,555,175,555,  175,555,170,550,  175,555,170,560);
		

		LengthAddLine(LineConstant.WAVELENGTH_IN_4, 130,580,175,580,  175,580,170,575,  175,580,170,585);
		LengthAddLine(LineConstant.WAVELENGTH_IN_5, 130,590,175,590,  175,590,170,585,  175,590,170,595);
		//AddLine(LineConstant.WAVELENGTH_IN_6, 130,600,175,600,  175,600,170,595,  175,600,170,605);

		LengthAddLine(LineConstant.WAVELENGTH_IN_4, 130,580,175,580,  175,580,170,575,  175,580,170,585);
		LengthAddLine(LineConstant.WAVELENGTH_IN_5, 130,590+10,175,590+10,  175,590+10,170,585+10,  175,590+10,170,595+10);
		LengthAddLine(LineConstant.WAVELENGTH_IN_6, 130,600,175,600,  175,600,170,595,  175,600,170,605);


		LengthAddLine(LineConstant.WAVELENGTH_IN_6, 205,620,205,660,  205,620,200,625,  205,620,210,625);
		offset=15;
		LengthAddLine(LineConstant.WAVELENGTH_IN_7, 205+offset,620,205+offset,660,  205+offset,620,200+offset,625,  205+offset,620,210+offset,625);
		LengthAddLine(LineConstant.WAVELENGTH_IN_8, 205+offset*2,620,205+offset*2,660,  205+offset*2,620,200+offset*2,625,  205+offset*2,620,210+offset*2,625);
		
		
		LengthAddLine(LineConstant.WAVELENGTH_OUT_1, 342,535,385,535,  385,535,380,530,  385,535,380,540);
		offset=10;
		LengthAddLine(LineConstant.WAVELENGTH_OUT_2, 342,535+offset,385,535+offset,  385,535+offset,380,530+offset,  385,535+offset,380,540+offset);
		LengthAddLine(LineConstant.WAVELENGTH_OUT_3, 342,535+offset*2,385,535+offset*2,  385,535+offset*2,380,530+offset*2,  385,535+offset*2,380,540+offset*2);
		
		LengthAddLine(LineConstant.WAVELENGTH_OUT_4, 342,580,385,580,  385,579,380,574,  385,570+9,380,570+9+5);
		LengthAddLine(LineConstant.WAVELENGTH_OUT_5, 342,590+10,385,590+10,  385,590+10,380,585+10,  385,590+10,380,595+10);
		LengthAddLine(LineConstant.WAVELENGTH_OUT_8, 280, 620,280,660, 280,660,275,655,  280,660,285,655);
		
		offset=15;
		LengthAddLine(LineConstant.WAVELENGTH_OUT_7, 280+offset, 620,280+offset,660, 280+offset,660,275+offset,655,  280+offset,660,285+offset,655);
		LengthAddLine(LineConstant.WAVELENGTH_OUT_6, 280+offset*2, 620,280+offset*2,660, 280+offset*2,660,275+offset*2,655,  280+offset*2,660,285+offset*2,655);

		allElements.add(fiberMap);
		allElements.add(bandMap);
		allElements.add(lengthMap);
	}
		
	private static void FiberAddLine(int name,int ...it) {
		temp.clear();
		if(it.length==12)
		{
			for(int i=0;i<12;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}
		else if(it.length==16) {
			for(int i=0;i<16;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}else if (it.length==24) {
			for(int i=0;i<24;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		}
		fiberMap.put(name, new MyList(new ArrayList<>(temp)));
		
	}
	private static void BandAddLine(int name,int ...it) {
		temp.clear();
		if(it.length==12)
		{
			for(int i=0;i<12;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}
		else if(it.length==16) {
			for(int i=0;i<16;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}else if (it.length==24) {
			for(int i=0;i<24;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		}
		bandMap.put(name,new MyList(  new ArrayList<>(temp)));
		
	}
	private static void LengthAddLine(int name,int ...it) {
		temp.clear();
		if(it.length==12)
		{
			for(int i=0;i<12;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}
		else if(it.length==16) {
			for(int i=0;i<16;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		
		}else if (it.length==24) {
			for(int i=0;i<24;i=i+4)
				temp.add(new Line(it[i], it[i+1], it[i+2], it[i+3]));
		}
		lengthMap.put(name, new MyList( new ArrayList<>(temp)));
		
	}
    
}
