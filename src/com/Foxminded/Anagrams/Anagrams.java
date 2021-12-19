package com.Foxminded.Anagrams;

import java.util.StringJoiner;

public class Anagrams {

    public String swapLettersInTheWords(String someWords) {

        String WORD_SEPARATOR = " ";
        String[] words = someWords.split(WORD_SEPARATOR);
        StringJoiner sentence = new StringJoiner(WORD_SEPARATOR);

        for (String s : words) {
            sentence.add(swapLettersInTheWord(s));
        }
        return sentence.toString();
    }

    private String swapLettersInTheWord(String word) {

        char[] letters = word.toCharArray();

        int quantityOfLetters = 0;
        for (char o : letters) {
            if (Character.isLetter(o)) quantityOfLetters++;
        }
        int quantityOfIterations = quantityOfLetters / 2;

        int positionOfLetterToBeSwappedFromFirstPartOfTheWord = 0;
        int positionOfLetterToBeSwappedFromSecondPartOfTheWord = letters.length - 1;

        for (int i = 0; i < quantityOfIterations; i++) {

            while (!Character.isLetter(letters[positionOfLetterToBeSwappedFromFirstPartOfTheWord])) {
                positionOfLetterToBeSwappedFromFirstPartOfTheWord++;
            }
            while (!Character.isLetter(letters[positionOfLetterToBeSwappedFromSecondPartOfTheWord])) {
                positionOfLetterToBeSwappedFromSecondPartOfTheWord--;
            }
            swapLetters(letters, positionOfLetterToBeSwappedFromFirstPartOfTheWord, positionOfLetterToBeSwappedFromSecondPartOfTheWord);
            positionOfLetterToBeSwappedFromFirstPartOfTheWord++;
            positionOfLetterToBeSwappedFromSecondPartOfTheWord--;

        }
        StringBuilder newWord = new StringBuilder();
        newWord.append(letters);

        return newWord.toString();
    }

    private void swapLetters(char[] array, int i, int j) {

        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}

