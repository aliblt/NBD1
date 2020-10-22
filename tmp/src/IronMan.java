public class IronMan {

    String name;
    String familyName;
    public IronMan(Billionaire b){
        name = b.name;
        familyName = b.familyName;
    }

    public void printNameOfOwner() {
        System.out.println("Iron Man Wins!");
    }

    public void attack( Enemy e ){
        System.out.println(e.getName() + " defeated!");
    }
}
