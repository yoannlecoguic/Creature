package view.customObject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.listener.ListenerPanel;

public class BackgroundPanel extends ListenerPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		private BufferedImage image;
		private String image_path;

		private Dimension panelSize;
		private Dimension panelPosition;
		
		private Dimension imageSize;
		private Dimension imagePosition;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public BackgroundPanel(){
			super();
			
			this.panelPosition = new Dimension(0,0);
			this.imagePosition = new Dimension(0,0);
			this.setLayout(null);
		}
		
		public void paint(){
			this.setBounds(this.panelPosition.width,this.panelPosition.height,this.panelSize.width,this.panelSize.height);
			this.setPreferredSize(this.panelSize);
		}
		
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    if(this.image != null && this.imageSize.width != 0 && this.imageSize.height != 0){
		    	g.drawImage(this.image,this.imagePosition.width,this.imagePosition.height,this.imageSize.width,this.imageSize.height,this);
		    }
		  }
	//END CONSTRUCTOR
//---------------------------------------------------------------------------		
		//GETTER
			//SIZE
				public Dimension getPanelSize(){
					return this.panelSize;
				}
				
				public Dimension getImageSize(){
					return this.imageSize;
				}
			//END SIZE
				
			//POSITION
				public Dimension getPanelPosition(){
					return this.panelPosition;
				}
				
				public Dimension getImagePosition(){
					return this.imagePosition;
				}
			//END POSITION
		//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		//IMAGE
			public void setImage(String image_to_load){
				image_path = "img/"+image_to_load;
				try { 
					this.image = ImageIO.read(new File(image_path));
					this.repaint();
				}catch(IOException e)
				{ 
					System.out.println("Image not found");
				}	
			}
		//END IMAGE
		
		//POSITION
			public void setPosition(int x, int y){
				this.panelPosition = new Dimension(x,y);
			}
			
			public void setImagePosition(int x, int y){//0;0 for a background image
				this.imagePosition = new Dimension(x,y);
			}
		//END POSITION
		
		//SIZE
			public void setSize(int w, int h){
				this.panelSize = new Dimension(w,h);
			}
			
			public void setImageSize(int w, int h){
				this.imageSize = new Dimension(w,h);
			}
		//END SIZE
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
