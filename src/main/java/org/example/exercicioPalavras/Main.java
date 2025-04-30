package org.example.exercicioPalavras;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> words = new HashMap<>();
        List<String> inputedWords = new ArrayList<>();

        while(true){
            input = sc.nextLine();
            if(input.isBlank())
                break;
            else{
                inputedWords.add(input);
                if(!words.containsKey(input)){
                    words.put(input, 1);
                }else{
                    words.replace(input, words.get(input) + 1);
                }
            }
        }
        sc.close();

        Set<String> sortedWords = new TreeSet<>(words.keySet());

        System.out.println("Palavras digitadas: "+inputedWords);
        System.out.println("Palavras sem repetição e ordenadas: "+sortedWords);

        for(String word : words.keySet()){
            System.out.println(word + ": " + words.get(word) + " ocorrências");
        }
    }
}
