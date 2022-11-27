package charts;

import java.util.List;
import java.util.Arrays;

public abstract class Unit implements UnitInterface {
    private int attack;
    private int protect;
    private int shoot;
    private int[] damage;
    protected float health;
        protected int maxHealth;
    protected int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
        private String status;
    private static int idCounter;
    private int playerID;
    protected List<Unit> gang;
    protected Vector2 position;

    public Unit(int attack, int protect, int shoot, int[] damage, float health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.protect = protect;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        playerID = idCounter++;
    }

    public Vector2 getPosition(){return position;}

    public int getPlayerID(){
        return playerID;
    }

    public float getHealth() {return health;}

    public String getName() {return name;}

    public String getCharacter() {return name + " A:" + attack + ", P:" + protect + ", Dmg:" + Arrays.toString(damage) + ", HP:" + health + ", S:" + speed + ", D:" + delivery + ", M:" + magic;}

    @Override
    public String getInfo(){
        return "Attack:" + attack + ", Protection:" + protect + ", Damage:" + Arrays.toString(damage) + ", Health:" + health + ", Speed:" + speed + ", Delivery:" + delivery + ", Magic:" + magic;
    }

    @Override
    public void step(List<Unit> gang){
    };

}
