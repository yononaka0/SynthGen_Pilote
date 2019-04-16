import java.util.ArrayList;

public abstract class CurrentFunction {

    public CurrentFunction(){
    }

    public abstract int compute(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);

    public abstract int normalizeTo100(int val,ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);

    public abstract int getMaxValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);
    public abstract int getMinValue(ArrayList<BoundedValue> indicators,ArrayList<BoundedValue> weights);


}

