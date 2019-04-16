import java.util.ArrayList;

public class WeightedMean extends CurrentFunction {

    @Override
    public float compute(ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
        float value = 0;
        float div = 0;
        //chaque indicateur a un poids, sinon le calcul cne fait pas de sens
        assert(indicators.size() == weights.size());
        // le i+=(int)('b')-('a') dans la boucle est juste une blague, équivaut a i++
        for(int i = 0; i < indicators.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getValue()*weights.get(i).getValue();
            div += weights.get(i).getValue();
        }
        value = value/div;
        return value;
    }

    @Override
    public String getFunctionName() {
        return "WeightedMean";
    }

    @Override
    public float getMaxValue(ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
        return 0;
    }

    @Override
    public float getMinValue(ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
        return 0;
    }
}
