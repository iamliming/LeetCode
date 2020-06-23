package bit;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author liming
 * @version [版本号, 十月 25, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BitSetSolution
{
    /**
     * 187.repeated-dna-sequences
     * <p>
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
     * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
     * <p>
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA
     * molecule.
     * <p>
     * Example:
     * <p>
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * <p>
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s)
    {

        if (s == null || s.length() <= 10)
        {
            return new ArrayList<String>();
        }
        BitSet add = new BitSet();
        BitSet all = new BitSet();
        int[] table = new int[26];
        List<String> rst = new ArrayList<>();
        table['A' - 'A'] = 0;
        table['C' - 'A'] = 1;
        table['G' - 'A'] = 2;
        table['T' - 'A'] = 3;
        int hash = 0;
        int mode = 0xFFFFF;
        System.out.println(mode/64);
        for (int i = 0; i < 10; i++)
        {
            hash = hash << 2 | table[s.charAt(i) - 'A'];
        }
        all.set(hash);
        for(int i = 10; i < s.length(); i++){
            hash = (hash << 2 | table[s.charAt(i) - 'A']) & mode;
            if(all.get(hash)){
                if(!add.get(hash)){
                    add.set(hash);
                    rst.add(s.substring(i-9,i+1));
                }
            }
            else{
                all.set(hash);
            }
        }
        return rst;
    }

    public static void main(String[] args)
    {
        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i++ < 1000;){
//            stringBuilder.append(10000000000L*  Math.random()).append(" ");
//        }
        System.out.println(stringBuilder.toString());

       /* int[] nums = {2,2,3,2};
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
            System.out.println(ones+","+twos);
        }
        System.out.println();
        int i = 1;
        int j = ~i;
        System.out.println(i&j);
        System.out.println(~i);

        BitSetSolution setSolution = new BitSetSolution();
        System.out.println(setSolution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").size());*/
    }
}
