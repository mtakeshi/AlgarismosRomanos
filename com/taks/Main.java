package com.taks;

public class Main {

    /*
    1 - I
    5 - V
    10 - X
    50 - L
    100 - C
    500 - D
    1000 - M
    */
    private static String[] algrom = {"I","V","X","L","C","D","M","_"};


    /*
    converte algarismos arabicos em algarismos romanos
    - nao ha numeros negativos ou zero
    - limitado ate 3999
    */
    public static void main(String[] args) {

        System.out.println("inicio");

        for (int c = 1; c <= 4000; c++) {
            System.out.println(c + ": " + toRoman(c));
        }

        System.out.println("fim");
    }

    private static String toRoman(int n) {
        String saida = "";
        int idx;
        String[] dig = String.valueOf(n).split("");

        int nivel = dig.length;

        for (String d: dig) {   //varredura esquerda > direita
            int a = Integer.parseInt(dig[dig.length - nivel]);

//            System.out.println(d);

            idx = 2 * nivel - 2;    // dependendo do nivel o indice do array muda (unidade, dezena, centena, milhar)

            if (a < 4) {
                for (int j = 1; j <= a; j++) {
                    saida += algrom[idx];
                }
            } else if (a >=4 && a < 9) {
                if (a < 5) {
                    saida += algrom[idx];
                }

                saida += algrom[idx+1];

                for (int j = 6; j <= a; j++) {
                    saida += algrom[idx];
                }
            } else {
                saida += (algrom[idx] + algrom[idx+2]);
            }

            nivel--;
        }

        return saida;
    }

}
