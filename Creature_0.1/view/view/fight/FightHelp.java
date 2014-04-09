package view.fight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;

import mode.customObject.LimitedText;
import view.customObject.BackgroundPanel;
import controller.listener.NightWatcher;

public class FightHelp extends BackgroundPanel{
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
	//VARIABLE
		//VIEW OBJECT
			private JTextPane text_pane;
		//END VIEW OBJECT
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
	public FightHelp(Dimension resolution, NightWatcher watcher){
		this.setEventID("help");
		this.setWatcher(watcher);
		
		//SET SIZE AND POSITION
			this.setSize(350,120);
			this.setPosition(0, resolution.height-this.getPanelSize().height-28);
			this.setImageSize(350,120);
			this.setImagePosition(0,0);
		
		//SET GRAPHICS OPTIONS
			this.setImage("bg_help.png");
			this.setOpaque(false);
		
		//ADD COMPONENT
			this.text_pane = new JTextPane();
		
		//SET COMPONENT GRAPHIC
			text_pane.setBounds(35, 30, 280, 60);
			Font font = new Font("Arial", Font.TRUETYPE_FONT, 16);
			text_pane.setFont(font);
			this.text_pane.setForeground(new Color(17,204,211));
			text_pane.setOpaque(false);
			text_pane.setEditable(false);
			this.add(text_pane);
		
		this.paint();
	}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setText(String text){
			this.text_pane.setText(text);
		}
	//END SETTER
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}