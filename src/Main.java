import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class Main {




    public static void main(String[] args) {

        //#################################################################
        //config
        //nombre d'indicateur a générer (équivaut au nombre de poids)
        int nbIndicateurs = 40;
        //nombre de jeux de données a générer (avec les memes poids)
        int nbGeneration = 20;
        //choix de la fonction utilisée
        //CurrentFunction func = new WeightedSum();
        CurrentFunction func = new WeightedMean();
        //nom fichier de sauvegarde
        String fileName = "data.json";
        //fichier de sauvegarde
        JsonArray Joutput = new JsonArray();
        JsonObject Joutput_o = new JsonObject();
        //#################################################################
        JsonObject Jinfo = new JsonObject();
        Jinfo.addProperty("functionName",func.getFunctionName());
        Jinfo.addProperty("borneMin",0.0f);
        Jinfo.addProperty("borneMax",1.0f);
        Jinfo.addProperty("nbIndicateurs",nbIndicateurs);
        Jinfo.addProperty("nbGeneration",nbGeneration);
        Jinfo.addProperty("fileName",fileName);
        Joutput.add(Jinfo);
        Joutput_o.add("info",Jinfo);

        //weights
        Random rand = new Random();
        ArrayList<BoundedValue> weights = new ArrayList<>();
        for(int i = 0; i<nbIndicateurs;i++){
            weights.add(new BoundedValue(rand.nextFloat()));
        }
        //weights to Json
        JsonObject Jweights = listToJsonO(weights,"weightNum");
        Joutput.add(Jweights);
        Joutput_o.add("weights",Jweights);
        JsonObject Jind = new JsonObject();
        JsonObject Jatt = new JsonObject();

        ArrayList<String> indicateurs_list = new ArrayList<>();
        ArrayList<String> attention_list = new ArrayList<>();
        SynthGen gen1 = new SynthGen(func,weights);
        for(int i = 0; i < nbGeneration;i++){
            System.out.println("################################################");
            float estAttentif = gen1.cleanAndGenerate();
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

            //to JSON
            Jind.add("indicateursGen"+i,listToJsonO(gen1.getIndicators(),"indicateurNum"));
            Jatt.addProperty("attentionGen"+i,estAttentif);
        }
        System.out.println("################################################");

        //writing JSON output
        Joutput.add(Jind);
        Joutput.add(Jatt);
        Joutput_o.add("indicatorsGen",Jind);
        Joutput_o.add("attentionGen",Jatt);
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(Joutput_o.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonObject listToJsonO(ArrayList<BoundedValue> list,String id){
        JsonObject j = new JsonObject();
        int i = 0;
        for (BoundedValue b: list) {
            j.addProperty(id+i,b.getValue());
            i++;
        }
        return j;
    }

}
