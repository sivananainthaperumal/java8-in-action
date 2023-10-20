package com.dsp.Refactor.chainofresponsiblity;

public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    abstract protected T handleWork(T input);

    public T handle(T input){
        T r = handleWork(input);

        if(successor!=null){
            successor.handle(r);
        }
        return r;

    }
}
