import java.util.ArrayList;

public abstract class CurrentFunction {

    public CurrentFunction(){
    }

    public abstract float compute(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);
    //public abstract float normalizeTo100(float val,ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);
    //@Override
    public float normalizeTo100(float val, ArrayList<BoundedValue> indicators, ArrayList<BoundedValue> weights) {
        float borneMin = getMinValue(indicators, weights);
        float borneMax = getMaxValue(indicators, weights);

        float nVal = ((val-borneMin) / (borneMax-borneMin));
        System.out.println("min:"+borneMin+" max: "+borneMax+" val: "+val+" nval: "+nVal);
        return nVal;
    }
    public abstract String getFunctionName();
    public abstract float getMaxValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);
    public abstract float getMinValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);


}

