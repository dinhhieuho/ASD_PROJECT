
package creditcard;

import creditcard.controller.CcardController;
import creditcard.ui.CcardGUI;
import framework.Finco;
import framework.ui.GUI;

public class Ccard extends Finco {

	private GUI gui = new CcardGUI(new CcardController(super.getDefaultDBAccess()));

	public static void main(String[] args) {
		Ccard ccard = new Ccard();
		ccard.gui.run();
	}
}
