import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Main {
  public static void main(String[] args) {
    // DECLARATION
    int windowWidth = 1200;
    int windowHeight = 800;

    int centerX = windowWidth / 2;
    int centerY = windowHeight / 2;

    Vector2 screenCenter = new Vector2();

    screenCenter.x((float) windowWidth / 2);
    screenCenter.y((float) windowHeight / 2);

    Vector2 initialVelocity = new Vector2();
    float ballAcc = 1;

    Vector2 ballPosition = new Vector2();

    ballPosition.x(centerX);
    ballPosition.y(centerY);

    initialVelocity.x(0);
    initialVelocity.y(0);

    String pos;

    Color bgColor = BLACK;

    Entity ball = new Entity(ballPosition, initialVelocity, ballAcc, screenCenter);

    InitWindow(windowWidth, windowHeight, "Boop");

    while (!WindowShouldClose()) {
      // EVENT HANDLING
      float deltaTime = GetFrameTime();

      ball.positionUpdate(deltaTime);
      pos = String.format("X: %.4f\n\nY: %.4f", ball.getX(), ball.getY());

      BeginDrawing();
      ClearBackground(bgColor);
      // DRAWING
      DrawText(pos, 0, 0, 24, WHITE);
      DrawCircleV(ball.getPos(), 30, WHITE);
      EndDrawing();
    }
    CloseWindow();
  }
}
