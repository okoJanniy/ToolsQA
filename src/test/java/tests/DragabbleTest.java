package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragabblePage;

public class DragabbleTest extends BaseTest {

    @Test
    public void simpleDraggableTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.simpleDragBox();
        Assert.assertEquals(dragabblePage.getSimpleDragBoxPosition(), "100px x 150px");
    }

    @Test
    public void axisXRestrictedDraggableTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.axisXRestrictedBox();
        Assert.assertEquals(dragabblePage.getAxisXRestrictedDragBoxPosition(), "100px x 0px");
    }

    @Test
    public void axisYRestrictedDraggableTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.axisYRestrictedBox();
        Assert.assertEquals(dragabblePage.getAxisYRestrictedDragBoxPosition(), "0px x 100px");
    }

    @Test
    public void bigContainerRestrictedDraggableTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.bigContainerRestricted();
        Assert.assertEquals(dragabblePage.getBigContainerRestrictedDragBoxPosition(), "auto x auto");
    }

    @Test
    public void smallContainerRestrictedDraggableTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.smallContainerRestricted();
        Assert.assertEquals(dragabblePage.getSmallContainerRestrictedDragBoxPosition(), "auto x auto");
    }

    @Test
    public void cursorStyleTest() {
        DragabblePage dragabblePage = new DragabblePage();
        dragabblePage.open();
        dragabblePage.cursorStyle();
    }
}
