package com.dsp.Refactor;

public class StrategyPatternRefactoring {


    public static void main(String[] args) {

        Validator lowerCaseValidator = new Validator(new ValidationStrategy() {
            @Override
            public boolean execute(String s) {
                return s.matches("[a-z]]+");
            }
        });

        Validator numericalValidator = new Validator(new ValidationStrategy() {
            @Override
            public boolean execute(String s) {
                return s.matches("\\d+");
            }
        });

        System.out.println(lowerCaseValidator.validate("asdf$"));
        System.out.println(numericalValidator.validate("sadfa"));

        Validator lowerCaseLambdaValidator = new Validator(s->s.matches("[a-z]+"));
        System.out.println(lowerCaseLambdaValidator.validate("asdfa"));
        Validator numericLambdaValidator = new Validator( s->s.matches("\\d+"));
        System.out.println(numericLambdaValidator.validate("234"));

    }


}
