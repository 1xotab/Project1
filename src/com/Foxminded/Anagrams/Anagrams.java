package com.Foxminded.Anagrams;

public class Anagrams {

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
        StringBuilder wordWithSwappedLetters = new StringBuilder();
        wordWithSwappedLetters.append(letters);

        return wordWithSwappedLetters.toString();
    }

    private void swapLetters(char[] array, int i, int j) {

        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public String swapLettersInTheWords(String someWords) {

        String space = " ";
        String[] words = someWords.split(space);
        StringBuilder sentence = new StringBuilder();

        for (String s : words) {
            sentence.append(swapLettersInTheWord(s));
            sentence.append(space);
        }
        return sentence.toString();
    }
}

