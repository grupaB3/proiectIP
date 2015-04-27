package processToolBar;

public class ProcessScan {

	
		 private EndButton endButton;
		 private NewTaskButton newTaskButton;
		
		protected ProcessScan(){
			endButton=new EndButton();
			newTaskButton=new NewTaskButton();
			
		}
		
		public EndButton getEndButton(){
			return endButton;
		}
		public NewTaskButton getNewTaskButton(){
			return newTaskButton;
		}

}
