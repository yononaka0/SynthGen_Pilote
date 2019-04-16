import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SynthGen {
    private CurrentFunction fun;
    private int nbIndicator;
    private ArrayList<BoundedValue> indicators;
    private ArrayList<BoundedValue> weights;
    private int attention;
    private int nAttention;

    public SynthGen(CurrentFunction fun, ArrayList<BoundedValue> w){
        this.nbIndicator = w.size();
        this.fun = fun;
        this.indicators = new ArrayList<>();
        this.weights = w;
    }

    public int cleanAndGenerate(){
        this.indicators.clear();
        //genere des indicateurs random entre 1 et 100
        for(int i = 0;i<nbIndicator;i++){
            indicators.add(new BoundedValue(ThreadLocalRandom.current().nextInt(1, 100 + 1)));
        }
        attention = fun.compute(indicators,weights);
        //System.out.println("[DEBUG]Attention:"+attention);
        nAttention = fun.normalizeTo100(attention,indicators,weights);
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
