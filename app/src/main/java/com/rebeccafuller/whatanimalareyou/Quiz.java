package com.rebeccafuller.whatanimalareyou;

import java.util.LinkedList;
import java.util.List;

class Quiz {
    private final String[] answers;
    private int index;
    private List<Integer> mAnswers;

    private final int[] dolphinNums = {3, 4, 1, 4, 5, 5, 3, 4};
    private final int[] elephantNums = {1, 5, 2, 2, 1, 5, 1, 3};
    private final int[] monkeyNums = {5, 3, 5, 1, 2, 1, 2, 5};
    private final int[] redPandaNums = {4, 1, 4, 3, 4, 3, 2, 3};
    private final int[] tigerNums = {2, 2, 3, 5, 3, 2, 2, 3};
    private final int[] seagullNums = {1, 2, 3, 3, 2, 1, 1, 3};
    private final int[] snakeNums = {5, 1, 3, 5, 5, 3, 3, 1};
    private final int[] spiderNums = {4, 1, 5, 5, 5, 1, 1, 1};
    private final int[] turtleNums = {3, 1, 1, 4, 5, 5, 3, 4};
    private final int[] whaleNums = {1, 1, 1, 3, 3, 5, 3, 3};

    private int dolphin;
    private int elephant;
    private int monkey;
    private int redPanda;
    private int seagull;
    private int snake;
    private int spider;
    private int tiger;
    private int turtle;
    private int whale;

    private String animal;

    public Quiz(String[] answers) {
        this.answers = answers;
        getAnswersAsNum();
    }

    private void getAnswersAsNum() {
        mAnswers = new LinkedList<>();
        index = 0;
        while (index < 7) {
            if (answers[index].equals("Agree completely")) {
                mAnswers.add(1);
            } else if (answers[index].equals("Agree somewhat")) {
                mAnswers.add(2);
            } else if (answers[index].equals("Neutral")) {
                mAnswers.add(3);
            } else if (answers[index].equals("Disagree somewhat")) {
                mAnswers.add(4);
            } else if (answers[index].equals("Disagree completely")){
                mAnswers.add(5);
            }
            index++;
        }
        testAnswers();
    }

    private void testAnswers() {
        index = 0;
        while (index < 7) {
            animalNums(index);
            index++;
        }
    }


    private void animalNums(int index) {
        if (mAnswers.get(index) == dolphinNums[index]) {
            dolphin++;
        }
        if (mAnswers.get(index) == elephantNums[index]) {
            elephant++;
        }
        if (mAnswers.get(index) == monkeyNums[index]) {
            monkey++;
        }
        if (mAnswers.get(index) == redPandaNums[index]) {
            redPanda++;
        }
        if (mAnswers.get(index) == seagullNums[index]) {
            seagull++;
        }
        if (mAnswers.get(index) == snakeNums[index]) {
            snake++;
        }
        if (mAnswers.get(index) == spiderNums[index]) {
            spider++;
        }
        if (mAnswers.get(index) == tigerNums[index]) {
            tiger++;
        }
        if (mAnswers.get(index) == turtleNums[index]) {
            turtle++;
        }
        if (mAnswers.get(index) == whaleNums[index]) {
            whale++;
        }
        getMaxAnimal();
    }

    private void getMaxAnimal() {
        int a = Math.max(dolphin, elephant);
        int b = Math.max(monkey, redPanda);
        int c = Math.max(seagull, snake);
        int d = Math.max(spider, tiger);
        int e = Math.max(turtle, whale);

        int f = Math.max(a, b);
        int g = Math.max(c, d);
        int h = Math.max(e, f);
        int max = Math.max(g, h);

        getAnimalString(max);
    }

    private void getAnimalString(int max) {
        if (max == dolphin) {
            animal = "dolphin";
        } else if (max == elephant) {
            animal = "elephant";
        } else if (max == monkey) {
            animal = "monkey";
        } else if (max == redPanda) {
            animal = "red panda";
        } else if (max == seagull) {
            animal = "seagull";
        } else if (max == snake) {
            animal = "snake";
        } else if (max == spider) {
            animal = "spider";
        } else if (max == tiger) {
            animal = "tiger";
        } else if (max == turtle) {
            animal = "turtle";
        } else if (max == whale) {
            animal = "whale";
        }
        if (animal == null) {
            animal = "dolphin";
        }
    }

    public String getAnimal() {
        return animal;
    }
}
