import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class UserPanel extends JPanel{

	
	private JButton okBtn;
	private JButton testBtn;
	private PassRequestListener passRequestListener;
	private CheckPassListener checkPassListener;
	private JCheckBox useUpper;
	private JCheckBox useLower;
	private JCheckBox useNum;
	private JCheckBox useSym;
	private JComboBox lengthChoice;
	private JLabel PassLabel;
	private JTextField PassField;
	
	
	public UserPanel() {
		
		Dimension dim= getPreferredSize();
		dim.width=330;
		setPreferredSize(dim);
	
		
		useLower= new JCheckBox();
		useUpper= new JCheckBox();
		useNum= new JCheckBox();
		useSym= new JCheckBox();
		lengthChoice=new JComboBox();
		PassLabel=new JLabel("Password: ");
		PassField=new JTextField(10);
				
		PassField.setPreferredSize(new Dimension(100,25));
		//Setup Combo box
		DefaultComboBoxModel sizeModel=new DefaultComboBoxModel();
		
		for (int i=1;i<=100;i++) {
			sizeModel.addElement(i);

		}
		
		lengthChoice.setModel(sizeModel);
		lengthChoice.setSelectedIndex(0);
	//	lengthChoice.setEditable(false); Was true but changed so no invalid input can be given
		
		
		//Setup Button for password generation
		okBtn=new JButton("Generate Pasword");
		
		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean incLower=useLower.isSelected();
				boolean incUpper=useUpper.isSelected();
				boolean incNum=useNum.isSelected();
				boolean incSym=useSym.isSelected();
				
				int length=(int)lengthChoice.getSelectedItem();
				
				
				GeneratePassEvent ev=new GeneratePassEvent(this,incLower,incUpper,incNum,incSym,length);
				
				if (passRequestListener!=null) {
					passRequestListener.PassRequestOccured(ev);
				}
			}
			
		});
		
		
		//Setup Button for Password strength check
		testBtn=new JButton("Test");
		
		testBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Password P=new Password(PassField.getText());
								
				CheckPassEvent ev=new CheckPassEvent(this,P);
				
				if (passRequestListener!=null) {
					checkPassListener.CheckPassOccured(ev);
				}
			}
			
		});
		
		Border innerBorder=BorderFactory.createTitledBorder("Password");
		Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents();
	}
	
	public void layoutComponents() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc= new GridBagConstraints();
		
		
		////////////First Row///////////////
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(new JLabel("Password Generator"),gc);
		
		////////////Next Row///////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(new JLabel("Use Lowercase Letters (abcd...): "),gc);
		
		
		gc.gridx=1;
		
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(useLower,gc);
		
		
		////////////Next Row////////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(new JLabel("Use Uppercase Letters (ABCD...): "),gc);
		
		
		gc.gridx=1;
		
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(useUpper,gc);
		
		
		////////////Next Row////////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(new JLabel("Use Numbers (1234...): "),gc);
		
		
		gc.gridx=1;
		
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(useNum,gc);
		
		
		////////////Next Row////////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.1;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_END;
		gc.insets=new Insets(0,0,0,0);
		add(new JLabel("Use Symbols (!@#$...): "),gc);
		
		
		gc.gridx=1;
		
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(useSym,gc);
		
		////////////Next Row////////////////
		
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridx=0;
		gc.insets=new Insets(0,0,0,5);
		gc.anchor=GridBagConstraints.FIRST_LINE_END;

		add(new JLabel("Length:  "),gc);
		
		
		gc.gridx=1;
		
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(lengthChoice,gc);
		
		
		
		////////////Next Row////////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridx=0;
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.insets=new Insets(0,80,0,0);
		gc.anchor=GridBagConstraints.CENTER;
		add(okBtn,gc);
	
		
		
		////////////Next Row///////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridx=0;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,5);
		add(new JLabel("Password Strength Check"),gc);
		
		////////////Next Row////////////////
		gc.gridy++;
		
		gc.weightx=1;
		gc.weighty=0.1;
		
		
		gc.gridx=0;
		
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.fill= GridBagConstraints.HORIZONTAL;
		gc.insets=new Insets(0,0,0,0);
		add(PassLabel,gc);
		
		gc.gridx=1;
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		gc.insets=new Insets(0,0,0,0);
		add(PassField,gc);
		
		
		////////////Next Row////////////////
		gc.gridy++;
		gc.weightx=1;
		gc.weighty=0.2;
		
		gc.gridx=0;
		
		gc.fill=GridBagConstraints.HORIZONTAL;
		gc.insets=new Insets(0,80,0,0);
		gc.anchor=GridBagConstraints.CENTER;
		add(testBtn,gc);
	
		
		
		
	}
	
	
	
	public void setPassRequestListener(PassRequestListener listener){
		this.passRequestListener=listener;
	}
	
	public void setCheckPassListener(CheckPassListener listener){
		this.checkPassListener=listener;
	}
}


