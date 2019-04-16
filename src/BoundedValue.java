public class BoundedValue {
    private float value;
    private float borneMax;
    private float borneMin;

    public BoundedValue(float value){
        this.borneMax = 1;
        this.borneMin = 0;
        //ternaire vérifiant si la valeur est dans les bornes,
        //lui donne la valeur de la borne la plus proche dans le cas contraire
        this.value = value > borneMax ? borneMax : value < borneMin ? borneMin : value;
    }

    public BoundedValue(float value, float borneMax, float borneMin){
        this.borneMax = borneMax;
        this.borneMin = borneMin;
        //ternaire vérifiant si la valeur est dans les bornes,
        //lui donne la valeur de la borne la plus proche dans le cas contraire
        this.value = value > borneMax ? borneMax : value < borneMin ? borneMin : value;
    }

    public float getValue() {
        return value;
    }

    public float getBorneMax() {
        return borneMax;
    }

    public float getBorneMin() {
        return borneMin;
    }
}
