package lc.daily;

import java.util.*;

//https://leetcode.com/problems/number-of-matching-subsequences/submissions/
public class NumberofMatchingSubsequences {


// stringBuilder and array of list api info
//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append('w');
//        sb.deleteCharAt(sb.length())
//        sb.length()
//        sb.charAt()
//
//        LinkedList<StringBuilder>[] charToWordList = new LinkedList[26];
//        charToWordList[0] = new LinkedList<>();
//        charToWordList[0].addLast(new StringBuilder("test"));
//
//        System.out.println(charToWordList[0].getLast());
//    }



    public int numMatchingSubseq(String s, String[] words) {

        LinkedList<StringBuilder>[] charToWordList = new LinkedList[26];

        for(int i=0; i<26; ++i) {
            charToWordList[i] = new LinkedList<StringBuilder>();
        }

        for(String word: words) {
            char firstChar = word.charAt(0);
            charToWordList[firstChar - 'a'].addLast(new StringBuilder(word));
        }

        int res = 0;
        for(char c: s.toCharArray()) {

            int size = charToWordList[c - 'a'].size();
            LinkedList<StringBuilder> curMatches = charToWordList[c - 'a'];

            for(int i=0; i<size; ++i) {
                StringBuilder wordBuilder = curMatches.removeFirst();
                if(wordBuilder.length()==1)
                    res++;
                else {
                    wordBuilder.deleteCharAt(0);
                    charToWordList[wordBuilder.charAt(0) - 'a'].addLast(wordBuilder);
                }
            }

        }

        return res;

//------------------------------------------------------------------------------------------------------------//

        //TLE cause size of s is upto 5 * 10^4
        //Sol - visit each char in the String only once
        //by comparing the char with all the words in a single iteration.
        // definitely extra space by using a modified trie DS (linear - internally using list)
        // map char to word, but char range is 26 so instead of map -> arr[26] and stringBuilder for each str

//------------------------------------------------------------------------------------------------------------//


    }

//     public int numMatchingSubseq(String s, String[] words) {

//         HashMap<String, Integer> wordMap = new HashMap<>();
//         for(int i=0;i<words.length; ++i) {
//             wordMap.put(words[i], wordMap.getOrDefault(words[i], 0)+1);
//         }

//         return matchSubseq(s.toCharArray(), wordMap, new StringBuilder(), 0);

// //------------------------------------------------------------------------------------------------------------//
//         //Intituion
//         // form all subsequences by using choose/notChoose algorithm
//         // for each subsequence -> check if the word is availble in the given list
//         // TC - 2^n * m (for each subs -> m comparison in the words array)
//         // SC - Auxillary recurssion stack space




//         // use hashmap - TC - 2^n if no collision



// //------------------------------------------------------------------------------------------------------------//
//     }

//     private int matchSubseq(char[] strArr, HashMap<String, Integer> wordMap, StringBuilder seqHolder, int ind) {

//         if(wordMap.keySet().size()==0)
//             return 0;

//         if(ind==strArr.length) {
//             String seq = seqHolder.toString();
//             if(wordMap.containsKey(seq)) {
//                 int val = wordMap.get(seq);
//                 wordMap.remove(seq);
//                 return val;
//             } else {
//                 return 0;
//             }
//         }

//         seqHolder.append(strArr[ind]);
//         int take = matchSubseq(strArr, wordMap, seqHolder, ind+1);
// // $$$$$$$$$$$$$$$$$$$$ Api for deleting in stringBuilder $$$$$$$$$$$$$$$$$$$$$$$
//         seqHolder.deleteCharAt(seqHolder.length()-1);
//         int notTake = matchSubseq(strArr, wordMap, seqHolder, ind+1);

//         return take + notTake;
//     }
}
