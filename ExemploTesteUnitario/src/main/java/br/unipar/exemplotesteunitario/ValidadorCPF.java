package br.unipar.exemplotesteunitario;

/**
 *
 * @author Antony
 */
public class ValidadorCPF {
    
    public boolean validarCPF(String cpf) {
        cpf = cpf.trim();
        
        if(cpf == null || cpf.isEmpty()) {
            return false;
        }
        
        if(cpf.length() != 14) {
            return false;
        }

        boolean ponto1 = cpf.charAt(3) == '.';
        boolean ponto2 = cpf.charAt(7) == '.';
        boolean hifen = cpf.charAt(11) == '-';

        // Remover oq nao é numero
        String numeros = cpf.replaceAll("[^\\d]", "");
        boolean somenteDigitos = numeros.length() == 11;

        
        //digito verificador 1
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(numeros.charAt(i)) * (10 - i);
        }
        
        int primeiroDigito = soma % 11;
        primeiroDigito = primeiroDigito < 2 ? 0 : 11 - primeiroDigito;
        
         //digito verificador 2
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(numeros.charAt(i)) * (11 - i);
        }

        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }
        
        return primeiroDigito == Character.getNumericValue(numeros.charAt(9)) &&
               segundoDigito == Character.getNumericValue(numeros.charAt(10)) && 
               ponto1 && 
               ponto2 && 
               hifen &&
               somenteDigitos;
        
    }
 }
