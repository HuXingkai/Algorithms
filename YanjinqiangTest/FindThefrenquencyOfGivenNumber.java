package YanjinqiangTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andy on 2017/7/24.
 */
public class FindThefrenquencyOfGivenNumber {
    //找出给定的字符在字符串中出现的次数
    public int frenquencyOfNum(String str,char num) {
        int frequency=0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == num) {
                frequency+=1;
            }
        }
        return frequency;
    }

    //找出所有字符中出现频率最大的那个,并把所有的字符以及出现的频次输出
    public char maxFrequency(String str) {
        List<Character> chars = new ArrayList<>();
        Map<Character, Integer> maps = new HashMap<>();

        for (int j=0;j<str.length();j++) {
            char target=str.charAt(j);
            if (!chars.contains(target)) {
                chars.add(target);
                int num = frenquencyOfNum(str, target);
                maps.put(target, num);
            }
        }
        int maxFre=0;char maxCha='a';
        for (char charsset:maps.keySet()) {
            System.out.println(charsset+"--"+maps.get(charsset));
            if (maps.get(charsset) > maxFre) {
                maxFre=maps.get(charsset);
                maxCha=charsset;
            }
        }
        return maxCha;
    }

    public static void main(String[] args) {
        FindThefrenquencyOfGivenNumber find=new FindThefrenquencyOfGivenNumber();
        int answer = find.frenquencyOfNum("12134569875631477357", '7');
        System.out.println(answer);
        char charanswer = find.maxFrequency("12134569875631477357");
        System.out.println(charanswer);
    }
}
