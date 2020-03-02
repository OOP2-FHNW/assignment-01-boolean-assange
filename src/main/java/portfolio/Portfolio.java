package portfolio;

import portfolio.investments.Investment;
import portfolio.investments.Share;

import java.util.ArrayList;
import java.util.List;

public class Portfolio<T extends Investment> {

    private List<T> myShares = new ArrayList<>();

    public boolean contains(Share s) {
        return myShares.contains(s);
    }

    public void buy(Share s) {
        if (myShares.contains(s)) {
            for (T sh : myShares) {
                if (sh.equals(s)) {
                    sh.setCount(sh.getCount() + s.getCount());
                }
            }
        } else {
            myShares.add((T) s);
        }
    }

    public void sell(String s, int amount) {
        for (T sh : myShares) {
            if(sh.getTitel().equals(s)){
                if(sh.getCount() == amount){
                    sh.setCount(sh.getCount()-amount);
                    myShares.remove(sh);
                    return;
                } else {
                    sh.setCount(sh.getCount() - amount);
                }
            }
        }
    }

    public Object getShare(String s) {
        for (T sh : myShares) {
            if(sh.getTitel().equals(s)) {
                return sh;
            }
        }
        return null;
    }

}
