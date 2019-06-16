package tddbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ClosedRangeTest {

    private ClosedRange closedRange;

    @BeforeEach
    public void before() {
        closedRange = new ClosedRange(3,8);
    }


    @Nested
    class 上下端が保持できること {
        @Test
        void 閉区間3_8を保持できること() {
            int lowerValue = closedRange.getLowerEndpoint();
            int upperValue = closedRange.getUpperEndpoint();

            assertEquals(3, lowerValue);
            assertEquals(8, upperValue);
        }
    }

    @Nested
    class 整数の閉区間の文字列を返すこと {

        @Test
        void 閉区間3_8を文字列を返すこと() {
            String closedRangeString = closedRange.toString();

            assertEquals("[3,8]", closedRangeString);
        }

    }

    @Nested
    class 整数の閉区間は上端点より下端点が大きい閉区間を作ることはできないこと {

        @Test
        void 閉区間8_3生成時に例外をスローすること() {

            try {
                ClosedRange closedRange = new ClosedRange(8, 3);
                fail("例外が発生しなかったので失敗");
            }
            catch (IllegalArgumentException ex) {
                assertEquals(IllegalArgumentException.class, ex.getClass());
            }

        }
    }

    @Nested
    class 整数の閉区間は指定した整数を含むかどうかを判定できること {

        @Test
        void 閉区間3_8にcontains_3の時はtrueが返ること() {
            assertEquals(true, closedRange.contains(3));
        }

        @Test
        void 閉区間3_8にcontains_5の時はtrueが返ること() {
            assertEquals(true, closedRange.contains(5));
        }

        @Test
        void 閉区間3_8にcontains_8の時はtrueが返ること() {
            assertEquals(true, closedRange.contains(8));
        }

        @Test
        void 閉区間3_8にcontains_2の時はfalseが返ること() {
            assertEquals(false, closedRange.contains(2));
        }

        @Test
        void 閉区間3_8にcontains_9の時はfalseが返ること() {
            assertEquals(false, closedRange.contains(9));
        }
    }

    @Nested
    class 整数の閉区間は同一の範囲の閉区間かどうかを判定できること {

        @Test
        void 閉区間3_8に同一の閉区間3_8をequalsで比較した時はtrueが返ること() {
            ClosedRange sameClosedRange = new ClosedRange(3, 8);

            boolean isEqual = closedRange.equals(sameClosedRange);
            assertEquals(true, isEqual);
        }

        @Test
        void 閉区間3_8に異なる閉区間4_9をequalsで比較した時はfalseが返ること() {
            ClosedRange differentClosedRange = new ClosedRange(4, 9);

            boolean isEqual = closedRange.equals(differentClosedRange);
            assertEquals(false, isEqual);
        }
    }

    @Nested
    class 閉区間に対して別の閉区間が完全に含まれるかどうかを判定できること {

        @Test
        void 閉区間3_8に別の閉区間4_7が含まれること() {
            ClosedRange containsClosedRange = new ClosedRange(4, 7);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(true, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間3_8が含まれること() {
            ClosedRange containsClosedRange = new ClosedRange(3, 8);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(true, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間0_2が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 2);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間0_3が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 3);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間0_4が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 4);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間0_8が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 8);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間0_9が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 9);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

        @Test
        void 閉区間3_8に別の閉区間_9が含まれないこと() {
            ClosedRange containsClosedRange = new ClosedRange(0, 9);
            boolean contains = closedRange.contains(containsClosedRange);
            assertEquals(false, contains);
        }

    }
}
