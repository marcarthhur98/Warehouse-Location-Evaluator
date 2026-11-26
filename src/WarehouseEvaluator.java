public class WarehouseEvaluator {

    public long calculateScore(WarehouseCandidate candidate, Customer[] customers){
        long score = 0;
        for(Customer customer: customers){
           score += (long)( Math.abs(candidate.getX() - customer.getX())
                   + Math.abs(candidate.getY() - customer.getY()) )
                   * customer.getDemand();
        }
        return score;
    }

    public long[] evaluateSequential(WarehouseCandidate[] candidates, Customer[] customers){
        long[] scores = new long[candidates.length];
        for(int i = 0; i < candidates.length; i++){
            scores[i] = calculateScore(candidates[i], customers);
        }
        return scores;
    }

    public int findBestCandidate(WarehouseCandidate[] candidates, long[] scores){
        long smallest = scores[0];
        int position = 0;
        for(int i = 1; i < candidates.length;i++){
            if(scores[i] <= smallest ){
                if(scores[i] == smallest){
                    if(candidates[i].getId() < candidates[position].getId()){
                        position = i;
                    }
                } else{
                    smallest = scores[i];
                    position = i;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) {

    }

}

 class Customer {
    private final int x;
    private final int y;
    private final int demand;

    public Customer(int x, int y, int demand){
        this.x = x;
        this.y = y;
        this.demand = demand;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getDemand(){
        return demand;
    }
}

class WarehouseCandidate{
    private final int id;
    private final int x;
    private final int y;

    public WarehouseCandidate(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId(){
        return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}



