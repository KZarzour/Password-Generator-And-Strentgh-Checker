import java.util.EventListener;

public interface PassRequestListener extends EventListener{
	public void PassRequestOccured(GeneratePassEvent e);
}
