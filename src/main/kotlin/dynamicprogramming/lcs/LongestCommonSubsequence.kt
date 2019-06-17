package dynamicprogramming.lcs

import kotlin.math.max


fun longestCommonSubsequence(s1:String, s2:String):Int{
    val dpTable = mutableListOf<MutableList<Int>>()

    /**
     * Initialize the DP Table (there may be a way to do this smarter)
     */
    for(x in 0..s2.length){
        dpTable.add(x, mutableListOf())
        for(y in 0..s1.length){
            dpTable[x].add(y,0)
        }
    }

    for (i in 0..s2.length){
        for(j in 0..s1.length){

            /**
             * Base case for the LCS when one of the "words" is the empty string
             */
            if(i == 0 || j == 0){
                dpTable[i][j] = 0
            }

            else {
                /**
                 * CurrentChars do NOT MATCH -> take max LCS of its subproblems;
                 * That is "deleting" either the one or the other char (of s1 bzw. s2)
                 */
                if (s1[j-1] != s2[i-1]) dpTable[i][j] = max(dpTable[i-1][j],dpTable[i][j-1])

                /**
                 * CurrentChars DO MATCH -> take LCS of "deleting both chars" and INCREMENT BY ONE!
                 */
                else dpTable[i][j] = dpTable[i-1][j-1] + 1
            }
        }
    }
    return dpTable[s2.length][s1.length]
}


fun main(){
    println(longestCommonSubsequence(" abcdefghijklmnopq","apcdefghijklmnobq") == "acdefghijklmnoq".length)
}