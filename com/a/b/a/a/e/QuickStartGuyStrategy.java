package com.a.b.a.a.e;

import com.a.b.a.a.c.Car;
import com.a.b.a.a.c.World;
import com.a.b.a.a.c.Move;
import com.a.b.a.a.c.Game;

// $FF: renamed from: com.a.b.a.a.e.b
public class QuickStartGuyStrategy implements Strategy {
    // $FF: renamed from: a (com.a.b.a.a.c.c, com.a.b.a.a.c.v, com.a.b.a.a.c.l, com.a.b.a.a.c.m) void
    public void move(Car self, World world, Game game, Move move) {

        double nextWaypointX = ((double) self.getNextWaypointX() + 0.5D) * game.getTrackTileSize();
        double nextWaypointY = ((double) self.getNextWaypointY() + 0.5D) * game.getTrackTileSize();

        double cornerTileOffset = 0.25D * game.getTrackTileSize();

        switch(world.getTilesXY()[self.getNextWaypointX()][self.getNextWaypointY()]) {
        case LEFT_TOP_CORNER:
            nextWaypointX += cornerTileOffset;
            nextWaypointY += cornerTileOffset;
            break;
        case RIGHT_TOP_CORNER:
            nextWaypointX -= cornerTileOffset;
            nextWaypointY += cornerTileOffset;
            break;
        case LEFT_BOTTOM_CORNER:
            nextWaypointX += cornerTileOffset;
            nextWaypointY -= cornerTileOffset;
            break;
        case RIGHT_BOTTOM_CORNER:
            nextWaypointX -= cornerTileOffset;
            nextWaypointY -= cornerTileOffset;
        }

        double angleToWaypoint = self.getAngleTo(nextWaypointX, nextWaypointY);
        double speedModule = StrictMath.hypot(self.getSpeedX(), self.getSpeedY());

        if(speedModule * speedModule * StrictMath.abs(angleToWaypoint) > 2.5D * 2.5D * StrictMath.PI) {
            move.setBrake(true);
        }

        move.setWheelTurn(angleToWaypoint * 32.0D / StrictMath.PI);
        move.setEnginePower(0.75D);
    }
}
