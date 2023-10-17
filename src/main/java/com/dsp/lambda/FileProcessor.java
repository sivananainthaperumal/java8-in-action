package com.dsp.lambda;

import java.io.*;

public class FileProcessor {

    //Traditional way of processing the file
    public static String processFile() throws IOException{
        InputStream is = FileProcessor.class.getClassLoader().getResourceAsStream("data.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println(br.readLine());
        return br.readLine();
    }



    //Step 2: Create a method to pass on the functional interface and invoke the method on the functional interface
    public static String processFileUsingBufferedReaderProcessor(BufferedReaderProcessor processor) throws IOException{
        InputStream is = FileProcessor.class.getClassLoader().getResourceAsStream("data.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return processor.process(br);
    }
    public static void main(String[] args) throws IOException {

        System.out.println("Using Traditional Way");
        System.out.println(processFile());

        System.out.println("Using Anonymous Way");
        System.out.println(processFileUsingBufferedReaderProcessor(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine();
            }
        }));

        System.out.println("Using Lambda Way");
        //Step 3 : Pass on the behavior as the instance of the interface implementation.
        System.out.println(processFileUsingBufferedReaderProcessor(br->br.readLine()));
    }


}

// Step 1 : Create a Functional interface
@FunctionalInterface
interface BufferedReaderProcessor {

    String process(BufferedReader br) throws IOException;
}


