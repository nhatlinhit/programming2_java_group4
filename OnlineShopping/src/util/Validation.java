package util;

public class Validation {
 public static IntValidationResult isInt(String input, String msg) {
  IntValidationResult result = new IntValidationResult();
  try {
   result.value = Integer.parseInt(input);
   result.isValid = true;
   return result;
  }
  catch (NumberFormatException e)
  {
   System.out.println(msg);
   result.isValid = false;
   result.value = 0;
   return result;
  }
 }
}

