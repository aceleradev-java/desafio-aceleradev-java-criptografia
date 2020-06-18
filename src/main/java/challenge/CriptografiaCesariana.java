package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        int quantidadeDeCaracteres = texto.length();
        String textoCriptografado = new String();
        int decimalDoCaractere;
        int decimalComSalto = 0;
        
        for (int i = 0; i < quantidadeDeCaracteres; i++) {
            decimalDoCaractere = texto.toLowerCase().charAt(i);
            if (decimalDoCaractere > 96 && decimalDoCaractere < 120) {
                decimalComSalto = decimalDoCaractere + 3; 
            }else if (decimalDoCaractere > 119) {
                decimalComSalto = decimalDoCaractere - (26 - 3);
            } else {
                decimalComSalto = decimalDoCaractere;
            }
            textoCriptografado += (char) decimalComSalto;
        }
        
        return textoCriptografado;
    }

    @Override
    public String descriptografar(String texto) {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode estar vazio");
        }

        int quantidadeDeCaracteres = texto.length();
        String textoDescriptografado = new String();
        int decimalDoCaractere;
        int decimalComSalto = 0;
        
        for (int i = 0; i < quantidadeDeCaracteres; i++) {
            decimalDoCaractere = texto.toLowerCase().charAt(i);
            if (decimalDoCaractere > 99 && decimalDoCaractere < 122) {
                decimalComSalto = decimalDoCaractere - 3; 
            }else if (decimalDoCaractere > 96 && decimalDoCaractere < 100) {
                decimalComSalto = decimalDoCaractere + (26 - 3);
            } else {
                decimalComSalto = decimalDoCaractere;
            }
            textoDescriptografado += (char) decimalComSalto;
        }
        
        return textoDescriptografado;
    }
}
