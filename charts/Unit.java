package charts;

import java.util.List;
import System.Vector2;
import java.util.Arrays;

public abstract class Unit implements UnitInterface {
    private int attack;
    private int protect;
    protected int shoot;
    private int[] damage;
    protected float health;
        protected int maxHealth;
    protected int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    protected String action;
    private static int idCounter;
    private int playerID;
    protected List<Unit> gang, side;
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
        this.action = "Stand";
    }

    public Vector2 getPosition(){return position;}

    public int getPlayerID(){
        return playerID;
    }

    public float getHealth() {return health;}

    public String getName() {return name;}

    public String getCharacter() {return name + " A:" + attack + ",P:" + protect + ",Dmg:" + Arrays.toString(damage) + ",HP:" + health + ",S:" + speed + ",D:" + delivery + ",M:" + magic + "," + action;}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSpeed() {
        return speed;
    }

    public float calcDamage(Unit unit) {
        if (unit.protect - this.attack == 0) {
            return (this.damage[0] + this.damage[1]) / 2.0f;
        }
        if (unit.protect - this.attack < 0) {
            return this.damage[1];
        }
        return this.damage[0];
    }

    public void getHit(float damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.action = "Dead";
        }
    }

    @Override
    public String getInfo(){
        return "Attack:" + attack + ", Protection:" + protect + ", Damage:" + Arrays.toString(damage) + ", Health:" + health + ", Speed:" + speed + ", Delivery:" + delivery + ", Magic:" + magic + action;
    }

    @Override
    public void step(){
    };
}
