package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DroppablePage;

public class DroppableTest extends BaseTest {

    @Test
    public void simpleDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.simpleDragAndDrop();
        Assert.assertEquals(droppablePage.getSimpleDroppableBoxMessage(), "Dropped!");
    }

    @Test
    public void acceptDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.notAcceptableDragAndDrop();
        Assert.assertEquals(droppablePage.getAcceptableDroppableBoxMessage(), "Drop here");
        droppablePage.acceptableDragAndDrop();
        Assert.assertEquals(droppablePage.getAcceptableDroppableBoxMessage(), "Dropped!");
    }

    @Test
    public void notGreedyDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.dragToNotGreedyAndDrop();
        Assert.assertEquals(droppablePage.getNotGreedyDroppableBoxesMessages(), "Dropped!\nDropped!");
    }

    @Test
    public void greedyDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.dragToGreedyAndDrop();
        Assert.assertEquals(droppablePage.getGreedyDroppableBoxesMessages(), "Outer droppable\nDropped!");
    }

    @Test
    public void revertableDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.dragBoxWillRevert();
        Assert.assertEquals(droppablePage.getRevertableDroppableBoxMessage(), "Dropped!");
        Assert.assertEquals(droppablePage.getRevertableBoxPosition(), "0px x 0px");
    }

    @Test
    public void notRevertableDroppableTest() {
        DroppablePage droppablePage = new DroppablePage();
        droppablePage.open();
        droppablePage.dragBoxWillNotRevert();
        Assert.assertEquals(droppablePage.getRevertableDroppableBoxMessage(), "Dropped!");
        Assert.assertEquals(droppablePage.getNotRevertableBoxPosition(), "263px x -17px");
    }
}
