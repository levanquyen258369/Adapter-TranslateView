package com.example.CodeBase.model;


import org.apache.commons.codec.DecoderException;


import java.io.*;
import java.util.Base64;


public class Images implements Convert<String, String>{
    @Override
    public String encode(String imagePath) {
      String base64ToImage = "";
      File file = new File(imagePath);
      try(FileInputStream imageInFile = new FileInputStream(file)) {
          byte imageData[] = new byte[(int) file.length()];
          imageInFile.read(imageData);
          base64ToImage = Base64.getEncoder().encodeToString(imageData);
      }catch (IOException ex){
          ex.printStackTrace();
      }
        return base64ToImage;
    }
    @Override
    public String decode(String base64Image) throws Exception {
        String pathFile = null;
        try(FileOutputStream imageOutFile = new FileOutputStream(pathFile)){
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return base64Image;
    }
}
