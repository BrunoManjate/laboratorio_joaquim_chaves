import java.io.IOException;

public class Video
{
  public Video() throws IOException
  {
	  String comando = "C:\\Users\\Kelvin\\Kelvin\\video\\joaquimChaves.mp4";  
	  Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " +comando);
  }
}
