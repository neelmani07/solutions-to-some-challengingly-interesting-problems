/*
Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.*/

class Solution {
    public int maxSatisfied(int[] c, int[] g, int x) {
        int nT=0;
        for(int i=0;i<c.length;i++){
            nT+=g[i]==0?c[i]:0;
        }
        int bstT=nT;int st=0;
        nT=findForFirstWindow(0,x-1,c,g,nT);bstT=bstT>nT?bstT:nT;
        nT=bstT;
        for(int end=x;end<c.length;st++,end++){
            if(g[end]==1)nT+=c[end];
            if(g[st]==1)nT-=c[st];
            bstT=bstT>nT?bstT:nT;
        }
        return bstT;
    }
    public int findForFirstWindow(int st,int e,int[] c,int [] g,int tprev){
        int newt=tprev;
        for(int k=st;k<=e;k++){
            if(g[k]==1)
                newt+=c[k];
        }
        return newt;
    }
}
