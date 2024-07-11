import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] nums = {1,1,1};
        int k = 1;
        long expected = 6;
        long actual = new  Solution().countSubarrays(nums, k);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[] nums = {0,0,4,6,2};
        int k = 6;
        long expected = 1;
        long actual = new  Solution().countSubarrays(nums, k);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        int[] nums = {1,9,9,7,4};
        int k = 1;
        long expected = 6;
        long actual = new  Solution().countSubarrays(nums, k);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void checkTest() {
        boolean expected = true;
        boolean actual = new  Solution().check(6, 6);

        Assert.assertEquals(expected, actual);
    }
}
