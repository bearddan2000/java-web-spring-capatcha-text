package example;

import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultRestController {
  private String generateStr()
  {

      // chose a Character random from this String
      String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      // create StringBuffer size of AlphaNumericString
      StringBuilder sb = new StringBuilder(5);

      for (int i = 0; i < 5; i++) {

          // generate a random number between
          // 0 to AlphaNumericString variable length
          int index
              = (int)(AlphaString.length()
                      * Math.random());

          // add Character one by one in end of sb
          sb.append(AlphaString
                        .charAt(index));
      }

      return sb.toString();
  }

  @GetMapping("/capatcha")
  @ResponseBody
  public String getCapatcha() {
      return generateStr();
  }

  @PostMapping("/")
  @ResponseBody
  public String postCapatcha(@RequestParam String guess, @RequestParam String provided) {
      boolean res = guess.equals(provided);
      System.out.println("Guess: " + guess);
      System.out.println("Provided: " + provided);
      return String.format("Match: %s", res ? "true" : "false");
  }
}
