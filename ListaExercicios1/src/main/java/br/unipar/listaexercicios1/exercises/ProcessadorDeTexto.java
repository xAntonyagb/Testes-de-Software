package br.unipar.listaexercicios1.exercises;

import br.unipar.listaexercicios1.exceptions.ValidationException;

public class ProcessadorDeTexto {


    public String inverterPalavras(String frase) {

        if (frase == null || frase.isEmpty()) {
            throw new ValidationException("Frase não pode ser nula ou vazia");
        }

        String[] palavras = frase.split(" ");
        StringBuilder fraseInvertida = new StringBuilder();

        for (int i = palavras.length - 1; i >= 0; i--) {
            fraseInvertida.append(palavras[i]);
            if (i > 0) {
                fraseInvertida.append(" ");
            }
        }

        return fraseInvertida.toString();
    }


    public String substituirPalavras(String frase, String palavraAntiga, String palavraNova) {
        if (frase == null || frase.isEmpty()) {
            throw new ValidationException("Frase não pode ser nula ou vazia");
        }
        if(palavraAntiga == null || palavraAntiga.isEmpty()) {
            throw new ValidationException("Palavra antiga não pode ser nula ou vazia");
        }
        if(palavraNova == null || palavraNova.isEmpty()) {
            throw new ValidationException("Palavra nova não pode ser nula ou vazia");
        }

        return frase.replaceAll(palavraAntiga, palavraNova);
    }


    public int contarOcorrenciasDePalavra(String frase, String palavra) {
        if (frase == null || frase.isEmpty()) {
            throw new ValidationException("Frase não pode ser nula ou vazia");
        }

        if(palavra == null || palavra.isEmpty()) {
            throw new ValidationException("Palavra não pode ser nula ou vazia");
        }


        String[] palavras = frase.split(" ");
        int count = 0;

        for (String p : palavras) {
            if (p.equals(palavra)) {
                count++;
            }
        }

        return count;
    }
}
