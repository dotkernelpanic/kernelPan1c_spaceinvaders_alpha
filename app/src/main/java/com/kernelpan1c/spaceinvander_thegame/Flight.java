package com.kernelpan1c.spaceinvander_thegame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.kernelpan1c.spaceinvander_thegame.GameView.screenRatioX;
import static com.kernelpan1c.spaceinvander_thegame.GameView.screenRatioY;


public class Flight {

    public boolean isGoingUp            = false;
    public int      toShoot             = 0;
    int x, y, width, height, counter    = 0, shootCounter = 1;
    Bitmap rocket1, rocket2, shoot1, shoot2, shoot3, shoot4, shoot5, dead;
    private GameView gameView;

    Flight (GameView gameView, int screenY, Resources resources) {

        this.gameView = gameView;

        rocket1 = BitmapFactory.decodeResource ( resources, R.drawable.rocket1 );
        rocket2 = BitmapFactory.decodeResource ( resources, R.drawable.rocket2 );

        width   = rocket1.getWidth();
        height  = rocket1.getHeight();

        width   /= 4;
        height  /= 4;

        width   = (int) (width * screenRatioX);
        height  = (int) (height * screenRatioY);

        rocket1 = Bitmap.createScaledBitmap( rocket1, width, height, false);
        rocket2 = Bitmap.createScaledBitmap( rocket2, width, height, false);

        shoot1 = BitmapFactory.decodeResource( resources, R.drawable.shoot1 );
        shoot2 = BitmapFactory.decodeResource( resources, R.drawable.shoot2 );
        shoot3 = BitmapFactory.decodeResource( resources, R.drawable.shoot3 );
        shoot4 = BitmapFactory.decodeResource( resources, R.drawable.shoot4 );
        shoot5 = BitmapFactory.decodeResource( resources, R.drawable.shoot5 );

        shoot1 = Bitmap.createScaledBitmap( shoot1, width, height, false );
        shoot2 = Bitmap.createScaledBitmap( shoot2, width, height, false );
        shoot3 = Bitmap.createScaledBitmap( shoot3, width, height, false );
        shoot4 = Bitmap.createScaledBitmap( shoot4, width, height, false );
        shoot5 = Bitmap.createScaledBitmap( shoot5, width, height, false );

        dead   = BitmapFactory.decodeResource( resources, R.drawable.dead );
        dead   = Bitmap.createScaledBitmap( dead, width, height, false );

        y = screenY / 2;
        x = (int) (64 * screenRatioX);
    }

    Bitmap getFlight () {

        if ( toShoot != 0 ) {

            if ( shootCounter == 1 ) {
                shootCounter++;
                return shoot1;
            }

            if ( shootCounter == 2 ) {
                shootCounter++;
                return shoot2;
            }

            if ( shootCounter == 3 ) {
                shootCounter++;
                return shoot3;
            }

            if ( shootCounter == 4 ) {
                shootCounter++;
                return shoot4;
            }

            shootCounter = 1;
            toShoot--;
            gameView.create_new_bullet();

            return shoot5;
        }

        if ( counter == 0 ) {
            counter++;
            return rocket1;
        }

        counter--;
        return rocket2;
    }

    Rect getCollision () {
        return new Rect( x, y, x + width, y + height );
    }

    Bitmap getDead() {
        return dead;
    }
}
