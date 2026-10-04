package individuals;

/**
 * @author ilyas 
 */
import housing.Property;
import main.Account;
import main.Occupation;

public class Managers extends People{
	
	private Account managerAccount;

	/*
	 * public Managers() { managerAccount = new Account(); managerAccount.setId(0);
	 * // Assuming '0' is a valid ID for the manager
	 * managerAccount.setPassword("HALAMADRID!");
	 * managerAccount.getPerson().setFN("Hamza");
	 * managerAccount.getPerson().setLN("Bennani");
	 * managerAccount.getPerson().setOccupation(Occupation.MANAGER); }
	 */
        public boolean HireHouseKeepers(boolean value){
            return value;
        }
	
	
	public boolean Maintain (Property p) {
		p.setIsMaintained(true);
		return true;
	}
	
}