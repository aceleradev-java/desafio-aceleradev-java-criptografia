package challenge;

public class CriptografiaCesariana implements Criptografia {

    private int codigoDecimalDoCaractere = 0;
    private int codigoDecimal = 0;
    private int chaveDeCriptografia = 3;
    
    @Override
    public String criptografar(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        int quantidadeDeCaracteres = texto.length();
        StringBuilder textoCriptografado = new StringBuilder();
        
        for (int i = 0; i < quantidadeDeCaracteres; i++) {
            codigoDecimalDoCaractere = texto.toLowerCase().charAt(i);
            textoCriptografado.append((char) this.encriptarLetra(codigoDecimalDoCaractere));
        }
        
        return textoCriptografado.toString();
    }

    @Override
    public String descriptografar(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        int quantidadeDeCaracteres = texto.length();
        StringBuilder textoDescriptografado = new StringBuilder();
        
        for (int i = 0; i < quantidadeDeCaracteres; i++) {
            codigoDecimalDoCaractere = texto.toLowerCase().charAt(i);
            textoDescriptografado.append((char) this.descriptarLetra(codigoDecimalDoCaractere));
        }
        
        return textoDescriptografado.toString();
    }
    
    private int encriptarLetra(int decimalDoCaractere) {
        if (decimalDoCaractere > 96 && decimalDoCaractere < 120) {
            codigoDecimal = decimalDoCaractere + chaveDeCriptografia; 
        }else if (decimalDoCaractere > 119) {
            codigoDecimal = decimalDoCaractere - (26 - chaveDeCriptografia);
        } else {
            codigoDecimal = decimalDoCaractere;
        }
        return codigoDecimal;        
    }
    
    private int descriptarLetra(int decimalDoCaractere) {
        if (decimalDoCaractere > 99 && decimalDoCaractere < 123) {
            codigoDecimal = decimalDoCaractere - chaveDeCriptografia; 
        }else if (decimalDoCaractere > 96 && decimalDoCaractere < 100) {
            codigoDecimal = decimalDoCaractere + (26 - chaveDeCriptografia);
        } else {
            codigoDecimal = decimalDoCaractere;
        }
        return codigoDecimal;
    }
}
