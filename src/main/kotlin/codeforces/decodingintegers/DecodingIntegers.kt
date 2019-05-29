package codeforces.decodingintegers

import java.util.*
import kotlin.collections.ArrayList

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints


fun decode(m:Int, seq:List<Int>){
    val seqNum = seq.filter { it == -1 }.count()
    val sequences = ArrayList<ArrayList<Int>>()
    val helper = ArrayDeque<Int>()
    for(i in 0 until seqNum){
        helper.add(i)
    }

    for(i in 0 until m){
        if (seq[i] == -1){
            val t = helper.first
            if(t >= sequences.size){
                        sequences.add(ArrayList())
                    }
            helper.removeFirst()
        }

        else {
            val t = helper.first
            helper.removeFirst()
            if(t >= sequences.size){
                sequences.add(ArrayList())
            }
            sequences[t].add(seq[i])
            helper.add(t)
        }
    }
    println("$seqNum")
    for(e in sequences){
        print("${e.size} ")
        for(ei in e){
            print("$ei ")
        }
        print("\n")
    }
}


fun main(args:Array<String>){
    val m = readInt()
    val seq = readInts()
    decode(m,seq)
}