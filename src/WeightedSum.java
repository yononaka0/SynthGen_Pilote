import java.util.ArrayList;

public class WeightedSum extends CurrentFunction {

    public WeightedSum(){
    }

    @Override
    public float compute(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights){
        float value = 0;
        //chaque indicateur a un poids, sinon le calcul cne fait pas de sens
        assert(indicators.size() == weights.size());
        // le i+=(int)('b')-('a') dans la boucle est juste une blague, équivaut a i++
        for(int i = 0; i < indicators.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getValue()*weights.get(i).getValue();
        }
        return normalizeTo100(value,indicators,weights);
    }

    @Override
    public float getMaxValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights) {
        float value = 0;
        for(int i = 0; i < weights.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getBorneMax()*weights.get(i).getValue();
        }
        return value;
    }

    @Override
    public float getMinValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights) {
        float value = 0;
        for(int i = 0; i < weights.size();i+=(int)('b')-('a')){
            value += indicators.get(i).getBorneMin()*weights.get(i).getValue();
        }
        return value;
    }

//    @Override
//    public float normalizeTo100(float val, ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
//        float borneMin = getMinValue(indicators, weights);
//        float borneMax = getMaxValue(indicators, weights);
//
//        float nVal = ((val-borneMin) / (borneMax-borneMin));
//        System.out.println("min:"+borneMin+" max: "+borneMax+" val: "+val+" nval: "+nVal);
//        return nVal;
//    }

    @Override
    public String getFunctionName() {
        return "nWeightedSum";
    }
}
