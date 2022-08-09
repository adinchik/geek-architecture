package ru.geekbrains;

public class RequestParsing {

    public String[] getPartsOfFirstLineRequest(String firstLine) {
        String[] parts = firstLine.split(" ");
        System.out.println(firstLine);
        return parts;
    }


}
