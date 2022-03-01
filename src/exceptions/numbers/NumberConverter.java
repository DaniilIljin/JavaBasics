package exceptions.numbers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class NumberConverter {
    private Properties properties;

    public NumberConverter(String lang) {
        String filePath = "src/exceptions/numbers/numbers_" + lang + ".properties";
        properties = new Properties();
        FileInputStream is = null;
        try {
            is = new FileInputStream(filePath);

            InputStreamReader reader = new InputStreamReader(
                    is, StandardCharsets.UTF_8);

            properties.load(reader);
        }catch (IOException e){
            throw new MissingLanguageFileException(lang, e);
        } catch (IllegalArgumentException e) {
            throw new BrokenLanguageFileException(lang, e);
        } finally {
            close(is);
        }
    }

    private static void close(FileInputStream is) {
        if (is == null) {
            return;
        }

        try {
            is.close();
        } catch (IOException ignore) {}
    }

    public String numberInWords(Integer number) {
        if(properties.containsKey(String.valueOf(number))) {
            return properties.getProperty(String.valueOf(number));
        }
        String word = "";
        if (number > 99 && number < 1000){
            word += makeHundreds(number);
            number = number % 100;
        }
        if (number > 19 && number < 100){
            word += makeTens(number);
            number = number % 10;
        }
        if (number > 10 && number < 20){
            word += makeTeens(number);
        } else {
                if (!properties.containsKey(String.valueOf(number))){
                    throw new MissingTranslationException(String.valueOf(number));
                }
                if (word != "" && number == 0){
                return word;
                } else {
                    word += properties.getProperty(String.valueOf(number));
                }
        }
        return word;
    }

    public String makeTeens(Integer number) {
        if(!properties.containsKey(String.valueOf(number / 10)) || !properties.containsKey("teen")){
            throw new MissingTranslationException(String.valueOf(number));
        }
        if(properties.containsKey(String.valueOf(number))) {
            return properties.getProperty(String.valueOf(number));
        }  else {
            return properties.getProperty(String.valueOf(number % 10)) + properties.getProperty("teen");}
    }

     public String makeTens(Integer number){
         if(!properties.containsKey(String.valueOf(number / 10)) || !properties.containsKey("tens-suffix")
                 || !properties.containsKey("tens-after-delimiter")){
             throw new MissingTranslationException(String.valueOf(number));
         }
         String answer = "";
         if (properties.containsKey(String.valueOf(number - number % 10))){
             answer += properties.getProperty(String.valueOf(number - number % 10));
         } else {
             answer += properties.getProperty(String.valueOf(number / 10)) + properties.getProperty("tens-suffix");
         }
         if (number % 10 != 0){
             answer += properties.getProperty("tens-after-delimiter");
         }
         return answer;
     }
      public String makeHundreds(Integer number) {
          if(!properties.containsKey(String.valueOf(number / 100)) || !properties.containsKey("hundred") ||
                  !properties.containsKey("hundreds-before-delimiter") || !properties.containsKey("hundreds-after-delimiter")){
              throw new MissingTranslationException(String.valueOf(number));
          }
          String answer = properties.getProperty(String.valueOf(number / 100)) + properties.getProperty("hundreds-before-delimiter") +
                  properties.getProperty("hundred");
          if (number % 100 != 0){
              answer += properties.getProperty("hundreds-after-delimiter");
          }
          return answer;
      }
}
