/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Fraccion {
    private int denominador;
    private int nominador;

    public Fraccion(int nominador , int denominador) {
        this.denominador = denominador;
        this.nominador = nominador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int getNominador() {
        return nominador;
    }

    public void setNominador(int nominador) {
        this.nominador = nominador;
    }
    
    
	// dividendo/divisor
    private int mcd(Fraccion fraccion){
    	int denominador = fraccion.getDenominador();
    	int nominador = fraccion.getNominador();
    	return mcdAux(denominador, nominador);
    } 

    private int mcdAux(int denominador, int nominador){ 
        if(nominador != 0)          
        {
            int residuo = denominador % nominador;
            if (residuo == 0 )
                return nominador;
            return(mcdAux(nominador, residuo));
        }
        return -1;
}    
    public Fraccion simplificar(Fraccion fraccion){
    	int mcd = mcd(fraccion);
    	fraccion.setDenominador(fraccion.getDenominador()/mcd);
    	fraccion.setNominador(fraccion.getNominador()/mcd);
        if(fraccion.getDenominador()<0){
            fraccion.setNominador( - fraccion.getNominador());
            fraccion.setDenominador( - fraccion.getDenominador());       
        }
        if(fraccion.getNominador() == 0)
            fraccion.setDenominador(1);
        
    	return fraccion;
    }
    
    
	private int[][] getTerms(Fraccion a, Fraccion b){
	int terms[][] = new int[2][2];
    	terms[0][0] = a.getNominador();
    	terms[1][0] = a.getDenominador();
    	
    	terms[0][1] = b.getNominador();
    	terms[1][1] = b.getDenominador();
    	return terms;
    }

	private int[][] getTerms(Fraccion a){
		int terms[][] = new int[2][2];
    	terms[0][0] = a.getNominador();
    	terms[1][0] = a.getDenominador();
    	return terms;
    }
	
	private Fraccion sumaResta(int[][] terms, char simbol){
	Fraccion result = new Fraccion(1,1);
    	if(terms[1][0] == terms[1][1])
    	{
    		if(simbol == '+')
    			result.setNominador(terms[0][0]+terms[0][1]);
    		if(simbol == '-')
    			result.setNominador(terms[0][0]-terms[0][1]);
    		result.setDenominador(terms[1][0]);
    		return simplificar(result);    		
    	}
    	if(simbol == '+')
    		result.setNominador(terms[0][0]*terms[1][1]+terms[0][1]*terms[1][0]);
    	if(simbol == '-')
    		result.setNominador(terms[0][0]*terms[1][1]-terms[0][1]*terms[1][0]);
	result.setDenominador(terms[1][0]*terms[1][1]);	
	return result;			
	}
	
    public Fraccion operacion(Fraccion a, Fraccion b, char simbol){
    	// +, -, *, / e, suma, resta, multiplicación, divi, e escalar
    	int terms[][] = getTerms(a, b);
        //System.out.println("A- " + terms[0][0] + "/" + terms[1][0]);
        //System.out.println("B- " + terms[0][1] + "/" + terms[1][1]);
        //System.out.println("simbol"+simbol);
    	if( simbol == '+' || simbol == '-')
    		return simplificar(sumaResta(terms, simbol));

    	Fraccion result = new Fraccion(1,1);    
    	if(simbol == '*')
    	{
    		result.setNominador(terms[0][0]*terms[0][1]);
    		result.setDenominador(terms[1][0]*terms[1][1]);
    	}
    	else if(simbol == '/'){ // /
    		result.setNominador(terms[0][0]*terms[1][1]);
    		result.setDenominador(terms[1][0]*terms[0][1]);
    	}
    	else
    		System.out.println("Msg temp, validad las entradas ;)");
    	return simplificar(result);
	
    }
    
    public Fraccion operacion(Fraccion a, int escalar){
    	int terms[][] = getTerms(a);
    	Fraccion result = new Fraccion(1,1);
    	result.setNominador(a.getNominador() * escalar);
	result.setDenominador(a.getDenominador());
	return simplificar(result);
    }

    private void result(int i, int j) {
            // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return this.nominador+"/"+denominador;
    }          
}