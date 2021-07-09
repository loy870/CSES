package Archive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


public class Dioph {

    public static String solEquaStr(long n) {
        LinkedList<List<Long>> result = new LinkedList<>();

        for(long x=0; x < Math.sqrt(n) + 1; x++){
            double y = Math.pow(((double) x-Math.sqrt(n))/2, 2);
            if(y % 1 == 0){
                List<Long> list = new ArrayList<>();
                list.add(x);
                list.add((long) y);
                result.addFirst(list);
            };
        }
        return result.toString();
    }

    @Test
    public void test1() {
        Assertions.assertEquals("[[3, 1]]", solEquaStr(5));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("[[4, 1]]", Dioph.solEquaStr(12));
    }

    @Test
    public void test3() {
        Assertions.assertEquals("[[7, 3]]", Dioph.solEquaStr(13));
    }

    @Test
    public void test4() {
        Assertions.assertEquals("[[4, 0]]", Dioph.solEquaStr(16));
    }

    @Test
    public void test5() {
        Assertions.assertEquals("[[9, 4]]", Dioph.solEquaStr(17));
    }

    @Test
    public void test6() {
        Assertions.assertEquals("[[6, 2]]", Dioph.solEquaStr(20));
    }

    @Test
    public void test7() {
        Assertions.assertEquals("[[4501, 2250]]", Dioph.solEquaStr(9001));
    }

    @Test
    public void test8() {
        Assertions.assertEquals("[[2252, 1125]]", Dioph.solEquaStr(9004));
    }

    @Test
    public void test9() {
        Assertions.assertEquals("[[4503, 2251], [903, 449]]", Dioph.solEquaStr(9005));
    }

    @Test
    public void test10() {
        Assertions.assertEquals("[[1128, 562]]", Dioph.solEquaStr(9008));
    }

    @Test
    public void test11() {
        String a = "[[4505, 2252], [1503, 750], [647, 320], [505, 248], [415, 202], [353, 170], [225, 102], [153, 60], [135, 48], [103, 20], [97, 10], [95, 2]]";
        Assertions.assertEquals(a, Dioph.solEquaStr(9009));
    }

    @Test
    public void test12() {
        Assertions.assertEquals("[[45001, 22500]]", Dioph.solEquaStr(90001));
    }

    @Test
    public void test13() {
        Assertions.assertEquals("[]", Dioph.solEquaStr(90002));
    }

    @Test
    public void test14() {
        Assertions.assertEquals("[[22502, 11250]]", Dioph.solEquaStr(90004));
    }

    @Test
    public void test15() {
        Assertions.assertEquals("[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]", Dioph.solEquaStr(90005));
    }

    @Test
    public void test16() {
        Assertions.assertEquals("[[45005, 22502], [15003, 7500], [5005, 2498], [653, 290], [397, 130], [315, 48]]", Dioph.solEquaStr(90009));
    }

    @Test
    public void test17() {
        Assertions.assertEquals("[[112502, 56249], [56254, 28123], [37506, 18747], [22510, 11245], [18762, 9369], [12518, 6241], [11270, 5615], [7530, 3735], [6286, 3107], [4550, 2225], [3810, 1845], [2590, 1205], [2350, 1075], [1650, 675], [1430, 535], [1150, 325], [1050, 225], [950, 25]]", Dioph.solEquaStr(900000));
    }

    @Test
    public void test18() {
        Assertions.assertEquals("[[450001, 225000]]", Dioph.solEquaStr(900001));
    }

    @Test
    public void test19() {
        Assertions.assertEquals("[[225002, 112500], [32150, 16068]]", Dioph.solEquaStr(900004));
    }

    @Test
    public void test20() {
        Assertions.assertEquals("[[450003, 225001], [90003, 44999]]", Dioph.solEquaStr(900005));
    }

    @Test
    public void test21() {
        Assertions.assertEquals("[[4500001, 2250000], [73801, 36870]]", Dioph.solEquaStr(9000001));
    }

    @Test
    public void test22() {
        Assertions.assertEquals("[[2250002, 1125000], [173090, 86532], [132370, 66168], [10402, 4980]]", Dioph.solEquaStr(9000004));
    }

    @Test
    public void test23() {
        Assertions.assertEquals("[[4500003, 2250001], [900003, 449999], [642861, 321427], [155187, 77579], [128589, 64277], [31107, 15481], [22269, 11033], [4941, 1963]]", Dioph.solEquaStr(9000005));
    }

    @Test
    public void test24() {
        Assertions.assertEquals("[[45000001, 22500000], [6428575, 3214284], [3461545, 1730766], [494551, 247230]]", Dioph.solEquaStr(90000001));
    }

    @Test
    public void test25() {
        Assertions.assertEquals("[[22500002, 11250000], [252898, 126360], [93602, 46560], [22498, 10200]]", Dioph.solEquaStr(90000004));
    }

    @Test
    public void test26() {
        Assertions.assertEquals("[[450000005, 225000002], [150000003, 75000000], [50000005, 24999998], [26470597, 13235290], [8823555, 4411752], [2941253, 1470550]]", Dioph.solEquaStr(900000009));
    }

    @Test
    public void test27() {
        Assertions.assertEquals("[[225000004, 112500001], [75000004, 37499999], [3358276, 1679071], [1119604, 559601]]", Dioph.solEquaStr(900000012));
    }

    @Test
    public void test28() {
        Assertions.assertEquals("[[4500000021, 2250000010], [155172429, 77586200]]", Dioph.solEquaStr(9000000041l));
    }

}