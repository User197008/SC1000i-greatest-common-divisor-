import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jaime Jose Goga Nakayoshi
 */
public class GCD {
    public static String GCD(String cadena) {
        try {
            ArrayList<String> Lista = split(cadena);
            ArrayList<Integer> num = new ArrayList<>();
            for(String d : Lista)    {
                Integer m = Integer.valueOf(d);
                if(m>=0)    {
                    num.add(m);
                }else    {
                    return "Error: Only Positive Value";
                }
            }
            List<List<Integer>> pri = new ArrayList<>();
            List<List<Integer>> fac = new ArrayList<>();
            List<List<Integer>> new_fac = new ArrayList<>();
            List<List<Integer>> conteo = new ArrayList<>();
            ArrayList<Integer> factor2 = new ArrayList<>();
            ArrayList<Integer> exponen = new ArrayList<>();
            int count = 0;
            for(int k = 0; k < num.size(); k++)    {
                pri.add(new ArrayList<Integer>());
                fac.add(new ArrayList<Integer>());
                conteo.add(new ArrayList<Integer>());
                new_fac.add(new ArrayList<Integer>());
                numerosprimos(num.get(k),count,pri);
                count += 1;
            }
            factor(num,pri,fac);
            Borrar_R(fac,new_fac);
            contar(fac,new_fac,conteo);
            factorexpo(new_fac, conteo,factor2, exponen);
            int resultado = (int) unificar(num,factor2,exponen);
            return String.valueOf(resultado);
        }catch(Exception e){
            return "Error: Only Integer";
        }
    }
    
  
    
    public  static void numerosprimos(int n, int count, List<List<Integer>> pri )  {
        for(int i=1; i< n+1; i++)   {
            esPrimo(i,count,pri);
        }
    }
    public static boolean esPrimo(int n, int count, List<List<Integer>> pri){
        int a = 0;
        for(int i=1;i<(n+1);i++){
            if(n%i==0){
                a++;
            }
        }
        if(a!=2){
            return false;
        }
        else{
            pri.get(count).add(n);
            return true;
        }
    }
    public  static void factor(ArrayList<Integer> num, List<List<Integer>> pri, List<List<Integer>> fac)    {
        int tan = 0;
        for(int h : num)    {
            while(h>=2) {
                for(int i : pri.get(tan))   {
                    if(h%i == 0)    {
                        h /= i;
                        fac.get(tan).add(i);
                    }
                }
            }
            Collections.sort(fac.get(tan));
            tan += 1;
        }
    }
    public  static void Borrar_R( List<List<Integer>> fac,List<List<Integer>> new_fac)    {
        for(int j=0; j < fac.size(); j++)  {
            for(int h : fac.get(j)) {
                new_fac.get(j).add(h);
            }
        }
        for(int f=0; f < new_fac.size(); f++)   {
            uniqueOrdenado(new_fac.get(f));
        }
    }
    public  static void contar( List<List<Integer>> fac, List<List<Integer>> new_fac, List<List<Integer>> conteo)    {
        int ttt = 0;
        for(List<Integer>t:new_fac)  {
            for(int w:t)    {
                int count = 0;
                for(int item:fac.get(ttt))  {
                    if(item == w)   {
                        count += 1;
                    }
                }
                conteo.get(ttt).add(count);
            }
            ttt += 1;
        }
    }
    public  static void factorexpo(List<List<Integer>> new_fac, List<List<Integer>> conteo, ArrayList<Integer> factor2,ArrayList<Integer> exponen )    {
        for(List<Integer> item1 : new_fac)  {
            factor2.addAll(item1);
        }
        for(List<Integer> item2 : conteo)   {
            exponen.addAll(item2);
        }
    }
    public  static float unificar(ArrayList<Integer> num, ArrayList<Integer> factor2, ArrayList<Integer> exponen) {
        List<List<Integer>> coe = new ArrayList<>();
        List<List<Integer>> coe2 = new ArrayList<>();
        List<List<Integer>>expo = new ArrayList<>();
        List<Integer> factorcomun = new ArrayList<>();
        List<Integer> expo2 = new ArrayList<>();
        Integer p = Collections.max(num);
        List<List<Integer>> uni = zip(factor2,exponen);
        int c = 0;
        for(int i = 1; i < p+1; i++)    {
            coe.add(new ArrayList<Integer>());
            for(List<Integer> g : uni)  {
                if(g.get(0) == i)   {
                    coe.get(c).add(g.get(1));
                }
            }
            c += 1;
        }
        for(List<Integer> j : coe)  {
            if(j.size() != 0) {
                coe2.add(j);
            }
        }
        List<Integer> new_factor = uniqueOrdenado(factor2);
        Collections.sort(new_factor);
        for(int h=0; h<coe2.size(); h++) {
            if(coe2.get(h).size()==num.size())  {
                expo.add(coe2.get(h));
                factorcomun.add(new_factor.get(h));
            }
        }
        for(List<Integer> k : expo) {
            Integer m = Collections.min(k);
            expo2.add(m);
        }
        ArrayList<Integer> pow = new ArrayList<>();
        for (int i = 0; i < factorcomun.size(); i++) {
            int fac = factorcomun.get(i);
            int ex = expo2.get(i);
            int po = (int) Math.pow(fac,ex);
            pow.add(po);
        }
        float MCD = 1;
        for(int z : pow)    {
            MCD *= z;
        }
        return MCD;
    }
    public  static double unificarL(ArrayList<Integer> num, ArrayList<Integer> factor2, ArrayList<Integer> exponen) {
        List<List<Integer>> coe = new ArrayList<>();
        List<List<Integer>> coe2 = new ArrayList<>();
        ArrayList<Integer> expo = new ArrayList<>();
        Integer p = Collections.max(num);
        List<List<Integer>> uni = zip(factor2,exponen);
        int c = 0;
        for(int i = 1; i < p+1; i++)    {
            coe.add(new ArrayList<Integer>());
            for(List<Integer> g : uni)  {
                if(g.get(0) == i)   {
                    coe.get(c).add(g.get(1));
                }
            }
            c += 1;
        }

        for(List<Integer> j : coe)  {
            if(j.size() != 0) {
                coe2.add(j);
            }
        }

        for(List<Integer> k : coe2) {
            Integer m = Collections.max(k);
            expo.add(m);
        }
        List<Integer> new_factor = uniqueOrdenado(factor2);
        Collections.sort(new_factor);
        ArrayList<Integer> pow = new ArrayList<>();
        for (int i = 0; i < new_factor.size(); i++) {
            int fac = new_factor.get(i);
            int ex = expo.get(i);
            int po = (int) Math.pow(fac,ex);
            pow.add(po);
        }
        double MCM = 1;
        for(int z : pow)    {
            MCM *= z;
        }
        long LMCM = (long) MCM;
        return LMCM;
    }
    
    public static ArrayList<String> split(String cadena)  {

        List<String> myList = new ArrayList<>(Arrays.asList(cadena.split(" ")));
        ArrayList<String> Lista = new ArrayList<>();
        for (int i=0;i<=myList.size()-1;i++) {
            String x = myList.get(i);

            if (!"".equals(x)) {
                Lista.add(x);
            }
        }
        return Lista;

    }
    
    public static List<Integer> uniqueOrdenado(List<Integer> lista){        
        Set<Integer> s = new LinkedHashSet<>(lista);                        
        lista.clear();
        lista.addAll(s);
        return lista;
    
    }   
    public static <T> List<List<T>> zip(List<T>... lists) {
        List<List<T>> zipped = new ArrayList<>();
        for (List<T> list : lists) {
            for (int i = 0, listSize = list.size(); i < listSize; i++) {
                List<T> list2;
                if (i >= zipped.size())
                    zipped.add(list2 = new ArrayList<>());

                else
                    list2 = zipped.get(i);
                list2.add(list.get(i));

            }
        }
        return zipped;
    }
    
     
     public static void main(String[] args) {
        String cadena = "100 234 432 321 561";
        
        System.out.println("GCD: " + GCD(cadena));
    
    
     } 

   
    
    
}
