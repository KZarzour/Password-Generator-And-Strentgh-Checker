import java.util.EventObject;

public class GeneratePassEvent extends EventObject {

	private boolean incLower;
	private boolean incUpper;
	private boolean incNum;
	private boolean incSym;
	private int length;

	public GeneratePassEvent(Object source) {
		super(source);

	}

	public GeneratePassEvent(Object source, boolean incLower, boolean incUpper, boolean incNum, boolean incSym, int length) {
		super(source);

		this.incLower = incLower;
		this.incUpper = incUpper;
		this.incNum = incNum;
		this.incSym = incSym;
		this.length = length;
	}

	public boolean isIncLower() {
		return incLower;
	}

	public boolean isIncUpper() {
		return incUpper;
	}

	public boolean isIncSym() {
		return incSym;
	}

	public boolean isIncNum() {
		return incNum;
	}

	public int getLength() {
		return length;
	}

}
