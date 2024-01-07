import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created by Jaime Jose Goga Nakayoshi on 20/05/2016.
 */
public class MiniLibrary {
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

    public static String ArrayToString(ArrayList<String>Lista)  {       // Convierte una Lista Array a String
        String listString = "";
        String newString = "";
        for (String s : Lista){
            listString += s + " ";
            newString = listString.substring(0, listString.length()-1);
        }
        return newString;
    }

    public static String ListToString(List<String>Lista)  { //Convierte Lista a String
        String listString = "";
        String newString = "";
        for (String s : Lista){
            listString += s + " ";
            newString = listString.substring(0, listString.length()-1);
        }

        return newString;
    }




    public static int countOccurrences(String cadena, char car)    {    // Ocurrencias en un String
        int count = 0;
        for (int i=0; i < cadena.length(); i++)   {
            if (cadena.charAt(i) == car)   {
                count++;
            }
        }
        return count;
    }


    public static List<String> getWords(List<String> strSentences){     //Convierte una Lista en ArrayList
        ArrayList<String> allWords = new ArrayList<>();
        Iterator<String> itrTemp = strSentences.iterator();
        while(itrTemp.hasNext()){
            String strTemp = itrTemp.next();
            allWords.addAll(Arrays.asList(strTemp.toLowerCase().split("\\s+")));
        }
        return allWords;
    }
    public static List<Integer> uniqueSinOrdenado(List<Integer> lista){     //Borra repetidos en una lista de numeros
        HashSet<Integer> hs = new HashSet<>();                              //enteros, sin orden de los numeros en la lista.
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        return lista;
    }

    public static List<Integer> uniqueOrdenado(List<Integer> lista){        //Borra repetidos en una lista de numeros
        Set<Integer> s = new LinkedHashSet<>(lista);                        //enteros, el orden de los numeros se mantiene.
        lista.clear();
        lista.addAll(s);
        return lista;
    }

    public static int OccurrencesString(String sTexto, String sTextoBuscado)    {  // Cuenta las Ocurrencias de un string pequeño
        int contador = 0;                                                          // en un string mas grande.

        while (sTexto.contains(sTextoBuscado)) {
            sTexto = sTexto.substring(sTexto.indexOf(sTextoBuscado) + sTextoBuscado.length(),sTexto.length());
            contador++;
        }
        return contador;
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

    public static ArrayList<String>change(ArrayList<String>Lista,String value1,String value2)  {

        ListIterator<String> it = Lista.listIterator();
        while(it.hasNext()) {
            String x = it.next();
            if(x.equals(value1)) {
                it.remove();
                it.add(value2);
            }
        }
        return Lista;
    }

    public static  String SeparaMiles(String cadena) {

        double entraTecla = Double.parseDouble(cadena);
        long iPart = (long)entraTecla;
        String fPartSS;
        String NumCompleto = "";
        double fPart = entraTecla - iPart;
        String iPartS = String.valueOf(iPart);
        String fPartS = String.valueOf(fPart);
        fPartSS = fPartS.substring(1);
        if("0".equals(iPartS)){
            NumCompleto = fPartS;
        }
        else if(!"0".equals(iPartS) & iPartS.length() <= 3){
            NumCompleto = iPartS + fPartS.substring(1);
        }
        else{
            NumCompleto = iPartS + fPartSS;
        }
        String canti = NumCompleto;

        String[] cantidades = canti.split("\\.");
        //String cantidades1 = cantidades[1];

        String cantidades2 = cantidades[0];
        int num2 = cantidades2.length();
        if( num2 > 3 & num2 < 16){
            StringBuilder sb = new StringBuilder(cantidades[0]).append(".");
            for (int i = 1, len = sb.length(); i < len; i++) {
                if (i % 4 == 0) {
                    sb.insert(len = sb.length() - i, ',');
                    len = sb.length();
                }
            }
            String decimal = String.format("%.3f", Double.parseDouble(fPartS));
            String deci = decimal.substring(2);
            String resultado = sb + deci;
            return resultado;
        }else{
            return cadena;
        }
    }
}

