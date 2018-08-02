package ZTEtest;

/**
 * Created by andy on 2017/9/8.
 */
public class test {

    public int min(int num, int shot, int rem, int[] health) {
        int firenum=0;
        while (!ifDead(health)) {
            int index = findMac(health);
            for (int i=0;i<health.length;i++) {
                if (i == index) {
                    health[i]-=shot;
                }
                else {
                    health[i]-=rem;
                }
            }
            firenum++;
        }

        return firenum;

    }

    public int findMac(int[] health) {
        int index=0;
        int max=0;
        for (int i=0;i<health.length;i++) {
            if (health[i] > max) {
                max=health[i];
                index=i;
            }
        }
        return index;
    }

    public boolean ifDead(int[] health) {
        for (int i=0;i<health.length;i++) {
            if (health[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {9, 8, 2,5};
        test t=new test();
        int a = t.min(4, 3, 1, arr);
        System.out.println(a);
    }
}
