package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DishStackTest {

    // Tests for Dish class
    @Test
    public void testDishCreation() {
        Dish dish = new Dish("Spaghetti");
        assertEquals("Spaghetti", dish.getDescription());
    }

    @Test
    public void testDishDescription() {
        Dish dish = new Dish("Pizza");
        dish.description = "Margherita Pizza";
        assertEquals("Margherita Pizza", dish.getDescription());
    }

    // Tests for DishStack class
    @Test
    public void testPushAndPeek() {
        DishStack stack = new DishStack();
        Dish dish1 = new Dish("Plate");
        Dish dish2 = new Dish("Bowl");

        stack.push(dish1);
        assertEquals(dish1, stack.peek());
        assertEquals(1, stack.size());

        stack.push(dish2);
        assertEquals(dish2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPop() {
        DishStack stack = new DishStack();
        Dish dish1 = new Dish("Plate");
        Dish dish2 = new Dish("Bowl");

        stack.push(dish1);
        stack.push(dish2);

        Dish popped = stack.pop();
        assertEquals(dish2, popped);
        assertEquals(1, stack.size());
        assertEquals(dish1, stack.peek());

        popped = stack.pop();
        assertEquals(dish1, popped);
        assertEquals(0, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        DishStack stack = new DishStack();
        assertThrows(NullPointerException.class, stack::pop);
    }

    @Test
    public void testPeekEmptyStack() {
        DishStack stack = new DishStack();
        assertThrows(NullPointerException.class, stack::peek);
    }

    @Test
    public void testSize() {
        DishStack stack = new DishStack();
        assertEquals(0, stack.size());

        stack.push(new Dish("Plate"));
        assertEquals(1, stack.size());

        stack.push(new Dish("Bowl"));
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testStackOrder() {
        DishStack stack = new DishStack();
        Dish dish1 = new Dish("First");
        Dish dish2 = new Dish("Second");
        Dish dish3 = new Dish("Third");

        stack.push(dish1);
        stack.push(dish2);
        stack.push(dish3);

        assertEquals(dish3, stack.pop());
        assertEquals(dish2, stack.pop());
        assertEquals(dish1, stack.pop());
    }
}