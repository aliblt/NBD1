public class Enemy {

    String name;

    public Enemy(String _name){
        name = _name;
    }

    public void makeEvilIntroduction() {
        System.out.println("I'm " + name);
    }

    public void attack(Billionaire b){
        int a = (int) (Math.random()*2);
        if( a == 1 )
            b.setDanger(true);
    }

    public String getName() {
        return name;
    }
}
