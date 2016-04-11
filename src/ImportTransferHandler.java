import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JList;
import javax.swing.TransferHandler;

/**
 * Specifies a JList as Transferable
 *
 */
public class ImportTransferHandler extends TransferHandler{

    /**
	 * Fixing serial warning
	 */
	private static final long serialVersionUID = -4878266806869912463L;

	public boolean canImport(TransferHandler.TransferSupport supp) {
        if (!supp.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }
 
    public boolean importData(TransferHandler.TransferSupport supp) {
        // Fetch the Transferable and its data
        Transferable t = supp.getTransferable();
        String data = "";
        try {
            data = (String)t.getTransferData(DataFlavor.stringFlavor);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        // Fetch the drop location
        JList.DropLocation loc = target.getDropLocation();
        int row = loc.getIndex();
        model.add(row, data);
        target.validate();
        return true;
    }
    
}
