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
        if(check(number)) {
            return get(number);
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
                if (!check(number)){
                    throw new MissingTranslationException(String.valueOf(number));
                }
                if (!word.equals("") && number == 0){
                return word;
                } else {
                    word += get(number);
                }
        }
        return word;
    }

    public boolean check(Integer number){
        return properties.containsKey(String.valueOf(number));
    }

    public boolean check(String number){
        return !properties.containsKey(number);
    }

    public String get(Integer number){
        return properties.getProperty(String.valueOf(number));
    }

    public String get(String number){
        return properties.getProperty(number);
    }

    public String makeTeens(Integer number) {
        if(!check(number / 10) || check("teen")){
            throw new MissingTranslationException(String.valueOf(number));
        }
        if(check(number)) {
            return get(number);
        }  else {
            return get(number % 10) + get("teen");
        }
    }

     public String makeTens(Integer number){
         if(!check(number / 10) || check("tens-suffix")
                 || check("tens-after-delimiter")){
             throw new MissingTranslationException(String.valueOf(number));
         }
         String answer = "";
         if (check(number - number % 10)){
             answer += get(number - number % 10);
         } else {
             answer += get(number / 10) + get("tens-suffix");
         }
         if (number % 10 != 0){
             answer += get("tens-after-delimiter");
         }
         return answer;
     }
      public String makeHundreds(Integer number) {
          if(!check(number / 100) || check("hundred") ||
                  check("hundreds-before-delimiter") || check("hundreds-after-delimiter")){
              throw new MissingTranslationException(String.valueOf(number));
          }
          String answer = get(number / 100) + get("hundreds-before-delimiter") +
                  get("hundred");
          if (number % 100 != 0){
              answer += get("hundreds-after-delimiter");
          }
          return answer;
      }
}
