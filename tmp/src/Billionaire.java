import java.math.BigDecimal;
import java.math.BigInteger;

public class Billionaire{

    String name;
    String familyName;
    BigInteger money;
    Boolean danger;

    public Billionaire(String _name, String _familyName) {
        name = _name;
        familyName = _familyName;
        danger = false;
    }

    public void goParty() {
        System.out.println("Party Time!");
    }


    public void setDanger(Boolean danger) {
        this.danger = danger;
    }

    public boolean isInDanger(){
        return danger;
    }
}