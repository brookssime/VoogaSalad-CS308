package game_engine;

/**
 * This is the Sprite abstract interface
 * Sprites such as Tower, Base, Enemy, and Projectile will extend this
 * There are no methods because the sprite object is going to be very low in the hierarchy
 * However, each sprite will hold instance variables, such as its health.
 * The SpriteManager class (detailed in Design Details) will handle moving the sprites
 * That SpriteManager class is also going to handle collisions, deaths, etc.
 * @author Sid
 *
 */


public interface Sprite {

}
