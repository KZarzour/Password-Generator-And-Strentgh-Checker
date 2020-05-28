import java.util.EventObject;

public class CheckPassEvent extends EventObject {

	private Password pass;

	public CheckPassEvent(Object source) {
		super(source);

	}

	public CheckPassEvent(Object source, Password P) {
		super(source);

		this.pass=P;
	}

	public Password getPass() {
		return pass;
	}

	

}
