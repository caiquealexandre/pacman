package jogo;

//import java.io.FileInputStream;
import java.io.PrintStream;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;


public class Som
{
  public static void reproduzir(String som)
  {
    try
    {
//      AudioPlayer MGP = AudioPlayer.player;
//      AudioStream BGM = new AudioStream(new FileInputStream(som));
//      MGP.start(BGM);
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
