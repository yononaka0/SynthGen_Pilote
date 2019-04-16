public class BoundedValue {
    private int value;
    private int borneMax;
    private int borneMin;

    public BoundedValue(int value){
        this.borneMax = 100;
        this.borneMin = 1;
        //ternaire vérifiant si la valeur est dans les bornes,
        //lui donne la valeur de la borne la plus proche dans le cas contraire
        this.value = value > borneMax ? borneMax : value < borneMin ? borneMin : value;
    }

    public BoundedValue(int value, int borneMax, int borneMin){
        this.borneMax = borneMax;
        this.borneMin = borneMin;
        //ternaire vérifiant si la valeur est dans les bornes,
        //lui donne la valeur de la borne la plus proche dans le cas contraire
        this.value = value > borneMax ? borneMax : value < borneMin ? borneMin : value;
    }

    public int getValue() {
        return value;
    }

    public int getBorneMax() {
        return borneMax;
    }

    public int getBorneMin() {
        return borneMin;
    }
}

//test