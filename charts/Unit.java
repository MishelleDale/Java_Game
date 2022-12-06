package charts;

import java.util.List;

import System.Vector2;
import java.util.Arrays;

public abstract class Unit implements UnitInterface {
    private int attack;
    private int protect;
    protected int shoot;
    protected int[] damage;
    public double health;
        public double maxHealth;
    protected int speed;
    private boolean delivery;
    private boolean magic;
    private final String name;
    public String action;
    private static int idCounter;
    private int playerID;
    protected List<Unit> gang, side;
    protected Vector2 position;
    protected int quantity;

    public Unit(int attack, int protect, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.protect = protect;
        this.shoot = shoot;
        this.damage = damage;
        this.maxHealth = health;
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

    public double getHealth() {return health;}

    public String getName() {return name;}

    public String getCharacter() {return name + " A:" + attack + ",P:" + protect + ",Dmg:" + Arrays.toString(damage) + ",HP:" + health + ",S:" + speed + ",D:" + delivery + ",M:" + magic + "," + action;}

    public String getAction() {return action;    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSpeed() {
        return speed;
    }

    public double calcDamage(Unit enemy) {
        int d = enemy.protect - attack;
        if (d == 0) {
            return ((this.damage[0] + this.damage[1]) / 2.0) * quantity;
        }else if (d < 0) {
            return this.damage[0] * quantity;
        } else {
            return this.damage[1] * quantity;
        }
    }

    public void getHit(double damage) {
        double tmpHealth = (quantity - 1) * maxHealth + health;
        tmpHealth -= damage;
        if (tmpHealth <= 0) {
            this.health = 0;
            this.action = "Dead";
            quantity = 0;
        } else {
            quantity = (int)(tmpHealth / maxHealth);
            health = maxHealth; 
            if (tmpHealth%maxHealth > 0) {
                quantity++;
                health = tmpHealth%maxHealth;
            }
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
