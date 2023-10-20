package com.dsp.Refactor.chainofresponsiblity;

public class AddFooter extends ProcessingObject<String>{
    @Override
    protected String handleWork(String input) {
        return "footer "+input;
    }
}
