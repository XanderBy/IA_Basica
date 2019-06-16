

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Número de entradas externas del perceptrón  
		 int TotalEntradas = 2;  
		//Número de salidas externas del perceptrón   
		 int TotalSalidas = 1;    
		//Total capas que tendrá el perceptrón 
		 int TotalCapas = 4;        
		//Los índices iniciarán en 1 en esta implementación
		 int[] neuronasporcapa = new int[TotalCapas + 1];          
		//Entradas externas del perceptrón 
		 neuronasporcapa[1] = TotalEntradas;    
		//Capa oculta con 4 neuronas
		 neuronasporcapa[2] = 4;           
		//Capa oculta con 4 neuronas    
		 neuronasporcapa[3] = 4;   
		//Capa de salida con 2 neuronas 
		 neuronasporcapa[4] = TotalSalidas; 
		 
         Cerebro objP = new Cerebro(TotalEntradas, TotalSalidas, TotalCapas, neuronasporcapa); 

         /* Tabla del XOR. Son 4 conjuntos de entradas y salidas                 
          * 1 ..... 1  ===> 0                 
          * 1 ..... 0  ===> 1                 
          * 0 ..... 1  ===> 1                 
          * 0 ..... 0  ===> 0     */             
         int ConjuntoEntradas = 4;             
         double[][] entraXOR = new double[ConjuntoEntradas+1][];             
         entraXOR[1] = new double[3];             
         entraXOR[2] = new double[3];             
         entraXOR[3] = new double[3];             
         entraXOR[4] = new double[3];             
         entraXOR[1][1] = 1; 
         entraXOR[2][1] = 1; 
         entraXOR[3][1] = 0; 
         entraXOR[4][1] = 0;
         entraXOR[1][2] = 1; 
         entraXOR[2][2] = 0; 
         entraXOR[3][2] = 1; 
         entraXOR[4][2] = 0; 
         
         double[][] salirXOR = new double[ConjuntoEntradas+1][];             
         salirXOR[1] = new double[3];             
         salirXOR[2] = new double[3];             
         salirXOR[3] = new double[3];             
         salirXOR[4] = new double[3];             
         salirXOR[1][1] = 0; 
         salirXOR[2][1] = 1; 
         salirXOR[3][1] = 1; 
         salirXOR[4][1] = 0; 

         double alpha = 0.4; //Factor de aprendizaje 

         //Ciclo que entrena la red neuronal             
         for (int ciclo = 1; ciclo <= 8000; ciclo++) {                 
        	 if (ciclo % 500 == 0) 
        		 System.out.println("Iteracion: " + ciclo);                 
        	 //Importante: Se envía el primer conjunto de entradas-salidas, luego el segundo, tercero y cuarto                 
        	 //por cada ciclo de entrenamiento.                  
        	 for (int entra = 1; entra <= ConjuntoEntradas; entra++) {                     
        		 objP.Procesa(entraXOR[entra]);                     
        		 if (ciclo % 500 == 0) objP.Muestra(entraXOR[entra], salirXOR[entra]);                     
        		 objP.Entrena(alpha, entraXOR[entra], salirXOR[entra]);                 
        		 }             
        	 }
       

	}

}
