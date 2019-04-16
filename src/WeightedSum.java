import java.util.ArrayList;

public class WeightedSum extends CurrentFunction {

    public WeightedSum(){
    }

    @Override
    public int compute(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights){
        int value = 0;
        //chaque indicateur a un poids, sinon le calcul cne fait pas de sens
        assert(indicators.size() == weights.size());
        // le i+=(int)('b')-('a') dans la boucle est juste une blague, équivaut a i++
        for(int i = 0; i < indicators.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getValue()*weights.get(i).getValue();
        }
        return value;
    }

    @Override
    public int getMaxValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights) {
        int value = 0;
        for(int i = 0; i < weights.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getBorneMax()*weights.get(i).getValue();
        }
        return value;
    }

    @Override
    public int getMinValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights) {
        int value = 0;
        for(int i = 0; i < weights.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getBorneMin()*weights.get(i).getValue();
        }
        return value;
    }

    @Override
    public int normalizeTo100(int val, ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
        int borneMin = getMinValue(indicators, weights);
        int borneMax = getMaxValue(indicators, weights);
        //TODO
        // WHY THE FUCK CA FAIT 0 ca
        float nVal = ((float)(val-borneMin) / (float)(borneMax-borneMin));
        System.out.println("min:"+borneMin+" max: "+borneMax+" val: "+val+" nval: "+nVal);
        return (int)(nVal*100);
    }
}
