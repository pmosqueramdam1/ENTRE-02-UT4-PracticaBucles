import java.util.Random;
/**
 *   @author -- Pablo Mosquera
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        System.out.println("Nº maximo aleatorios a generar 42 \n o hasta que salga el 0");
        int numeros = 0;
        int numero = generador.nextInt(6001) - 1000;
        double media = 0;
        double sumaImp = 0;
        double maxPar = 0;
        int resul = 0;
        while (numero != 0 && numeros <= n) {
            numero = generador.nextInt(6001) - 1000;
            
            System.out.printf("%12d" + "%s" + "%5d", numero, ":", obtenerNumeroSinCeros(numero));
            if (numeros % 10 == 0 || numeros % 10 == 5) {
                System.out.println();
            }
            
            numeros++;
            resul = resul + numero;
            media = resul / numeros;
            
            
            if (esImpar(numero)) {
                sumaImp += numero;
            }
            
            
            if (numero % 2 == 0 && numero > maxPar) {
                maxPar = numero;
            }
            
        }
        System.out.println();
        System.out.println();
        System.out.printf("%25s%10.2f\n", "Media: ", media);
        System.out.printf("%25s%10.2f\n", "Suma impares: ", sumaImp);
        System.out.printf("%25s%10.2f", "Máximo pares: ", maxPar);
    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        int n = numero;
        while (n % 2 == 0) {
            return true;
        }
        
        return  false;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int n = numero;
        int resul = 0;
        int multiplicador = 1;
        while (n > 0) {
            int cifra = n % 10;
            if (cifra == 0 ) {
                resul = resul;
            }
            else {
                resul = resul  + cifra * (int) Math.pow(10, multiplicador - 1);
                multiplicador++;
            }
            
            n = n / 10;
        }
        
        while (n < 0) {
            int cifra = n % 10;
            if (cifra == 0 ) {
                resul = resul;
            }
            else {
                resul = resul  + cifra * (int) Math.pow(10, multiplicador - 1);
                multiplicador++;
            }
            
            n = n / 10;
        }
        return resul;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
        System.out.println("Letra N -  Altura: " + altura);
        for (int i = 0; i < altura; i++) {
            escribirCaracter(CARACTER, altura);
        }
        

    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
        caracter = CARACTER;
        for (int i = n; i <= n; i++) {
            System.out.println(caracter);
        }
    }

}
