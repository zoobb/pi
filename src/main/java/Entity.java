import static com.raylib.Raylib.*;

public class Entity {
  private final Vector2 pos;
  private final Vector2 velocity;
  private final float accQ;
  private final float friction = 0.999F;
  private final Vector2 screenCenter;

  public Entity(Vector2 pos, Vector2 velocity, float accQ, Vector2 screenCenter) {
    this.pos = pos;

    this.velocity = velocity;
    this.accQ = accQ;

    this.screenCenter = screenCenter;
  }

  public void positionUpdate(float deltaTime) {
    if (IsKeyDown(KEY_LEFT) || IsKeyDown(KEY_A)) moveLeft();
    if (IsKeyDown(KEY_RIGHT) || IsKeyDown(KEY_D)) moveRight();
    if (IsKeyDown(KEY_UP) || IsKeyDown(KEY_W)) moveUp();
    if (IsKeyDown(KEY_DOWN) || IsKeyDown(KEY_S)) moveDown();
    if (IsKeyDown(KEY_C)) {
      pos.x(screenCenter.x());
      pos.y(screenCenter.y());
      velocity.x(0);
      velocity.y(0);
    }
    if (IsKeyDown(KEY_V)) {
      velocity.x(0);
      velocity.y(0);
    }
    velocity.x(velocity.x() * friction);
    velocity.y(velocity.y() * friction);

    pos.x(pos.x() + velocity.x() * deltaTime);
    pos.y(pos.y() + velocity.y() * deltaTime);
  }
  public void moveLeft() {
    velocity.x(velocity.x() - accQ);
  }
  public void moveRight() {
    velocity.x(velocity.x() + accQ);
  }
  public void moveUp() {
    velocity.y(velocity.y() - accQ);
  }
  public void moveDown() {
    velocity.y(velocity.y() + accQ);
  }

  public Vector2 getPos() {
    return pos;
  }
  public float getX() {
    return pos.x();
  }
  public float getY() {
    return pos.y();
  }
}
