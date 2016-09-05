package com.alanrusnak.api2048.engine;

import com.alanrusnak.api2048.engine.model.Tile;
import org.junit.Assert;
import org.junit.Test;

public class MoveExecutorTest {

    MoveExecutor moveExecutor = new MoveExecutor();

    @Test
    public void testSlideTile0Spaces(){
        Tile[] row = row(0,0,0,2);
        moveExecutor.slideRight(row);
        Assert.assertEquals(2, row[3].getValue());
    }

    @Test
    public void testSlideTile1Spaces(){
        Tile[] row = row(0,0,2,0);
        moveExecutor.slideRight(row);
        Assert.assertEquals(2, row[3].getValue());
    }

    @Test
    public void testSlideTile2Spaces(){
        Tile[] row = row(0,2,0,0);
        moveExecutor.slideRight(row);
        Assert.assertEquals(2, row[3].getValue());
    }

    @Test
    public void testSlideTile3Spaces(){
        Tile[] row = row(2,0,0,0);
        moveExecutor.slideRight(row);
        Assert.assertEquals(2, row[3].getValue());
    }

    @Test
    public void testSlideTileWithSpaceTaken(){
        Tile[] row = row(2,0,0,4);
        moveExecutor.slideRight(row);
        Assert.assertEquals(2, row[2].getValue());
    }

    @Test
    public void testMergeTwoTiles(){
        Tile[] row = row(2,0,0,2);
        moveExecutor.slideRight(row);
        Assert.assertEquals(4, row[3].getValue());
    }

    @Test
    public void testMergeTwoTilesWithOneOnRight(){
        Tile[] row = row(2,0,2,4);
        moveExecutor.slideRight(row);
        Assert.assertEquals(4, row[2].getValue());
    }

    @Test
    public void testMergeTwoTilesWithOneOnLeft(){
        Tile[] row = row(8,0,4,4);
        moveExecutor.slideRight(row);
        Assert.assertEquals(8, row[2].getValue());
        Assert.assertEquals(8, row[3].getValue());
    }

    @Test
    public void testMergeFourTiles(){
        Tile[] row = row(2,2,2,2);
        moveExecutor.slideRight(row);
        Assert.assertEquals(0, row[1].getValue());
        Assert.assertEquals(4, row[2].getValue());
        Assert.assertEquals(4, row[3].getValue());
    }

    private Tile[] row(int t1, int t2, int t3, int t4){
        return new Tile[]{new Tile(t1), new Tile(t2), new Tile(t3), new Tile(t4)};
    }
}