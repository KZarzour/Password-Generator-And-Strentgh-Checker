import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private UserPanel userPanel;

	public MainFrame() {

		super("Ziz Password Services");

		setLayout(new BorderLayout());

		textPanel = new TextPanel();
		userPanel = new UserPanel();
		
		userPanel.setPassRequestListener(new PassRequestListener() {
			public void PassRequestOccured(GeneratePassEvent e) {
				boolean incLower = e.isIncLower();
				boolean incUpper = e.isIncUpper();
				boolean incNum = e.isIncNum();
				boolean incSym = e.isIncSym();
				int length = e.getLength();

				Password p = PasswordRequest(incLower, incUpper, incNum, incSym, length);
				textPanel.appendText(p.toString() + "\n");
			}

		});
		
		
		userPanel.setCheckPassListener(new CheckPassListener() {
			public void CheckPassOccured(CheckPassEvent e) {
				Password p = e.getPass();
				textPanel.appendText(p.CalculateScore() + "\n");
				
			}

		});

		add(userPanel, BorderLayout.WEST);
		add(textPanel, BorderLayout.CENTER);

		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}

	public static Password PasswordRequest(boolean includeLower, boolean includeUpper, boolean includeNum,
			boolean includeSym, int length) {

		// No Box Ticked return empty password
		if (!includeUpper && !includeLower && !includeNum && !includeSym) {
			Password UserPass = new Password("");
			return UserPass;
		}

		Generator G = new Generator(includeUpper, includeLower, includeNum, includeSym);

		Password UserPass = G.GeneratePassword(length);

		return UserPass;
	}
}
