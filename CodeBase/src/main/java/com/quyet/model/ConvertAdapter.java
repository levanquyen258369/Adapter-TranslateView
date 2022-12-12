package com.quyet.model;

public class ConvertAdapter {

    public static String convert(String inputData, String sourceType, String destinationType) throws Exception {
        StringEncoder sourceEncoder = DataTypeEnum.valueOf(sourceType).getEncoder();
        byte[] processingData = sourceEncoder.decode(inputData);
        StringEncoder destinationEncoder = DataTypeEnum.valueOf(destinationType).getEncoder();
        return destinationEncoder.encode(processingData);
    }

}

