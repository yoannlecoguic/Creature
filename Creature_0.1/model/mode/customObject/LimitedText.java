package mode.customObject;

public class LimitedText {
//---------------------------------------------------------------------------
	//VARIABLE
		private String text;
		private String buffer;
	//END VARIABLE
//---------------------------------------------------------------------------
	//CONSTRUCTOR
		public LimitedText(){
			this.text = "";
			this.buffer = "";
		}
	//END CONSTRUCTOR
//---------------------------------------------------------------------------
	//GETTER
		public String getText(){
			return this.text;
		}
		
		public String getBuffer(){
			return this.buffer;
		}
	//END GETTER
//---------------------------------------------------------------------------
	//SETTER
		public void setText(String text){		
			this.text = text;
			this.buffer = "";
			this.limitWordSize();
			this.limitTextSize();
		}
		
		public void setBuffer(String text){
			this.buffer = text;
		}
	//END SETTER
//---------------------------------------------------------------------------
	//VERIFICATION
		public void update(){
			this.text = this.buffer;
			this.buffer = "";
			this.limitTextSize();
		}
		
		public void limitWordSize(){
			String[] array = this.text.split(" ");
			StringBuffer valid = new StringBuffer();
			
			for(String word : array){
				if(word.length()>30){
					word = word.substring(0,30);
					word = word + "[..]";
				}
				valid.append(word+" ");
			}
			this.text = valid.toString();
		}
		
		public void limitTextSize(){
			if(this.text.length() > 150){
				this.buffer = this.text.substring(150);
				this.text = this.text.substring(0,150);
				/*if(this.isEmpty() == false){
					this.text = this.text + "[...]";
				}*/
			}
		}
		
		public boolean isEmpty(){
			if(this.buffer == null || this.buffer.equals("") || this.buffer.length() == 0){
				return true;
			}else{
				return false;
			}
		}
	//END VERIFICATION
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
}
