import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int nbGeneration = 1;

        CurrentFunction func = new WeightedSum();
        ArrayList<BoundedValue> weights = new ArrayList<>();
        for(int i = 0; i<20;i++){
            weights.add(new BoundedValue(50));
        }

        SynthGen gen1 = new SynthGen(func,weights);



        for(int i = 0; i < nbGeneration;i++){
            System.out.println("################################################");
            int estAttentif = gen1.cleanAndGenerate();
            System.out.print("Indicateurs: [ ");
            for(BoundedValue ind : gen1.getIndicators()){
                System.out.print(ind.getValue()+" ");
            }
            System.out.println("]");
            System.out.print("Weights:     [ ");
            for(BoundedValue wei : weights){
                System.out.print(wei.getValue()+" ");
            }
            System.out.println("]");
            System.out.println("EstAttentif: "+estAttentif);

        }
        System.out.println("################################################");



    }
}
