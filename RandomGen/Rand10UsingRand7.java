/*
Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().

 */
 /**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
 class Rand10UsingRand7 extends SolBase {
    public int rand10() 
    {
        int k=rand7()*7+rand7()-7;
        if(k<41)
        {
            return k%10+1;
        }
        else
            return rand10();
    }
}
