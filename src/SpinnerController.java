import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerController implements ChangeListener{
	@Override
	public void stateChanged(ChangeEvent eventSource) {
		
		if(eventSource.getSource() instanceof JSpinner){
			JSpinner spinnerSource = (JSpinner)eventSource.getSource();
			
			/**
			 * Prevents spinners from going into the negatives.
			 */
			if( ((Integer)spinnerSource.getValue()) < 0 )
				spinnerSource.setValue(0);
			
			if( ((Integer)spinnerSource.getValue()) > 9 )
				spinnerSource.setValue(9);
		 	
			spinnerSource.repaint();
		}
		
	}
}
