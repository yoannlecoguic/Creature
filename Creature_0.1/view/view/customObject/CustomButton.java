package view.customObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class CustomButton extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		//VIEW OBJECT
			private JLabel label;
		//END VIEW OBJECT
		
		private String image_out;
		private String image_in;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public CustomButton(Dimension size, Dimension position){
			super();
			//SET SIZE AND POSITION
				this.setSize(size.width,size.height);
				this.setPosition(position.width, position.height);
				this.setImageSize(size.width,size.height);
				this.setImagePosition(0,0);
				
			//ADD COMPONENT
				this.label = new JLabel();
				this.label.setBounds(12, 1, size.width, size.height);
				Font font = new Font("Arial", Font.TRUETYPE_FONT, 16);
				this.label.setFont(font);
				this.add(this.label);
			
			this.paint();
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		//STRING
			public JLabel getLabel(){
				return this.label;
			}
		
			public String getText(){
				return this.label.getText();
			}
			
			public String getImageIn(){
				return this.image_in;
			}
			
			public String getImageOut(){
				return this.image_out;
			}
		//END STRING
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		//STRING
			public void setText(String text){
				this.label.setText(text);
			}
			
			public void setImageOut(String image){
				this.image_out = image;
			}
			
			public void setImageIn(String image){
				this.image_in = image;
			}
		//END STRING
	//END SETTER
//---------------------------------------------------------------------------
	//EVENTS HANDLER
	//END EVENTS HANDLER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
