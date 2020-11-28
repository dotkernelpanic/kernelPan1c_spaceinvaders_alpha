package com.kernelpan1c.spaceinvander_thegame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.kernelpan1c.spaceinvander_thegame.GameView.screenRatioX;
import static com.kernelpan1c.spaceinvander_thegame.GameView.screenRatioY;

public class Bullet {

    int x, y, width, height;
    Bitmap bullet;

    Bullet (Resources resources) {

        bullet = BitmapFactory.decodeResource( resources, R.drawable.bullet );

        width   = bullet.getWidth();
        height  = bullet.getHeight();

        width   /= 4;
        height  /= 4;

        width   = (int) (width * screenRatioX);
        height  = (int) (height * screenRatioY);

        bullet = Bitmap.createScaledBitmap( bullet, width, height, false );

    }

    Rect getCollision () {
        return new Rect( x, y, x + width, y + height );
    }


}
