import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Main {
  public static void main(String[] args) {
    //Declaration
    int windowWidth = 1200;
    int windowHeight = 800;

    int ballX = windowWidth / 2;
    int ballY = windowHeight / 2;

    int ballSpeed = 5;
    Color bgColor = BLACK;

    InitWindow(windowWidth, windowHeight, "Boop");

    while (!WindowShouldClose()) {
      //Event handling
      switch (GetKeyPressed()) {
        case KEY_LEFT:
          ballX -= ballSpeed;
          break;
        case KEY_RIGHT:
          ballX += ballSpeed;
          break;
        case KEY_UP:
          ballY -= ballSpeed;
          break;
        case KEY_DOWN:
          ballY += ballSpeed;
          break;
        default:
          break;
      }
      BeginDrawing();
      ClearBackground(bgColor);
      // Drawing
      DrawCircle(ballX, ballY, 30, WHITE);
      EndDrawing();
    }
    CloseWindow();
  }
}

