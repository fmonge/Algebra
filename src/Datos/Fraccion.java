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

    public Fraccion(int denominador, int nominador) {
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
		int residuo = denominador % nominador;
		if (residuo == 0 )
			return nominador;
		return(mcdAux(nominador, residuo));
}    
    public Fraccion simplificar(Fraccion fraccion){
    	int mcd = mcd(fraccion);
    	fraccion.setDenominador(fraccion.getDenominador()/mcd);
    	fraccion.setNominador(fraccion.getNominador()/mcd);
    	return fraccion;
    }
    
    
	private int[][] getTerms(Fraccion a, Fraccion b){
		int terms[][] = new int[2][2];
    	terms[0][0] = a.getNominador();
    	terms[1][0] = a.getDenominador();
    	
    	terms[0][0] = b.getNominador();
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
    	if(terms[0][1] == terms[1][1])
    	{
    		if(simbol == '+')
    			result.setNominador(terms[0][0]+terms[0][1]);
    		if(simbol == '-')
    			result.setNominador(terms[0][0]-terms[0][1]);
    		result.setDenominador(terms[0][1]);
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
    		result.setDenominador(terms[1][0]*terms[1][1]);
    	}
    	else
    		System.out.println("Msg temp, validad las entradas ;)");
    	return simplificar(result);
	
    }
    
    public Fraccion operacion(Fraccion a, int escalar){
    	int terms[][] = getTerms(a);
    	Fraccion result = new Fraccion(1,1);
    	result.setNominador(terms[0][0]*escalar);
		result.setDenominador(terms[1][0]);
		return simplificar(result);
    }

	private void result(int i, int j) {
		// TODO Auto-generated method stub
		
	}
    
}
