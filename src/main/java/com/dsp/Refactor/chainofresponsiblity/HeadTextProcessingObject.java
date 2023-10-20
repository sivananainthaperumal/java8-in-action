package com.dsp.Refactor.chainofresponsiblity;

public class HeadTextProcessingObject extends ProcessingObject<String>{

    @Override
    protected String handleWork(String input) {
        return "From Principal"+ input;
    }
}
