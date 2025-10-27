package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MinimumStack JUnit Tests")
class JUnitTest {

    private MinimumStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinimumStack();
    }

    // ---------- push() and getMin() ----------
    @Nested
    @DisplayName("push() and getMin()")
    class PushAndMin {

        @Test
        @DisplayName("finds correct min after all pushes")
        void correctMinAfterPushes() {
            int[] values = {Main.NUM1, Main.NUM2, Main.NUM3, Main.NUM4, Main.NUM5};
            for (int v : values) stack.push(v);
            assertEquals(15, stack.getMin());
        }

        @ParameterizedTest
        @ValueSource(ints = {10, -5, 100})
        @DisplayName("single value pushed is the min")
        void singleValueIsMin(int value) {
            stack.push(value);
            assertEquals(value, stack.getMin());
        }
    }

    // ---------- pop() ----------
    @Nested
    @DisplayName("pop() and min tracking")
    class PopTests {

        @BeforeEach
        void fillStack() {
            int[] values = {Main.NUM1, Main.NUM2, Main.NUM3, Main.NUM4, Main.NUM5};
            for (int v : values) stack.push(v);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2})
        @DisplayName("updates min correctly after pops")
        void minAfterPops(int popCount) {
            for (int i = 0; i < popCount; i++) stack.pop();
            int expected = (popCount == 1) ? 15 : 18;
            assertEquals(expected, stack.getMin());
        }
    }

    // ---------- edge cases ----------
    @Nested
    @DisplayName("edge cases")
    class EdgeCases {

        @Test
        void peekEmptyReturnsMinusOne() {
            assertEquals(-1, stack.peek());
        }

        @Test
        void getMinEmptyReturnsMinusOne() {
            assertEquals(-1, stack.getMin());
        }

        @Test
        void getMinAfterAllPoppedReturnsMinusOne() {
            stack.push(10);
            stack.pop();
            assertEquals(-1, stack.getMin());
        }
    }
}
