import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SynthGen {
    private CurrentFunction fun;
    private int nbIndicator;
    private ArrayList<BoundedValue> indicators;
    private ArrayList<BoundedValue> weights;
    private float attention;
    private float nAttention;

    public SynthGen(CurrentFunction fun, ArrayList<BoundedValue> w){
        this.nbIndicator = w.size();
        this.fun = fun;
        this.indicators = new ArrayList<>();
        this.weights = w;
    }

    public float cleanAndGenerate(){
        Random rand = new Random();
        this.indicators.clear();
        //genere des indicateurs random entre 1 et 100
        for(int i = 0;i<nbIndicator;i++){
            indicators.add(new BoundedValue(rand.nextFloat()));
        }
        nAttention = fun.compute(indicators,weights);
        //System.out.println("[DEBUG]nAttention:"+nAttention);
        return nAttention;
    }

    public ArrayList<BoundedValue> getIndicators() {
        return indicators;
    }

    public ArrayList<BoundedValue> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<BoundedValue> weights) {
        this.weights = weights;
    }
}
